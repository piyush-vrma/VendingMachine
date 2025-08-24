package states;

public class OutOfService extends BaseMachineState {

    public OutOfService(MachineStateEnum machineStateEnum) {
        super(machineStateEnum);
    }

    @Override
    public void init() {
        super.init();
        System.out.println();
        System.out.println("Sorry! Cannot perform any operations :(");
        System.out.println("Currently out of service");
        System.out.println("Please call the executive");
    }

    @Override
    public void printCurrentState() {
        vendingMachine.display("OUT OF SERVICE STATE");
    }
}
