package org.example.services;

public class StartScreen {
    public static void showStartScreen(){
        String message = """
                Привет!
                Это консольный to-do список.
                Для отображения всех доступных команд введи /help.
                """;

        System.out.println(message);
    }
}
