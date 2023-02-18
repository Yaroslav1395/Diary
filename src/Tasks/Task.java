package Tasks;

import java.time.LocalDateTime;

public class Task {
    private final Type type;
    private final String name;
    private final String description;
    private final String dateTime;

    public Task(Type type, String name, String description, String dateTime) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.dateTime = dateTime;
    }

    public Task(Task task) {
        this.type = task.getType();
        this.name = task.getName();
        this.description = task.getDescription();
        this.dateTime = task.getDateTime();
    }

    public Type getType() {
        return type;
    }
    public String getTypeAsString(){
        return  type.getNameOfTask();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "type=" + type +
                ", name='" + name +
                ", description='" + description +
                ", dateTime='" + dateTime;
    }
}
