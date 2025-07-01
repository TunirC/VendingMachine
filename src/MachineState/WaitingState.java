package MachineState;

import Service.VendingMachine;

public class WaitingState implements VendingState {
    @Override
    public void handler(VendingMachine vendingMachine) {
        System.out.println("Machine is waiting for payment");
    }
}
