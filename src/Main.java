
import Calendar.Calendar;
import Diary.Diary;
import FileService.FileService;


import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        try{
            new Diary("localhost", 9889).start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}