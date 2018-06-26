import static org.junit.Assert.*;

import org.junit.Test;

public class CalendarTestYear {

	CalendarModel cal = new CalendarModel();

	@Test
	public void testyear() {
		int currentyear = 2018;
		int testYear = cal.getCurrentYear();
		assertEquals(testYear, currentyear);
	}

}
