package org.example;


import org.example.services.TaskService;

import java.util.Scanner;

import static org.example.services.StartScreen.showStartScreen;

public class Main {
    public static void main(String[] args) {
        showStartScreen();
        Scanner input = new Scanner(System.in);

        while(true){
            String command = input.nextLine();
            switch (command){
                case "/create":
                    TaskService service = new TaskService();
                    System.out.println(service.createTask());
                    break;
                case "/exit":
                    System.exit(0);
                    break;

            }
        }
    }
}