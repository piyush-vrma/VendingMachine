package inventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<Integer, ItemColumn> stock;

    private Inventory() {
        stock = new HashMap<>();
    }

    // Bill pugh Singleton (Thread safe)
    private static class Holder {
        private static final Inventory instance = new Inventory();
    }

    public static Inventory getInstance() {
        return Holder.instance;
    }

    public void insertItem(int itemCode, Item value, int newItemCount) {
        stock.compute(itemCode, (k, existingColumn) -> {
            if (existingColumn == null) {
                return new ItemColumn(value, newItemCount);  // create new
            } else {
                existingColumn.addItems(newItemCount);
                return existingColumn; // update existing
            }
        });
    }

    public void removeItem(int itemCode) {
        stock.computeIfPresent(itemCode, (k, existingColumn) -> {
            if (existingColumn.getItemCount() > 0)
                existingColumn.removeItem();
            else System.out.println("Item Sold Out!!");
            return existingColumn;
        });
    }

    public boolean hasItemInStock(int itemCode) {
        return stock.get(itemCode).getItemCount() > 0;
    }

    public Item getItem(int itemCode) {
        return stock.get(itemCode).getItem();
    }

    public boolean hasItem(int itemCode) {
        // If the itemCode is not found in the stock, that means, the user entered wrong itemCode!
        // Because in the above remove method, we are not removing the entry of itemCode from the HashMap even if the itemCount is zero.
        return stock.containsKey(itemCode);
    }

    public void displayInventory() {
        stock.forEach((itemCode, itemColumn) -> {
            System.out.print("ItemCode: " + itemCode);
            System.out.print(", Price: " + itemColumn.getItem().getPrice());
            System.out.print(", Quantity: " + itemColumn.getItemCount());
            System.out.println();
        });
    }
}

