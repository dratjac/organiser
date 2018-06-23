package currencyConverter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class test {

    public static void main(String args[]) {

        // converting 1000 Euro to US Dollar
        System.out.println("Euro/US Dollar: " + findExchangeRateAndConvert("EUR", "USD", 1000));

        // converting 1000 US Dollar to Euro
        System.out.println("US Dollar/Euro: " + findExchangeRateAndConvert("USD", "EUR", 1000));

        // converting 1000 US Dollar to Indian Rupee
        System.out.println("US Dollar/Indian Rupee: " + findExchangeRateAndConvert("USD", "INR", 1000));

        // converting 1000 Indian Rupee to US Dollar
        System.out.println("Indian Rupee/US Dollar: " + findExchangeRateAndConvert("INR", "USD", 1000));
    }
   
    private static Double findExchangeRateAndConvert(String from, String to, int amount) {
        try {
            //Yahoo Finance API
            URL url = new URL("http://finance.yahoo.com/d/quotes.csv?f=l1&s="+ from + to + "=X");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            if (line.length() > 0) {
                return Double.parseDouble(line) * amount;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}