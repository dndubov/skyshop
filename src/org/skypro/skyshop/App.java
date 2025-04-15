package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.product.Article;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Создаем поисковый движок
        SearchEngine searchEngine = new SearchEngine(10);

        // Создаем товары
        SimpleProduct milk = new SimpleProduct("Молоко", 80);
        DiscountedProduct eggs = new DiscountedProduct("Яйца", 120, 10);
        FixPriceProduct cheese = new FixPriceProduct("Сыр");

        // Добавляем товары в движок
        searchEngine.add(milk);
        searchEngine.add(eggs);
        searchEngine.add(cheese);

        // Создаем статьи
        Article milkArticle = new Article("Скидки на молоко", "Как купить молоко по акции.");
        Article cheeseArticle = new Article("Сыр и его виды", "Все, что нужно знать о сыре.");

        // Добавляем статьи в движок
        searchEngine.add(milkArticle);
        searchEngine.add(cheeseArticle);

        // Пример поиска
        System.out.println("Результаты поиска по запросу 'молоко':");
        System.out.println(Arrays.toString(searchEngine.search("молоко")));

        System.out.println("Результаты поиска по запросу 'сыр':");
        System.out.println(Arrays.toString(searchEngine.search("сыр")));
    }
}
