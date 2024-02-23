package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == productId) {
                iterator.remove();
                System.out.println("Товар успішно видалено з кошика.");
                return;
            }
        }
        System.out.println("Товар з таким ID не знайдено у кошику.");
    }

    public List<Product> getProducts() {
        return products;
    }
}