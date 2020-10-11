package ru.rudolf;

/*
    Написать программу вычисления выражения введенного с клавиатуры. Консольное
    приложение запрашивает формулу, после ввода формулы запрашивает значения
    переменных. После ввода всех переменных выводится результат выражения.

    Парсер
    https://github.com/mariuszgromada/MathParser.org-mXparser
*/

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.mXparser;

import java.util.Scanner;

public class App {

    private Scanner in;
    private Expression e;


    public App() {
        in = new Scanner(System.in);

        System.out.println("Введите выражение:");
        String exp = in.nextLine();

        e = new Expression(exp);

        for (String arg: e.getMissingUserDefinedArguments()) {
            System.out.println("Введите " + arg);
            e.addArguments(new Argument(arg, in.nextLine()));
        }

        mXparser.consolePrintln("Res 1: " + e.getExpressionString() + " = " + e.calculate());
    }

    public static void main(String[] args) {
        new App();
    }
}
