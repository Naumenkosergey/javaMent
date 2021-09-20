package module4exception.messagetask;

import java.util.Objects;

/**
Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
*/
public class MailMessage extends AbstractSendable {

    private final String message;

    protected MailMessage(String from, String to, String message) {
        super(from, to);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        if (!super.equals(other)) return false;
        MailMessage that = (MailMessage) other;
//        return Objects.equals(message, that.message);
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
