import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Timer;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class OregonTrailMainGui {

	private JFrame baseFrame;
	private JFrame shopFrame;
	private JFrame landmarkFrame;
	private JFrame riverFrame;
	private JFrame startFrame;
	private JFrame optionsFrame;
	private baseMenu baseMenu;
	private ShopMenu shopMenu;
	private StartMenu startMenu;
	private OptionsMenu optionsMenu;
	private RiverMenu riverMenu;
	private LandmarkMenu landmarkMenu;
	private Shop shop;
	private Wagon wagon = new Wagon();
	private Weather weather = new Weather(0);
	private ArrayList<Landmark> locations;
	private ArrayList<Item> availableItems;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OregonTrailMainGui window = new OregonTrailMainGui();
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
		
		wagon = new Wagon();
		weather = new Weather(0);
				 Fort fortWallaWalla = new Fort("Fort Walla Walla", 350);
				 Landmark blueMountains = new Landmark("Blue Mountains", 2800);
			     Fort fortBridger = new Fort("Fort Bridger", 1500);
			     Landmark independenceRock = new Landmark("Independence Rock", 1000);
			     Landmark southPass = new Landmark("South Pass", 1200);
			     Fort fortLaramie = new Fort("Fort Laramie", 800);
			     Landmark theDalles = new Landmark("The Dalles", 3000);
			     locations = new ArrayList<Landmark>();
			     locations.add(fortWallaWalla);
			     locations.add(fortLaramie);
			     locations.add(independenceRock);
			     locations.add(southPass);
			     locations.add(fortBridger);
			     locations.add(blueMountains);
			     locations.add(theDalles);
			     
			     Food bacon = new Food(200, 0.20, "Bacon");
			     Food flour = new Food(100, 0.02, "Flour");
			     Food cornmeal = new Food(100, 0.02, "Cornmeal");
			     Food rice = new Food(100, 0.06, "Rice");
			     Food beans = new Food(100, 0.06, "Beans");
			     Food saltPork = new Food(200, 0.16, "Salt Pork");
			     Food beef = new Food(200, 0.16, "Beef");
			     Item boots = new Item(1, 10.00, "Boots");
			     Item shoes = new Item(1, 5.00, "Shoes");
			     Item pants = new Item(1, 5.00, "Pants");
			     Item dresses = new Item(1, 5.00, "Dresses");
			     Item shirts = new Item(1, 2.00, "Shirts");
			     Item ammunition = new Item(20, 2.00, "Ammunition");
			     Item wagonWheel = new Item(1, 10.00, "Wagon Wheel");
			     Item sparePartsKit = new Item(1, 20.00, "Spare Parts Kit");
			     Item fishingPole = new Item(1, 2.00, "Fishing Pole");
			     Item rifle = new Item(1, 20.00, "Rifle");
			     Item pistol = new Item(1, 10.00, "Pistol");
			     Item firstAidKit = new Item(1, 5.00, "First Aid Kit");
			     Item map = new Item(1, 5.00, "Map");
			     
			     availableItems = new ArrayList<Item>();
			     availableItems.add(bacon);
			     availableItems.add(flour);
			     availableItems.add(cornmeal);
			     availableItems.add(rice);
			     availableItems.add(beans);
			     availableItems.add(saltPork);
			     availableItems.add(shoes);
			     availableItems.add(shirts);
			     availableItems.add(ammunition);
			     availableItems.add(wagonWheel);
			     availableItems.add(firstAidKit);
			     
			     shop = new Shop(availableItems);
			     
			     
				
		initialize();
		
		optionsMenu = new OptionsMenu(optionsFrame);
		shopMenu = new ShopMenu(shopFrame);
		baseMenu = new baseMenu(baseFrame);
		startMenu = new StartMenu(startFrame);
		landmarkMenu = new LandmarkMenu(landmarkFrame);
		riverMenu = new RiverMenu(riverFrame);
		
		baseMenu.Display(locations.get(0),landmarkFrame,optionsFrame,wagon,weather);
		shopMenu.Display(shop,wagon,landmarkFrame,baseFrame,false);
		startMenu.Display(shopFrame);
		optionsMenu.Display(wagon,baseFrame);
		startFrame.setVisible(true);
		
		
		
		

		
		
		//start display
		//display shop
		//then start on trail
		
		
		
}
	
	public void passDay() {
		wagon.travelDay();
		weather.WeatherDay(locations.get(0).getLocation());
		baseMenu.Display(locations.get(0),landmarkFrame,optionsFrame,wagon,weather);
	}
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		baseFrame = new JFrame();
		baseFrame.setBounds(100, 100, 697, 541);
		baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		baseFrame.getContentPane().setLayout(null);
						
		startFrame = new JFrame();
		startFrame.setBounds(100, 100, 697, 541);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.getContentPane().setLayout(null);
		
		shopFrame = new JFrame();
		shopFrame.setBounds(100, 100, 697, 541);
		shopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		shopFrame.getContentPane().setLayout(null);
		
		optionsFrame = new JFrame();
		optionsFrame.setBounds(100, 100, 697, 541);
		optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		optionsFrame.getContentPane().setLayout(null);
		
		landmarkFrame = new JFrame();
		landmarkFrame.setBounds(100, 100, 697, 541);
		landmarkFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		landmarkFrame.getContentPane().setLayout(null);
		
		riverFrame = new JFrame();
		riverFrame.setBounds(100, 100, 697, 541);
		riverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		riverFrame.getContentPane().setLayout(null);
		
		
		
	
		
		
	
	
		
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
