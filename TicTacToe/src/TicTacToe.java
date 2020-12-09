import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static ArrayList<Integer> playerposition = new ArrayList<Integer>();
	static ArrayList<Integer> cpuposition = new ArrayList<Integer>();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] gameBoard= {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}};
		
	
		while(true) {
			Scanner scan=new Scanner(System.in);
		    System.out.println("Enter your placement (1-9):");
		    int playerpos=scan.nextInt();
		    while(playerposition.contains(playerposition) || cpuposition.contains(playerposition)) {
		    	System.out.println("position are taken! Enter a correct position");
		    	playerpos=scan.nextInt();
		    }
		
		    System.out.println(playerpos);
		    placepiece(gameBoard,playerpos,"player");
		    
		    String result =checkWinner();
		    if(result.length() > 0) {
		    	System.out.println(result);
		    	break;
		    }
		    Random rand=new Random();
		    int cpupos=rand.nextInt(9) +1;
		    while(playerposition.contains(cpuposition) || cpuposition.contains(cpuposition)) {
		    	//System.out.println("position are taken! Enter a correct position");
		    	cpupos=rand.nextInt(9) +1;
		    	
		    }
		    placepiece(gameBoard,cpupos,"cpu");
		    
		    result =checkWinner();
		    if(result.length() > 0) {
		    	System.out.println(result);
		    	break;
		    }
		
		    printGameBoard(gameBoard);
		   //String result= checkWinner();
		  // System.out.println(result);
		}
		
		
		
		
		
		

	}
	public static void printGameBoard(char[][] gameBoard) {
		for(char[] row:gameBoard) {
			for(char c: row) {
				System.out.print(c);
			}
			System.out.println();
		}

		
	}
	public static void placepiece(char[][] gameBoard,int pos,String user) {
		char symbol =' ';
		if(user.equals("player")) {
			symbol='X';
			playerposition.add(pos);
		} else if(user.equals("cpu")) {
			symbol='O';
			cpuposition.add(pos);
		} 
		
		 
		switch(pos) {
	        case 1:
	        	gameBoard[0][0]=symbol;
			    break;
		    case 2:
		    	
			    gameBoard[0][2]=symbol;
			    break;
		    case 3:
			    gameBoard[0][4]=symbol;
			    break;
		    case 4:
			    gameBoard[2][0]=symbol;
			    break;
		    case 5:
			    gameBoard[2][2]=symbol;
			    break;
		    case 6:
			   gameBoard[2][4]=symbol;
			   break;
		    case 7:
			    gameBoard[4][0]=symbol;
			    break;
		    case 8:
			    gameBoard[4][2]=symbol;
			    break;
		    case 9:
			    gameBoard[4][4]=symbol;
			    break;
		    default:
			    break;
				
		                          
			   
		}
		
		
		
	}
	public static String checkWinner() {
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List leftcol= Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(7,5,3);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftcol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l : winning) {
			if(playerposition.containsAll(l)) {
				return "Congratulations you won!";
			} else if(cpuposition.containsAll(l)) {
				return "CPU wins! Sorry :(";
			} else if(playerposition.size() + cpuposition.size() == 9) {
				return "CAT";
			}
			
		}
		return "";
		 
		
	}

}
