package ru.rudolf;

/*Напишите Java-программу, чтобы найти второе по величине число в массиве.*/

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class App {

    private final List<Integer> numbers;

    public App() {
        numbers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            numbers.add(ThreadLocalRandom.current().nextInt(0, 101));
        }

        System.out.println(numbers.toString());

        int max = numbers.get(0);
        int secondMax = numbers.get(0);

        for (int number : numbers) {
            if (number > max) {
                secondMax = max;
                max = number;
            } else if (number > secondMax && number != max) {
                secondMax = number;
            }
        }
        System.out.println("Максимальное: " + max + "\nВторое по велечине: " + secondMax);
    }

    public static void main(String[] args) {
        new App();
    }
}
