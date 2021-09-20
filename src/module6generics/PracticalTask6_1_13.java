package module6generics;

import java.util.Arrays;

public class PracticalTask6_1_13 {

    public static void main(String[] args) {
        DynamicArray<Integer> mylist = new DynamicArray<>();

        System.out.println(mylist.length);
        mylist.add(5);
        mylist.add(5);
        mylist.add(5);
        mylist.add(5);
        mylist.add(5);
        mylist.add(4);
        mylist.add(5);
        mylist.add(5);
        mylist.add(5);
        mylist.add(5);
        mylist.add(5);
        mylist.add(5);
        mylist.add(5);
        System.out.println(mylist);
        int a = mylist.get(5);
        System.out.println(a);
        mylist.remove(5);
        System.out.println(mylist);
    }

    public static class DynamicArray<T> {
        //Реализуй класс здесь
        private T[] array;
        private int length = 10, current;

        public DynamicArray() {
            array = (T[]) new Object[length];
        }

        public void add(T el) {
            if (current > array.length - 1) {
                createArray();
            }
            array[current++] = el;
        }

        private void createArray() {
            T[] newArray = Arrays.copyOf(array, length);
            length = length * 3 / 2 + 1;
            new DynamicArray();
            array = Arrays.copyOf(newArray, length);

        }

        public void remove(int index) {
            T[] fistPart = Arrays.copyOfRange(array, 0, index);
            T[] secondPart = Arrays.copyOfRange(array, index + 1, length);
            for (int i = 0; i < fistPart.length; i++) {
                array[i] = fistPart[i];
            }
            for (int i = 0, j = fistPart.length; i < secondPart.length; i++) {
                array[j++] = secondPart[i];
            }

        }

        public <T> T get(int index) {
            return (T) array[index];
        }

        @Override
        public String toString() {
            return Arrays.toString(array);
        }
    }
}
