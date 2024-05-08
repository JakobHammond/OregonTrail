import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class baseMenu extends Menu {

	public baseMenu(JFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}
	
	public void Display(Landmark location, JFrame landmarkFrame, JFrame optionsFrame, Wagon wagon, Weather weather) {
		JLabel trailPicLabel = new JLabel();
		trailPicLabel.setBounds(152, 6, 539, 360);
		
		ImageIcon image = new ImageIcon(getClass().getResource("OregonTrailClearWeatherOx-1.png.png"));
		trailPicLabel.setIcon(image);
		trailPicLabel.setOpaque(true);
		JButton menuButton = new JButton("Options");
		menuButton.setBounds(23, 400, 117, 29);
		RandomEvents randomEvent = new RandomEvents();
		menuButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				optionsFrame.setVisible(true);
				frame.setVisible(false);
			}
			
		});
		
		
		JLabel dayLabel = new JLabel("Days: "+wagon.getDay());
		dayLabel.setBounds(6, 6, 117, 16);
		JLabel healthLabel = new JLabel("Health: "+wagon.getGroupHealth());
		healthLabel.setBounds(6, 34, 100, 16);
		JLabel foodLabel = new JLabel("Food Left: "+wagon.getFoodLeft());
		foodLabel.setBounds(6, 62, 200, 100);
		JLabel weatherLabel = new JLabel("Weather: "+weather.getCurrentTemp()+" and " + weather.getCurrentWeather());
		weatherLabel.setBounds(6, 90,200, 16);
		JLabel milesToLabel = new JLabel("Miles to " + location.getName() + ":" + (location.getLocation()-wagon.getDistance()));
		milesToLabel.setBounds(6, 118, 200, 16);
		JLabel milesTraveledLabel = new JLabel("Miles Traveled: " + wagon.getDistance());
		milesTraveledLabel.setBounds(6, 138, 200, 16);
		JLabel eventLabel = new JLabel();
		eventLabel.setBounds(6, 287, 1000, 16);
		frame.getContentPane().add(eventLabel);
		
		JButton landmarkButton = new JButton();
		landmarkButton.setBounds(251, 400, 247, 29);
		landmarkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				landmarkFrame.setVisible(true);
				frame.setVisible(false);
			}
			
		});
		
		JButton nextDayButton = new JButton("Travel Day");
		nextDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wagon.travelDay();
				weather.WeatherDay(location.getLocation());
				System.out.println(location.getLocation());
				randomEvent.setEvents(weather, wagon);
				Random rand = new Random();
				int i = rand.nextInt(10);
				if (i>5) {
					randomEvent.eventHappens(wagon, weather);
					eventLabel.setText(randomEvent.getEventString());
				}
				

				if(wagon.getDistance()>location.getLocation()) {
					
					landmarkButton.setVisible(true);
					wagon.setDistance(location.getLocation());
				}
				else landmarkButton.setVisible(false);
				
				dayLabel.setText("Days: "+wagon.getDay());
				healthLabel.setText("Health: "+wagon.getGroupHealth());	
				foodLabel.setText("Food Left: "+wagon.getFoodLeft());
				weatherLabel.setText("Weather: "+weather.getCurrentTemp()+" and " + weather.getCurrentWeather());
				milesToLabel.setText("Miles to " + location.getName() + ": " + (location.getLocation()-wagon.getDistance()));
				milesTraveledLabel.setText("Miles Traveled: " + wagon.getDistance());
			}
		});
		nextDayButton.setBounds(558, 6, 117, 29);
		frame.getContentPane().add(nextDayButton);
		
		
		JButton restDayButton = new JButton("Rest Day");
		restDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wagon.restDay(1);
				weather.WeatherDay(location.getLocation());
				
				
				dayLabel.setText("Days: "+wagon.getDay());
				healthLabel.setText("Health: "+wagon.getGroupHealth());	
				foodLabel.setText("Food Left: "+wagon.getFoodLeft());
				weatherLabel.setText("Weather: "+weather.getCurrentTemp()+" and " + weather.getCurrentWeather());
				milesToLabel.setText("Miles to " + location.getName() + ":" + (location.getLocation()-wagon.getDistance()));
				milesTraveledLabel.setText("Miles Traveled: " + wagon.getDistance());
			}
		});
		restDayButton.setBounds(400, 6, 117, 29);
		frame.getContentPane().add(restDayButton);


		
		
		frame.getContentPane().add(milesTraveledLabel);
		frame.getContentPane().add(milesToLabel);
		frame.getContentPane().add(weatherLabel);
		frame.getContentPane().add(foodLabel);
		frame.getContentPane().add(healthLabel);
		frame.getContentPane().add(dayLabel);
		frame.getContentPane().add(trailPicLabel);
		frame.getContentPane().add(menuButton);
		frame.getContentPane().add(landmarkButton); 
	}

}
