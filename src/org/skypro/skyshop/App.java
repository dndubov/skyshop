package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

public class App {
    public static void main(String[] args) {
        // 1. Создаем корзину
        ProductBasket basket = new ProductBasket();

        // 2. Создаем тестовые продукты разных типов
        SimpleProduct milk = new SimpleProduct("Молоко", 80);
        SimpleProduct bread = new SimpleProduct("Хлеб", 50);
        DiscountedProduct eggs = new DiscountedProduct("Яйца", 120, 10);
        FixPriceProduct cheese = new FixPriceProduct("Сыр");

        // 3. Добавляем продукты в корзину
        System.out.println("=== Добавление продуктов ===");
        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(eggs);
        basket.addProduct(cheese);

        // 4. Выводим содержимое корзины
        System.out.println("\n=== Содержимое корзины ===");
        basket.printContents();

        // 5. Проверяем наличие конкретных продуктов
        System.out.println("\n=== Проверка наличия ===");
        basket.printProductPresence("Хлеб");
        basket.printProductPresence("Колбаса");

        // 6. Очищаем корзину
        System.out.println("\n=== Очистка корзины ===");
        basket.clear();
        basket.printContents();
    }
}