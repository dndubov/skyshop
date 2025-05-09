package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> basket = new HashMap<>();

    public void addProduct(Product product) {
        String name = product.getName();
        basket.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
        System.out.println("Добавлен: " + product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removed = basket.remove(name);
        return removed != null ? removed : Collections.emptyList();
    }

    public void printContents() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        int totalPrice = 0;
        int specialCount = 0;

        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                System.out.println(product);
                totalPrice += product.getPrice();
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + totalPrice + " руб.");
        System.out.println("Специальных товаров: " + specialCount);
    }
}
