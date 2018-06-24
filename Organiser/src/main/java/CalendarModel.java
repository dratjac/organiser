import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CalendarModel {
	private int maxDays;
	private int selectedDay;
	private HashMap<String, ArrayList<Event>> eventMap = new HashMap<>();
	private ArrayList<ChangeListener> listeners = new ArrayList<>(); 
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
     * UPDATUJE WSZYSTKIE ChangeListeners W array.
     */
    public void update() {
        for (ChangeListener l : listeners) {
            l.stateChanged(new ChangeEvent(this));
        }
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
        update();                                                    
    }

    /**
     * PRZESUWA KALENDARZ O MIESI¥Æ W TY£
     */
    public void prevMonth() {
        cal.add(Calendar.MONTH, -1);
        maxDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        monthChanged = true;
        update();                                                  
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
        update();               
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
        update();                                                         
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
    public void createEvent(String title, String startTime, String endTime) {
        String date = (cal.get(Calendar.MONTH)+1) + "/" + selectedDay + "/" + cal.get(Calendar.YEAR);
        Event e = new Event(title, date, startTime, endTime);
        ArrayList<Event> eventArray = new ArrayList<>();
        if(hasEvent(e.date)) {
        	eventArray = eventMap.get(date);
        }
        eventArray.add(e);
        eventMap.put(date, eventArray);
    }
    
    /**
     * SPRAWDZA CZY W WYBRANEJ DACIE NIE MA JUZ STWORZONEGO EVENTU
     */
    public Boolean hasEvent(String date) {
        return eventMap.containsKey(date);
    }
    
    /**
     * SPRAWDZA CZY NOWY EVENT NIE KONFLIKTUJE CZASOWO Z WCZESNIEJ USTALONYM EVENTEM
     */
    public Boolean hasEventConflict(String timeStart, String timeEnd) {
        String date = (getCurrentMonth()+1) + "/" + selectedDay + "/" + getCurrentYear();
        if (!hasEvent(date)) {
            return false;
        }

        ArrayList<Event> eventArray = eventMap.get(date);
        Collections.sort(eventArray);
        Collection.this(eventHashmap, timeComparator());

        int timeStartMins = convertHourToMin(timeStart);
        int timeEndMins = convertHourToMin(timeEnd);
        for (Event e : eventArray) {
            int eventStartTime = convertHourToMin(e.startTime);
            int eventEndTime = convertHourToMin(e.endTime);
            if (timeStartMins > eventStartTime && timeStartMins < eventEndTime) {
                return true;
            } else if (timeStartMins < eventStartTime && timeEndMins > eventStartTime) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * WSZYSTKIE EVENTY W TRAKCIE TEJ SAMEJ DATY
     */
    public String getEvents(String date) {
        ArrayList<Event> eventArray = eventMap.get(date);
        Collections.sort(eventArray);
        Collection.this(eventHashmap, timeComparator());
        String events = "";
        if (timeStartMins > eventStartTime && timeStartMins < eventEndTime) {
            return true;
        }
        for (Event e : eventArray) {
            events = events + e.toString() + "\n";
        }
        return events;
    }
    
    /**
     * KONWERSJA GODZIN NA MINUTY
     */
    private int convertHourToMin(String time) {
        int hours = Integer.valueOf(time.substring(0, 2));
        return hours * 60 + Integer.valueOf(time.substring(3));
    }

    /**
     * KOMPARATOR DO POROWNYWANIA CZASEM W FORMACIE XX:XX.
     */
    private static Comparator<Event> timeComparator() {
    	return new Comparator<Event>() {
            @Override
            public int compare(Event arg0, Event arg1) {
                if (arg0.startTime.substring(0, 2).equals(arg1.startTime.substring(0, 2))) {
                    return Integer.parseInt(arg0.startTime.substring(3, 5)) - Integer.parseInt(arg1.startTime.substring(3, 5));
                }
                return Integer.parseInt(arg0.startTime.substring(0, 2)) - Integer.parseInt(arg1.startTime.substring(0, 2));
            }
        };
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

        /**
         * ZAPIS DO STRINGA
         */
        public String toString() {
            if (endTime.equals("")) {
                return startTime + ": " + title;
            }
            return startTime + " - " + endTime + ": " + title;
        }           
    }    
}