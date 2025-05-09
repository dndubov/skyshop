package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.basket.ProductBasket;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Создаем поисковый движок
        SearchEngine searchEngine = new SearchEngine();

        // Пример создания продуктов
        try {
            SimpleProduct milk = new SimpleProduct("Молоко", 80);
            DiscountedProduct eggs = new DiscountedProduct("Яйца", 120, 10);
            FixPriceProduct cheese = new FixPriceProduct("Сыр");

            searchEngine.add(milk);
            searchEngine.add(eggs);
            searchEngine.add(cheese);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }

        // Создаем статьи
        Article milkArticle = new Article("Скидки на молоко", "Как купить молоко по акции.");
        Article cheeseArticle = new Article("Сыр и его виды", "Все, что нужно знать о сыре.");

        searchEngine.add(milkArticle);
        searchEngine.add(cheeseArticle);

        // Пример поиска
        try {
            List<Searchable> results = searchEngine.search("молоко");
            System.out.println("\nРезультаты поиска по 'молоко':");
            results.forEach(r -> System.out.println(r.getStringRepresentation()));

            Searchable bestMatch = searchEngine.findBestMatch("молоко");
            System.out.println("\nЛучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        // Работа с корзиной
        ProductBasket basket = new ProductBasket();
        SimpleProduct milk1 = new SimpleProduct("Молоко", 80);
        SimpleProduct milk2 = new SimpleProduct("Молоко", 80);
        DiscountedProduct eggs = new DiscountedProduct("Яйца", 120, 10);

        basket.addProduct(milk1);
        basket.addProduct(milk2);
        basket.addProduct(eggs);

        System.out.println("\nСодержимое корзины:");
        basket.printContents();

        // Демонстрация удаления продуктов
        System.out.println("\nУдаляем молоко из корзины:");
        List<Product> removed = basket.removeProductsByName("Молоко");
        System.out.println("Удаленные продукты:");
        removed.forEach(System.out::println);

        System.out.println("\nСодержимое корзины после удаления:");
        basket.printContents();

        System.out.println("\nПопытка удалить несуществующий продукт:");
        removed = basket.removeProductsByName("Хлеб");
        if (removed.isEmpty()) {
            System.out.println("Список пуст - продукт не найден");
        }

        System.out.println("\nСодержимое корзины:");
        basket.printContents();
    }
}