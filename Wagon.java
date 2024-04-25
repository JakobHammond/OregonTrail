

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
	private ArrayList<Passenger> people;
	private int groupHealth; //increases to indicate poor health
	private final int MAXWEIGHT = 2400;
	private int weight;
	private int foodWeight; //amount of edible food
	private int numPeople;
	private int distanceTraveled;
	private int pace;
	private int rationLevel;
	private double money;
	private int days;
	
	
	public Wagon() {
		// TODO Auto-generated constructor stub
		inventory = new ArrayList<Item>();
		money=100;
		weight=0;
		foodWeight=0;
		numPeople=5;
		groupHealth=0;
		days=0;
		
	}
	
	/**
	 * adds a specified item to the wagons inventory if adding the item wouldn't put the wagon over Max weight, 
	 * will return false if item wasn't successfully added
	 * @param item - the item you'ld like to add to wagon's inventory
	 * @return true if Item was successfully added, false otherwise
	 */
	public boolean addItem(Item item) {
		
		if((weight+item.getWeight())<=MAXWEIGHT) {
			inventory.add(item);
			weight=weight+item.getWeight();
			if (item instanceof Food && ((Food) item).getNutrition()) foodWeight+=item.getWeight();//checks that item is food and has nutritional value
			return true;
		}
		else return false;
	}
	
	/**
	 * removes a specified item from the wagon's inventory 
	 * @param item - the item you'ld like to remove from wagon's inventory
	 */
	public void removeItem(Item item) {
		
		inventory.remove(item);
		weight=weight-item.getWeight();
		if (item instanceof Food && ((Food) item).getNutrition()) foodWeight-=item.getWeight();
	}
	
	/**
	 * apply's the appropriate effects to show a wagon traveling a day, adding distance, subtracting food, applying effects on health
	 */
	public void travelDay() {
		distanceTraveled=distanceTraveled+pace;
		foodWeight=foodWeight-(numPeople*rationLevel);
		applyHealthEffects();
		days++;
	}
	
	/**
	 * applies the health effects of having low rations, no food, or extremely poor health
	 */
	public void applyHealthEffects() {
		if(foodWeight==0) groupHealth+=6;
		else if (rationLevel==2) groupHealth+=2;
		else if (rationLevel==1) groupHealth+=4;
		
		if(pace==20) groupHealth+=2;
		else if (pace==30) groupHealth+=4;
		else if (pace==40) groupHealth+=6;
	
		if(groupHealth>=140) {
			Random rand = new Random();
			people.remove(rand.nextInt(people.size())); //random person is removed when health is too poor, will change to most injured person when implimented
		}
	}
	
	/**
	 * get's the distance the wagon has traveled so far
	 * @return the distance the wagon has traveled
	 */
	public int getDistance() {
		return distanceTraveled;
	}
	
	/**
	 * get's the amount of food left in the wagon
	 * @return the current amount of food in pounds
	 */
	public int getFoodWeight() {
		return foodWeight;
	}
	
	/**
	 * get's the amount of money had in the wagon
	 * @return the current amount of money in the wagon
	 */
	public double getMoney() {
		return money;
	}
	
	/**
	 * for stores, essentially add item but also subtracts a price from the total amount of money the wagon has.
	 * @param item - the item you'ld like to purchase
	 * @param price - the price of the item
	 */
	public boolean buyItem (Item item, double price) {
		if(addItem(item)&&money>price) {
			money-=price;
			return true;
		}
		else return false;
	}
	
	public void buyService(double price) {
		money-=price;
	}
	
	/**
	 * get's the groups health as a string from dying to good
	 * @return a string describing the current group health
	 */
	public String getHealth() {
		if(groupHealth<=34) return "Good";
		else if(groupHealth<=65) return "Fair";
		else if(groupHealth<=104) return "Poor";
		else if(groupHealth<=139) return "Very Poor";
		else return "Dying";
	}
	
	/**
	 * set's the pace the wagon travels a day
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
	
	/**
	 * get's the current inventory of the wagon
	 * @return the current inventory of the wagon as an ArrayList of Item
	 */
	public ArrayList<Item> getInventory(){
		return inventory;
	}
	

}
