import Enums.PaymentMode;
import InventoryEntities.Inventory;
import InventoryEntities.Product;
import Service.VendingMachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        VendingMachine vendingMachine = VendingMachine.getInstance();
        Inventory inventory = new Inventory();
        Product coke = new Product(1, "Coke", 10);
        Product pepsi = new Product(2, "Pepsi", 15);
        Product chips = new Product(3, "Chips", 20);
        inventory.addProduct(coke, 5);
        inventory.addProduct(pepsi, 3);
        inventory.addProduct(chips, 2);

        vendingMachine.setInventory(inventory);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- VENDING MACHINE ---");
            System.out.println("1. Buy Coke (₹10)");
            System.out.println("2. Buy Pepsi (₹15)");
            System.out.println("3. Buy Chips (₹20)");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int option = scanner.nextInt();
            Product selectedProduct = null;
            switch (option) {
                case 1 -> selectedProduct = coke;
                case 2 -> selectedProduct = pepsi;
                case 3 -> selectedProduct = chips;
                case 4 -> {
                    System.out.println("Thank you. Goodbye!");
                    return;
                }
                default -> {
                    System.out.println("Invalid option.");
                    continue;
                }
            }

            System.out.println("Select Payment Mode: COIN / CASH / ONLINE");
            String paymentStr = scanner.next().toUpperCase();
            PaymentMode paymentMode = PaymentMode.valueOf(paymentStr);

            System.out.print("Enter amount: ₹");
            double amount = scanner.nextDouble();

            try {
                Product dispensed = vendingMachine.dispenseItem(selectedProduct, paymentMode, amount);
                System.out.println("✅ Dispensed: " + dispensed.getName());
            } catch (Exception e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }
}