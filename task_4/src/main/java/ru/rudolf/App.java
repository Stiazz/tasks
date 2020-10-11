package ru.rudolf;

import java.util.HashMap;

/*
    Напишите программу на Java для подсчета количества конкретных слов в строке, используя HashMap.
*/

public class App {

    private static String text = "Lorem Ipsum - это текст \"рыба\", часто используемый в печати " +
            "и вэб-дизайне. Lorem Ipsum является стандартной \"рыбой\" для текстов на латинице с начала XVI века.";

    private static final HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        //Разбиваем текст на слова
        String[] w = text.split(" ");
        //Проходимся по всему списку
        for (String word : w) {
            //Если такого ключа не существует, содаем его
            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            //Увеличиваем счет у ключа
            map.put(word, map.get(word) + 1);
        }

        System.out.println(map.toString());

    }


}
