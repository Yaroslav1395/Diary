import Calendar.Calendar;
import Diary.Diary;
import FileService.FileService;
import Generetor.Generator;
import Tasks.Task;
import Tasks.Tasks;

import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        FileService.writeJsonCalendar(calendar);
        try{
            new Diary("localhost", 9889).start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}