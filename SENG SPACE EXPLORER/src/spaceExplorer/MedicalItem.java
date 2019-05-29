package spaceExplorer;

import javax.swing.ImageIcon;

/**
 * Note: medicine name and attributes should be changed
 */

import spaceExplorer.Medicine;


public class MedicalItem {
	private String name;
	private boolean CuresPlague = false;
	private int HealthIncrease = 0;
	private int price;
	public String medimg;
	public int medCount = 1;
	
	Medicine medicine;
	
	public MedicalItem(Medicine medicine) {
        switch (medicine) {
        case MEDICINE1:
            name = "Syringe";
            price = 40;
            HealthIncrease = 60;
            CuresPlague = true;				//label_1.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorerImages/syring.png")));
            medimg = "/spaceExplorerImages/syring.png";
            break;
        case MEDICINE2:
            name = "Painkiller";
            price = 25;
            HealthIncrease = 20;
            medimg = "/spaceExplorerImages/Painkillers1.png";
            break;
        case MEDICINE3:
            name = "Bandage";
            price = 5;
            HealthIncrease = 10;
            medimg = "/spaceExplorerImages/Bandage1.png";
            break;
            }
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealthIncrease() {
		return HealthIncrease;
	}
	
	public boolean CuresPlague() {
		return CuresPlague;
	}

}
