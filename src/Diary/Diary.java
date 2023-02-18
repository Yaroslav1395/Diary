package Diary;

import Calendar.Calendar;
import Tasks.*;
import FileService.FileService;
import Server.BasicServer;
import Server.Utils;
import com.sun.net.httpserver.HttpExchange;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

import java.io.IOException;
import java.util.Map;

public class Diary extends BasicServer {

    public Diary(String host, int port) throws IOException {
        super(host, port);
        registerGet("/calendar", this::calendarGet);
        registerGet("/day", this::dayGet);
        registerGet("/newTask", this::newTaskGet);
        registerPost("/newTask", this::newTaskPost);
    }
    private void calendarGet(HttpExchange exchange){
        Calendar calendar = FileService.readJsonCalendar();

        renderTemplate(exchange, "/calendar.html", calendar);
    }
    private void dayGet(HttpExchange exchange){
        Calendar calendar = FileService.readJsonCalendar();
        String query = getQueryParams(exchange);
        Map<String, String> parsedQuery = Utils.parseUrlEncoded(query, "&");
        Tasks tasks = calendar.getTasksByDay(Integer.parseInt(parsedQuery.get("day")));
        if(parsedQuery.get("remove") != null){
            calendar.removeTaskByName(Integer.parseInt(parsedQuery.get("day")), parsedQuery.get("remove"));
            FileService.writeJsonCalendar(calendar);
        }
        renderTemplate(exchange, "/day.html", tasks);
    }
    private void newTaskGet(HttpExchange exchange){
        String query = getQueryParams(exchange);
        Map<String, String> parsedQuery = Utils.parseUrlEncoded(query, "&");
        Date date = new Date(
                parsedQuery.get("day"),
                parsedQuery.get("month"),
                parsedQuery.get("year"));
        renderTemplate(exchange, "/newTask.html", date);
    }
    private void newTaskPost(HttpExchange exchange){
        String body = getBody(exchange);
        Map<String, String> parsedQuery = Utils.parseUrlEncoded(body, "&");
        String date = LocalDateTime.now().getYear() + "-" + parsedQuery.get("month") + "-" + parsedQuery.get("day") + "T" + LocalTime.now();
        Task task = new Task(Type.getRandomType(), parsedQuery.get("name"), parsedQuery.get("description"), date);
        Calendar calendar = FileService.readJsonCalendar();
        calendar.addNewTask(Integer.parseInt(parsedQuery.get("day")), task);
        FileService.writeJsonCalendar(calendar);
        renderTemplate(exchange, "/calendar.html", calendar);
    }
}
