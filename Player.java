public class Player{
	//fields
	private static int currentId=1;
	private int id;
	private String name;
	private int wins=0;
	private int losses=0;
	private double winPercent = 0;
	private boolean autoPlay;
	
	public int getId() {return id;}
	public String getName(){return name;}
	public int getWins(){return wins;}
	public int getLosses(){return losses;}
	public double getWinPercent(){return winPercent;}
	public boolean getAutoPlay(){return autoPlay;}
	
	
	//constructor
	Player(String n){
		this.name=n;
	}
	public int[] takeTurns(TicTacGui gui,board b,String Letter){
		gui.displayMsg("Choose a row (A-C) and a column (1-3).");
		int[] coords = new int[]{4,4};
		boolean error = true;
		while(error){
			coords = gui.receiveCoordReply();
			if(coords[0]>=3 || coords[1]>=3){	
				gui.displayMsg("Invalid row and colunm.");
				error=true;
			}else if(b.squares[coords[0]][coords[1]].equals("X") || b.squares[coords[0]][coords[1]].equals("O")){
				gui.displayMsg("Error. Square is already filled.");				
			}else{
				b.setSquares(coords,Letter);
				gui.displayMsg(name+" added "+b.getSquares(coords)+" to the board.");
				System.out.print(b.squares[1][2]);
				error= false;
			}
		}
			return coords;
	}
	public void addWins(){
		this.wins++;
	}
	public void addLosses(){
		this.losses++;
	}
		
}
	
	