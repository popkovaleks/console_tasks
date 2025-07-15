package org.example.services;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.Task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskService {

    private ObjectMapper mapper = new ObjectMapper();
    private File file = new File("tasks.json");

    public String createTask(){
        String message = "Введи описание задачи";
        System.out.println(message);

        Scanner input = new Scanner(System.in);
        Task newTask = new Task(input.nextLine());

        saveTask(newTask);

        return "Сохранено";
    }

    public void saveTask(Task task){

        try{
            List<Task> tasks = (file.exists() && file.length() > 0) ? mapper.readValue(file, new TypeReference<List<Task>>() {})
                    : new ArrayList<Task>();
            tasks.add(task);
            mapper.writeValue(file, tasks);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public List<Task> getTasks(){

        List<Task> tasks = null;
        try {
            tasks = mapper.readValue(file, new TypeReference<ArrayList<Task>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }

    public void showAll(){

        try{
                List<Task> tasks = (ArrayList<Task>) getTasks();
            for (int i = 1; i <= tasks.size(); i++) {
                    System.out.println(i + " " + tasks.get(i - 1).getContent() + " " + (tasks.get(i - 1).isDone() ? "\u2713" : ""));
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void markAsDone(int id){
        try {
            List<Task> tasks = getTasks();
            tasks.get(id - 1).setDone(true);
            mapper.writeValue(file, tasks);
            System.out.println("Задача " + tasks.get(id - 1).getContent() + " отмечена выполненой");
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id){
        try{
            List<Task> tasks = getTasks();
            tasks.remove(id);
            mapper.writeValue(file, tasks);
            System.out.println("Задача удалена");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
