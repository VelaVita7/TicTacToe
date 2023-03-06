public class Game { 
	//fields 
	/*
	Tic Tic Ticking time bomb 
	
	01000001 00100000 01100010 01110010 01101111 01101011 01100101 01101110 00100000 
	01110100 01101001 01100011 00100000 01110100 01100001 01100011 00100000 01110100 
	01101111 01100101 00100000 01100111 01100001 01101101 01100101
	*/
	private TicTacGui gui=new TicTacGui();
	private board b= new board();
	private Player[] players=new Player[2];
	private int whoseTurn;
	private boolean playersPresent = false;
	private boolean noWinner = true;
	private String XO= "O";
	//constructor
	
	//getter/setter
	
	//methods
	public void reset(){
		if(!playersPresent){
			gui.displayMsg("Welcome to TicTac!!");
			collectPlayerNames();
		}
		b.clearboard();
		
	}
	public boolean play(){
		gui.displayBoard(b);
		while(noWinner){
			int[] tickTacks = players[whoseTurn].takeTurns(gui,b,XO);
			gui.displayBoard(b);
			if(b.isWinner()){
				noWinner=false;
				players[whoseTurn].addWins();
				for(int losers= 0; losers<players.length; losers++){
					if(losers != whoseTurn){
						players[losers].addLosses();
					}
				}
				congradulations();
				this.checkWhoseTurn();
				gui.displayMsg("Would you like to play again?");
				boolean playAgain = gui.receiveBooleanReply();
				if(playAgain){
					gui.displayMsg("Would you like to select new players?");
					if(gui.receiveBooleanReply()){
						playersPresent =false;
						return playAgain;
					}
				}
					return playAgain;
			}
			checkWhoseTurn();
		}
	return noWinner;
	}
	
	//private
	
	private String[] collectPlayerNames(){
		String[] name = new String[players.length];
		Player[] eachname = new Player[name.length];
		for(int i=0;i<players.length;i++){
			gui.displayMsg("What is the name of player "+(i+1));
			name[i]=gui.receiveStringReply();
			eachname[i]=new Player(name[i]);
		}
		this.players=eachname;
		playersPresent=true;
		return name;
	}
	// 01000011 01101111 01101110 01100111 01110010 01100001 01110100 
	//01110011 00100000 01111001 01101111 01110101 00100000 01100110 01101111 01110101 01101110 01100100 00100000 01101001 01110100 00100001 00100001
	private boolean congradulations(){
		gui.displayMsg(players[whoseTurn].getName()+" won the game!");
		ScoreBoard scoreBoard = new ScoreBoard(players);
		System.out.print(scoreBoard.sBoard());
		return false;
	}
	
	private void checkWhoseTurn(){
		if(whoseTurn+1<players.length){
			XO = "X";
			whoseTurn++;
		}else if (whoseTurn+1==players.length){
			whoseTurn=0;
			XO = "O";
		}
	}
}
	
