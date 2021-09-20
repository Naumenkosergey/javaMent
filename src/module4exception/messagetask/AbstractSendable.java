package module4exception.messagetask;
/**
Абстрактный класс,который позволяет абстрагировать логику хранения
источника и получателя письма в соответствующих полях класса.
*/
public abstract class AbstractSendable implements Sendable {

    protected final String from;

    protected final String to;


    protected AbstractSendable(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null && getClass() != other.getClass()) return false;
        AbstractSendable that = (AbstractSendable) other;
        if (!from.equals(that.from)) return false;
        if (!to.equals(that.to)) return false;
        return true;
    }
}
