package Calendar;

import Tasks.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendar {
    private Map<String, Days> calendar = new HashMap<>();

    public Calendar() {
        calendar.put("February", new Days());
    }

    public Map<String, Days> getCalendar() {
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
    public Tasks getTasksByDay(int day){
        return calendar.get("February").getTasksByDay(day);
    }
    public void removeTaskByName(int day, String name){
        calendar.get("February").getTasksByDay(day).removeTaskByName(name);
    }
    public List<String> getFirstDayOfWeek(){
        return calendar.get("February").getFirstDayOfWeek();
    }
    public void addNewTask(int day, Task task){
        calendar.get("February").getDaysTasks().get(day).addNewTask(task);
    }
}
