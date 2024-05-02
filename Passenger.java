
public class Passenger {
	private String name;
	private int healthLevel;
	
	public Passenger(String name) {
		this.name=name;
		healthLevel=0;
	}
	
	public void addBadEffect(int damage) {
		healthLevel+=damage;
	}
	
	public int getHealthLevel() {
		return healthLevel;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean equals (Passenger otherPassenger) {
		if (otherPassenger.getName()==name) return true;
		else return false;
	}
}
