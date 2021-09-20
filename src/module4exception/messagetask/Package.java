package module4exception.messagetask;
/**
Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
*/
public class Package {

    private final String content;
    private final int price;

    public Package(String content, int price) {
        this.content = content;
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Package thatPackage = (Package) other;
        if (price != thatPackage.price) return false;
        if (!content.equals(thatPackage.content)) return false;
        return true;
    }
}
