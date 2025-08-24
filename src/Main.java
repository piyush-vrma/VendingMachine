import controller.VendingMachineController;
import states.BaseMachineState;
import states.IdleState;
import states.MachineStateEnum;
import vendingMachine.VendingMachine;
import vendingMachine.VendingMachineImpl;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachineImpl(new IdleState(MachineStateEnum.Idle));
        ((BaseMachineState) vendingMachine.getMachineState()).setVendingMachine(vendingMachine);
        VendingMachineController controller = new VendingMachineController(vendingMachine);
        controller.fillInventory();
        controller.start();
    }
}