package Tasks;

import Generetor.Generator;

import java.time.LocalDateTime;
import java.util.*;

public class Days {
    private Map<Integer, Tasks> daysTasks= new HashMap<>();

    public Days() {

    }

    public Map<Integer, Tasks> getDaysTasks() {
        return daysTasks;
    }

    public void createDaysTask(){
        LocalDateTime time = LocalDateTime.parse("2023-02-01T10:23:38.723040500");
        for (int i = 1; i <= 28; i++){
            if(i != 1){
                time = time.plusDays(1);
            }
            System.out.println(time);
            daysTasks.put(i, new Tasks());
            for(int j = 0; j < Type.values().length; j++){
                daysTasks.get(i).addNewTask(new Task(
                        Type.getRandomType(),
                        Generator.makeName(),
                        Generator.makeDescription(),
                        time.toString()));
            }
        }
    }
    public Tasks getTasksByDay(int day){
        return daysTasks.get(day);
    }
    public List<String> getFirstDayOfWeek(){
        List<String> weeks = new ArrayList<>();
        for(int i = 1; i < 8; i++){
            weeks.add(daysTasks.get(i).getNameOfFirstDayOfWeek());
        }
        return weeks;
    }

}
