

/**
 * Food class stores a food item with a certain weight and whether or not the food is edible
 */
public class Food extends Item {

	private boolean isNutritional; //shows whether food can be eaten
	
	/**
	 * constructor of food that assumes the food item is inedible
	 * @param weight the weight of the Food item
	 */
	public Food(int weight, double basePrice, String name) {
		super(weight, basePrice, name);
		isNutritional=false;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * constructor of food that can set the food to be edible
	 * @param weight the weight of the Food item
	 * @param isNutritional whether or not the food item has nutritional value
	 */
	public Food(int weight, double basePrice, String name, boolean isNutritional) {
		super(weight, basePrice, name);
		this.isNutritional=isNutritional;
	}
	
	/**
	 * 
	 * @return true if the food item is edible, false otherwise
	 */
	public boolean getNutrition() {
		return isNutritional;
	}

}
