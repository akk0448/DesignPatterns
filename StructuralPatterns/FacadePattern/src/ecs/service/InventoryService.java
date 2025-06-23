package ecs.service;

import ecs.model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InventoryService {

    private final Map<Integer, Product> productMap = new HashMap<>();

    public InventoryService() {
        addProduct(new Product(1, "Wireless Mouse", 499.0, 10));
        addProduct(new Product(2, "Mechanical Keyboard", 1499.0, 5));
        addProduct(new Product(3, "USB-C Cable", 199.0, 20));
    }

    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    public void listProducts() {
        System.out.println("\n--- Available Products ---");
        productMap.values().forEach(System.out::println);
    }

    public Optional<Product> getProductById(int id) {
        return Optional.ofNullable(productMap.get(id));
    }

    public boolean isAvailable(int productId, int quantity) {
        Product product = productMap.get(productId);
        return product != null && product.getStock() >= quantity;
    }

    public void reduceStock(int productId, int quantity) {
        Product product = productMap.get(productId);
        if (product != null) {
            product.reduceStock(quantity);
        }
    }
}