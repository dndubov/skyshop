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

    // Метод для поиска самого подходящего элемента
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            if (item != null) {
                int count = countOccurrences(item.getSearchTerm(), search);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящих результатов для запроса: " + search);
        }
        return bestMatch;
    }

    // Вспомогательный метод для подсчета вхождений подстроки в строку
    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
}
