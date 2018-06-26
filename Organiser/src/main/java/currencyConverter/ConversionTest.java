package currencyConverter;

import static org.junit.Assert.*;

import org.junit.Test;
public class ConversionTest {


	@Test
	public void testConversion() {
		//Testing catched exceptions//
		
		String currentUSDtoPLN = "3.71";
		
		try {
		
			//1. Negative amount//
			String testInput = CurrencyConverterFrame.convert("USD", "PLN", "-5");
			fail("");
		}
		catch (Exception e){
			//passed
		}
		try {
			
			//2. Wrong format//
			String testInput2 = CurrencyConverterFrame.convert("USD", "PLN", "jsfsdfjs");
			fail("");
		}
		catch (Exception e){
			//passed
		}
		try {
			
			//3. Too large input//
			String testInput4 = CurrencyConverterFrame.convert("USD", "PLN", "3000000 ");
			fail("");
		}
		catch (Exception e){
			//passed
		}
			
		try {
			
			//4. Conversion based on real ratio//
			String testReturn = CurrencyConverterFrame.convert("USD", "PLN", "1");
			System.out.println(testReturn);
			assertEquals(testReturn, currentUSDtoPLN);
			
		}
		catch (Exception e){
			//passed
		}
	
		
	}

}
