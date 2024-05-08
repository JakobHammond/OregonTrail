import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StartMenu extends Menu {

	public StartMenu(JFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}
	
	public void Display (JFrame shopFrame) {
		JLabel oregonTrailLabel = new JLabel("Oregon Trail Game");
		oregonTrailLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		oregonTrailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		oregonTrailLabel.setBounds(105, 54, 476, 99);
		frame.getContentPane().add(oregonTrailLabel);
		

		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shopFrame.setVisible(true);
				frame.setVisible(false);
			}
		});
		startButton.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		startButton.setBounds(131, 242, 420, 99);
		frame.getContentPane().add(startButton);
	}

}
