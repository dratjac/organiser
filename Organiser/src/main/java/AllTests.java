import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CalendarTestDay.class, CalendarTestMonth.class, CalendarTestYear.class })
public class AllTests {

}
