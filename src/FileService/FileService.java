package FileService;

import Calendar.Calendar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static Calendar readJsonCalendar(){
        Path parsedPath = Paths.get("json/calendar.json");
        String fileContents;
        try {
            fileContents = Files.readString(parsedPath);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        return gson.fromJson(fileContents, Calendar.class);
    }

    public static void writeJsonCalendar(Calendar calendar){
        String json = gson.toJson(calendar);
        Path parsedPath = Paths.get("json/calendar.json");
        try {
            byte[] bytes = json.getBytes();
            Files.write(parsedPath, bytes);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
