package module2types;

import java.math.BigInteger;

public class PracticalTask2_4 {

    public static void main(String[] args) {
//        int minFromFour = getMinFromFour(14, 11, 10, 15);
//        System.out.println(minFromFour);
//        for (int i = 0; i < 70; i++) {
//            System.out.println(i + "лет" + ":" + (determineGroup(i)));
//
//        }
//
//        int[] ints = evenArray(10);
//        int[] ints2 = evenArray(11);
//        int[] ints3 = evenArray(7);
//        int[] ints4 = evenArray(1);
        int[] ints5 = evenArray(100000);

//        System.out.println(Arrays.toString(ints));
//        System.out.println(Arrays.toString(ints2));
//        System.out.println(Arrays.toString(ints3));
//        System.out.println(Arrays.toString(ints4));
//        System.out.println(Arrays.toString(ints5));
        printOddNumbers(ints5);
//        System.out.println(Arrays.toString(mergeArrays(new int[]{3, 5, 7, 9, 10, 15, 17}, new int[]{1, 4, 8})));
//        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 2, 2}, new int[]{1, 3})));

    }

    public static int getMinFromFour(int a, int b, int c, int d) {
        int firstPairResult = getMinFromTwo(a, b);
        int secondPairResult = getMinFromTwo(d, b);

        return getMinFromTwo(firstPairResult, secondPairResult);
    }

    public static int getMinFromTwo(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    public static BigInteger factorial(int value) {
        if (value == 0 || value == 1) {
            return BigInteger.valueOf(1);
        }
        return BigInteger.valueOf(value).multiply(factorial(value - 1));
    }

    public static BigInteger factorialNoRekursion(int value) {
        if (value == 0 || value == 1) {
            return BigInteger.valueOf(1);
        }
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 1; i <= value; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    public static int determineGroup(int age) {
        //Твой код здесь
        if (age >= 7 && age < 14) {
            return 1;
        } else if (age >= 14 && age < 18) {
            return 2;
        } else if (age >= 18 && age < 66) {
            return 3;
        }
        return -1;
    }

    //    Напишите метод evenArray который принимает целое число типа int и возвращает массив заполненный четными числами
//    от 1 до этого числа.
    public static int[] evenArray(int number) {
        //Твой код здесь
//        int[] array = new int[number/2];
        int[] array = new int[number];
//        for (int i = 0, k = 2; k <= number; i++, k+=2) {
        for (int i = 0, k = 2; k <= number; i++, k++) {
            array[i] = k;
        }
        return array;
    }

    public static void printOddNumbers(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        long time = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                stringBuilder.append(arr[i]).append(","); //один объект и с ним работаем
        }
        if (stringBuilder.length() != 0) {
            System.out.println(stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(",")));
        }
        //это ваша программа
//        boolean p = true;
//        long time = System.currentTimeMillis();
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != 0) {
//                if (Math.abs(arr[i] % 2) > 0) {
//                    if(p) {
//                        System.out.print(arr[i]);
//                        p = false;
//                    } else {
//                        System.out.print("," + arr[i]); // вот в этой строке вы создали очень много объектов 50000
//                    }
//                }
//            }
//        }
//        System.out.println("");
        System.out.println(System.currentTimeMillis() - time);
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        //твой код здесь
        int[] resArray = new int[a1.length + a2.length];
        for (int i = 0, leftIndex = 0, rightIndex = 0; i < resArray.length; i++) {
            if (a1.length > leftIndex && a2.length > rightIndex) {
                if (a1[leftIndex] <= a2[rightIndex]) {
                    resArray[i] = a1[leftIndex++];
                } else {
                    resArray[i] = a2[rightIndex++];
                }
            } else if (a1.length > leftIndex) {
                resArray[i] = a1[leftIndex++];
            } else
                resArray[i] = a2[rightIndex++];
        }
        return resArray;
    }
}

