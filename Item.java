

/**
 * Item class stores an Item with a specified weight
 */
public class Item {
	
	private int weight;
	private double basePrice;
	private String name;
	
	/**
	 * 
	 * @param weight the weight of the Item
	 * @param isFood true if the Item is food, false otherwise
	 */
	public Item(int weight, double basePrice, String name) {
		// TODO Auto-generated constructor stub
		this.weight=weight;
		this.basePrice=basePrice;
		this.name=name;
		
	}
	
	/**
	 * 
	 * @return the weight of the item
	 */
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int n) {
		weight = n;
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean equals (Item otherItem) {
		if (otherItem.getName()==name) return true;
		else return false;
	}


}
