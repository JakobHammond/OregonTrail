import java.util.Random;

public class Weather {
	private double accumulatedRain;
	private double accumulatedSnow;
	private String currentWeather;
	private String currentTemp;
	
	//distances of "zones" from start
	int NEBRASKA_DIST = 600;
	int WYOMING_DIST = 800;
	int IDAHO_DIST = 1800;
	int OREGON_DIST = 2200;
	//average temps for each zone (in degrees Fahrenheit)
	int KANSAS_TEMP = 79;
	int NEBRASKA_TEMP = 74;
	int WYOMING_TEMP = 67;
	int IDAHO_TEMP = 75;
	int OREGON_TEMP = 70;
	//average rainfalls for each zone (in inches per week)
	double KANSAS_RAIN = 0.824;
	double NEBRASKA_RAIN = 0.723;
	double WYOMING_RAIN = 0.237;
	double IDAHO_RAIN = 0.056;
	double OREGON_RAIN = 0.169;
	
	public Weather(int distanceTraveled) {
		accumulatedRain = 1;
		accumulatedSnow = 0;
		this.newCurrentTemp(distanceTraveled);
		this.newCurrentWeather(distanceTraveled);
	}
	
	public void newCurrentTemp(int distanceTraveled) {
		//switch based on six zones and distanceTraveled to get avg-temp.
		//int avgTemp = 51;
		
		int avgTemp;
		if(distanceTraveled >= OREGON_DIST) avgTemp = OREGON_TEMP;
		else if(distanceTraveled >= IDAHO_DIST) avgTemp = IDAHO_TEMP;
		else if(distanceTraveled >= WYOMING_DIST) avgTemp = WYOMING_TEMP;
		else if(distanceTraveled >= NEBRASKA_DIST) avgTemp = NEBRASKA_TEMP;
		else avgTemp = KANSAS_TEMP;
		
		
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
		
		//Similar to current temperature changes based on "zone".
		//Set average weekly rainfall according to which zone the player is in
		double avgRainfall;
		if(distanceTraveled >= OREGON_DIST) avgRainfall = OREGON_RAIN;
		else if(distanceTraveled >= IDAHO_DIST) avgRainfall = IDAHO_RAIN;
		else if(distanceTraveled >= WYOMING_DIST) avgRainfall = WYOMING_RAIN;
		else if(distanceTraveled >= NEBRASKA_DIST) avgRainfall = NEBRASKA_RAIN;
		else avgRainfall = KANSAS_RAIN;
		
		
		
		
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