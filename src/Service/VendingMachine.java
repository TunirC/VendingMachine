package Service;

import Exceptions.ProductNotFoundException;
import InventoryEntities.Inventory;
import InventoryEntities.Product;
import Enums.PaymentMode;
import Factory.DispensorFactory;
import MachineState.DispenseState;
import MachineState.IdleState;
import MachineState.VendingState;

public class VendingMachine {
    private static VendingMachine instance;
    private VendingState state;
    private Inventory inventory;
    private Transaction transaction;

    private VendingMachine() {
        this.state = new IdleState();
        this.inventory = new Inventory();
        this.transaction = new Transaction();
    }

    public static VendingMachine getInstance() {
        VendingMachine localRef = instance;
        if (localRef == null) {
            synchronized (VendingMachine.class) {
                if (localRef == null) {
                    instance = localRef = new VendingMachine();
                }
            }
        }
        return localRef;
    }

    public Product dispenseItem(Product product, PaymentMode paymentMode, double amount) {
            // Set State
        if (initiateTransaction(product, paymentMode, amount)) {
            setState(new DispenseState());
            state.handler(this);
            DispensorFactory factory = new DispensorFactory();
            return factory.createDispensor(paymentMode).dispense(product, inventory);
        }
        throw new ProductNotFoundException("Product not dispensed successfully.");
    }

    public boolean initiateTransaction(Product product, PaymentMode paymentMode, double amount) {
        transaction.setMode(paymentMode);
        transaction.setSelectedProduct(product);
        return transaction.completeTransaction(amount);
    }

    public VendingState getState() {
        return state;
    }

    public void setState(VendingState state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
