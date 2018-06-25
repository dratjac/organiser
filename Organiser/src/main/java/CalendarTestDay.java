import static org.junit.Assert.*;

import org.junit.Test;

public class CalendarTestDay {

	CalendarModel cal=new CalendarModel();
	
	@Test
	public void testday() {
		int currentday=25;
		int testDay=cal.getSelectedDay();
		assertEquals(testDay, currentday);
	}
}
