public class board { 
	//Setting up how the player can select the row and columns on the board. 
	private static final String[] rLabels = new String[]{"A","B","C"};
	private static final String[] cLabels = new String[]{"1","2","3"};
	public static int[] stringToCoords(String coords){
		String row = coords.substring(0,1);
		int rowC = 4;
		int colC=4;
		for(int i = 0; i<rLabels.length; i++){
			if(row.equals(rLabels[i])){
				rowC = i;
			}
		}
		String col = coords.substring(1,2);
		for(int i = 0; i<cLabels.length; i++){
			if(col.equals(cLabels[i])){
				colC = i;
			}
		}
		int[] coordinates = new int[]{rowC,colC};
		return coordinates;
			
	}
	
	
	//fields 
	String[][] squares = new String[3][3];
	private String[][] spaces;
	//constructor 
	
	//getter/setters
	public String getSquares(int[] coords){return squares[coords[0]][coords[1]];}
	public void setSquares(int[] coords,String letter){
		squares[coords[0]][coords[1]]=letter;
	}
	//public methods
	public void clearboard(){
		for(String[] row : squares){
			for(int col = 0;col<row.length;col++){
				row[col]=" ";
			}
		}
		
	}
	// This method is really long, could have improvements to it. 
	public boolean isWinner(){
		boolean winner=false;
		String letter = "X";
		String letter2 = "O";
		if(squares[0][0].equals(letter)&&squares[0][1].equals(letter)&&squares[0][2].equals(letter)){
			winner = true;
			return winner;
		}
		if(squares[1][0].equals(letter)&&squares[1][1].equals(letter)&&squares[1][2].equals(letter)){
			winner = true;
			return winner;
		}
		if(squares[2][0].equals(letter)&&squares[2][1].equals(letter)&&squares[2][2].equals(letter)){
			winner = true;
			return winner;
		}
		if(squares[0][0].equals(letter)&&squares[1][0].equals(letter)&&squares[2][0].equals(letter)){
			winner = true;
			return winner;
		}
		if(squares[0][1].equals(letter)&&squares[1][1].equals(letter)&&squares[2][1].equals(letter)){
			winner = true;
			return winner;
		}
		if(squares[0][2].equals(letter)&&squares[1][2].equals(letter)&&squares[2][2].equals(letter)){
			winner = true;
			return winner;
		}
		if(squares[0][0].equals(letter)&&squares[1][1].equals(letter)&&squares[2][2].equals(letter)){
			winner = true;
			return winner;
		}
		if(squares[0][2].equals(letter)&&squares[1][1].equals(letter)&&squares[2][0].equals(letter)){
			winner = true;
			return winner;
		}
		//O's 
		if(squares[0][0].equals(letter2)&&squares[0][1].equals(letter2)&&squares[0][2].equals(letter2)){
			winner = true;
			return winner;
		}
		if(squares[1][0].equals(letter2)&&squares[1][1].equals(letter2)&&squares[1][2].equals(letter2)){
			winner = true;
			return winner;
		}
		if(squares[2][0].equals(letter2)&&squares[2][1].equals(letter2)&&squares[2][2].equals(letter2)){
			winner = true;
			return winner;
		}
		if(squares[0][0].equals(letter2)&&squares[1][0].equals(letter2)&&squares[2][0].equals(letter2)){
			winner = true;
			return winner;
		}
		if(squares[0][1].equals(letter2)&&squares[1][1].equals(letter2)&&squares[2][1].equals(letter2)){
			winner = true;
			return winner;
		}
		if(squares[0][2].equals(letter2)&&squares[1][2].equals(letter2)&&squares[2][2].equals(letter2)){
			winner = true;
			return winner;
		}
		if(squares[0][0].equals(letter2)&&squares[1][1].equals(letter2)&&squares[2][2].equals(letter2)){
			winner = true;
			return winner;
		}
		if(squares[0][2].equals(letter2)&&squares[1][1].equals(letter2)&&squares[2][0].equals(letter2)){
			winner = true;
			return winner;
		}
		return winner;
	}	
	
}

	
