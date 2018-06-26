package currencyConverter;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class CurrencyConverterFrame {

	public static JFrame frame;
	private JTextField amountField;
	private JTextField resultField;

	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverterFrame window = new CurrencyConverterFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static String convert(String from, String to, String amount) throws Exception, NumberFormatException {

		if (Double.parseDouble(amount) < 0) {
			throw new Exception("negative value");
			
		}
		if (Double.parseDouble(amount) > 1000000) {
			throw new Exception("Too large value \n max value = 1 mln");
		}

		URL url = new URL("http://free.currencyconverterapi.com/api/v5/convert?q=" + from + "_" + to + "&compact=y");
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = reader.readLine();
		if (line.length() > 0) {
			String[] parts = line.split("l");
			String part2 = parts[1];
			String[] value = part2.split(":");
			value[1] = value[1].replaceAll("}", "");

			reader.close();
			return Double
					.toString(Math.round(Double.parseDouble(value[1]) * Double.parseDouble(amount) * 100d) / 100d);

		} else {
			throw new Exception("incorrect url");
		}

	}

	/**
	 * Create the application.
	 */
	public CurrencyConverterFrame() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "USD", "PLN", "GBP", "EUR", "CHF" }));
		comboBox.setToolTipText("DUPA");
		comboBox.setEditable(true);
		comboBox.setBounds(168, 142, 86, 20);
		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel_2 = new JLabel("Convert To");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(38, 189, 90, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JComboBox comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] { "PLN", "USD", "GBP", "EUR", "CHF" }));
		comboBox2.setEditable(true);
		comboBox2.setBounds(168, 186, 86, 20);
		frame.getContentPane().add(comboBox2);

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

				try {
					resultField.setText(convert(comboBox.getSelectedItem().toString(),
							comboBox2.getSelectedItem().toString(), amountField.getText()));
				} catch (NumberFormatException e1) {

					ExceptionFrame frame = new ExceptionFrame("Incorrect format");
					frame.setVisible(true);
				} catch (Exception e2) {

					ExceptionFrame frame = new ExceptionFrame(e2.getMessage());
					frame.setVisible(true);
				}

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

		JButton backButton = new JButton("Back to menu");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		backButton.setBounds(287, 220, 121, 23);
		frame.getContentPane().add(backButton);
	}
}
