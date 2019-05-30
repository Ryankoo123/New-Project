package spaceExplorer;

/**
 * 
 *	The CrewInfo Class is used to store information regarding 
 *  CrewMembers, ship name/health, total money and food/medical items obtained
 */

import java.util.ArrayList;

public class CrewInfo {
	public static String ShipName = "Ship";
	public static double ShipHealth = 100;
	public static int Money = 0;
	
	public static ArrayList<CrewMember> CrewList = new ArrayList<CrewMember>();
	public static ArrayList<MedicalItem> MedicalList = new ArrayList<MedicalItem>();
	public static ArrayList<FoodItem> FoodList = new ArrayList<FoodItem>();
//	public static ArrayList<CharNames> NameList = new ArrayList<CharNames>();
	
	public void addMember(Type type, String name) {
		CrewMember crewMember = new CrewMember();
		crewMember.setName(name);
		crewMember.setType(type);
		CrewList.add(crewMember);
	}
	
	public void addMedicalItem(Medicine medicine) {
		MedicalItem medicalItem = new MedicalItem(medicine);
		MedicalList.add(medicalItem);
	}
	
	public void addFoodItem(Food food) {
		FoodItem foodItem = new FoodItem(food);
		FoodList.add(foodItem);
	}
	
	
	public String shipStatus() {
		return "Name: " + ShipName + "\nHealth" + ShipHealth;
	}
	
	public ArrayList<CrewMember> getCrewList() {
		return CrewList;
	}
	
	public ArrayList<MedicalItem> getMedicalItemList() {
		return MedicalList;
	}

	public ArrayList<FoodItem> getFoodItemList() {
		return FoodList;
	}
	
	public int getMoney() {
		return Money;
	}
	
	public void setShipName(String newName) {
		ShipName = newName;
	}
	
	/**
	 * temp test code below
	 */
	
	public static void main(String[] args) {
//		crewInfo.addMember(Type.TYPE1, "Mario");
//		crewInfo.addMember(Type.TYPE2, "Jeff");
//		crewInfo.addMember(Type.TYPE3, "Brad");
//		crewInfo.addMember(Type.TYPE4, "Ryan");
//		crewInfo.addFoodItem(Food.BREAD);
//		crewInfo.addFoodItem(Food.FOOD2);
//		crewInfo.addFoodItem(Food.FOOD3);

//		for (CrewMember i : crewInfo.getCrewList()) {
//			System.out.println(i);
//		}
//		for (FoodItem i : crewInfo.getFoodItemList()) {
//			System.out.println(i);
//		}

	}
	
}