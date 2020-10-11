package ru.rudolf;

/*
    Написать программу реализующую следующий функционал: дано выражение вида ((3 + 2)
    * (6 + 4)), реализовать программу которая сделает вычисление множителей параллельно в
    разных потоках и вычислит их произведение
*/

public class App {

    public App() {
        SumThread sumThread_1 = new SumThread(3, 2);
        SumThread sumThread_2 = new SumThread(6, 4);

        sumThread_1.start();
        sumThread_2.start();

        try {
            sumThread_1.join();
            sumThread_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int end = sumThread_1.getSum() * sumThread_2.getSum();

        System.out.println(end);
    }

    public static void main(String[] args) {
        new App();
    }
}

class SumThread extends Thread {

    private final int a;
    private final int b;
    private int sum;

    public SumThread(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        sum = a + b;
        System.out.println(Thread.currentThread().getName() + " " + +a + "+" + b + "=" + sum);
    }

    public int getSum() {
        return sum;
    }
}
