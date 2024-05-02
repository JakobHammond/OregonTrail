
public class Food extends Item {

	public Food(int weight, double basePrice, String name) {
		super(weight, basePrice, name);
	}

	public void eatFood (int amountNeeded) {
		int n = this.getWeight();
		n -= amountNeeded;
		this.setWeight(n);
	}
	
	public boolean isEnoughFood (int amountNeeded) {
		if (amountNeeded > this.getWeight()) return false;
		else return true;
	}

}
