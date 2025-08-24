package factory;

import states.*;

public class MachineStateFactory {
    public static MachineState getMachineState(MachineStateEnum machineStateEnum) throws Exception {
        switch (machineStateEnum) {
            case Idle -> {
                return new IdleState(machineStateEnum);
            }
            case HasMoney -> {
                return new HasMoneyState(machineStateEnum);
            }
            case ItemDispense -> {
                return new ItemDispense(machineStateEnum);
            }
            case OutOfStock -> {
                return new OutOfStock(machineStateEnum);
            }
            case OutOfService -> {
                return new OutOfService(machineStateEnum);
            }
            default -> {
                throw new Exception("Unknown State");
            }
        }
    }
}
