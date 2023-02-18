package Calendar;

import Tasks.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendar {
    private Map<String, Tasks> calendar = new HashMap<>();

    public Calendar() {
        calendar.put("February", new Tasks());
    }

    public Map<String, Tasks> getCalendar() {
        return calendar;
    }

    public int getCurrentDay(){
        return LocalDateTime.now().getDayOfMonth();
    }
    public int getDayFromTask(Task task){
        return LocalDateTime.parse(task.getDateTime()).getDayOfMonth();
    }
    public String getTypeOfTask(Task task){
        return task.getType().getNameOfTask();
    }
}
