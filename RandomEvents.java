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
		if(select <= 150) severeBlizzard = true; //15% chance; need to add condition for cold weather
			
		select = rnd.nextInt(1000) + 1;
		if(select <= 200) severeThunderstorm = true; //20% chance; need to add modifier based on month
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 60) heavyFog = true; //6% chance; need to add condition for hot weather
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 60) oxInjury = true; //6% chance; need to add modifier based on terrain
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 60) injuredPerson = true; //6% chance; need to add modifier based on terrain
		
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
		if(select <= 100) badWater = true; //10% chance; need to add condition for rainfall
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 200) littleWater = true; //20% chance; need to add condition for rainfall
		
		select = rnd.nextInt(1000) + 1;
		if(select <= 0) illness = true; //0% chance; need to add condition for health
		
	}
	
	public void eventHappens() {
		setEvents();
		
		//Consequences for event:
		if(oxInjury == true) Oxen.injureOx();
		
		
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
	
	
	
}
