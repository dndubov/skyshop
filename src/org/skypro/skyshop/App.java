package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        // 1. Создаем корзину
        ProductBasket basket = new ProductBasket();

        // 2. Создаем тестовые продукты
        Product milk = new Product("Молоко", 80);
        Product bread = new Product("Хлеб", 50);
        Product eggs = new Product("Яйца", 120);

        // 3. Добавляем продукты в корзину
        System.out.println("=== Добавление продуктов ===");
        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(eggs);

        // 4. Выводим содержимое корзины
        System.out.println("\n=== Содержимое корзины ===");
        basket.printContents();

        // 5. Проверяем наличие конкретных продуктов
        System.out.println("\n=== Проверка наличия ===");
        basket.printProductPresence("Хлеб");
        basket.printProductPresence("Колбаса");

        // 6. Пытаемся добавить в заполненную корзину
        System.out.println("\n=== Попытка переполнения ===");
        basket.addProduct(new Product("Сыр", 200));
        basket.addProduct(new Product("Йогурт", 60));

        // 7. Очищаем корзину
        System.out.println("\n=== Очистка корзины ===");
        basket.clear();
        basket.printContents();
    }
}