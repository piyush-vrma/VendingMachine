package states;

public class IdleState extends BaseMachineState {

    public IdleState(MachineStateEnum machineStateEnum) {
        super(machineStateEnum);
    }

    @Override
    public void insertMoney(int amount) {
        vendingMachine.setInsertedAmount(amount);
        vendingMachine.display("Received " + amount + "Rs");
        vendingMachine.setMachineState(MachineStateEnum.HasMoney);
    }

    @Override
    public void printCurrentState() {
        vendingMachine.display("IDEAL STATE");
    }
}
