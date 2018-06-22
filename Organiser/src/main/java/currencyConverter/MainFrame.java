package currencyConverter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import CurrencyConverter;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MainFrame {

	private JFrame frame;
	private JTextField amountField;
	private JTextField resultField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
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
	public MainFrame() {
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
		
		JLabel lblNewLabel = new JLabel("Currency Converter");
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(UIManager.getColor("Button.darkShadow"));
		lblNewLabel.setBounds(103, 23, 185, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEnterAmount = new JLabel("Enter Amount");
		lblEnterAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAmount.setBackground(new Color(240, 240, 240));
		lblEnterAmount.setBounds(38, 100, 90, 24);
		frame.getContentPane().add(lblEnterAmount);
		
		amountField = new JTextField();
		amountField.setHorizontalAlignment(SwingConstants.CENTER);
		amountField.setBounds(168, 102, 86, 20);
		frame.getContentPane().add(amountField);
		amountField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Convert From");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(38, 145, 90, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"USD", "PLN", "GBN", "EUR", "CHF"}));
		comboBox.setToolTipText("DUPA");
		comboBox.setEditable(true);
		comboBox.setBounds(168, 142, 86, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Convert To");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(38, 189, 90, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"PLN", "USD", "GBN", "EUR", "CHF"}));
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(168, 186, 86, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("Result");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(38, 224, 90, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		resultField = new JTextField();
		resultField.setEditable(false);
		resultField.setHorizontalAlignment(SwingConstants.CENTER);
		resultField.setBounds(168, 221, 86, 20);
		frame.getContentPane().add(resultField);
		resultField.setColumns(10);
		
		JButton convertButton = new JButton("Convert");
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
			}
		});
		convertButton.setBounds(302, 141, 89, 23);
		frame.getContentPane().add(convertButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				amountField.setText(null);
				resultField.setText(null);
			}
		});
		resetButton.setBounds(302, 185, 89, 23);
		frame.getContentPane().add(resetButton);
		
		JButton backButton = new JButton("Back to main menu");
		backButton.setBounds(287, 220, 121, 23);
		frame.getContentPane().add(backButton);
	}
}
