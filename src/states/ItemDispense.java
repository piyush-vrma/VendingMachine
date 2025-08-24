package states;

import inventory.Item;

public class ItemDispense extends BaseMachineState {

    public ItemDispense(MachineStateEnum machineStateEnum) {
        super(machineStateEnum);
    }

    @Override
    public void dispenseItem(int itemCode) {
        // Check if the item is in the stock, if yes -> dispense the item and update the stock in inventory
        if (vendingMachine.hasItemInStock(itemCode)) {
            // Item is in stock, check if inserted amount is sufficient, if not move to HasMoneyState.

            Item item = vendingMachine.getItem(itemCode);
            if (item.getPrice() <= vendingMachine.getInsertedAmount()) {
                // consume the amount with the item price
                vendingMachine.setInsertedAmount(vendingMachine.getInsertedAmount() - item.getPrice());
                // dispense
                vendingMachine.display("Item Dispensed!");
                // update inventory
                vendingMachine.removeItem(itemCode);
                // check for balance amount, if no money left, move to Idle state
                if (vendingMachine.getInsertedAmount() == 0) {
                    vendingMachine.display("Thank You for choosing US :)");
                    vendingMachine.setMachineState(MachineStateEnum.Idle);
                    vendingMachine.setTransactionComplete(true);
                }
            } else {
                vendingMachine.display("Insufficient balance!!");
            }

            // Insufficient money or money left after receiving item.
            // move to HasMoneyState
            if (vendingMachine.getInsertedAmount() > 0) {
                vendingMachine.display("Money remaining: " + vendingMachine.getInsertedAmount());
                vendingMachine.setMachineState(MachineStateEnum.HasMoney);
            }
        } else {
            vendingMachine.setMachineState(MachineStateEnum.OutOfStock);
        }
    }

    @Override
    public void printCurrentState() {
        vendingMachine.display("ITEM DISPENSE STATE");
    }
}
