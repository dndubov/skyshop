package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.basket.ProductBasket;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        // Создаем поисковый движок
        SearchEngine searchEngine = new SearchEngine();

        // Продукты
        Product milk = new SimpleProduct("Молоко", 80);
        Product eggs = new DiscountedProduct("Яйца", 120, 10);
        Product cheese = new FixPriceProduct("Сыр");

        Product bread = new SimpleProduct("Хлеб", 50);
        Product juice = new DiscountedProduct("Сок", 200, 15);
        Product sausage = new FixPriceProduct("Колбаса");

        Product yogurt = new SimpleProduct("Йогурт", 60);
        Product butter = new DiscountedProduct("Масло", 180, 20);
        Product chocolate = new FixPriceProduct("Шоколад");

        // Добавляем продукты в поисковый движок
        searchEngine.add(milk);
        searchEngine.add(eggs);
        searchEngine.add(cheese);
        searchEngine.add(bread);
        searchEngine.add(juice);
        searchEngine.add(sausage);
        searchEngine.add(yogurt);
        searchEngine.add(butter);
        searchEngine.add(chocolate);

        // Статьи
        searchEngine.add(new Article("Скидки на молоко", "Как купить молоко по акции."));
        searchEngine.add(new Article("Сыр и его виды", "Все, что нужно знать о сыре."));
        searchEngine.add(new Article("Лучшие молочные продукты", "Обзор популярных молочных товаров."));
        searchEngine.add(new Article("Как выбрать сок", "На что обратить внимание при покупке сока."));

        // Поиск
        try {
            Map<String, Searchable> results = searchEngine.search("сок");
            System.out.println("\nРезультаты поиска по 'сок':");
            results.forEach((name, item) -> System.out.println(item.getStringRepresentation()));

            Searchable bestMatch = searchEngine.findBestMatch("молоко");
            System.out.println("\nЛучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        // Работа с корзиной
        ProductBasket basket = new ProductBasket();
        basket.addProduct(milk);
        basket.addProduct(milk);
        basket.addProduct(eggs);
        basket.addProduct(bread);
        basket.addProduct(juice);
        basket.addProduct(sausage);
        basket.addProduct(butter);

        System.out.println("\nСодержимое корзины:");
        basket.printContents();

        // Удаление продуктов
        System.out.println("\nУдаляем молоко из корзины:");
        List<Product> removed = basket.removeProductsByName("Молоко");
        System.out.println("Удаленные продукты:");
        removed.forEach(System.out::println);

        System.out.println("\nСодержимое корзины после удаления:");
        basket.printContents();

        System.out.println("\nПопытка удалить несуществующий продукт:");
        removed = basket.removeProductsByName("Огурец");
        if (removed.isEmpty()) {
            System.out.println("Список пуст - продукт не найден");
        }

        System.out.println("\nСодержимое корзины:");
        basket.printContents();
    }
}
