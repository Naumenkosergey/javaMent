package module7functionalinterfaces;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Создайте функциональный интерфейс NumberGenerator, параметризованный таким образом,
 * что принимает только наследников класса Number, имеющий метод boolean cond(T arg).
 * <p>
 * Создайте в методе public static NumberGenerator<? super Number> getGenerator() с
 * помощью лямбда выражения реализацию NumberGenerator, которая возвращает true, если число в int эквиваленте больше 0.
 * <p>
 * Требования:
 * 1. Должен быть метод public static NumberGenerator<? super Number> getGenerator()
 * 2. Соблюдайте код стайл при параметризации.
 * 3. Имя параметра должно быть "Т"
 * 4. Метод должен возвращать корректную реализацию
 */
public class PracticalTask7_1_8 {
    @FunctionalInterface
    interface NumberGenerator<T extends Number> {
        boolean cond(T arg);

    }

    public static NumberGenerator<? super Number> getGenerator() {
        // и здесь
        return n -> n.intValue() > 0;
    }

    public static void main(String[] args) {
        NumberGenerator<? super Number> numGen = getGenerator();
        System.out.println(numGen.cond(123456L));
        System.out.println(numGen.cond(123456.56));
        System.out.println(numGen.cond(132));
        System.out.println(numGen.cond(Byte.MAX_VALUE));
        System.out.println(numGen.cond(-5.5));
        System.out.println(numGen.cond(-1253523525L));
        System.out.println(numGen.cond(0));
        System.out.println(numGen.cond(-2));
        System.out.println(numGen.cond(Byte.MIN_VALUE));
    }

    //PracticalTask 7.1.9
    /**
    * Дан предикат condition и две функции ifTrue и ifFalse. Напишите метод ternaryOperator, который из них построит
     * новую функцию, возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе.
     *
     * Пример использования метода (можно было все свернуть в одну строчку, но для наглядности все элементы
     * вынесены в отдельные переменные):
     *
     *
     * Predicate<Object> condition = Objects::isNull;
     * Function<Object, Integer> ifTrue = obj -> 0;
     * Function<CharSequence, Integer> ifFalse = CharSequence::length;
     * Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
     * Результирующая функция будет для нулевых ссылок на String возвращать 0, а для ненулевых ссылок возвращать длину строки.
     *
     * Все импорты объявлены за вас.
     *
     * Требования:
     * 1. Должен быть метод public static <T, U> Function<T, U> ternaryOperator(Predicate<? super T> condition,
     * Function<? super T, ? extends U> ifTrue, Function<? super T, ? extends U> ifFalse)
     * 2. Метод должен возвращать функцию
     * 3. Используйте лямбда-выражение
     * */
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }
}
