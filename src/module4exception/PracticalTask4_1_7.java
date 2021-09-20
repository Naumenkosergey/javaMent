package module4exception;

public class PracticalTask4_1_7 {

    public static void main(String[] args) throws MyNewException {
        testEx();
    }
    public static void testEx() throws MyNewException{
        throw new MyNewException("myExeption");
    }
}


