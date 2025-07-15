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
                    service.markAsDone(Integer.valueOf(splittedCommand[1]));
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