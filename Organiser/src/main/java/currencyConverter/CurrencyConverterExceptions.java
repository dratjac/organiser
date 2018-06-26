package currencyConverter;
import currencyConverter.CurrencyConverterFrame;
import javax.swing.JOptionPane;

public class CurrencyConverterExceptions extends Exception{
	
		private static String message;
		
		 public CurrencyConverterExceptions(String message) {
			 this.message = message;
			ExceptionFrame frame = new ExceptionFrame(this.message);
			frame.setVisible(true);
			
		}
		
	}
	
	
	


