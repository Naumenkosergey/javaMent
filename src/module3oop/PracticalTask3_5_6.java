package module3oop;

public class PracticalTask3_5_6 {


/*Напишите статический класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов
 (их коды влезают в один байт) в массиве байт. По сравнению с классом String из Java 8, хранящим каждый символ как char,
  AsciiCharSequence будет занимать в два раза меньше памяти

Класс AsciiCharSequence должен:

реализовывать интерфейс java.lang.CharSequence;
иметь конструктор, принимающий массив байт;
определять методы length(), charAt(), subSequence() и toString()

Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence
(JavaDoc или исходники).

В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, поэтому их
проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.*/

    public static void main(String[] args) {

//        AsciiCharSequence asciiCharSequence = new AsciiCharSequence(new byte[]{65,70,75,80,90,100,127,33,20,40});
        AsciiCharSequence asciiCharSequence = new AsciiCharSequence();
        System.out.println(asciiCharSequence.length());
        for (int i = 0; i < asciiCharSequence.length(); i++) {

            System.out.println(i + "-" + " " + asciiCharSequence.charAt(i));
        }

        System.out.println(asciiCharSequence);
        System.out.println(asciiCharSequence.subSequence(5,10));
    }

}

