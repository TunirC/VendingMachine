package InventoryEntities;

import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private final ConcurrentHashMap<Integer, ItemSlot> inventoryMapping;

    public Inventory() {
        this.inventoryMapping = new ConcurrentHashMap<>();
    }

    public boolean hasProduct(Product product) {
        return inventoryMapping.containsKey(product.getId()) && inventoryMapping.get(product.getId()).getQuantity() > 0;
    }

    public void reduceQuantity(Product product) {
        inventoryMapping.computeIfPresent(product.getId(), (key, value) -> new ItemSlot(product, value.getQuantity() - 1));
    }

    public void addProduct(Product product, int quantity) {
        inventoryMapping.compute(product.getId(), (key, value) -> {
            if (value == null)  {
                return new ItemSlot(product, quantity);
            } else {
                value.setQuantity(value.getQuantity() + quantity);
                return value;
            }
        });
    }
}
