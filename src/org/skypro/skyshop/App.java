package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product milk = new Product("Молоко", 80);
        Product bread = new Product("Хлеб", 50);
        Product eggs = new Product("Яйца", 120);

        ProductBasket basket = new ProductBasket();

        // Добавляем продукты
        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(eggs);

        // Пытаемся добавить ещё (демонстрация переполнения)
        basket.addProduct(new Product("Сок", 90));
        basket.addProduct(new Product("Печенье", 60));
        basket.addProduct(new Product("Шоколад", 70)); // Не добавится

        // Выводим содержимое
        System.out.println("\nТекущее состояние корзины:");
        basket.printContents();

        // Проверяем наличие
        System.out.println("\nЕсть ли хлеб? " +
                (basket.containsProduct("хлеб") ? "Да" : "Нет"));

        // Очищаем корзину
        basket.clear();
        System.out.println("\nПосле очистки:");
        basket.printContents();
    }
}