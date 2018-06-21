 public CalendarModel() {
        maxDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        selectedDay = cal.get(Calendar.DATE);
        loadEvents();
    }
 
 public calendar() {}