
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

public class ShopMenu extends Menu {

	public ShopMenu(JFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}
	public void Display (Shop shop, Wagon wagon, JFrame landmarkFrame, JFrame baseFrame, boolean check) {
		ArrayList<Item> Stock = shop.getStock();
		double priceMultiplier = shop.getPriceMultiplier();
		
		int n = shop.getStock().size();
		String[] stockList = new String[n];
		for(int i=0; i<n; i++) {
			stockList[i]=shop.getStock().get(i).getName()+": "+(shop.getStock().get(i).getBasePrice()*shop.getPriceMultiplier()); //displays the items available for purchase and their prices into a String ArrayList
		}
		
		JList<String> list = new JList<>(stockList);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JScrollPane stockPane = new JScrollPane(list);
		stockPane.setBounds(6, 27, 194, 347);
		frame.getContentPane().add(stockPane);
		
		JTextArea inventoryArea = new JTextArea();
		inventoryArea.setBounds(322, 27, 194, 347);
		frame.getContentPane().add(inventoryArea);
		ArrayList<Item> inventory = wagon.getInventory();
		String inventoryString = "";
		for(Item item: inventory) {
			inventoryString = inventoryString + item.getName() + "\n";
		}
		inventoryArea.setText(inventoryString);
	
		JLabel moneyLabel = new JLabel("Money: " + wagon.getMoney());
		moneyLabel.setBounds(16, 386, 184, 16);
		frame.getContentPane().add(moneyLabel);
		
		
		JLabel stockLabel = new JLabel("Stock");
		stockLabel.setBounds(67, 6, 61, 16);
		frame.getContentPane().add(stockLabel);
		
		JLabel errorLabel = new JLabel();
		errorLabel.setBounds(16, 445, 431, 16);
		frame.getContentPane().add(errorLabel);
		
		JButton exitButton = new JButton("Continue");
		exitButton.setBounds(560, 445, 117, 29);
		frame.getContentPane().add(exitButton);
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				if(check)landmarkFrame.setVisible(true);
				else baseFrame.setVisible(true);
			}
			
		});
		
		
		JLabel inventoryLabel = new JLabel("Inventory");
		inventoryLabel.setBounds(386, 6, 61, 16);
		frame.getContentPane().add(inventoryLabel);
		
		JButton purchaseButton = new JButton("Buy");
		purchaseButton.setBounds(201, 187, 117, 29);
		frame.getContentPane().add(purchaseButton);
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] indices = list.getSelectedIndices();
				for(int i: indices) {
					
					if (wagon.getMoney()<Stock.get(i).getBasePrice()*priceMultiplier) errorLabel.setText("Not enough Money"); //checks to ensure you have enough money for purchase
					else if(wagon.hasRoomForItem(Stock.get(i))) {
						wagon.buyItem(Stock.get(i),Stock.get(i).getBasePrice()*priceMultiplier);
					}
					else errorLabel.setText("would put wagon over weight");
				}
				ArrayList<Item> inventory = wagon.getInventory();
				String inventoryString = "";
				for(Item item: inventory) {
					inventoryString = inventoryString + item.getName() + "\n";
				}
				inventoryArea.setText(inventoryString);
				moneyLabel.setText("Money: "+wagon.getMoney());			
			}
			
		});
		
	}
}
