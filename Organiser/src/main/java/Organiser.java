import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Organiser {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Organiser window = new Organiser();
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
	public Organiser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOrganiser = new JLabel("Organiser");
		lblOrganiser.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrganiser.setFont(new Font("Arial Black", Font.BOLD, 41));
		lblOrganiser.setBounds(10, 11, 414, 84);
		frame.getContentPane().add(lblOrganiser);
		
		JButton btnCalendar = new JButton("Event Calendar");
		btnCalendar.setBounds(10, 106, 199, 33);
		frame.getContentPane().add(btnCalendar);
		
		JButton btnNewButton = new JButton("Currency Converter");
		btnNewButton.setBounds(210, 106, 214, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Notepad");
		btnNewButton_1.setBounds(10, 150, 199, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Calculator");
		btnNewButton_2.setBounds(210, 150, 214, 33);
		frame.getContentPane().add(btnNewButton_2);
	}
}
