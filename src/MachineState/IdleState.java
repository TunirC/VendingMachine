package MachineState;

import Service.VendingMachine;

public class IdleState implements VendingState{
    @Override
    public void handler(VendingMachine vendingMachine) {
        System.out.println("Machine is idle");
    }
}
