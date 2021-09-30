package module7functionalinterfaces;

import java.util.stream.IntStream;

public class PracticalTask7_2_10 {

    public static void main(String[] args) {
        IntStream intStream = pseudoRandomStream(13);
        intStream.forEach(System.out::println);
    }

    public static IntStream pseudoRandomStream(int seed) {
        //твой код здесь
        return IntStream.iterate(seed, n -> ((n * n) / 10) % 1000);


    }


}
