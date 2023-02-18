package Tasks;

import java.util.Random;

public enum Type {
    WORK("work"),
    HOME("home"),
    TRAINING("training"),
    DIET("diet");

    private final String nameOfTask;

    Type(String nameOfTask) {
        this.nameOfTask = nameOfTask;
    }

    public String getNameOfTask() {
        return nameOfTask;

    }
    public static Type getRandomType(){
        return Type.values()[new Random().nextInt(Type.values().length)];
    }
}
