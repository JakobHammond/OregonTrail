import java.awt.EventQueue;
import java.util.Timer;
import java.awt.event.*;
import javax.swing.JFrame;

public class OregonTrailMainGui {

	private JFrame frame;
	private Wagon wagon = new Wagon();
	private javax.swing.Timer dayTimer;

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
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
