package spaceExplorer;

import javax.swing.JOptionPane;

public class randomEvent {
	
	public int randomFoodItemIndex() {
		if (Math.random() > 0.40) {
			int indexNum = (int) (Math.random() * 100) % 6;

			return indexNum;
		} else {
			return -1;
		}
	}
		
	public int randomMedicalItemIndex() {
		if (Math.random() > 0.40) {
			int indexNum = (int) (Math.random() * 100) % 3;

			return indexNum;
		} else {
			return -1;
		}
	}
		
	public boolean hasShipPart() {
		if (Math.random() > 0.10) {
			return true;
		} else {
			return false;
		}
	}
	

	
	
		
	public void asteroidBelt() {
		CrewInfo.ShipHealth = (CrewInfo.ShipHealth * 0.70) - 5;
	}
	
	public boolean spacePlague() {
		if (Math.random() > 0.70 && CrewInfo.CrewList.size() > 1) {
			int indexNum = (int) (Math.random() * 100) % CrewInfo.CrewList.size();
			System.out.println(indexNum);

			CrewInfo.CrewList.get(indexNum).hasPlague = true;
			System.out.println(CrewInfo.CrewList.get(indexNum).hasPlague);

			return true;
		}
		return false;
	}
	
	
	public boolean alienPirates() {
		if (Math.random() > 0.70 && CrewInfo.FoodList.size() > 1) {
			int indexNum = (int) (Math.random() * 100) % CrewInfo.FoodList.size();
			CrewInfo.FoodList.remove(indexNum);
			return true;
		}
		return false;
	}
	
	
	}
	


