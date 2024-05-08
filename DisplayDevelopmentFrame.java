package DisplayDevelopmentPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class DisplayDevelopmentFrame {

	private JFrame frame;
	private JButton Conversate;
	private JTextArea conversationArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayDevelopmentFrame window = new DisplayDevelopmentFrame();
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
	public DisplayDevelopmentFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton Trade = new JButton("Trade");
		Trade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Trade.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		Trade.setBounds(497, 166, 190, 57);
		frame.getContentPane().add(Trade);
		
		JButton Shop = new JButton("Shop");
		Shop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Shop.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		Shop.setBounds(137, 166, 190, 57);
		frame.getContentPane().add(Shop);
		
		JButton Continue = new JButton("Cross River");
		Continue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Continue.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		Continue.setBounds(137, 298, 190, 57);
		frame.getContentPane().add(Continue);
		
		Conversate = new JButton("Conversate");
		Conversate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = locations[0].getName() + ".txt";
				conversatoinArea.setText(text);
			}
		});
		Conversate.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		Conversate.setBounds(497, 298, 190, 57);
		frame.getContentPane().add(Conversate);
		
		JLabel title = new JLabel("Welcome to "+ locations[0].getName);
		title.setFont(new Font("Lucida Grande", Font.BOLD, 35));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(31, 26, 738, 97);
		frame.getContentPane().add(title);
		
		conversationArea = new JTextArea();
		conversationArea.setLineWrap(true);
		conversationArea.setWrapStyleWord(true);
		conversationArea.setBounds(71, 390, 681, 85);
		frame.getContentPane().add(conversationArea);
	}
}
