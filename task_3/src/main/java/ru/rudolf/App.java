package ru.rudolf;

/*
    Напишите программу на Java, чтобы поменять
    местами значения, хранящиеся в двух переменных, без
    использования третьей переменной.
*/

public class App {

    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        System.out.println(a + ":" + b);

        a = a + b;
        b = b - a;
        b = -b;
        a = a - b;

        System.out.println(a + ":" + b);

        String A = "Hello";
        String B = "Java";

        A = A + B;
        B = A.substring(0, (A.length() - B.length()));
        A = A.substring(B.length());

        System.out.println("A = " + A);
        System.out.println("B = " + B);
    }

}
