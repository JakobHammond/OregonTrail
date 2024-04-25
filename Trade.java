
/**
 * @FileName Trade.java
 * @Author Grace Conrad
 * @Date 4/17/24
 * Description: A trade that can be carried out between an NPC and the "wagon" which represents the player
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Trade {
	
	private ArrayList<Item> potentialTrades;
	private Item offer;
	private Item request;
	
	/**
	 * Constructor that gives a small amount of items for potential trades, for demo purposes only
	 */
	public Trade() {
		potentialTrades = new ArrayList<Item>();
		Item wagonParts = new Item(100, 50, "Wagon Parts");
		Item ammunition = new Item(50, 10, "Ammunition");
		Food beefJerkey = new Food(25, 25, "Beef Jerkey");
		potentialTrades.add(beefJerkey);
		potentialTrades.add(wagonParts);
		potentialTrades.add(ammunition);
		
		
	}
	
	/**
	 * set's the current offered item and requested items to random items from the potentialTrades ArrayList
	 */
	public void setRandTrade() {
		Random rand = new Random();
		int n = rand.nextInt(potentialTrades.size());
		offer = potentialTrades.get(n);
		
		n = rand.nextInt(potentialTrades.size());
		request = potentialTrades.get(n);
	}
	
	/**
	 * actually carries out the trade if possible, returning whether or not the trade occurred
	 * @param wagon - the wagon the trade is occurring with
	 * @return true if a trade was possible and occurred and false otherwise.
	 */
	public boolean tradeWithWagon(Wagon wagon) {
		
		boolean check = false;
		for (Item i: wagon.getInventory()) {
			if(i.getName().equals(request.getName())) check = true;
		}
		if (check) {
			wagon.addItem(offer);
			for (Item i: wagon.getInventory()) {
				if(i.getName().equals(request.getName())) {
					wagon.removeItem(i);
					break;
				}
			}
			return true;
		}
		else return false;
	}
	
	/**
	 * displays the trade menu in a given JFrame with buttons, textAreas, and Labels
	 * @param frame - the frame you'ld like to display the trade menu into
	 * @param wagon - the wagon you'ld like to trade with
	 */
	public void displayTrade(JFrame frame, Wagon wagon) {
		
		JLabel inventoryLabel = new JLabel("Inventory:");
		inventoryLabel.setBounds(60,248,438,16);
		frame.getContentPane().add(inventoryLabel);
		
		JTextArea wagonInventoryArea = new JTextArea();
		
		JScrollPane wagonInventoryPane = new JScrollPane(wagonInventoryArea);
		wagonInventoryPane.setBounds(60, 268, 345, 192);
		frame.getContentPane().add(wagonInventoryPane);
		String inventoryString = "";
		for(Item item: wagon.getInventory()) {
			inventoryString = inventoryString + item.getName() + "\n";
		}
		wagonInventoryArea.setText(inventoryString);
		
		setRandTrade();
		JLabel tradeLabel = new JLabel("Offered " + offer.getName() + " For " + request.getName());
		tradeLabel.setBounds(6, 117, 438, 16);
		frame.getContentPane().add(tradeLabel);
		
		JLabel warnLabel = new JLabel();
		warnLabel.setBounds(6,100,438,16);
		frame.getContentPane().add(warnLabel);
		
		JButton acceptButton = new JButton("Accept Trade");
		acceptButton.setBounds(6, 154, 117, 29);
		frame.getContentPane().add(acceptButton);
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tradeWithWagon(wagon)) {
					String inventoryString = "";
					for(Item item: wagon.getInventory()) {
						inventoryString = inventoryString + item.getName() + "\n";
					}
					wagonInventoryArea.setText(inventoryString);
				}
				else warnLabel.setText("Trade not possible");
			}
		});
		
		JButton refreshButton = new JButton("New Trade");
		refreshButton.setBounds(327, 154, 117, 29);
		frame.getContentPane().add(refreshButton);
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				warnLabel.setText("");
				setRandTrade();
				tradeLabel.setText("Offered " + offer.getName() + " For " + request.getName());
			}
		});
		
	}
		
	

}
	