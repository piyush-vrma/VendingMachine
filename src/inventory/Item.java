package inventory;

public class Item {
    private final int code;
    private final String name;
    private final int price;

    public Item(int code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
