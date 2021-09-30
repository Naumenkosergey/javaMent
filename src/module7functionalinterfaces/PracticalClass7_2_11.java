package module7functionalinterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.

 Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:

 minMaxConsumer.accept(min, max);
 Если стрим не содержит элементов, то вызовите:

 minMaxConsumer.accept(null, null);
 Требования:
 1. Должен быть метод public <T> void findMinMax(Stream<? extends T> stream,
                                                Comparator<? super T> order,
                                                BiConsumer<? super T, ? super T> minMaxConsumer)
 2. Метод должен находить минимум и максимум в потоке, с помощью order.
 3. Полученные данные должны быть записаны minMaxConsumer, согласно условию
 List<T> list = stream.sorted(order).collect(Collectors.toList());


 */
public class PracticalClass7_2_11 {

    public static void main(String[] args) {
        Stream<Integer> stream = new ArrayList<Integer>(Arrays.asList(1, 35, 7, 3, 0, 8, 13, 21)).stream();

//        stream.forEach(System.out::println);

        findMinMax(stream,
                Comparator.naturalOrder(),
                (x, y) -> System.out.println(String.format("min %s, max %s", x, y)));
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (!list.isEmpty()) {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

}
