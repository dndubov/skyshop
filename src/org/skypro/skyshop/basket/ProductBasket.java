package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Добавлен: " + product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }

    public int getTotalPrice() {
        return products.stream().mapToInt(Product::getPrice).sum();
    }

    public int getSpecialProductsCount() {
        return (int) products.stream().filter(Product::isSpecial).count();
    }

    public void printContents() {
        System.out.println(getFormattedContents());
    }

    public boolean containsProduct(String name) {
        return products.stream().anyMatch(p -> p.getName().equalsIgnoreCase(name));
    }

    public void printProductPresence(String productName) {
        boolean exists = containsProduct(productName);
        System.out.println("\nЕсть ли " + productName + "? " + (exists ? "Да" : "Нет"));
    }

    public void clear() {
        products.clear();
        System.out.println("Корзина очищена");
    }

    public String getFormattedContents() {
        if (products.isEmpty()) {
            return "В корзине пусто";
        }

        StringBuilder sb = new StringBuilder();
        products.forEach(p -> sb.append(p).append("\n"));
        sb.append("Итого: ").append(getTotalPrice()).append(" руб.\n");
        sb.append("Специальных товаров: ").append(getSpecialProductsCount());
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("ProductBasket[товаров=%d]", products.size());
    }
}