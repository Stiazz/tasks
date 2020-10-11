package ru.rudolf;

/*Напишите Java-программу, чтобы определить, является ли строка или число палиндромом, или нет.*/

public class App {

    private static final String word = "121";

    public static void main(String[] args) {

        StringBuilder revWord = new StringBuilder();
        char[] wordChar = word.toCharArray();

        for (int i = wordChar.length - 1; i >= 0; i--) {
            revWord.append(wordChar[i]);
        }

        System.out.println(word.equals(revWord.toString()) ? "Палиндромом" : "Не палиндромом");
    }
}
