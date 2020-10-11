package ru.rudolf;

/*
    Напишите Java-программу для удаления
    всех пробелов из строки с помощью replace() и
    без использования replace().
*/

public class App {

    private String text = "One Two Three";

    public App() {
        System.out.println(withReplace(text));
        System.out.println(withoutReplace(text));
    }

    private String withReplace(String text) {
        return text.replaceAll("\\s", "");
    }

    private String withoutReplace(String text) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if ((text.charAt(i) != ' ') && (text.charAt(i) != '\t')) {
                builder.append(text.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        new App();
    }

}
