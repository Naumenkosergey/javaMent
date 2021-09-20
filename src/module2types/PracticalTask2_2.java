package module2types;

public class PracticalTask2_2 {

    public static void main(String[] args) {
        System.out.println(charExpression(5));
//        System.out.println(isPowerOfTwo(32));
//        System.out.println(isPowerOfTwo(-2));
//        System.out.println(isPowerOfTwo(33));
//        System.out.println(isPowerOfTwo(1024));
//        System.out.println(isPowerOfTwo(-512));
//        System.out.println(isPowerOfTwo(-513));
    }

    static char charExpression(int a) {
//        char c = '\\';
//        int numeric = (int)c+a;
        return (char) ('\\' + a);
    }

    static boolean isPowerOfTwo(int value) {
        value = Math.abs(value);
        while (value != 1 && value % 2 == 0) {
            value /= 2;
        }
        return value == 1;

//        return Integer.bitCount(Math.abs(value)) == 1;

    }
}
