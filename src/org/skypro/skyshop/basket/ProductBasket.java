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

        basket.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + getTotalPrice() + " руб.");
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    private int getTotalPrice() {
        return basket.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    private long getSpecialCount() {
        return basket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }
}
