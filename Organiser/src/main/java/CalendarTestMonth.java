import static org.junit.Assert.*;

import org.junit.Test;

public class CalendarTestMonth {

	CalendarModel cal=new CalendarModel();
	
	@Test
	public void testmonth() {
		int currentmonth=6;
		int testMonth=cal.getCurrentMonth();
		assertEquals(testMonth, currentmonth);
	}

}
