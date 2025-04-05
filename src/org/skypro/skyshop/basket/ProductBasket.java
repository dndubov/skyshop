package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int count = 0;

    // Добавление продукта
    public void addProduct(Product product) {
        if (count < products.length) {
            products[count++] = product;
            System.out.println("Добавлен: " + product);
        } else {
            System.out.println("Невозможно добавить продукт (" + product + ")");
        }
    }

    // Получение общей стоимости
    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    // Печать содержимого
    public void printContents() {
        System.out.println(this);
    }

    // Проверка наличия продукта
    public boolean containsProduct(String name) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    // Очистка корзины
    public void clear() {
        Arrays.fill(products, null);
        count = 0;
        System.out.println("Корзина очищена");
    }

    // Форматированное строковое представление
    @Override
    public String toString() {
        if (count == 0) {
            return "В корзине пусто";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(products[i]).append("\n");
        }
        sb.append("Итого: ").append(getTotalPrice()).append(" руб.");
        return sb.toString();
    }
}