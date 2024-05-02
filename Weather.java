import java.util.Random;

public class Weather {
	private double accumulatedRain;
	private double accumulatedSnow;
	private String currentWeather;
	private String currentTemp;
	
	public Weather(int distanceTraveled) {
		accumulatedRain = 1;
		accumulatedSnow = 0;
		this.newCurrentTemp(distanceTraveled);
		this.newCurrentWeather(distanceTraveled);
	}
	
	public void newCurrentTemp(int distanceTraveled) {
		//switch based on six zones and distanceTraveled to get avg-temp.
		int avgTemp = 51;
		if (distanceTraveled<200) avgTemp = 40; //like this
		Random rand = new Random();
		int actualTemp = rand.nextInt(avgTemp-20,avgTemp+21);
		if(actualTemp>90) currentTemp = "Very Hot";
		else if (actualTemp>70) currentTemp = "Hot";
		else if (actualTemp>50) currentTemp = "Warm";
		else if (actualTemp>30) currentTemp = "Cool";
		else if (actualTemp>10) currentTemp = "Cold";
		else currentTemp = "Very Cold";
	}
	
	public void newCurrentWeather(int distanceTraveled) {
		
		double avgRainfall = 4.8;
		if(distanceTraveled<200) avgRainfall = 2.4; //Similar to current temperature changes based on "zone".
		Random rand = new Random();
		if (rand.nextDouble(10)<avgRainfall) {
			if(currentTemp=="Cold"||currentTemp=="Very Cold") {
				if(rand.nextInt(10)<3) currentWeather = "Heavy Snow";
				else currentWeather = "Light Snow";
			}
			else {
				if(rand.nextInt(10)<3) currentWeather = "Heavy Rain";
				else currentWeather = "Light Rain";
			}
		}
		else currentWeather = "Clear";
	}
	
	public String getCurrentTemp() {
		return currentTemp;
	}
	
	public String getCurrentWeather() {
		return currentWeather;
	}
	
	public void WeatherDay(int distanceTraveled) {
		Random rand = new Random();
		if(rand.nextInt()<5) {
			this.newCurrentWeather(distanceTraveled);
			this.newCurrentTemp(distanceTraveled);
		}
		if (currentWeather == "Light Rain") accumulatedRain+=.2;
		else if (currentWeather == "Heavy Rain") accumulatedRain+=.8;
		else if (currentWeather == "Heavy Snow") accumulatedSnow+=8;
		else if (currentWeather == "Light Snow") accumulatedSnow+=2;
		else {
			if(accumulatedRain>0)accumulatedRain-=(.01*accumulatedRain);
			if(accumulatedSnow>0) {
				if(currentTemp == "Very Hot"||currentTemp == "Hot"|| currentTemp == "Warm") {
					accumulatedSnow-=5;
					accumulatedRain += .5;
					if(accumulatedSnow<0) accumulatedSnow = 0;
				}
				else accumulatedSnow-=(.03*accumulatedSnow);
				}
			}
		if(accumulatedRain < .1) currentWeather = "Severe Drought";
		else if (accumulatedRain < .2) currentWeather = "Drought";
		}


}
