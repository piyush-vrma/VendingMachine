package states;

public class OutOfStock extends BaseMachineState {

    public OutOfStock(MachineStateEnum machineStateEnum) {
        super(machineStateEnum);
    }

    @Override
    public void init() {
        super.init();
        System.out.println();
        System.out.println("Item SOLD OUT!!");
        System.out.println("Please select different item or cancel the transaction!!");
        System.out.println("You'll get full refund if you cancel!");
        vendingMachine.setMachineState(MachineStateEnum.HasMoney);
    }

    @Override
    public void printCurrentState() {
        vendingMachine.display("OUT OF STOCK STATE");
    }
}
