import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarModel {
	private int maxDays;
	private int selectedDay;
	private GregorianCalendar cal = new GregorianCalendar();
	private boolean monthChanged = false;
	 
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


	    
}