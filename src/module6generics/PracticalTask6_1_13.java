package module6generics;

import java.util.ArrayList;
import java.util.Arrays;

public class PracticalTask6_1_13 {

    public static void main(String[] args) {
        DynamicArray<Integer> mylist = new DynamicArray<>();

        System.out.println(mylist.length);
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
        mylist.add(4);
        mylist.add(5);
        mylist.add(6);
        mylist.remove(5);
        mylist.add(7);
        mylist.add(8);
        mylist.add(9);
        mylist.add(10);
        mylist.add(11);
        mylist.add(12);
        mylist.remove(10);
        mylist.add(13);
        System.out.println(mylist);
    }

    public static class DynamicArray<T> {
        private int length = 10;
        private int current = 0;
        private T[] array = (T[]) new Object[length];

        public void add(T el) {
            if (current > array.length - 1) {
                createArray();
            }
            array[current++] = el;
        }

        private void createArray() {
            length = length * 3 / 2 + 1;
            array = Arrays.copyOf(array, length);
        }


        public void remove(int index) {
            System.arraycopy(array, index + 1, array, index, array.length - (index + 1));
            current = current > 0 ? current - 1 : 0;

        }

        public T get(int index) {
            return array[index];
        }

        @Override
        public String toString() {
            return Arrays.toString(array);
        }
    }
}


 /*
        public void remove(int index) {
        T[] fistPart = Arrays.copyOfRange(array, 0, index);
        T[] secondPart = Arrays.copyOfRange(array, index + 1, length);
        for (int i = 0; i < fistPart.length; i++) {
            array[i] = fistPart[i];
        }
        for (int i = 0, j = fistPart.length; i < secondPart.length; i++) {
            array[j++] = secondPart[i];
        }

    }*/

        /*public void remove(int index) {
            T[] newArray = (T[]) new Object[array.length - 1];
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, array.length - 1 - index);
            current = current > 0 ? current - 1 : 0;
            array = newArray;
        }*/
