package states;

import vendingMachine.VendingMachine;

public abstract class BaseMachineState implements MachineState {
    protected VendingMachine vendingMachine;
    protected MachineStateEnum machineStateType;

    protected BaseMachineState(MachineStateEnum machineStateEnum) {
        this.machineStateType = machineStateEnum;
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("OOPS! Cannot perform this operation!!");
    }

    @Override
    public void selectItem(int itemCode) {
        System.out.println("OOPS! Cannot perform this operation!!");
    }

    @Override
    public void dispenseItem(int itemCode) {
        System.out.println("OOPS! Cannot perform this operation!!");
    }

    @Override
    public void returnMoney() {
        System.out.println("OOPS! Cannot perform this operation!!");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("OOPS! Cannot perform this operation!!");
    }

    @Override
    public void refill() {
        System.out.println("OOPS! Cannot perform this operation!!");
    }

    @Override
    public void init() {
        System.out.println("State Init!");
        printCurrentState();
    }

    @Override
    public MachineStateEnum getMachineStateType() {
        return machineStateType;
    }
}
