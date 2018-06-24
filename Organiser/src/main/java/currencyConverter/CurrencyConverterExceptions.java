package currencyConverter;

public class CurrencyConverterExceptions extends Exception{
	
		private static String message;
		
		 public CurrencyConverterExceptions(String message) {
			 this.message = message;
			// TODO Auto-generated constructor stub
		 
			ExceptionFrame frame = new ExceptionFrame(this.message);
			frame.setVisible(true);
			
		}
		
	}
	
	
	


