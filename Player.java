/* Assignment 3 by Ryan Winter for COP3252*/
import java.util.Random;

public class Player {

	int x, y; // used for board mark placement
	int numOfX;
	int numOfO;
	int numOfBlank;	
	boolean compSucessfulMove;
	boolean itWorked;
    private char[][] board;
    private char XorO;

    public Player() {
        board = new char[3][3];
		reset();
        XorO = 'X'; // this will make sure that the game always starts with the first player being "X"
    }
	public void compPlayer(int count){
		// first check for winning moves
		//if(compSucessfulMove == false){
			
			// check for winning moves
			// in a line
			// diagnoal
			
		//	compSucessfulMove = true; 
		//}
		// ** end of first part
		
		
		// second check if opponent is threat a win, block it if so
		//if(compSucessfulMove == false){
			
			
		//	compSucessfulMove = true;
		//}
		// ** end of second part
		
		
		// third take the center space if its open
		if(compSucessfulMove == false)
			if(board[1][1] == ' '){
				insertXorO(5);
				compSucessfulMove = true;
			}
	
		// ** end of third part
		
		
		// last randomly take any space
			// will need to know how many open spots there are on board.. need to pass in counter? and subtract 9-turnCounter and generate random number between 1 and that number
		//if(compSucessfulMove == false){
			numOfBlank = 0;
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					if(board[i][j] == 'X')
						numOfX++;
					if(board[i][j] == 'O')
						numOfO++;
					if(board[i][j]== ' ')
						numOfBlank++;
				}
			}
			Random rand = new Random();
			int r3 = rand.nextInt(numOfBlank-1) + 1;
			//System.out.print("\nComputers attempted move is: " + r3 + "\n");
			insertXorO(r3);
			if(r3 <= 9){
				insertXorO(r3);
			}
			else 
				compPlayer(count);
			compSucessfulMove = true;
		// ** end of last part	
	}
    public char getXorO()    // getter function for X or O
    {
        return XorO;
    }
    public void printBoard() { // Print the current board
		System.out.print("Game Board:				Positions:\n\n");	
		System.out.print(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);		// actual board
		System.out.print("				 1 | 2 | 3\n");  											// sample board
		System.out.print("-----------				-----------\n");
		System.out.print(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);		// actual bored
		System.out.print("				 4 | 5 | 6\n");												// sample board
		System.out.print("-----------				-----------\n");
		System.out.print(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]); // actual board
		System.out.print("				 7 | 8 | 9\n");												  // sample board
		System.out.print("\n");
    }
	public void reset() {
        for (int i = 0; i < 3; i++) // Loop through rows
            for (int j = 0; j < 3; j++) // Loop through columns
                board[i][j] = ' ';  // sets each element to a blank space
    }
    public boolean checkWin() {  // checks entire board for any win
		for(int i = 0; i < 3; i++) // checks rows 
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')
				return true;
		for(int i = 0; i < 3; i++) // checks columns
			if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')
				return true;
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
			return true;
		if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != ' ')
			return true;
		else 
			return false;
    }
    public void alternateMove() { // alternates players turn
        if (XorO == 'O')
            XorO = 'X';
        else
            XorO = 'O';
    }
    public boolean insertXorO(int i) { 
		if(i >= 1 && i <= 9) // makes sure input is between 1-9
		{
			// i holds the 1-9 number player selected...
			// [x][y] holds actual array slot..
			if(i == 1){
				x = 0;
				y = 0;
			}
			if(i == 2){
				x = 0;
				y = 1;	
			}
			if(i == 3){
				x = 0;
				y = 2;
			}
			if(i == 4){
				x = 1;
				y = 0;
			}
			if(i == 5){
				x = 1;
				y = 1;
			}
			if(i == 6){
				x = 1;
				y = 2;
			}
			if(i == 7){
				x = 2;
				y = 0;
			}
			if(i == 8){
				x = 2;
				y = 1;
			}
			if(i == 9){
				x = 2;
				y = 2;
			}
			if(board[x][y] == ' ')
			{
				board[x][y] = XorO;
				return true;
			}
		}
		return false;
    }
}