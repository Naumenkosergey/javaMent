package module6generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Реализуйте метод symmetricDifference, вычисляющий симметрическую разность двух множеств.
 * Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.
 * <p>
 * Пример ввода: [1, 2, 3} и {0, 1, 2]
 * Пример вывода: [0, 3]
 */
public class PracticalTask6_2_13 {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(0);
        set2.add(1);
        set2.add(2);


        Set<Integer> integers = summetricDifference(set1, set2);

        System.out.println(Arrays.toString(integers.toArray()));
    }

    public static <T> Set<T> summetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> resultSet = new HashSet<>(set1);
        resultSet.addAll(set2);
        Set<T> temptSet = new HashSet<>(set1);
        temptSet.retainAll(set2);
        resultSet.removeAll(temptSet);
        return resultSet;
//        extracted(set1, set2, resultSet);
//        extracted(set2, set1, resultSet);
//        return (Set<T>) resultSet;
//        set1.add(set2);
//        set2.removeAll(set1);
    }

    //проверяет по порядку элеметы множества 1 входят ли в множества 2
    private static <T> void extracted(Set<? extends T> set1, Set<? extends T> set2, Set<T> resultSet) {
        Iterator<? extends T> iterator = set1.iterator();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (!set2.contains(next)) {
                resultSet.add(next);
            }
        }
    }
}
