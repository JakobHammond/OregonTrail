import java.util.Random;


public class RandomEvents {

	String event;
	
	//event booleans:
	boolean indiansFindFood = false;
	boolean findFruit = false;
	boolean findAbandonedWagon = false;
	boolean severeBlizzard = false;
	boolean severeThunderstorm = false;
	boolean heavyFog = false;
	boolean oxInjury = false;
	boolean injuredPerson = false;
	boolean snakeBite = false;
	boolean loseTrail = false;
	boolean wrongTrail = false;
	boolean wagonFire = false;
	boolean lostPerson = false;
	boolean lostOx = false;
	boolean thief = false;
	boolean badWater = false;
	boolean littleWater = false;
	boolean illness = false;
	
	String eventString;
	
	
	public void setEvents() {
		Random rnd = new Random();
		int select = rnd.nextInt(1000) + 1;
		
		//Positive Events:
		if(select <= 50) indiansFindFood = true; //5% chance
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 40) findFruit = true; //4% chance; need to add condition for month
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 20) findAbandonedWagon = true; //2% chance
		
		//Negative Events:
		select = rnd.nextInt(1000) + 1;
		if(select <= 150 && (Weather.getCurrentTemp() == "Very Cold")) severeBlizzard = true; //15% chance if weather is very cold
			
		select = rnd.nextInt(1000) + 1;
		if(select <= 200) severeThunderstorm = true; //20% chance; need to add modifier based on month
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 60 && (Weather.getCurrentTemp() == "Hot" || Weather.getCurrentTemp() == "Very Hot")) heavyFog = true; //6% chance if weather is hot/very hot
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 60 || (select <= 70 && Wagon.getPace() >= 30) || (select <= 80 && Wagon.getPace() >= 40)) oxInjury = true; //6% chance if slow pace, 7% if moderate pace, 8% if fast pace
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 60) injuredPerson = true; //6% chance
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 7) snakeBite = true; //0.7% chance
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 20) loseTrail = true; //2% chance
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 10) wrongTrail = true; //1% chance
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 20) wagonFire = true; //2% chance
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 10) lostPerson = true; // 1% chance
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 10) lostOx = true; //1% chance
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 20) thief = true; //2% chance
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 100 && Weather.getCurrentWeather != "Clear") badWater = true; //10% chance if clear weather
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 200 && Weather.getCurrentWeather != "Clear") littleWater = true; //20% chance if clear weather
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 200 && (Wagon.getGroupHealth() != "Good" && Wagon.getGroupHealth() != "Fair")) illness = true; //20% chance if health is bad
		
	}
	
	public void eventHappens() {
		setEvents();
		eventString = "";
		
		//Consequences for event:
		if(indiansFindFood == true) {
			Food foundFood = new Food(8, 0, "Food");
			Wagon.addItem(foundFood);
			eventString += "Indians helped you find food; you gained 8 pounds of food. ";
		}
		if(findFruit == true) {
			Food fruit = new Food(5, 0, "Fruit");
			Wagon.addItem(fruit);
			eventString += "You found fruit; you gained 5 pounds of food. ";
		}
		if(findAbandonedWagon == true) {
			Food abandonedFood = new Food(20, 0, "Food");
			Wagon.addItem(abandonedFood);
			eventString += "You found an abandoned wagon; you gained 20 pounds of food. ";
		}
		if(severeBlizzard == true) {
			Wagon.restDay(4);
			eventString += "There was a severe blizzard; you lost 4 days. ";
		}
		if(severeThunderstorm == true) {
			Wagon.restDay(2);
			eventString += "There was a severe thunderstorm; you lost 2 days. ";
		}
		if(heavyFog == true) {
			Wagon.restDay(1);
			eventString += "There was heavy fog; you lost 1 day. ";
		}
		if(oxInjury == true) {
			Oxen.injureOx();
			eventString += "One of your oxen was hurt. ";
		}
		if(injuredPerson == true) {
			Wagon.getRandomPassenger().addBadEffect(30); 
			eventString += "One of your party members has been injured. ";
		}
		if(snakeBite == true) {
			Wagon.getRandomPassenger().addBadEffect(50); 
			eventString += "One of your party members has been bitten by a snake. ";
		}
		if(loseTrail == true) {
			Wagon.restDay(1);
			eventString += "You lost the trail; you lost 1 day. ";
		}
		if(wrongTrail == true) {
			Wagon.restDay(2);
			eventString += "You went down the wrong trail; you lost 2 days. ";
		}
		if(wagonFire == true) {
			Wagon.removeItem(Wagon.getRandomItem());
			eventString += "Your wagon caught fire and burned one of your items. ";
		}
		if(lostPerson == true) {
			Wagon.restDay(3);
			eventString += (Wagon.getRandomPassenger().getName() + " got lost; you lost 3 days. ");
		}
		if(lostOx == true) {
			Wagon.addDays(2);
			eventString += "One of your oxen got lost; you lost 2 days. ";
		}
		if(thief == true) {
			Wagon.removeMoney(50);
			eventString += "A thief came in the middle of the night; you lost $50. ";
		}
		if(badWater == true) {
			Wagon.getRandomPassenger().addBadEffect(10);
			eventString += "One of your part members drank bad water. ";
		}
		if(littleWater == true) {
			Wagon.alterHealth(3);
			eventString += "Your party has very little water. ";
		}
		if(illness == true) {
			Wagon.alterHealth(5);
			Wagon.getRandomPassenger().addBadEffect(15);
			eventString += "Illness is affecting your party. ";
		}
		
		
		//Reset booleans:
		indiansFindFood = false;
		findFruit = false;
		findAbandonedWagon = false;
		severeBlizzard = false;
		severeThunderstorm = false;
		heavyFog = false;
		oxInjury = false;
		injuredPerson = false;
		snakeBite = false;
		loseTrail = false;
		wrongTrail = false;
		wagonFire = false;
		lostPerson = false;
		lostOx = false;
		thief = false;
		badWater = false;
		littleWater = false;
		illness = false;
	}
	
	public String getEventString() {
		return eventString;
	}
	
	
	
}
