import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OptionsMenu extends Menu {

	public OptionsMenu(JFrame frame) {
		super(frame);
	}
	
	public void Display(Wagon wagon, JFrame baseFrame) {
		JTextField restDaysField = new JTextField();
		restDaysField.setBounds(317, 360, 100, 26);
		restDaysField.setColumns(10);
		JLabel restLabel = new JLabel("Rest for: ");
		restLabel.setBounds(345, 332, 61, 16);
		JSlider paceSlider = new JSlider();
		paceSlider.setMajorTickSpacing(1);
		paceSlider.setValue(1);
		paceSlider.setPaintTicks(true);
		paceSlider.setSnapToTicks(true);
		paceSlider.setMinorTickSpacing(1);
		paceSlider.setMinimum(1);
		paceSlider.setMaximum(3);
		paceSlider.setBounds(55, 6, 190, 29);
		JLabel paceLabel = new JLabel("Pace:");
		paceLabel.setBounds(17, 6, 61, 16);
		JLabel slowPaceLabel = new JLabel("Slow");
		slowPaceLabel.setBounds(55, 47, 61, 16);
		JLabel mediumPaceLabel = new JLabel("Moderate");
		mediumPaceLabel.setBounds(121, 47, 61, 16);
		JLabel fastPaceLabel = new JLabel("Grueling");
		fastPaceLabel.setBounds(204, 47, 61, 16);
		JSlider rationSlider = new JSlider();
		rationSlider.setValue(1);
		rationSlider.setSnapToTicks(true);
		rationSlider.setPaintTicks(true);
		rationSlider.setMinorTickSpacing(1);
		rationSlider.setMinimum(1);
		rationSlider.setMaximum(3);
		rationSlider.setMajorTickSpacing(1);
		rationSlider.setBounds(75, 122, 190, 29);	
		JLabel bareBoneLabel = new JLabel("Bare Bones");
		bareBoneLabel.setBounds(44, 163, 72, 16);
		JLabel meagerLabel = new JLabel("Meager");
		meagerLabel.setBounds(149, 163, 61, 16);
		JLabel fillingLabel = new JLabel("Filling");
		fillingLabel.setBounds(231, 163, 61, 16);
		JLabel rationLabel = new JLabel("Rations:");
		rationLabel.setBounds(6, 122, 61, 16);
		JButton continueButton = new JButton("Continue on Trail");
		continueButton.setBounds(491, 435, 200, 29);
		JButton restButton = new JButton("Rest Day");
		restButton.setBounds(306, 435, 117, 29);
		JButton tradeButton = new JButton("Attempt to trade");
		tradeButton.setBounds(17, 435, 193, 29);		
		JTextArea InventoryArea = new JTextArea();
		InventoryArea.setBounds(437, 47, 224, 350);
		
		
		ArrayList<Item> inventory = wagon.getInventory();
		String inventoryString = "";
		for(Item item: inventory) {
			inventoryString = inventoryString + item.getName() + "\n";
		}
		InventoryArea.setText(inventoryString);
		
		frame.getContentPane().add(tradeButton);
		tradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}});
		
		frame.getContentPane().add(continueButton);
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wagon.setPace(paceSlider.getValue());
				wagon.setRations(rationSlider.getValue());
				baseFrame.setVisible(true);
				frame.setVisible(false);

			}});
		
		frame.getContentPane().add(restButton);
		restButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baseFrame.setVisible(true);
				frame.setVisible(false);
				wagon.restDay(Integer.parseInt(restDaysField.getText()));
				
			}});
		frame.getContentPane().add(fillingLabel);
		frame.getContentPane().add(meagerLabel);
		frame.getContentPane().add(bareBoneLabel);
		frame.getContentPane().add(rationSlider);
		frame.getContentPane().add(fastPaceLabel);
		frame.getContentPane().add(mediumPaceLabel);
		frame.getContentPane().add(slowPaceLabel);
		frame.getContentPane().add(paceLabel);
		frame.getContentPane().add(paceSlider);
		frame.getContentPane().add(rationLabel);
		frame.getContentPane().add(restLabel);
		frame.getContentPane().add(restDaysField);
		
		
		frame.getContentPane().add(InventoryArea);
		
		
	}

}
