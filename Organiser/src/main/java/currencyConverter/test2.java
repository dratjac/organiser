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
	            	String part1 = parts[0];
	            	String part2 = parts[1];
	            	String[] x =part2.split(":");
	            	x[1]=x[1].replaceAll("}", "");
	            	//part2.split()
	            	String [] str =line.split(":")[0].split(":");
	            	 System.out.println(str[1]);
	            }
	            reader.close();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }

		 	//URL url = new URL("http://free.currencyconverterapi.com/api/v5/convert?q=USD_EUR&compact=y");
	
	 }
}
