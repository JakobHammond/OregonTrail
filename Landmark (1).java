
public class Landmark {
	int location;
	String name;
	String line1;
	String line2;
	String line3;
	
	public Landmark() {
		
	}
	public Landmark(String lmName, int lmLocation) {
		name = lmName;
		location = lmLocation;
	}
	//returns the Landmark's location as an int
	public int getLocation() {
		return location;
	}
	
	public String getName() {
		return name;
	}
	//sets NPCs' dialogue lines
	public void setDialogue(String d1, String d2, String d3) {
				line1 = d1;
				line2 = d2;
				line3 = d3;
	}
			//gets a random dialogue line
	public String getRandDialogue() {
				java.util.Random rndGen = new java.util.Random();
				int randVal = rndGen.nextInt(3);
				
				if(randVal == 1) return line1;
				else if(randVal == 2) return line2;
				else return line3;
	}
}
