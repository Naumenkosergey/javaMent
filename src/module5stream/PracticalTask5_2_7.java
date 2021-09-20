package module5stream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Напишите метод int sumOfStream(InputStream inputStream),
 * который принимает InputStream и возвращает сумму всех его элементов.
 * <p>
 * Пример ввода: 1, 2, 4, 10
 * <p>
 * Пример вывода: 17
 */

public class PracticalTask5_2_7 {

    public static void main(String[] args) throws IOException {
//        InputStream inputStream = new FileInputStream("D:\\javaMent\\src\\module5stream\\file.txt");
////        byte[]input = {6, 16, 12, 50};
////        InputStream inputStream = new ByteArrayInputStream(input);
//        System.out.println(sumOfStream(inputStream));
        byte[] arr = {1, 2, 4, 10, -6};
        byte[] arr2 = {};
        byte[] arr3 = {48, 49, 50, 51};
        InputStream inputStream = new ByteArrayInputStream(arr3);

        OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                System.out.println(b);
            }
        };
//        System.out.println(sumOfStream(inputStream));
//        print(inputStream, outputStream);
        System.out.println(readAsString(inputStream, StandardCharsets.US_ASCII));
    }

    /**
     * Напишите метод int sumOfStream(InputStream inputStream),
     * который принимает InputStream и возвращает сумму всех его элементов.
     * Пример ввода: 1, 2, 4, 10
     * Пример вывода: 17
     */
    public static int sumOfStream(InputStream inputStream) throws IOException {
        int buf;
        int sum = 0;
        while ((buf = inputStream.read()) != -1) {
            sum += (byte) buf;
        }
        return sum;
    }

    /**
     * Напишите метод void print(InputStream inputStream, OutputStream outputStream) который принимает
     * InputStream и OutputStream, считывает все байты из inputStream и записывает в OutputStream только четные.
     * Пример ввода: 3, 10, 4, 5, 7
     * Пример вывода: 10, 4
     */
    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        //твой код здесь
        int buf;
        while ((buf = inputStream.read()) != -1) {
            if (buf % 2 == 0) {
                outputStream.write((byte) buf);
            }
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
    }

    /**
     * Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
     * Пример:
     * InputStream последовательно возвращает четыре байта: 48 49 50 51
     * Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку: "0123".
     */
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        //Твой код здесь
        Reader reader = new InputStreamReader(inputStream, charset);
        StringWriter writer = new StringWriter();
        int buf;
        while ((buf = reader.read()) != -1) {
            writer.write(buf);
        }
        return writer.toString();
    }
}

