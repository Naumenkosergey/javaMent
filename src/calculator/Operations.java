package calculator;

public interface Operations {

    int add(int a, int b) throws CalculateException;

    int sub(int a, int b) throws CalculateException;

    int mul(int a, int b) throws CalculateException;

    int div(int a, int b) throws CalculateException;


    String add(String a, String b) throws CalculateException;

    String sub(String a, String b) throws CalculateException;

    String mul(String a, String b) throws CalculateException;

    String div(String a, String b) throws CalculateException;
}
