package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import spaceExplorer.CrewMember;
import spaceExplorer.MedicalItem;
import spaceExplorer.Medicine;
import spaceExplorer.Type;



class CrewMemberTest {
	
	@Test
	public void typeTest() {
		CrewMember crewMember = new CrewMember();
		crewMember.setType(Type.TYPE1);
		assertEquals("Repairs the ship faster", crewMember.ability);
		crewMember.setType(Type.TYPE2);
		assertEquals("Regenerate health over time", crewMember.ability);
		crewMember.setType(Type.TYPE3);
		assertEquals("Fasting", crewMember.ability);
		crewMember.setType(Type.TYPE4);
		assertEquals("Work extra hours", crewMember.ability);
		crewMember.setType(Type.TYPE5);
		assertEquals("Increased armour", crewMember.ability);
		crewMember.setType(Type.TYPE6);
		assertEquals("High chance of finding loot", crewMember.ability);
	}

	@Test
	public void setNameTest() {
		CrewMember crewMember = new CrewMember();
		crewMember.setName("Bob");
		assertEquals("Bob", crewMember.getName());
	}
	
	@Test
	public void healthTest() {
		CrewMember crewMember = new CrewMember();
		int InitialHealth = crewMember.getHealth();
		MedicalItem testHealing = new MedicalItem(Medicine.MEDICINE1);
		crewMember.consumeMedicalItem(testHealing);
		assertEquals(InitialHealth + 50, crewMember.getHealth());		
	}	
	
	
	@Test
	public void sleepTest() {
		CrewMember crewMember = new CrewMember();
		crewMember.tiredness = 100;
		crewMember.sleep(); 
		assertEquals(1, crewMember.NumberOfMoves);
		assertEquals(40, crewMember.tiredness);	
	}
	


	

	


}
