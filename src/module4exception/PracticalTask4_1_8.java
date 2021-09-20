package module4exception;


/*Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.

Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод, вызвавший данный
утилитный метод. Или null (нулевую ссылку, а не строку "null"), если метод, вызвавший getCallerClassAndMethodName()
является точкой входа в программу, т.е. его никто не вызывал.

Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе надо выводить класс и метод,
откуда сообщение было залогировано.*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PracticalTask4_1_8 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());

        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
        m();
        v();
    }

    private static void v() {
        m();
    }

    private static void m() {
        anotherMethod();
    }

    private static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        if (stackTrace.length < 3) {
            return null;
        } else {
            return stackTrace[2].getClassName() + "#" + stackTrace[2].getMethodName();
        }
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }
}
