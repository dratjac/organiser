import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class CalendarModel {
	private int maxDays;
	private int selectedDay;
	private HashMap<String, ArrayList<Event>> eventMap = new HashMap<>();
	private ArrayList<string> listeners = new ArrayList<>(); 
	private GregorianCalendar cal = new GregorianCalendar();
	private boolean monthChanged = false;
	 
	/**
	* ========================== DO KALENDARZA =========================
	*/
	
	/**
	* KONSTRUKTOR
	*/
	public CalendarModel() {
		maxDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	    selectedDay = cal.get(Calendar.DATE);
	    //loadEvents();                                            
	}
	
	/**
     * SETTER WYBRANEGO PRZEZ USERA DNIA
     */
    public void setSelectedDate(int day) {
        selectedDay = day;
    }

    /**
     * GETTER WYBRANEGO PRZEZ USERA DNIA.
     */
    public int getSelectedDay() {
        return selectedDay;
    }

    /**
     * ZWROT OBECNEGO ROKU
     */
    public int getCurrentYear() {
        return cal.get(Calendar.YEAR);
    }

    /**
     * ZWROT OBECNEGO MIESIACA
     */
    public int getCurrentMonth() {
        return cal.get(Calendar.MONTH);
    }

    /**
     * ZWROT DNIA TYGODNIA
     */
    public int getDayOfWeek(int i) {
        cal.set(Calendar.DAY_OF_MONTH, i);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * ZWROT MAXYMALNEJ ILOSCI DNI W MIESIACU
     */
    public int getMaxDays() {
        return maxDays;
    }

    /**
     * PRZESUWA KALENDARZ O MIESI¥C W PRZÓD
     */
    public void nextMonth() {
        cal.add(Calendar.MONTH, 1);
        maxDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        monthChanged = true;
        //update();                                                    
    }

    /**
     * PRZESUWA KALENDARZ O MIESI¥Æ W TY£
     */
    public void prevMonth() {
        cal.add(Calendar.MONTH, -1);
        maxDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        monthChanged = true;
        //update();                                                  
    }

    /**
     * PRZESÓWA WYBRANY DZIEN W PRZÓD
     */
    public void nextDay() {
        selectedDay++;
        if (selectedDay > cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            nextMonth();
            selectedDay = 1;
        }
        //update();               
    }

    /**
     * PRZESÓWA WYBRANY DZIEÑ W TY£
     */
    public void prevDay() {
        selectedDay--;
        if (selectedDay < 1) {
            prevMonth();
            selectedDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        //update();                                                         
    }

    /**
     * SPRAWDZA CZY USER ZMIENIL MIESIAC
     */
    public boolean hasMonthChanged() {
        return monthChanged;
    }

    /**
     * USTAWIA monthChanged NA FALSE
     */
    public void resetHasMonthChanged() {
        monthChanged = false;
    }
    
    /**
	* ========================== DO EVENTOW ==============================
	*/
	    
    /**
     * TWORZY EVENT W WYBRANYM DNIU
     */
    public void createEvent() {
        String date = (cal.get(Calendar.MONTH)) + "/" + selectedDay + "/" + cal.get(Calendar.YEAR);
        Event event = new Event(title, date, startTime, endTime);
        ArrayList<Event> eventArray = new ArrayList<>();
        eventArray.add(event);
        eventMap.put(date, eventArray);
    }
    
    /**
     * TWORZENIE EVENTU
     */
    private static class Event{
        private String title;
        private String date;
        private String startTime;
        private String endTime;

        /**
        * KONSTRUKTOR
        */
        private Event(String title, String date, String startTime, String endTime) {
            this.title = title;
            this.date = date;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        
    }
    
}