package spaceExplorer;


public class GameEnvironment {	

	public static int NumberOfDays;
	public static int pieces;
	public static int money;
	public static int actions;
	public static int currentplayer = 0;
	
	public void setNumberOfDays(int newNumber) {
		NumberOfDays = newNumber;
	}

	public void getNumberOfPieces() {
		pieces = (int) Math.round(NumberOfDays*0.66);
	}


	public static void main(String[] args) {
//		GameEnvironment gameEnvironment = new GameEnvironment();
//		gameEnvironment.setNumberOfDays(4);
//		System.out.println(gameEnvironment.pieces);
		}
}