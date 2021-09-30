package module6generics;

import java.util.*;

/**
 * Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами,
 * затем удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность
 * в обратном порядке в System.out.
 * Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.
 * Все import объявлены за вас.
 * <p>
 * Пример ввода: 1 2 3 4 5 6 7 8 9 10
 * Пример вывода: 10 8 6 4 2
 */
public class PracticalTask6_2_14 {

    public static void main(String[] args) {

        /*Scanner scanner = new Scanner(System.in);
    String text = scanner.nextLine();
    String[] textArray = text.split("\\s+");
    List<String> textList = new ArrayList<>(List.of(textArray));
    Iterator<String> iterator = textList.iterator();
    boolean remove = true;
    int i = 0, j = 0;
    while (i < textList.size()) {
        if (remove) {
            remove = false;
            textList.remove(j++);
        } else {
            remove = true;
            i++;
        }
    }
    List<Integer> integers = new ArrayList<>();
    for (i = textList.size() - 1; i >= 0; i--) {
        integers.add(Integer.parseInt(textList.get(i)));
    }
    System.out.println(Arrays.toString(integers.toArray()));*/


        Scanner scanner = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        while (scanner.hasNext()) {
            if (i++ % 2 != 0) {
                deque.addFirst(Integer.parseInt(scanner.next()));
            } else {
                scanner.next();
            }
        }
        for (Integer item : deque) {
            System.out.print(item + " ");
        }
//        System.out.println(Arrays.toString(deque.toArray()));


    }
}
