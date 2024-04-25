/**
 * FileName: Shop.java
 * Author: Anthony Parker
 * Date: 4/17/24
 * Description: generates a shop for an Oregon trail game which has an array list of items that represents the "Stock" of the shop, 
 * this Stock can be purchased from, also displays this shop in a given Frame.
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Shop {
	private ArrayList<Item> Stock;
	private double priceMultiplier; //to increase prices as you travel to further forts 
	
	/**
	 * Constructor that loads shop with three basic items, for demo use only.
	 */
	public Shop() {
		priceMultiplier=1;
		Stock = new ArrayList<Item>();
		Item wagonParts = new Item(100, 50, "Wagon Parts");
		Item ammunition = new Item(50, 10, "Ammunition");
		Food beefJerkey = new Food(25, 25, "Beef Jerkey");
		Stock.add(wagonParts);
		Stock.add(beefJerkey);
		Stock.add(ammunition);
	}
	
	/**
	 * displays the shop and current wagon inventory into a selected frame
	 * @param frame -the frame you'ld like to display the shop interface into
	 * @param wagon -the wagon that you'ld like to interact with the shop
	 */
	public void displayShop(JFrame frame, Wagon wagon) {
		
		int n = Stock.size();
		String[] stockList = new String[n];
		for(int i=0; i<n; i++) {
			stockList[i]=Stock.get(i).getName()+": "+(Stock.get(i).getBasePrice()*priceMultiplier); //displays the items available for purchase and their prices into a String ArrayList
		}
		
		JList<String> list = new JList<>(stockList);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JLabel priceLabel = new JLabel("Total: ");
		priceLabel.setBounds(55, 221, 192, 16);
		frame.getContentPane().add(priceLabel);
		
		JLabel warnLabel = new JLabel();
		warnLabel.setBounds(45, 23, 344, 16);
		frame.getContentPane().add(warnLabel);
		
		JLabel moneyLabel = new JLabel("Money: "+wagon.getMoney());
		moneyLabel.setBounds(35, 6, 151, 16);
		frame.getContentPane().add(moneyLabel);
		
		JButton purchaseButton = new JButton("Purchase");
		purchaseButton.setBounds(259, 221, 117, 29);
		frame.getContentPane().add(purchaseButton);
		
		JScrollPane outputPane = new JScrollPane(list); //the pane that displays the JList which holds the stock of the Shop.
		outputPane.setBounds(91, 73, 274, 143);
		frame.getContentPane().add(outputPane);
		
		JLabel inventoryLabel = new JLabel("Inventory:");
		inventoryLabel.setBounds(60,248,438,16);
		frame.getContentPane().add(inventoryLabel);
		
		JTextArea wagonInventoryArea = new JTextArea();
		
		JScrollPane wagonInventoryPane = new JScrollPane(wagonInventoryArea);
		wagonInventoryPane.setBounds(60, 268, 345, 192);
		frame.getContentPane().add(wagonInventoryPane);
		
		
		
		//listener for selecting items in the shop
		list.addListSelectionListener( new ListSelectionListener() {
			public void valueChanged( ListSelectionEvent e) {
				double totalPrice = 0;
				int[] indices = list.getSelectedIndices();
				for(int i: indices) {
					totalPrice+=Stock.get(i).getBasePrice()*priceMultiplier;
				}
				priceLabel.setText("Total: "+totalPrice+" Dollars"); 
			}
		});
		
		//listener for actually purchasing items from the shop.
		purchaseButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] indices = list.getSelectedIndices();
				for(int i: indices) {
					if (wagon.getMoney()<Stock.get(i).getBasePrice()*priceMultiplier) warnLabel.setText("Not enough Money"); //checks to ensure you have enough money for purchase
					else if(wagon.buyItem(Stock.get(i),Stock.get(i).getBasePrice()*priceMultiplier));
					else warnLabel.setText("would put wagon over weight");
				}
				ArrayList<Item> inventory = wagon.getInventory();
				String inventoryString = "";
				for(Item item: inventory) {
					inventoryString = inventoryString + item.getName() + "\n";
				}
				wagonInventoryArea.setText(inventoryString);
				moneyLabel.setText("Money: "+wagon.getMoney());
				
			}
			
		});
	}
}
