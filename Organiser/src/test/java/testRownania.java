import static org.junit.Assert.*;

import java.util.regex.PatternSyntaxException;

import org.junit.Test;

public class testRownania {

	@Test
	public void testRowna() {
		try {
			Calculator.rownanieTest("10.0", '/', "0");
		}
		catch(IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testRowna2() {
		double results = Calculator.rownanieTest("5.0", '+', "10.0");
		assertEquals(15.0, results, 0.0);		
	}
	
	@Test
	public void testRowna3() {
		double results = Calculator.rownanieTest("3.0", '*', "7.0");
		assertEquals(21.0, results, 0.0);		
	}
	
	@Test
	public void testRowna4() {
		double results = Calculator.rownanieTest("6.0", '-', "20.0");
		assertEquals(-14.0, results, 0.0);		
	}
	
	@Test
	public void testRowna5() {
		double results = Calculator.rownanieTest("1.0", '/', "2.0");
		assertEquals(0.5, results, 0.0);		
	}

}
