package calculator;

public class CheckArabicOrRoman {

    public static boolean checkRoman(String value) throws CalculateException {

        if (RomanNumberConvert.romanToArabic( value ) == 0)
            throw new CalculateException( "Не верный формат числа" );
        return true;
    }

    public static boolean checkArabic(String value) {
        try {
            Integer.parseInt( value );
        } catch (Exception ex) {
            return false;
        }

        return true;
    }
}
