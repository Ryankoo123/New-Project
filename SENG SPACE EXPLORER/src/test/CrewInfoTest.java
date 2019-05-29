package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;
import spaceExplorer.CrewInfo;
import spaceExplorer.CrewMember;
import spaceExplorer.MedicalItem;
import spaceExplorer.FoodItem;
import spaceExplorer.Food;
import spaceExplorer.Medicine;
import spaceExplorer.Type;


class CrewInfoTest {

	@Test
	public void foodItemTest() {
		CrewInfo crewInfo = new CrewInfo();
		crewInfo.addFoodItem(Food.BREAD);
		crewInfo.addFoodItem(Food.BURGER);
		crewInfo.addFoodItem(Food.CHICKEN);
		List<String> testfoods = Arrays.asList("BREAD", "BURGER", "CHICKEN");
		
		int counter = 0;
		for (FoodItem i : crewInfo.getFoodItemList()) {
			assertEquals(i.name, testfoods.get(counter));
			counter ++;
		}
	}
	@Test
	public void crewTest() {
		CrewInfo crewInfo = new CrewInfo();
		crewInfo.addMember(Type.TYPE1, "Mario");
		crewInfo.addMember(Type.TYPE2, "Jeff");
		crewInfo.addMember(Type.TYPE3, "Brad");
		crewInfo.addMember(Type.TYPE4, "Ryan");
		List<String> testnames = Arrays.asList("Mario", "Jeff", "Brad", "Ryan");

		
		int counter = 0;
		for (CrewMember i : crewInfo.getCrewList()) {
			assertEquals(i.name, testnames.get(counter));
			counter ++;
		}
	}
	
	@Test
	public void medicalItemTest() {
		CrewInfo crewInfo = new CrewInfo();
		crewInfo.addMedicalItem(Medicine.MEDICINE1);
		crewInfo.addMedicalItem(Medicine.MEDICINE2);
		crewInfo.addMedicalItem(Medicine.MEDICINE3);
		List<String> testmedicines = Arrays.asList("MEDICINE1", "MEDICINE2", "MEDICINE3");

		
		int counter = 0;
		for (MedicalItem i : crewInfo.getMedicalItemList()) {
			assertEquals(i.getName(), testmedicines.get(counter));
			counter ++;
		}
	}
	
	
}
