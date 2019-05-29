package spaceExplorer;

/**
 * note: The member type and the attributes should be changed
 */

import spaceExplorer.Type;

public class CrewMember {
	public String name = "Untitled";
	public int health = 100;
	public int hunger = 0;
	public int tiredness = 0;
	public int repair = 20;
	public int NumberOfMoves = 2;
	public boolean hasPlague = false;
	public boolean easterEgg = false;
	public String ability;
	public String characterimg;
	
	public int healthDecrease;
	public int hungerDecrease;
	public int tirednessDecrease;
	Type type;

	
	public void setType(Type type) {
        switch (type) {
        case TYPE1:
            healthDecrease = 20;
            hungerDecrease = 20;
            tirednessDecrease = 15;
            repair = 50;
            ability = "Repairs the ship better";
            characterimg = "/spaceExplorerImages/Chracter 0.png";
            break;
        case TYPE2:
            healthDecrease = 15;
            hungerDecrease = 20;
            tirednessDecrease = 5;
            ability = "Doesn't get tired easily";
            characterimg = "/spaceExplorerImages/character 3.png";
            break;
        case TYPE3:
            healthDecrease = 20;
            hungerDecrease = 10;
            tirednessDecrease = 15;
            ability = "Doesn't get hungry easily";
            easterEgg = true;
            characterimg = "/spaceExplorerImages/character 1.png";
            break;
        case TYPE4:
            healthDecrease = 20;
            hungerDecrease = 20;
            tirednessDecrease = 20;
            ability = "Immune to the plague";
            characterimg = "/spaceExplorerImages/character 2.png";
            break;
        case TYPE5:
            healthDecrease = 10;
            hungerDecrease = 10;
            tirednessDecrease = 10;
            ability = "The healthiest of the bunch";
            characterimg = "/spaceExplorerImages/character 4.png";
            break;
        case TYPE6:
            healthDecrease = 10;
            hungerDecrease = 10;
            tirednessDecrease = 20;
            ability = "Finds loot at a more efficient rate";
            characterimg = "/spaceExplorerImages/character 5.png";
            break;
        }	
	}
	
	public String toString() {
		return name + "\nHealth: " + health + "\nTiredness: " + tiredness
				+ "\nHunger: " + hunger;
	}
	
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getHunger() {
		return hunger;
	}
	
	public int getHealthDecrease() {
		if (hasPlague) {
			return 40;
		} else {
			return healthDecrease;
		}
	}
	
	public int getNumberOfMoves() {
		return NumberOfMoves;
	}
	
	public void feed(int food) {
		NumberOfMoves -= 1;
		hunger -= food;
	}
	
	public void consumeMedicalItem(MedicalItem item) {
		NumberOfMoves -= 1;
		if (item.CuresPlague() && hasPlague) {
			hasPlague = false;
			health += item.getHealthIncrease();
		} else {
			health += item.getHealthIncrease();
		}
		
	}
	
	public void sleep() {
		NumberOfMoves -= 1;
		tiredness -= 60;
	}
	
	public String getStatus() {
		return name + "\nHealth: " + health + "\nTiredness: " + tiredness
				+ "\nHunger: " + hunger;
	}
	
	public boolean isDead() {
		if (health <= 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
//		CrewMember CrewMember = new CrewMember();
//		CrewMember.setName("Astro");
//		System.out.println(CrewMember);
	}

}

