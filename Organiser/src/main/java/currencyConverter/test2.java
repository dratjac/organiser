package currencyConverter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


public class test2 {
	 public static void main(String args[]) {
		 try {
	            //Yahoo Finance API
			 	URL url = new URL("http://free.currencyconverterapi.com/api/v5/convert?q=USD_EUR&compact=y");
	            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	            String line = reader.readLine();
	            if (line.length() > 0) {
	            	String [] parts = line.split("l");
	            	String part2 = parts[1];
	            	String[] value =part2.split(":");
	            	value[1]=value[1].replaceAll("}", "");
	            	Double ratio = Double.parseDouble(value[1]);
	            	System.out.println(Double.parseDouble(value[1]) * 5); 
	            }
	            reader.close();
	            
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }

		 	//URL url = new URL("http://free.currencyconverterapi.com/api/v5/convert?q=USD_EUR&compact=y");
	
	 }
}
