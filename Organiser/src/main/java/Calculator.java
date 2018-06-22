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
	static JTextField textField;
	private JButton button_sqrt;
	private JButton button_opp;
	private JButton button_C;
	private JButton button_Ce;
	private JButton button_back;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_div;
	private JButton button_perc;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_mult;
	private JButton button_inv;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_minus;
	private JButton button_0;
	private JButton button_col;
	private JButton button_plus;
	private JButton button_eq;
	
	//private Numbers firstnum = new DoubleNumb();
	//private Numbers secnum = new DoubleNumb();
	//private String operation;
	private int state = 0;
	
	private Boolean porown = false, con = false, podzial = false;
    private String ls = "";
    private String input = "";
    private Numbers operand1 = new DoubleNumb("");
    private Numbers operand2 = new DoubleNumb("");
    private double result = 0.0;
    private char operation;
    
    private void display(String i) {
        if (textField.getText().equals("0")) textField.setText("");
        textField.setText(textField.getText() + i);
    }
    
    private void rownanie() {
    	textField.setText("");
        input = "";
        double num1, num2;
        operand1.Parse();
        operand2.Parse();
        num1 = operand1.getNumD();
        num2 = operand2.getNumD();
        
        switch (operation) {
        case '/':
        	if (num2 != 0) {
        		result = num1 / num2;
                display(""+result);
            }
            else {
            	display("Can't divide by 0!");
            }
            break;
        case '*':
        	result = num1 * num2;
        	display(""+result);
            break;
        case '+':
            result = num1 + num2;
            display(""+result);
            break;
        case '-':
            result = num1 - num2;
            display(""+result);
            break;
        }
        input = ""+result;
    }

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
	private Calculator() {
		initialize();
	}
	
	public static Calculator getInstance() {
        return CalcHolder.INSTANCE;
    }
	
	private static class CalcHolder {
        private static final Calculator INSTANCE = new Calculator();
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 342, 423);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setEditable(false);
		textField.setBounds(12, 13, 298, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText("0");
		
		button_0 = new JButton("0");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display("0");
	            input += "0";
			}
		});
		button_0.setBounds(12, 300, 112, 50);
		frame.getContentPane().add(button_0);
		
		button_1 = new JButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (porown == true)
	            {
	                textField.setText("");
	                input = "";
	                porown = false;
	            }
	            display("1");
	            input += "1";
			}
		});
		button_1.setBounds(12, 237, 50, 50);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (porown == true)
	            {
	                textField.setText("");
	                input = "";
	                porown = false;
	            }
	            display("2");
	            input += "2";
			}
		});
		button_2.setBounds(74, 237, 50, 50);
		frame.getContentPane().add(button_2);
		
		button_3 = new JButton("3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (porown == true)
	            {
	                textField.setText("");
	                input = "";
	                porown = false;
	            }
	            display("3");
	            input += "3";
			}
		});
		button_3.setBounds(136, 237, 50, 50);
		frame.getContentPane().add(button_3);
		
		button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (porown == true)
	            {
	                textField.setText("");
	                input = "";
	                porown = false;
	            }
	            display("4");
	            input += "4";
			}
		});
		button_4.setBounds(12, 174, 50, 50);
		frame.getContentPane().add(button_4);
		
		button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (porown == true)
	            {
	                textField.setText("");
	                input = "";
	                porown = false;
	            }
	            display("5");
	            input += "5";
			}
		});
		button_5.setBounds(74, 174, 50, 50);
		frame.getContentPane().add(button_5);
		
		button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (porown == true)
	            {
	                textField.setText("");
	                input = "";
	                porown = false;
	            }
	            display("6");
	            input += "6";
			}
		});
		button_6.setBounds(136, 174, 50, 50);
		frame.getContentPane().add(button_6);
		
		button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (porown == true)
	            {
	                textField.setText("");
	                input = "";
	                porown = false;
	            }
	            display("7");
	            input += "7";
			}
		});
		button_7.setBounds(12, 111, 50, 50);
		frame.getContentPane().add(button_7);
		
		button_8 = new JButton("8");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (porown == true)
	            {
	                textField.setText("");
	                input = "";
	                porown = false;
	            }
	            display("8");
	            input += "8";
			}
		});
		button_8.setBounds(74, 111, 50, 50);
		frame.getContentPane().add(button_8);
		
		button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (porown == true)
	            {
	                textField.setText("");
	                input = "";
	                porown = false;
	            }
	            display("9");
	            input += "9";
			}
		});
		button_9.setBounds(136, 111, 50, 50);
		frame.getContentPane().add(button_9);
		
		button_plus = new JButton("+");
		button_plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (podzial == true)
	            {
	                operand2.setNumber(input);
	                rownanie();
	                operand1.Empty();
	            }
	            if (porown != true) operand1.setNumber(input);
	            input = "";
	            display("+");
	            operation = '+';
	            con = false;
	            podzial = true;
			}
		});
		button_plus.setBounds(198, 300, 50, 50);
		frame.getContentPane().add(button_plus);
		
		button_minus = new JButton("-");
		button_minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (podzial == true)
	            {
	                operand2.setNumber(input);
	                rownanie();
	                operand1.Empty();
	            }
	            if (porown != true) operand1.setNumber(input);
	            input = "";
	            display("-");
	            operation = '-';
	            con = false;
	            podzial = true;
			}
		});
		button_minus.setBounds(198, 237, 50, 50);
		frame.getContentPane().add(button_minus);
		
		button_mult = new JButton("*");
		button_mult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (podzial == true)
	            {
	                operand2.setNumber(input);
	                rownanie();
	                operand1.Empty();
	            }
	            if (porown != true) operand1.setNumber(input);
	            input = "";
	            display("*");
	            operation = '*';
	            con = false;
	            podzial = true;
			}
		});
		button_mult.setBounds(198, 174, 50, 50);
		frame.getContentPane().add(button_mult);
		
		button_div = new JButton("/");
		button_div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (podzial == true)
	            {
	                operand2.setNumber(input);
	                rownanie();
	                operand1.Empty();
	            }
	            if (porown != true) operand1.setNumber(input);
	            input = "";
	            display("/");
	            operation = '/';
	            con = false;
	            podzial = true;
			}
		});
		button_div.setBounds(198, 111, 50, 50);
		frame.getContentPane().add(button_div);
		
		button_eq = new JButton("=");
		button_eq.setBounds(260, 237, 50, 113);
		frame.getContentPane().add(button_eq);
		
		button_inv = new JButton("1/x");
		button_inv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_inv.setBounds(260, 174, 50, 50);
		frame.getContentPane().add(button_inv);
		
		button_perc = new JButton("%");
		button_perc.setBounds(260, 111, 50, 50);
		frame.getContentPane().add(button_perc);
			
		button_sqrt = new JButton("\u221A");
		button_sqrt.setBounds(260, 48, 50, 50);
		frame.getContentPane().add(button_sqrt);
		
		button_opp = new JButton("+/-");
		button_opp.addActionListener(new ActionListener() {
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
		button_opp.setBounds(198, 48, 50, 50);
		frame.getContentPane().add(button_opp);
		
		button_C = new JButton("C");
		button_C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            input = "";
	            operand1 = "";
	            operand2 = "";
	            textField.setText("0");
	            porown = false;
	            con = false;
	            podzial = false;
			}
		});
		button_C.setBounds(136, 48, 50, 50);
		frame.getContentPane().add(button_C);
		
		button_Ce = new JButton("CE");
		button_Ce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("0");
				input = "";
			}
		});
		button_Ce.setBounds(74, 48, 50, 50);
		frame.getContentPane().add(button_Ce);
		
		button_back = new JButton("\u2190");
		button_back.setBounds(12, 48, 50, 50);
		frame.getContentPane().add(button_back);
		
		button_col = new JButton(".");
		button_col.setBounds(136, 300, 50, 50);
		frame.getContentPane().add(button_col);
	}
	
	private void rememberNumber() {
		//remembered = Double.parseDouble(textField.getText());
		//System.out.println(remembered);
	}
}