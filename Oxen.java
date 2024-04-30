import java.util.Random;

public class Oxen {

	double numOxen;
	int oxenHealth = 100; //if <= 0, oxen start to get injured/die
	
	public void decreaseHealth(int decrease) {
		oxenHealth -= decrease;
	}
	
	public void killOx() {
		if(Math.floor(numOxen) != numOxen) numOxen -= 0.5;
		numOxen -= 1;
	}
	
	public void injureOx() {
		if(Math.floor(numOxen) == numOxen)numOxen -= 0.5;
		else killOx();
	}
	
	public double getNumOxen() {
		return numOxen;
	}
	
	public int getHealth() {
		return oxenHealth;
	}
	
	public void shouldOxenDie() {
		if(oxenHealth <= 0) {
			Random rnd = new Random();
			if(rnd.nextInt(2) == 1) {
				injureOx();
			}
		}
	}
	
}
