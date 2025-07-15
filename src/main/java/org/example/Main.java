package org.example;


import org.example.services.TaskService;

import java.util.Scanner;

import static org.example.services.HelpScreen.showHelpScreen;
import static org.example.services.StartScreen.showStartScreen;

public class Main {
    public static void main(String[] args) {
        showStartScreen();
        Scanner input = new Scanner(System.in);
        TaskService service = new TaskService();

        while(true){
            String command = input.nextLine();
            String[] splittedCommand = command.split(" ");

            switch (splittedCommand[0]){
                case "/create":
                    System.out.println(service.createTask());
                    break;
                case "/show":
                    service.showAll();
                    break;
                case "/done":
                    if (splittedCommand.length > 1 && splittedCommand.length < 3 ){
                        if (splittedCommand[1].matches("\\d+")) {
                            service.markAsDone(Integer.valueOf(splittedCommand[1]));
                            break;
                        }
                    }
                    System.out.println("Передайте целочисленное значение");
                    break;
                case "/delete":
                    if (splittedCommand.length > 1 && splittedCommand.length < 3 ){
                        if (splittedCommand[1].matches("\\d+")) {
                            service.delete(Integer.valueOf(splittedCommand[1]));
                            break;
                        }
                    }
                    System.out.println("Передайте целочисленное значение");
                    break;
                case "/help":
                    showHelpScreen();
                    break;
                case "/exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    break;

            }
        }
    }
}