package Tasks;

import Generetor.Generator;

import java.time.LocalDateTime;
import java.util.*;

public class Tasks {
    private Map<Integer, List<Task>> daysTasks= new HashMap<>();

    public Tasks() {
        createDaysTask();
    }

    public Map<Integer, List<Task>> getDaysTasks() {
        return daysTasks;
    }

    public void createDaysTask(){
        LocalDateTime time = LocalDateTime.now();
        for (int i = 1; i < 31; i++){
            if(i != 0){
                time = time.plusDays(1);
            }
            daysTasks.put(i, new ArrayList<>());
            for(int j = 0; j < Type.values().length; j++){
                daysTasks.get(i).add(new Task(
                        Type.getRandomType(),
                        Generator.makeName(),
                        Generator.makeDescription(),
                        time.toString()));
            }
        }
    }

}
