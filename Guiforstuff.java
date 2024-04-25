/**
 * @FileName: Guiforsuff.java
 * Author: Max Williams
 * Date: 4/17/24
 * Description: Implements all prototypes of shop river and trade classes into a concise GUI
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Guiforstuff {

	private JFrame shopFrame;
	private JFrame riverFrame;
	private JFrame tradeFrame;
	private Wagon wagon = new Wagon();
	private Shop shop = new Shop();
	private River river = new River(2, 2);
	private Trade trade = new Trade();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guiforstuff window = new Guiforstuff();
					window.shopFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Guiforstuff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		shopFrame = new JFrame();
		shopFrame.setBounds(100, 100, 450, 507);
		shopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		shopFrame.getContentPane().setLayout(null);
		
		riverFrame = new JFrame();
		riverFrame.setBounds(100, 100, 450, 507);
		riverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		riverFrame.getContentPane().setLayout(null);
		riverFrame.setVisible(false);
		
		tradeFrame = new JFrame();
		tradeFrame.setBounds(100, 100, 450, 507);
		tradeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tradeFrame.getContentPane().setLayout(null);
		
		shop.displayShop(shopFrame, wagon);
		
		//Button switches to next display from shop to river to trade.
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(shopFrame.isVisible()) { //if currently on shopFrame switches to riverFrame
					shopFrame.setVisible(false);
					riverFrame.setVisible(true);
					river.displayRiver(riverFrame, wagon);
					riverFrame.getContentPane().add(nextButton);
				}
				else if (riverFrame.isVisible()) { //if currently on riverFrame switches to tradeFrame
					riverFrame.setVisible(false);
					tradeFrame.setVisible(true);
					trade.displayTrade(tradeFrame, wagon);
				}
			}
		});
		nextButton.setBounds(333, 6, 117, 29);
		shopFrame.getContentPane().add(nextButton);
		
		
		
		
		
		
	}
}
