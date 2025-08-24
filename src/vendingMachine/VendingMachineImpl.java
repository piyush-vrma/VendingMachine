package vendingMachine;

import factory.MachineStateFactory;
import inventory.Inventory;
import inventory.Item;
import states.BaseMachineState;
import states.MachineState;
import states.MachineStateEnum;

public class VendingMachineImpl implements VendingMachine {

    private MachineState machineState;
    private int insertedAmount;
    private final Inventory inventory;
    private boolean isTransactionComplete = false;

    public VendingMachineImpl(MachineState machineState) {
        this.machineState = machineState;
        insertedAmount = 0;
        inventory = Inventory.getInstance();
    }

    @Override
    public MachineStateEnum getMachineStateType() {
        return machineState.getMachineStateType();
    }

    @Override
    public MachineState getMachineState() {
        return machineState;
    }

    @Override
    public void displayInventory() {
        inventory.displayInventory();
    }

    @Override
    public void setTransactionComplete(boolean isTransactionComplete) {
        this.isTransactionComplete = isTransactionComplete;
    }

    @Override
    public boolean getTransactionComplete() {
        return isTransactionComplete;
    }

    @Override
    public void setMachineState(MachineStateEnum machineState) {
        try {
            this.machineState = MachineStateFactory.getMachineState(machineState);
            ((BaseMachineState) this.machineState).setVendingMachine(this);
            this.machineState.init();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void display(String msg) {
        System.out.println("[VM Display]: " + msg);
        System.out.println();
    }

    @Override
    public void insertItem(int itemCode, Item value, int newItemCount) {
        inventory.insertItem(itemCode, value, newItemCount);
    }

    @Override
    public void removeItem(int itemCode) {
        inventory.removeItem(itemCode);
    }

    @Override
    public boolean hasItemInStock(int itemCode) {
        return inventory.hasItemInStock(itemCode);
    }

    @Override
    public boolean hasItem(int itemCode) {
        return inventory.hasItem(itemCode);
    }

    @Override
    public Item getItem(int itemCode) {
        return inventory.getItem(itemCode);
    }

    @Override
    public int getInsertedAmount() {
        return insertedAmount;
    }

    @Override
    public void setInsertedAmount(int insertedAmount) {
        this.insertedAmount = insertedAmount;
    }

    @Override
    public void addMoreAmount(int moreAmount) {
        this.insertedAmount += moreAmount;
    }
}
