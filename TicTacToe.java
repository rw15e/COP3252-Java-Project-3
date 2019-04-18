import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe {
    public static void main(String[] args)
    {
		//int x,y;
		int input = 0;
		int turnCounter = 0;
        Scanner sc = new Scanner(System.in);
        Player game = new Player();
        game.reset();		
		boolean twoComp = false;
		boolean twoHuman = false;
		boolean oneComponeHuman = false;
		boolean currentPlayerHuman = false;

		if(args.length == 2)
			oneComponeHuman = true;
		if(args.length == 1)
			twoComp = true;
		if(args.length == 0)
			twoHuman = true;
	
		if(twoComp == true)
		{
			System.out.print("\nTic Tac Toe with two computer players!\n\n");
			// make sure to increment turncounter inside loop!!!!!!!!!
			
			// code here if two computers playing each 
			// needs to switch between both computer players every turn
	
			
		}	// end of twoComp==true
		
		if(oneComponeHuman == true)
		{
			int z = Integer.parseInt(args[1]);// converts the second command line argument to an int 
			
			System.out.print("\nTic Tac Toe with one computer and one human player!\n");
			if(z == 1){
				System.out.print("Computer is player 1 and human is player 2\n\n");
	
				while(!game.checkWin() && turnCounter<9){
					game.printBoard();
					if(turnCounter % 2 != 0) // then it is humans turn
					{
						while (!game.insertXorO(input)) // get input from user and error check it
						{
							System.out.println("Player " + game.getXorO() + ", please enter a location:");
							input = sc.nextInt();
						}
					}
					if(turnCounter % 2 == 0) // then it is computers turn
					{
						game.compPlayer(turnCounter);
						//System.out.print("\n\nCOMPUTER WILL MAKE ITS MOVE HERE\n TURN COUNTER IS: " + turnCounter);
					}
					turnCounter++;
					game.alternateMove();
				} // end of big while loop
			if(!game.checkWin() && turnCounter>=9){ // if its been 9 or more moves and there is no winner the game must be a tie
				game.printBoard();    // prints out the filled game board
				System.out.print("\nThe game was a tie\n");
			}
			else{
				game.alternateMove(); // need to change player for correct output
				game.printBoard();    // prints out the filled game board
				System.out.print("\nPlayer " + game.getXorO() + " wins\n");
			}	
			} // END OF SECOND PARAMETER = 1
				
			if(z == 2){ // if human is player one and computer is player 2 ***********
				System.out.print("Human is player 1 and computer is player 2\n\n");
				while(!game.checkWin() && turnCounter<9){
					game.printBoard();
					if(turnCounter % 2 == 0) // then it is humans turn
					{
						while (!game.insertXorO(input)) // get input from user and error check it
						{
							System.out.println("Player " + game.getXorO() + ", please enter a location:");
							input = sc.nextInt();
						}
					}
					if(turnCounter % 2 != 0) // then it is computers turn
					{
						game.compPlayer(turnCounter);
						//System.out.print("\n\nCOMPUTER WILL MAKE ITS MOVE HERE\n");\
					}
					turnCounter++;
					game.alternateMove();
				} // end of big while loop
			if(!game.checkWin() && turnCounter>=9){ // if its been 9 or more moves and there is no winner the game must be a tie
				game.printBoard();   // prints out the filled game board
				System.out.print("\nThe game was a tie\n");
			}
			else{
				game.alternateMove(); // need to change player for correct output!
				game.printBoard();   // prints out the filled game board
				System.out.print("\nPlayer " + game.getXorO() + " wins\n");
			}	
		}// end of SECOND PARAMETER =2
		} // end of oneComponeHuman==true
	
		if(twoHuman == true)
		{
			System.out.print("\nTic Tac Toe with two human players!\n\n");
			while(!game.checkWin() && turnCounter<9){
				game.printBoard();
				turnCounter++;
				while (!game.insertXorO(input))
				{
					System.out.println("Player " + game.getXorO() + ", please enter a location:");
					input = sc.nextInt();
				}
				game.alternateMove(); // alternate moves
			}
			if(!game.checkWin() && turnCounter>=9){ // if its been 9 or more moves and there is no winner the game must be a tie
				game.printBoard();   // prints out the filled game board
				System.out.print("\nThe game was a tie\n");
			}
			else{
				game.alternateMove(); // need to change player for correct output!
				game.printBoard();   // prints out the filled game board
				System.out.print("\nPlayer " + game.getXorO() + " wins\n");
			}
		}		
		} // end of if(twohuman == true)
}
