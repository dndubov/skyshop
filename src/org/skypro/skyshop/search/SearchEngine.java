package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Searchable;


import java.util.Arrays;

public class SearchEngine {
    private Searchable[] items;
    private int size;

    public SearchEngine(int capacity) {
        items = new Searchable[capacity];
        size = 0;
    }

    public void add(Searchable item) {
        if (size < items.length) {
            items[size++] = item;
        }
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] results = new Searchable[5]; // Массив для 5 результатов поиска
        int resultCount = 0;

        // Перебираем все элементы в поисковом движке
        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().contains(searchTerm)) {
                // Добавляем результат, если он соответствует поисковому запросу
                results[resultCount++] = item;

                // Если нашли 5 результатов, прерываем поиск
                if (resultCount == 5) {
                    break;
                }
            }
        }

        // Обрезаем массив до найденных результатов
        return Arrays.copyOf(results, resultCount);
    }
}
