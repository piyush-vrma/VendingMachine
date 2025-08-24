package vendingMachine;

import inventory.Item;
import states.MachineState;
import states.MachineStateEnum;

public interface VendingMachine {
    void setMachineState(MachineStateEnum machineState);

    int getInsertedAmount();

    void setInsertedAmount(int insertedAmount);

    void addMoreAmount(int moreAmount);

    void display(String msg);

    void insertItem(int itemCode, Item value, int newItemCount);

    void removeItem(int itemCode);

    boolean hasItemInStock(int itemCode);

    boolean hasItem(int itemCode);

    Item getItem(int itemCode);

    MachineStateEnum getMachineStateType();

    MachineState getMachineState();

    void displayInventory();

    void setTransactionComplete(boolean isTransactionComplete);

    boolean getTransactionComplete();
}
