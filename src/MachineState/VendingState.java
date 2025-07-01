package MachineState;

import Service.VendingMachine;

public interface VendingState {
    void handler(VendingMachine machine);
}
