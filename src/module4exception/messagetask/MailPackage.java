package module4exception.messagetask;

/**
Посылка, содержимое которой можно получить с помощью метода `getContent`
*/
public class MailPackage extends AbstractSendable {

    private final Package content;

    public MailPackage(String from, String to, Package content) {
        super(from, to);
        this.content = content;
    }

    public Package getContent() {
        return content;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        if (!super.equals(other)) return false;
        MailPackage that = (MailPackage) other;
        if (!content.equals(that.content)) return false;
        return true;
    }
}
