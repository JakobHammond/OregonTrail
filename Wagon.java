

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Anthony Parker
 * file: Wagon.java
 * date:4/9/2024
 * wagon class that can track how far it has traveled it's pace, the rations each person gets, the Food available, the Resources held
 * the health of the group the number of people, and how much money the wagon has.
 * it will act as an inventory for our final Oregon trail game.
 */
public class Wagon {
	
	private ArrayList<Item> inventory;
	private ArrayList<Passenger> party;
	private int groupHealth; //increases to indicate poor health
	private final int MAXWEIGHT = 2400;
	private int weight;
	private int distanceTraveled;
	private int pace;
	private int rationLevel;
	private int money;
	private int days;
	
	
	public Wagon() {
		money=0;
		weight=0;
		groupHealth=0;
		days=0;
		
	}
	
	/**
	 * adds a specified item to the wagons inventory
	 */
	public void addItem(Item item) {
			inventory.add(item);
			weight=weight+item.getWeight();
	}
	
	/**
	 * removes a specified item from the wagon's inventory 
	 * @param item - the item you'ld like to remove from wagon's inventory
	 */
	public void removeItem(Item item) {
		
		inventory.remove(item);
		weight=weight-item.getWeight();
	}
	
	public void restDay() {
		if (this.hasFoodLeft()) applyFoodEffects(party.size()*rationLevel);
		days++;
	}
	
	/**
	 * apply's the appropriate effects to show a wagon traveling a day, adding distance, subtracting food, applying effects on health
	 */
	public void travelDay() {
				
			
		
			if (this.hasFoodLeft()) applyFoodEffects(party.size()*rationLevel);
		
		
			applyHealthEffects();
			distanceTraveled=distanceTraveled+pace;
			days++;
	}
	
	public void applyFoodEffects(int foodAmountNeeded) {
		if(foodAmountNeeded>this.getFoodLeft()) {
			
		}
		else {
			while (foodAmountNeeded>0) {
					Food foodItem = this.getFoodItem();
				if (foodItem.getWeight() > foodAmountNeeded){
					foodItem.eatFood(foodAmountNeeded);
					foodAmountNeeded = 0;
				}
				else if (foodItem.getWeight() == foodAmountNeeded) {
					this.removeItem(foodItem);
					foodAmountNeeded = 0;
				}
				else {
					foodAmountNeeded -= foodItem.getWeight();
					this.removeItem(foodItem);
				}
			}
		}
	}
	
	/**
	 * applies the health effects of having low rations, no food, or extremely poor health
	 */
	public void applyHealthEffects() {
		if(this.getFoodLeft()==0) groupHealth+=6;
		else if (rationLevel==2) groupHealth+=2;
		else if (rationLevel==1) groupHealth+=4;
		
		if(pace==20) groupHealth+=2;
		else if (pace==30) groupHealth+=4;
		else if (pace==40) groupHealth+=6;
	
		if(groupHealth>=140) {
			int healthCheckNum = -1;
			int deathIndex = 0;
			for (int i =0; i<party.size(); i++) {
				if (party.get(i).getHealthLevel()>healthCheckNum) {
					healthCheckNum = party.get(i).getHealthLevel();
					deathIndex = i;
				}
			}
			party.remove(deathIndex);
		}
	}
	
	/**
	 * get's the distance the wagon has traveled so far
	 * @return the distance the wagon has traveled
	 */
	public int getDistance() {
		return distanceTraveled;
	}
	
	public int getFoodLeft() {
		int foodWeight = 0;
		for (Item item : inventory) {
			if (item instanceof Food) foodWeight += item.getWeight(); 
		}
		return foodWeight;
	}

	
	/**
	 * get's the amount of money had in the wagon
	 * @return the current amount of money in the wagon
	 */
	public int getMoney() {
		return money;
	}
	
	/**
	 * for stores, essentially add item but also subtracts a price from the total amount of money the wagon has.
	 * @param item - the item you'ld like to purchase
	 * @param price - the price of the item
	 */
	public void buyItem (Item item, int price) {
		money-=price;
		this.addItem(item);
	}
	
	/**
	 * get's the groups health as a string from dying to good
	 * @return a string describing the current group health
	 */
	public String getGroupHealth() {
		if(groupHealth<=34) return "Good";
		else if(groupHealth<=65) return "Fair";
		else if(groupHealth<=104) return "Poor";
		else if(groupHealth<=139) return "Very Poor";
		else return "Dying";
	}
	
	/**
	 * 
	 * @param pace - a value 1-3 that shows the pace you travel a day
	 */
	public void setPace(int pace) {
		if(pace==1) this.pace=20;
		if(pace==2) this.pace=30;
		if(pace==3) this.pace=40;
	}
	
	/**
	 * set's the amount of food that each person on the wagon will get
	 * @param rationLevel - a value 1-3 that describes how much food each person is eating a day
	 */
	public void setRations(int rationLevel) {
		this.rationLevel=rationLevel;
	}
	
	/**
	 * get's the pace at which the wagon is traveling
	 * @return the pace at which the wagon is traveling
	 */
	public int getPace() {
		return pace;
	}
	
	/**
	 * get's the amount of days the wagon has been traveling
	 * @return the amount of days the wagon has been traveling
	 */
	public int getDay() {
		return days;
	}
	
	public Food getFoodItem() {
		for (Item item : inventory) {
			if (item instanceof Food) return (Food) item;
		}
		return null;
	}
	
	public boolean hasFoodLeft() {
		if (this.getFoodLeft() > 0) return true;
		else return false;
	}
	
	public boolean isPartyDead() {
		if(party.isEmpty()) return true;
		else return false;
	}
	
	public Item getRandomItem() {
		Random rnd = new Random();
		int i = rnd.nextInt(inventory.size());
		return inventory.get(i);
	}

	public Passenger getRandomPassenger() {
		Random rnd = new Random();
		int i = rndnextInt(party.size());
		return party.get(i);
	}

	

}