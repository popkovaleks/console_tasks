package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.Task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskService {

    public String createTask(){
        String message = "Введи описание задачи";
        System.out.println(message);

        Scanner input = new Scanner(System.in);
        Task newTask = new Task(input.nextLine());

        saveTask(newTask);

        return "Сохранено";
    }

    public void saveTask(Task task){
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("tasks.json");

        try{
//
            List<Task> tasks = (file.exists() && file.length() > 0) ? mapper.readValue(file, new TypeReference<List<Task>>() {}): new ArrayList<Task>();
            tasks.add(task);
            mapper.writeValue(file, tasks);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
