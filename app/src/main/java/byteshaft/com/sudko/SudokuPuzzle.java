package byteshaft.com.sudko;

public class SudokuPuzzle {
	
	//setting up arrays
	private int board [][];
	private int start[][];
	
	public SudokuPuzzle(){
		//initialize array to 9X9 board game
		start = new int [9][9];
		board = new int [9][9];
	}
	
	// toString method returns the look and feel of the actual board game output
	public String toString(){
		String puzzleString = "Row/Col\n    1  2  3  4  5  6  7  8  9\n";
		puzzleString = puzzleString+ "   --------------------------\n";
		
		for (int i=0; i<9; i++){
			puzzleString = puzzleString + (i+1) + " |";
			for (int j=0; j<9; j++){
				if (board [i][j] == 0)
					puzzleString = puzzleString + " " + ".|";
				else
					puzzleString = puzzleString + " " +board [i][j] + "|";
			}
			puzzleString = puzzleString + "\n";
			puzzleString = puzzleString + "  |__|__|__|__|__|__|__|__|__|\n";
		}
		
		return puzzleString;
	}
	
	public void addInitial(int row, int col, int value){
		//add initial values to puzzle
		if (row>=0 && row<=9 && col >=0 && col <=9 && value >=1 && value <=9){
			start [row][col] = value;
			board [row][col] = value;
		}
	}
	
	public void addGuess(int row, int col, int value){
		// only set the value if the start is 0
		if (row>=0 && row<=9 && col >=0 && col <=9 && value >=1 && value <=9 && start [row][col] == 0){
			board [row][col]= value;
		}
	}
	
	public int getValueIn(int row, int col){
		return board[row][col];
	}
	
	//reset the board to initial values, the start values
	public void reset(){
		for (int i=0;i<9;i++)
			for( int j=0;j<9;j++)
				board[i][j] = start[i][j];
	}
	
	public boolean isFull(){
		boolean allFilled = true;
		for (int i=0;i<9;i++)
			for( int j=0;j<9;j++)
				allFilled = allFilled && board[i][j]>0;
		return allFilled;
	}
	
	public boolean[] getAllowedValues(int row, int col){
		// save the value at the location, next attempt values that are left
		int savedValue = board[row][col];
		boolean result[] = new boolean[9];
		for (int value = 1; value <=9; value++){
			board [row][col] = value;
			result[value-1] = checkPuzzle();
		}
		board [row][col] = savedValue;
		return result;
	}
	
	public boolean checkPuzzle(){
		boolean looksGood = true;
		//see if values in squares are legal
		for (int i=0;i<9;i++){
			looksGood = looksGood && checkRow(i);
			looksGood = looksGood && checkCol(i);
			looksGood = looksGood && checkSub(i);
		}
		return looksGood; // or false
	}
	
	public boolean checkRow(int row){
		// make sure a number only appears once in col
		int count[]= new int[10];
		for (int col=0;col<9;col++){
			count[board[row][col]]++;
		}
		boolean countIsOk = true;
		
		for(int i=1; i<=9; i++)
			countIsOk = countIsOk && (count[i]<=1);
		return countIsOk;
		
	}
	
	public boolean checkCol(int col){
		int count[] = new int[10];
		for(int row=0; row<9; row++){
			count[board[row][col]]++;
		}
		boolean countIsOk = true;
		for(int i=1; i<=9; i++)
			countIsOk = countIsOk && (count[i]<=1);
		return countIsOk;
	}
	
	public boolean checkSub(int sub){
		int count[] = new int[10];
		int rowBase = (sub/3) *3;

		// make sure a number only appears once in a 3B3 array
		int colBase = (sub%3) *3;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				count[board[rowBase+i][colBase+j]]++;
			}
		}

		boolean countIsOk = true;
		for(int i=1; i<=9; i++)
			countIsOk = countIsOk && (count[i]<=1);
		return countIsOk;
	}
	// Initialize the puzzle to the board configuration example in the text
	public static void initializePuzzle(SudokuPuzzle p){
	p.addInitial(0,0,1);
	p.addInitial(0,1,2);
	p.addInitial(0,2,3);
	p.addInitial(0,3,4);
	p.addInitial(0,4,9);
	p.addInitial(0,5,7);
	p.addInitial(0,6,8);
	p.addInitial(0,7,6);
	p.addInitial(0,8,5);
	p.addInitial(1,0,4);
	p.addInitial(1,1,5);
	p.addInitial(1,2,9);
	p.addInitial(2,0,6);
	p.addInitial(2,1,7);
	p.addInitial(2,2,8);
	p.addInitial(3,0,3);
	p.addInitial(3,4,1);
	p.addInitial(4,0,2);
	p.addInitial(5,0,9);
	p.addInitial(5,5,5);
	p.addInitial(6,0,8);
	p.addInitial(7,0,7);
	p.addInitial(8,0,5);
	p.addInitial(8,3,9);
	}
}