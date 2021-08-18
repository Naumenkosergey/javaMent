package calculator;

class CheckArabicOrRoman {

    static boolean checkRoman(String value) throws CalculateException {

        if (RomanNumberConvert.romanToArabic( value ) == 0)
            throw new CalculateException( "Неверный формат числа" );
        return true;
    }

    static boolean checkArabic(String value) {
        try {
            Integer.parseInt( value );
        } catch (Exception ex) {
            return false;
        }

        return true;
    }
}
