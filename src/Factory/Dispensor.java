package Factory;

import InventoryEntities.Inventory;
import InventoryEntities.Product;

public interface Dispensor {
    Product dispense(Product product, Inventory inventory);
}
