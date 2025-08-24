package inventory;

public class ItemColumn {
    private final Item item;
    private int itemCount;

    public ItemColumn(Item item, int itemCount) {
        this.item = item;
        this.itemCount = itemCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public Item getItem() {
        return item;
    }

    public void addItems(int newItemCount) {
        itemCount += newItemCount;
    }

    public void removeItem() {
        itemCount--;
    }
}
