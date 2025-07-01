package Test;

import Enums.PaymentMode;
import Exceptions.ProductNotFoundException;
import InventoryEntities.Inventory;
import InventoryEntities.Product;
import Service.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @BeforeEach
    public void setup() {
        vendingMachine = VendingMachine.getInstance();
        Inventory inventory = new Inventory();

        // Add 1 Coke priced at ₹10
        Product coke = new Product(1, "Coke", 10);
        inventory.addProduct(coke, 1); // you'll need to implement this
        vendingMachine.setInventory(inventory);
    }

    @Test
    void testSuccessfulDispense() {
        Product coke = new Product(1, "Coke", 10);
        Product result = vendingMachine.dispenseItem(coke, PaymentMode.COIN, 10);
        assertEquals("Coke", result.getName());
    }

    @Test
    void testInsufficientPayment() {
        Product coke = new Product(1, "Coke", 10);
        assertThrows(ProductNotFoundException.class, () ->
                vendingMachine.dispenseItem(coke, PaymentMode.COIN, 5));
    }

    @Test
    void testProductOutOfStock() {
        Product coke = new Product(1, "Coke", 10);
        vendingMachine.dispenseItem(coke, PaymentMode.COIN, 10); // 1st: success
        assertThrows(ProductNotFoundException.class, () ->
                vendingMachine.dispenseItem(coke, PaymentMode.COIN, 10)); // 2nd: out of stock
    }

    @Test
    void testSingleton() {
        VendingMachine anotherRef = VendingMachine.getInstance();
        assertSame(vendingMachine, anotherRef);
    }


}
