package module2types;

public class PracticalTask2_1 {

    public static void main(String[] args) {
        System.out.println(priceColculation(17.25, 2));
        System.out.println(priceColculation(8.5, 2));
        System.out.println(priceColculation(5, 2));
        System.out.println(priceColculation(-5, 2));
        System.out.println(priceColculation(14.0, 2));

        System.out.println(doubleExpression(0.5, 0.5, 1));
        System.out.println(doubleExpression(0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1, 0.5, 1.5));
        System.out.println(doubleExpression(0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1, 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1, 1.5));
        System.out.println(doubleExpression(0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1, 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1, 2.0));


        System.out.println(drawisMonitorsCounter(5,13));
        System.out.println(drawisMonitorsCounter(50,13));
        System.out.println(drawisMonitorsCounter(13,13));
        System.out.println(drawisMonitorsCounter(14,13));
        System.out.println(drawisMonitorsCounter(28,13));


    }

    private static double priceColculation(double price, int count) {

        return price * count;
    }

    public static boolean doubleExpression(double a, double b, double c) {
//        return a + b == c;
        return Math.abs(c - (a + b)) < 0.0001;
    }

    public static  int drawisMonitorsCounter(int monitors, int programmers) {
        return monitors % programmers;

    }

}
