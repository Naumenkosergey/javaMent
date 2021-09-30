package module6generics;

import java.util.Objects;

public class PracticalTask6_1_12 {

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

        System.out.println(i);
        System.out.println(s);
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);
    }

    public static class Pair<T, X> {

        private T first;
        private X second;

        private Pair(T first, X second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public X getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Pair that = (Pair) obj;
            return Objects.equals(this.first, ((Pair<?, ?>) that).first) &&
                    Objects.equals(this.second, ((Pair<?, ?>) that).second);
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(first, second);
        }

        public static <T, X> Pair<T, X> of(T first, X second) {

            return new Pair<>(first, second);
        }
    }

}
