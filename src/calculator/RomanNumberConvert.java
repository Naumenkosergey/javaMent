package calculator;

import java.util.Map;
import java.util.TreeMap;

class RomanNumberConvert {

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put( 100, "C" );
        map.put( 90, "XC" );
        map.put( 50, "L" );
        map.put( 40, "XL" );
        map.put( 10, "X" );
        map.put( 9, "IX" );
        map.put( 5, "V" );
        map.put( 4, "IV" );
        map.put( 1, "I" );
    }


    private static int findKeyForValueToMap(String value) {
        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            if (value.equals( pair.getValue() ))
                return pair.getKey();
        }
        return 0;
    }

    static String arabicToRoman(int number) {
        int l = map.floorKey( number );
        if (number == l) {
            return map.get( number );
        }
        return map.get( l ) + arabicToRoman( number - l );
    }

    static int romanToArabic(String number) {
        int sum = 0;
        int current = 0;
        for (int i = 0; i < number.length(); i++) {
            int prev = current;
            char c = number.charAt( i );
            current = findKeyForValueToMap( String.valueOf( c ) );
            if (i != 0) {
                if (current > prev) {
                    sum -= prev * 2;
                }
            }
            sum += current;
        }
        return sum;
    }
}
