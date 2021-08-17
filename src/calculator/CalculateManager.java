package calculator;

public class CalculateManager implements Operations {

    @Override
    public int add(int a, int b) throws CalculateException {
        if (a > 10 || a < 0 || b < 0 || b > 10)
            throw new CalculateException( "Подано неверное число" );
        return a + b;
    }

    @Override
    public String add(String a, String b) throws CalculateException {

        return RomanNumberConvert.arabicToRoman( add( RomanNumberConvert.romanToArabic( a ),
                RomanNumberConvert.romanToArabic( b ) ) );
    }

    @Override
    public int sub(int a, int b) throws CalculateException {
        if (a > 10 || a < 0 || b < 0 || b > 10)
            throw new CalculateException( "Подано неверное число" );
        else
            return a - b;
    }

    @Override
    public String sub(String a, String b) throws CalculateException {
        if (RomanNumberConvert.romanToArabic( b ) > RomanNumberConvert.romanToArabic( a ))
            throw new CalculateException( "//т.к. в римской системе счисления нет отрицательных чисел" );
        return RomanNumberConvert.arabicToRoman( sub( RomanNumberConvert.romanToArabic( a ),
                RomanNumberConvert.romanToArabic( b ) ) );
    }

    @Override
    public int mul(int a, int b) throws CalculateException {
        if (a > 10 || a < 0 || b < 0 || b > 10)
            throw new CalculateException( "Подано неверное число" );
        else
            return a * b;
    }

    @Override
    public String mul(String a, String b) throws CalculateException {
        return RomanNumberConvert.arabicToRoman( mul( RomanNumberConvert.romanToArabic( a ),
                RomanNumberConvert.romanToArabic( b ) ) );
    }

    @Override
    public int div(int a, int b) throws CalculateException {
        if (a > 10 || a < 0 || b < 0 || b > 10)
            throw new CalculateException( "Подано неверное число" );
        else
            return a / b;
    }

    @Override
    public String div(String a, String b) throws CalculateException {
        return RomanNumberConvert.arabicToRoman( div( RomanNumberConvert.romanToArabic( a ),
                RomanNumberConvert.romanToArabic( b ) ) );
    }


    public String checkOperation(String[] splitLine) throws CalculateException {
        if ("+".equals( splitLine[1] )) {
            if (CheckArabicOrRoman.checkArabic( splitLine[0] ) && CheckArabicOrRoman.checkArabic( splitLine[2] ))
                return String.valueOf( add( Integer.parseInt( splitLine[0] ), Integer.parseInt( splitLine[2] ) ) );
            else if (CheckArabicOrRoman.checkRoman( splitLine[0] ) && CheckArabicOrRoman.checkRoman( splitLine[2] ))
                return add( splitLine[0], splitLine[2] );
            else
                throw new CalculateException( "Неверный формат чисел" );
        } else if ("-".equals( splitLine[1] )) {
            if (CheckArabicOrRoman.checkArabic( splitLine[0] ) && CheckArabicOrRoman.checkArabic( splitLine[2] ))
                return String.valueOf( sub( Integer.parseInt( splitLine[0] ), Integer.parseInt( splitLine[2] ) ) );
            else if (CheckArabicOrRoman.checkRoman( splitLine[0] ) && CheckArabicOrRoman.checkRoman( splitLine[2] ))
                return sub( splitLine[0], splitLine[2] );
            else
                throw new CalculateException( "Неверный формат чисел" );
        } else if ("*".equals( splitLine[1] )) {
            if (CheckArabicOrRoman.checkArabic( splitLine[0] ) && CheckArabicOrRoman.checkArabic( splitLine[2] ))
                return String.valueOf( mul( Integer.parseInt( splitLine[0] ), Integer.parseInt( splitLine[2] ) ) );
            else if (CheckArabicOrRoman.checkRoman( splitLine[0] ) && CheckArabicOrRoman.checkRoman( splitLine[2] ))
                return mul( splitLine[0], splitLine[2] );
            else
                throw new CalculateException( "Неверный формат чисел" );
        } else if ("/".equals( splitLine[1] )) {
            if (CheckArabicOrRoman.checkArabic( splitLine[0] ) && CheckArabicOrRoman.checkArabic( splitLine[2] ))
                return String.valueOf( div( Integer.parseInt( splitLine[0] ), Integer.parseInt( splitLine[2] ) ) );
            else if (CheckArabicOrRoman.checkRoman( splitLine[0] ) && CheckArabicOrRoman.checkRoman( splitLine[2] ))
                return div( splitLine[0], splitLine[2] );
            else
                throw new CalculateException( "Неверный формат чисел" );
        } else
            throw new CalculateException( "//т.к. знак операции не соответствует задаче" );


    }
}
