package module4exception.bank;

public class BadCreditHistoryException extends Exception {

    public BadCreditHistoryException(String message) {
        super(message);
    }
}
