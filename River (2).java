/**
 * @author Jakob Hammond
 * @FileName River.java
 * @Date 4/17/24
 * Description: a River for Oregon Trail Game that has a depth width and boolean fast value which can determine whether or not a specified wagon 
 * will be able to cross depending on if it chooses to ford, float, or ferry.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class River extends Landmark{

	double depth;
	double width;
	static double FERRY_PRICE = 20;
	boolean isFast;
	
	//default constructor
	public River() {
		
	}
	/**
	 * 
	 * @param startDepth - the depth of the river
	 * @param startWidth - the width of the river
	 */
	public River(double startDepth, double startWidth) {
		depth = startDepth;
		width = startWidth;
		isFast=false;
	}
	/**
	 * 
	 * @param lmName - the name of the river
	 * @param lmLocation - the location of the river
	 * @param startDepth - the depth of the river
	 * @param startWidth - the width of the river
	 */
	public River(String lmName, int lmLocation, double startDepth, double startWidth) {
		name = lmName;
		location = lmLocation;
		depth = startDepth;
		width = startWidth;
	}
	/**
	 * 
	 * @param newDepth - the new depth of the river
	 */
	public void setDepth(double newDepth) {
		depth = newDepth;
	}
	//adds (or subtracts if negative number) depth to the river
	/**
	 * 
	 * @param depthIncrement - the amount of depth added to the river (negative if subtracting)
	 */
	public void alterDepth(double depthIncrement) {
		depth += depthIncrement;
	}
	
	
	/**
	 * checks if the player successfully crosses the river
	 * @param choice - how the player crosses the river (ford, float, or ferry)
	 * @param wagon - the player's wagon
	 * @return true if they successfully cross and false if they fail
	 */
	public boolean didCrossRiver(String choice, Wagon wagon) {
		//randomness still a work in progress
		
		Random rnd = new Random();
		int luck = rnd.nextInt(80) + 21; //value between 20 and 100
		
		//speed and depth are the main factors if fording
		if(choice == "ford") {
			//randomness still a work in progress
			
			//total failure:
			if(depth > 5) return false; //do not cross if too deep
			if(isFast == true) return false; //do not cross if fast
			if((luck / depth) < 20) return false; //otherwise, let fate decide (50% if 3 feet deep)
			//partial failure:
			if((luck / depth) < 24) {
				loseToRiver((depth + width) / luck, wagon); //lose more the deeper and wider the river is
				return true;
			}
			//total success:
			return true;
			
		}
		//speed and width are the main factors if floating
		else if(choice == "float") {
			//randomness still a work in progress
			
			//total failure:
			if((luck / width) < 10) return false; //less likely to cross if wider
			if(((luck / width) < 15) && isFast == true) return false; //less likely to succeed if river is fast
			//partial failure:
			if((luck / width < 15 || ((luck / width) < 20 && isFast == true))) {
				loseToRiver((depth + width) / luck, wagon); //lose more the deeper and wider the river is
				return true;
			}
			//total success
			return true;
			
			
		}
		else if(choice == "ferry") {
			return true; //ferries always work because you're paying them to
			
		}
		else return false; //returns false if a choice is put in that doesn't exist
		
	}
	
	/**
	 * Determines how many items are lost to the river (not fully implemented)
	 * @param severity - how severe the losses are
	 * @param wagon - the player's wagon
	 */
	public void loseToRiver(double severity, Wagon wagon) {
		Random rnd = new Random();
		int loss = rnd.nextInt(5) + (int)severity; //determines specifically how severe losses will be
		int itemLost = rnd.nextInt(wagon.getInventory().size()); //returns as an index of the ArrayList
		for(int i = 0; i < loss; i++) { //removes more items the more severe it was
			wagon.removeItem(wagon.getInventory().get(itemLost));
		}
	
		
	}
	/**
	 * 
	 * @return the depth and width of the river in a string
	 */
	public String riverInfo() {
		String info = "The river is " + depth + " feet deep, " + width + " feet wide,";
		if(isFast) info += " and is flowing quickly.";
		else info += " and is flowing slowly.";
		return info;
	}
	
	/**
	 * displays river menu to a selected frame for demo purpose
	 * @param frame - the frame you'ld like to display the river into
	 * @param wagon - the wagon you'ld like to put the river's effects onto
	 */
	public void displayRiver(JFrame frame, Wagon wagon) {
		
		JLabel outputLabel = new JLabel("");
		outputLabel.setBounds(6, 200, 438, 58);
		frame.getContentPane().add(outputLabel);
		
		JLabel moneyLabel = new JLabel("Money: " + wagon.getMoney());
		moneyLabel.setBounds(6, 6, 117, 16);
		frame.getContentPane().add(moneyLabel);
		
		JLabel infoLabel = new JLabel(riverInfo());
		infoLabel.setBounds(6, 90, 438, 16);
		frame.getContentPane().add(infoLabel);
		
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
		
		JButton fordButton = new JButton("Ford");
		fordButton.setBounds(6, 183, 117, 29);
		frame.getContentPane().add(fordButton);
		fordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = didCrossRiver("ford",wagon);
				String output = "";
				if(check==true) output = "You succesfully crossed the river.";
				else{
					output = "You sank while trying to ford the river";
					String inventoryString = "";
					for(Item item: wagon.getInventory()) {
						inventoryString = inventoryString + item.getName() + "\n";
					}
					wagonInventoryArea.setText(inventoryString);
				}
				outputLabel.setText(output);
			}
		});
		
		JButton ferryButton = new JButton("Ferry");
		ferryButton.setBounds(159, 183, 117, 29);
		frame.getContentPane().add(ferryButton);
		ferryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = didCrossRiver("ferry",wagon);
				if(check) {
					wagon.buyService(FERRY_PRICE);
					moneyLabel.setText("Money: "+wagon.getMoney());
					outputLabel.setText("succesfully crossed river, paid " + FERRY_PRICE);
				}
				else outputLabel.setText("not enough money");
			}
		});
		
		JButton floatButton = new JButton("Float");
		floatButton.setBounds(327, 183, 117, 29);
		frame.getContentPane().add(floatButton);
		fordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = didCrossRiver("float",wagon);
				String output = "";
				if(check) output = "You succesfully crossed the river.";
				else{
					output = "You sank while trying to float across the river";
					String inventoryString = "";
					for(Item item: wagon.getInventory()) {
						inventoryString = inventoryString + item.getName() + "\n";
					}
					wagonInventoryArea.setText(inventoryString);
				}
				outputLabel.setText(output);
			}
		});
		
	}
	
	
}

