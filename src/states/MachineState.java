package states;

public interface MachineState {
    void insertMoney(int amount);

    void selectItem(int itemCode);

    void dispenseItem(int itemCode);

    void returnMoney();

    void cancelTransaction();

    void refill();

    void printCurrentState();

    void init();

    MachineStateEnum getMachineStateType();
}
