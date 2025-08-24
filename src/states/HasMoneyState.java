package states;

public class HasMoneyState extends BaseMachineState {

    public HasMoneyState(MachineStateEnum machineStateEnum) {
        super(machineStateEnum);
    }

    @Override
    public void insertMoney(int amount) {
        vendingMachine.addMoreAmount(amount);
        vendingMachine.display("Received additional " + amount + "Rs");
        vendingMachine.display("Total Amount: " + vendingMachine.getInsertedAmount());
    }

    @Override
    public void selectItem(int itemCode) {
        // Validate entered item code
        if (vendingMachine.hasItem(itemCode)) {
            vendingMachine.display("Item selected: " + itemCode);
            vendingMachine.setMachineState(MachineStateEnum.ItemDispense);
            vendingMachine.getMachineState().dispenseItem(itemCode);
        } else {
            vendingMachine.display("Please enter correct Item Code!!");
        }
    }

    @Override
    public void cancelTransaction() {
        vendingMachine.display("Cancelling operation...");
        returnMoney();
    }

    @Override
    public void returnMoney() {
        int refundAmount = vendingMachine.getInsertedAmount();
        vendingMachine.setInsertedAmount(0);
        vendingMachine.display("Money refunded: " + refundAmount);
        vendingMachine.setMachineState(MachineStateEnum.Idle);
    }

    @Override
    public void printCurrentState() {
        vendingMachine.display("HAS MONEY STATE");
    }
}
