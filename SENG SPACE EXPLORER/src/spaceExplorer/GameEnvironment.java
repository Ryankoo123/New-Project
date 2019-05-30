package spaceExplorer;


public class GameEnvironment {	

	public static int NumberOfDays;
	public static int pieces;
	public static int money;
	public static int actions;
	public static int currentplayer = 0;
	public static FoodItem[] FoodList = new FoodItem[6];
	public static CrewMember[] PilotList = new CrewMember[2];
	
	

	
	public void setNumberOfDays(int newNumber) {
		NumberOfDays = newNumber;
	}

	public void getNumberOfPieces() {
		pieces = (int) Math.round(NumberOfDays*0.66);
	}


	public static void main(String[] args) {
		}
}