package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.Arrays;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int count = 0;

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count++] = product;
            System.out.println("Добавлен: " + product);
        } else {
            System.out.println("Невозможно добавить продукт (" + product + ")");
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public int getSpecialProductsCount() {
        int specialCount = 0;
        for (int i = 0; i < count; i++) {
            if (products[i].isSpecial()) {
                specialCount++;
            }
        }
        return specialCount;
    }

    public void printContents() {
        System.out.println(getFormattedContents());
    }

    public boolean containsProduct(String name) {
        for (int i = 0; i < count; i++) {
            if (products[i] != null && products[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void printProductPresence(String productName) {
        boolean exists = containsProduct(productName);
        System.out.println("\nЕсть ли " + productName + "? " + (exists ? "Да" : "Нет"));
    }

    public void clear() {
        Arrays.fill(products, null);
        count = 0;
        System.out.println("Корзина очищена");
    }

    public String getFormattedContents() {
        if (count == 0) {
            return "В корзине пусто";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(products[i]).append("\n");
        }
        sb.append("Итого: ").append(getTotalPrice()).append(" руб.\n");
        sb.append("Специальных товаров: ").append(getSpecialProductsCount());
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("ProductBasket[товаров=%d/%d]", count, products.length);
    }
}