package module5stream;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;


/**Напишите программу, читающую текст из System.in и выводящую в System.out сумму всех встреченных в
 * тексте вещественных чисел с точностью до шестого знака после запятой. Числом считается последовательность символов,
 * отделенная от окружающего текста пробелами или переводами строк и успешно разбираемая методом Double.parseDouble.
 *На этот раз вам надо написать программу полностью, т.е. объявить  публичный класс с именем
 *Main  и точку входа в программу — метод  main. И добавить все необходимые импорты
 */
public class PracticalTask5_3_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNext("((-)?\\d+e?\\.?\\d*\\s*)|(\\.\\d+)")) {
                sum += Double.parseDouble(scanner.next());
            } else {
                scanner.next();
            }
        }
        System.out.printf(Locale.ENGLISH, "%.6f", sum);
//        StringBuilder text = new StringBuilder();
//        while (true) {
//            String currentLine = scanner.nextLine();
//            if (currentLine.equals("")) {
//                break;
//            }
//            text.append(currentLine).append(" ");
//        }
//        String[] split = text.toString().split("\\s+");
//        double[] arrDouble = convertToDouble(split);
//        System.out.printf(Locale.ENGLISH, "%.6f", sumDoubleArray(arrDouble));
//        Scanner scanner = new Scanner(System.in);
//        String text = scanner.nextLine();
//        String[] split = text.split("\\s+");
//        double[] arrDouble = convertToDouble(split);
//        System.out.printf(Locale.ENGLISH, "%.6f", sumDoubleArray(arrDouble));
    }

    private static double sumDoubleArray(double[] arrDouble) {
        double sum = 0;
        for (double item : arrDouble) {
            sum += item;
        }
        return sum;
    }


    private static double[] convertToDouble(String[] split) {
        double[] d = new double[split.length];
        for (int i = 0, j = 0; i < split.length; i++) {
            try {
                d[j++] = Double.parseDouble(split[i]);
            } catch (NumberFormatException e) {

            }
        }
        return d;
    }
}
