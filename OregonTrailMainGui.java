import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Timer;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class OregonTrailMainGui {

	private JFrame frame;
	private Wagon wagon = new Wagon();
	private Weather weather = new Weather(0);
	private javax.swing.Timer dayTimer;
	private JLabel weatherLabel;
	private JLabel dayLabel;
	private JLabel healthLabel;
	private JLabel foodLabel;
	private JLabel milesToLabel;
	private JLabel milesTraveledLabel;
	private ArrayList<Landmark> locations;
	private JButton landmarkButton;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OregonTrailMainGui window = new OregonTrailMainGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OregonTrailMainGui() {
		initialize();
		
		dayTimer = new javax.swing.Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				passDay(evt);
			}
		});
		
	}
	
	public void passDay(ActionEvent evt) {
		wagon.travelDay();
		updateLabels();
		if (locations.get(0).getLocation() < (wagon.getPace()+wagon.getDistance())){
			wagon.setDistance(locations.get(0).getLocation());
			reachedLandmark();
		}
	}
	
	public void reachedLandmark() {
		landmarkButton.setText("Go to "+ locations.get(0).getLocation());
		frame.getContentPane().add(landmarkButton);
		landmarkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});

	}
	
	public void displayLandmark() {
		//display that gives options for conversation, shop, cross river
	}
	
	public void displayShop() {
		// changes frame to frame with shop display on it
	}
	
	public void displayTrade() {
	
	}
	
	public void displayRiver() {
		
	}
	
	public void removeRiverDisplay() {
		
	}
	
	public void removeTradeDisplay() {
		
	}
	
	public void removeLandmarkDisplay() {
		
	}
	
	public void removeBaseDisplay() {
		
	}
	
	public void updateLabels() {
		dayLabel.setText("Days: "+wagon.getDay());
		healthLabel.setText("Health: "+ wagon.getGroupHealth());
		foodLabel.setText("Food Left: "+ wagon.getFoodLeft());
		weatherLabel.setText("Weather: "+ weather.getCurrentTemp() + " and " +weather.getCurrentWeather());
		milesToLabel.setText("Miles to " + locations.get(0).getName() + ": " + (locations.get(0).getLocation()-wagon.getDistance()));
		milesTraveledLabel.setText("Miles traveled: "+ wagon.getDistance());
		
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 697, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel TrailPicLabel = new JLabel();
		TrailPicLabel.setBounds(152, 6, 539, 360);
		frame.getContentPane().add(TrailPicLabel);
		
		JButton menuButton = new JButton("Options");
		menuButton.setBounds(23, 400, 117, 29);
		frame.getContentPane().add(menuButton);
		
		dayLabel = new JLabel("Days: ");
		dayLabel.setBounds(6, 6, 117, 16);
		frame.getContentPane().add(dayLabel);
		
		healthLabel = new JLabel("Health: ");
		healthLabel.setBounds(6, 34, 61, 16);
		frame.getContentPane().add(healthLabel);
		
		foodLabel = new JLabel("Food Left: ");
		foodLabel.setBounds(6, 62, 61, 16);
		frame.getContentPane().add(foodLabel);
		
		weatherLabel = new JLabel("Weather: ");
		weatherLabel.setBounds(6, 90, 61, 16);
		frame.getContentPane().add(weatherLabel);
		
		milesToLabel = new JLabel("");
		milesToLabel.setBounds(6, 118, 61, 16);
		frame.getContentPane().add(milesToLabel);
		
		milesTraveledLabel = new JLabel("New label");
		milesTraveledLabel.setBounds(6, 146, 61, 16);
		frame.getContentPane().add(milesTraveledLabel);
		
		landmarkButton = new JButton();
		landmarkButton.setBounds(251, 400, 247, 29);
	
		
		/**
		 * base travel display w/ miles traveled, current weather, date, food left, group health, and miles to next location shown
		 * have listener to bring up a menu where you can see your inventory, change pace, change food rations, choose to rest for a day, 
		 * or choose to trade, if trade is chosen bring up trade display
		 * Start day Loop:
		 * check to ensure party isn't dead and that wagon is capable of moving.
		 * move one day, with all health effects
		 * check weather
		 * update displays to give current information
		 * if has lost bring up losing display, else ignore this
		 * check to see if at a location:
		 * if at a location prompt player to interact with location:
		 * if location is a fort give choice of conversation or shop
		 * if location is a river give choice of conversation or attempt to cross river
		 * otherwise location is just a spot for conversation and trading
		 * if not at a location or once location is left loop the days every couple of seconds
		 */
		
	}
}
