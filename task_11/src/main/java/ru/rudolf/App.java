package ru.rudolf;

/*
    Написать мини Эксель в командной строке
    Таблица размером 10*10
*/

import java.util.*;

public class App {

    public App() {

        Scanner in = new Scanner(System.in);

        Table table = new Table(10, 10, 'A');

        String command = "";
        String cell = "";
        String value = "";

        while (true) {

            System.out.println("Введите:\nпустая строка - записать в ячейку;\nquit - выйти;\nsave - сохранить");
            command = in.nextLine().toLowerCase();

            switch (command) {
                case "exit":
                    return;
                case "save":
                    try {
                        table.save("csv/write.csv", ';');
                    } catch (Exception e) {
                        System.out.println("Ошибка при сохранении");
                        e.printStackTrace();
                    }
                    break;
                case "":
                    System.out.println("Введите Номер ячейки:");
                    cell = in.nextLine();

                    if (!table.put(cell, "")) continue;

                    System.out.println("Введите значение:");
                    value = in.nextLine();

                    table.put(cell, value);
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new App();
    }

}
