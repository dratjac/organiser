import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Calculator {

	JFrame frame;
	private JTextField textField;
	private JButton btnSqrt;
	private JButton button_3;
	private JButton btnC;
	private JButton btnCe;
	private JButton btnBackspace;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_14;
	private JButton button_15;
	private JButton button_16;
	private JButton button_17;
	private JButton btnx;
	private JButton button_21;
	private JButton button_22;
	private JButton button_23;
	private JButton button_24;
	private JButton button_28;
	private JButton button_30;
	private JButton button_31;
	private JButton button_32;
	private double remembered;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
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
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 342, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setEditable(false);
		textField.setBounds(12, 13, 298, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnSqrt = new JButton("\u221A");
		btnSqrt.setBounds(260, 48, 50, 50);
		frame.getContentPane().add(btnSqrt);
		
		button_3 = new JButton("+/-");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] ary = textField.getText().split("");
				if(ary[0].equals("-")) {					
					//textField.setText(Arrays.toString(Arrays.copyOfRange(ary, 1, ary.length), ""));
					String[] ar2 = Arrays.copyOfRange(ary, 1, ary.length);
					String ar3 = new String();
					for(int i=0;i<ar2.length;i++) {
						ar3+=ar2[i];
					}
					//System.out.println(ar3);
					textField.setText(ar3);
				}
				else {
					textField.setText("-"+textField.getText());
				}
			}
		});
		button_3.setBounds(198, 48, 50, 50);
		frame.getContentPane().add(button_3);
		
		btnC = new JButton("C");
		btnC.setBounds(136, 48, 50, 50);
		frame.getContentPane().add(btnC);
		
		btnCe = new JButton("CE");
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnCe.setBounds(74, 48, 50, 50);
		frame.getContentPane().add(btnCe);
		
		btnBackspace = new JButton("\u2190");
		btnBackspace.setBounds(12, 48, 50, 50);
		frame.getContentPane().add(btnBackspace);
		
		button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"7");
			}
		});
		button_7.setBounds(12, 111, 50, 50);
		frame.getContentPane().add(button_7);
		
		button_8 = new JButton("8");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"8");
			}
		});
		button_8.setBounds(74, 111, 50, 50);
		frame.getContentPane().add(button_8);
		
		button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"9");
			}
		});
		button_9.setBounds(136, 111, 50, 50);
		frame.getContentPane().add(button_9);
		
		button_10 = new JButton("/");
		button_10.setBounds(198, 111, 50, 50);
		frame.getContentPane().add(button_10);
		
		button_11 = new JButton("%");
		button_11.setBounds(260, 111, 50, 50);
		frame.getContentPane().add(button_11);
		
		button_14 = new JButton("4");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"4");
			}
		});
		button_14.setBounds(12, 174, 50, 50);
		frame.getContentPane().add(button_14);
		
		button_15 = new JButton("5");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"5");
			}
		});
		button_15.setBounds(74, 174, 50, 50);
		frame.getContentPane().add(button_15);
		
		button_16 = new JButton("6");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"6");
			}
		});
		button_16.setBounds(136, 174, 50, 50);
		frame.getContentPane().add(button_16);
		
		button_17 = new JButton("*");
		button_17.setBounds(198, 174, 50, 50);
		frame.getContentPane().add(button_17);
		
		btnx = new JButton("1/x");
		btnx.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnx.setBounds(260, 174, 50, 50);
		frame.getContentPane().add(btnx);
		
		button_21 = new JButton("1");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText()+"1");
			}
		});
		button_21.setBounds(12, 237, 50, 50);
		frame.getContentPane().add(button_21);
		
		button_22 = new JButton("2");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"2");
			}
		});
		button_22.setBounds(74, 237, 50, 50);
		frame.getContentPane().add(button_22);
		
		button_23 = new JButton("3");
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"3");
			}
		});
		button_23.setBounds(136, 237, 50, 50);
		frame.getContentPane().add(button_23);
		
		button_24 = new JButton("-");
		button_24.setBounds(198, 237, 50, 50);
		frame.getContentPane().add(button_24);
		
		button_28 = new JButton("0");
		button_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText()+"0");
			}
		});
		button_28.setBounds(12, 300, 112, 50);
		frame.getContentPane().add(button_28);
		
		button_30 = new JButton(".");
		button_30.setBounds(136, 300, 50, 50);
		frame.getContentPane().add(button_30);
		
		button_31 = new JButton("+");
		button_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] ary = textField.getText().split("");
				//System.out.println(ary[ary.length-1]);
				int n = ary.length - 1;
				rememberNumber();
			}
		});
		button_31.setBounds(198, 300, 50, 50);
		frame.getContentPane().add(button_31);
		
		button_32 = new JButton("=");
		button_32.setBounds(260, 237, 50, 113);
		frame.getContentPane().add(button_32);
	}
	private void rememberNumber() {
		remembered = Double.parseDouble(textField.getText());
		System.out.println(remembered);
	}
}