package ru.rudolf;

/*
    Напишите программу на Java для того, чтобы поменять
    местами значения, хранящиеся в двух переменных
    с помощью третьей переменной
*/

public class App {

    public static void main(String[] args) {
        //Значения примитвных типов
        int a = 5;
        int b = 10;
        int temp;

        System.out.println(a + ":" + b);

        temp = a;
        a = b;
        b = temp;

        System.out.println(a + ":" + b);
    }
}
