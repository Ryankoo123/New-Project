package spaceExplorer;

import java.util.ArrayList;

public class GameEnvironment {	

	public static int NumberOfDays;
	public static int pieces;
	public static int money;
	public static int actions;
	public static int currentplayer = 0;
	public static ArrayList<Food> storeFoodList = new ArrayList<Food>();
	public static ArrayList<Medicine> storeMedicalList = new ArrayList<Medicine>();
	
	public void setNumberOfDays(int newNumber) {
		NumberOfDays = newNumber;
	}

	public void getNumberOfPieces() {
		pieces = (int) Math.round(NumberOfDays*0.66);
	}
	
	public void addStoreItemFood(Food food) {
		storeFoodList.add(food);
	}
	
	public void addStoreItemMeds(Medicine medicine) {
		storeMedicalList.add(medicine);
	}
	
	public ArrayList<Medicine> getMedicalItemList() {
		return storeMedicalList;
	}

	public ArrayList<Food> getFoodItemList() {
		return storeFoodList;
	}

	public static void main(String[] args) {
//		GameEnvironment gameEnvironment = new GameEnvironment();
//		gameEnvironment.setNumberOfDays(4);
//		System.out.println(gameEnvironment.pieces);
		}
}