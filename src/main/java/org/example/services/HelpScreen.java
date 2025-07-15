package org.example.services;

public class HelpScreen {

    public static void showHelpScreen(){
        String message = """
                /show - Показать все задачи
                /create - Создать задачу
                /done {id} - Пометить задачу выполненой
                /help - Справка по командам
                /exit - Выход из программы
                """;

        System.out.println(message);
    }
}
