
public class PegSolitaire {

	static char[][] board = new char[][] { 	{' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' '},	// Padded to remove edge cases while checking possible jumps.
											{' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' '},
											{' ' , ' ' , ' ' , ' ' , 'X' , 'X' , 'X' , ' ' , ' ' , ' ' , ' '},
											{' ' , ' ' , ' ' , ' ' , 'X' , 'X' , 'X' , ' ' , ' ' , ' ' , ' '},
											{' ' , ' ' , 'X' , 'X' , 'X' , 'X' , 'X' , 'X' , 'X' , ' ' , ' '},
											{' ' , ' ' , 'X' , 'X' , 'X' , 'O' , 'X' , 'X' , 'X' , ' ' , ' '},
											{' ' , ' ' , 'X' , 'X' , 'X' , 'X' , 'X' , 'X' , 'X' , ' ' , ' '},
											{' ' , ' ' , ' ' , ' ' , 'X' , 'X' , 'X' , ' ' , ' ' , ' ' , ' '},
											{' ' , ' ' , ' ' , ' ' , 'X' , 'X' , 'X' , ' ' , ' ' , ' ' , ' '}, 
											{' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' '},
											{' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' '} };
									
	public static void main(String[] args) {
																								
		long l = java.lang.System.currentTimeMillis();
		System.out.println(solvePegSolitaire()? "Solved in " + ((java.lang.System.currentTimeMillis() - l)/1000) + " secs!" : "Not Solvable!");
	}
	
	// Solves the Peg Solitaire using recursive backtracking algorithm.
	public static boolean solvePegSolitaire() {
		
		if (solved()) {
			printBoard();
			return true;
		}else {
			
			for(int i = 2; i < 9; i++) {
				for(int j = 2; j < 9; j++) {
				
					if(board[i][j] == 'X') {
						
						if (board[i - 1][j]=='X' && board[i - 2][j]=='O') {			// Check top!
							
							board[i][j] = 'O';
							board[i - 1][j] = 'O';
							board[i - 2][j] = 'X';
							if (solvePegSolitaire()) {
								board[i][j] = 'X';
								board[i - 1][j] = 'X';
								board[i - 2][j] = 'O';								
								printBoard();
								return true;
							}								
							else {
								board[i][j] = 'X';
								board[i - 1][j] = 'X';
								board[i - 2][j] = 'O';										
							}
							
						}
						
						if (board[i][j + 1]=='X' && board[i][j + 2]=='O') {			// Check right!
							
							board[i][j] = 'O';
							board[i][j + 1]='O';
							board[i][j + 2]='X';
							if (solvePegSolitaire()) {
								board[i][j] = 'X';
								board[i][j + 1]='X';
								board[i][j + 2]='O';
								printBoard();
								return true;							
							}								
							else {
								board[i][j] = 'X';
								board[i][j + 1]='X';
								board[i][j + 2]='O';										
							}
							
						}
						
						if (board[i + 1][j]=='X' && board[i + 2][j]=='O') {			// Check bottom!
							
							board[i][j] = 'O';
							board[i + 1][j]='O';
							board[i + 2][j]='X';
							if (solvePegSolitaire()) {
								board[i][j] = 'X';
								board[i + 1][j]='X';
								board[i + 2][j]='O';
								printBoard();
								return true;							
							}				
							else {
								board[i][j] = 'X';
								board[i + 1][j]='X';
								board[i + 2][j]='O';
							}
							
						}		
								
						if (board[i][j - 1]=='X' && board[i][j - 2]=='O') {			// Check left!
							
							board[i][j] = 'O';
							board[i][j - 1]='O';
							board[i][j - 2]='X';
							if (solvePegSolitaire()) {
								board[i][j] = 'X';
								board[i][j - 1]='X';
								board[i][j - 2]='O';
								printBoard();
								return true;
							}
							else {
								board[i][j] = 'X';
								board[i][j - 1]='X';
								board[i][j - 2]='O';
							}
						}			
								
					}
					
				}
			}
			
			return false;
			
		}
	}
	
	// Prints the board.
	private static void printBoard() {
		for(int row = 0; row < 11; row++) {
			for(int column = 0; column < 11; column++) {
				System.out.print(board[row][column]);
			}
			System.out.println();
		}			
	}

	// Checks if the board is solved.
	public static boolean solved() {
		
		if (board[5][5] == 'X') {					
			
			for(int i = 2; i < 9; i++) {
				for(int j = 2; j < 9; j++) {					
					if ((i == 5) && (j == 5))
						continue;
					if (board[i][j] == 'X') {
						return false;						
					}
				}			
			}
			return true;			
		}else {		
			return false;
		}
		
	}	
}
