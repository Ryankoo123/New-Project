package spaceExplorer;
/**
 * note: Food Item and its attributes should be renamed
 * 		to create food item FoodItem(Food.FOODNAME)
 */

import spaceExplorer.Food;

public class FoodItem {
	public String name;
	public int price;
	public int nutrition;
	public String imageIcon;
	public int foodCount = 1;
	Food food;
	
	public FoodItem(Food food) {
        switch (food) {
        case CHICKEN:
            name = "CHICKEN";
            price = 30;
            nutrition = 25;
            imageIcon = "/spaceExplorer/Chicken.png";
            break;
        case BURGER:
            name = "BURGER";
            price = 23;
            nutrition = 15;
            imageIcon = "/spaceExplorer/burger.png";
            break;
        case TOFFEE:
            name = "TOFFEE";
            price = 5;
            nutrition = 2;
            imageIcon = "/spaceExplorer/Toffee.png";
            break;
        case TEA:
            name = "TEA";
            price = 8;
            nutrition = 3;
            imageIcon = "/spaceExplorer/tea.png";
            break;
        case ICECREAM:
            name = "Ice Cream";
            price = 10;
            nutrition = 5;
            imageIcon = "/spaceExplorer/ice cream.png";
            break;
        case BREAD:
            name = "BREAD";
            price = 18;
            nutrition = 10;
            imageIcon = "/spaceExplorer/Bread.png";
            break;
        }	
	}
	
	public String toString() {
		return name + "\nNutrition: " + nutrition + "\nPrice: " + price;
	}
	
	public int getNutrition() {
		return nutrition;
	}
	
	public int getPrice() {
		return price;
	}
	
}