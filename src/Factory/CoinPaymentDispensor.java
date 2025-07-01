package Factory;

import Exceptions.ProductNotFoundException;
import InventoryEntities.Inventory;
import InventoryEntities.Product;

public class CoinPaymentDispensor implements Dispensor{
    @Override
    public Product dispense(Product product, Inventory inventory) {
        if (inventory.hasProduct(product)) {
            inventory.reduceQuantity(product);
            return product;
        }
        throw new ProductNotFoundException("Product not found");
    }
}
