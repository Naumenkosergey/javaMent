package module4exception;

public class MyNewException extends Exception {

    public MyNewException() {
        super();
    }

    public MyNewException(String message) {
        super(message);
    }

    public MyNewException(String message, Throwable cause) {
        super(message, cause);
    }
}
