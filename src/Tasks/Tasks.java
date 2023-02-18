package Tasks;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tasks {
    private List<Task> taskList = new ArrayList<>();

    public Tasks() {
    }

    public Tasks(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }
    public void addNewTask(Task task){
        taskList.add(task);
    }
    public int getTaskDay(){
        return LocalDateTime.parse(taskList.get(0).getDateTime()).getDayOfMonth();
    }
    public int getTaskMonth(){
        return LocalDateTime.parse(taskList.get(0).getDateTime()).getMonth().getValue();
    }
    public int getTaskYear(){
        return LocalDateTime.parse(taskList.get(0).getDateTime()).getYear();
    }
    public void removeTaskByName(String name){
        Task taskForRemove = null;
        for (Task task: taskList) {
            if(task.getName().equals(name)){
                taskForRemove = task;
                break;
            }
        }
        taskList.remove(taskForRemove);
    }
    public String getNameOfFirstDayOfWeek(){
        Task task = taskList.get(0);
        LocalDateTime date = LocalDateTime.parse(task.getDateTime());
        return date.getDayOfWeek().toString();
    }
}
