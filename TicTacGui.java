public class TicTacGui extends GUI{
	//fields
	//constructor
	
	//public methods
	public void displayBoard(board b){
		boolean error = true;
		int[] coords = new int[2];
		String bSquares = b.getSquares(coords);
		
		String board = "*******************";
		for(int row=0;row<b.squares.length;row++){
			board+="\n*";
			for(int col = 0; col <b.squares[row].length;col++){
				board+="  "+b.squares[row][col];
				for(int i = 0 ; i<1;i++){
					board+="  ";
				}
				board+="*";	
			}
			board+="\n*******************";
		}
	board+="\n";
	
	
	/*
	while(error){
			for(int row = 0;row<b.squares.length;row++){
				for(int col = 0;col<b.squares[row].length;col++){
					if(b.squares[row][col].equals("X")){
						System.out.print("This square is already taken.");
						
					}
					if(b.squares[row][col].equals("O")){
						System.out.print("This square is already taken.");
						
					}
				}
				error=false;
			}
		}
	*/
		System.out.print(board);
	}
	
	public int[] receiveCoordReply(){
		String coord = kb.next();
		if(coord.length() != 2){
			int[] a = new int[]{4,4};
			return a;
		}
		int[] a = board.stringToCoords(coord);
		return a;
		
	}
		
		
	
}
	
			