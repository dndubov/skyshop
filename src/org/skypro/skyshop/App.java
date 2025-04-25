package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.BestResultNotFound;

public class App {
    public static void main(String[] args) {
        // Создаем поисковый движок
        SearchEngine searchEngine = new SearchEngine(10);

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
            Searchable bestMatch = searchEngine.findBestMatch("молоко");
            System.out.println("Лучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}
