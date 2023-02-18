package Diary;

import Calendar.Calendar;
import FileService.FileService;
import Server.BasicServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public class Diary extends BasicServer {

    public Diary(String host, int port) throws IOException {
        super(host, port);
        registerGet("/calendar", this::calendarGet);
    }
    private void calendarGet(HttpExchange exchange){
        Calendar calendar = FileService.readJsonCalendar();

        renderTemplate(exchange, "/calendar.html", calendar);
    }
}
