package ru.rudolf;

/*Напишите программу для сортировки массива, использующую метод пузырька.*/

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class App {

    private int[] arr;

    public App() {
        arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(0, 101);
        }
        System.out.println("Исходный массив: " + Arrays.toString(arr));


        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;

                    buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                }
            }
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        new App();
    }
}
