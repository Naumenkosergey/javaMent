package module2types;

public class PracticalTask2_3 {

    public static void main(String[] args) {
        System.out.println(isPalindrom("Was it a cat I saw"));
        System.out.println(isPalindrom("шалаш"));
        System.out.println(isPalindrom("ifkfi"));
        System.out.println(isPalindrom("а роза упала на лапу азора"));
        System.out.println(isPalindrom("A palindrome is a word, number, phrase, or other sequence of characters which reads the same backward as forward, such as madam or racecar or the number 1080"));
    }

    private static boolean isPalindrom(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        StringBuffer stringBufferReverse = new StringBuffer(s).reverse();

        return s.equalsIgnoreCase(stringBufferReverse.toString());
    }
}
