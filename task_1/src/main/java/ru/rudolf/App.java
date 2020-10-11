package ru.rudolf;

/*
    Напишите программу на Java для переворачивания строки, изменив
    расположение символов в строке задом наперёд
    без использования встроенных в String функций.
*/

public class App {

    //Текст который будем переворачивать
    private static final String textStr = "Hello";


    public static void main(String[] args) {
        System.out.println(reversText(textStr));
    }

    /**
     * Этот метод переворачивает строку, изменив
     * расположение символов в строке задом наперёд.
     * @param text Строка текста, которкую будет переварачивать.
     * @return Новую задом наперёд строку.
     */
    public static String reversText(String text) {
        char[] charStr = text.toCharArray();
        reversText(charStr, 0, text.length() - 1);

        return new String(charStr);
    }
    /**
     * Это вспомогательный метод рекурсивно переворачивает строку символов, изменив расположение символов задом наперёд.
     * @param text Массив символов, который нужно перевернуть.
     * @param e С какого елемента нужно начать перебор.
     * @param length Длина массива.
     */
    private static void reversText(char[] text, int e, int length) {
        if (length - e <= 0)
            return;

        char t = text[e];
        text[e] = text[length];
        text[length] = t;
        reversText(text, e + 1, length - 1);
    }
}