package MachineState;

import Service.VendingMachine;

public class DispenseState implements VendingState {
    @Override
    public void handler(VendingMachine vendingMachine) {
        System.out.println("Machine is dispensing product");
    }
}
