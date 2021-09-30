package module7functionalinterfaces;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;


/**Напишите метод с названием sqrt, который возвращает реализацию функционального интерфейса UnaryOperator,
 * который принимает целое число(тип int) и возвращает его квадрат.

 Требования:
 1. Должен быть метод public UnaryOperator sqrt()
 2. Метод должен возвращать реализацию интерфейса UnaryOperator.
 3. Реализация должна соответствовать условию
 * */
public class PracticalTask7_1_7 {

    public static void main(String[] args) {

    }

    public UnaryOperator<Integer> sqrt() {
        //Твой код здесь
        return integer -> integer * integer;
    }
}

