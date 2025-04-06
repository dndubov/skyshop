package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.Arrays;

public class ProductBasket {
    private final Product[] products = new Product[3];
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

    // Новый метод для вывода информации о наличии товара
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

        StringBuilder sb = new StringBuilder("Содержимое корзины:\n");
        for (int i = 0; i < count; i++) {
            sb.append(i+1).append(". ").append(products[i]).append("\n");
        }
        sb.append("Общая сумма: ").append(getTotalPrice()).append(" руб.");
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("ProductBasket[товаров=%d/%d]", count, products.length);
    }
}