package org.skypro.skyshop.search;

import org.skypro.skyshop.product.*;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchableItems = new HashSet<>();

    public SearchEngine() {
        // Добавляем конкретные реализации Product и Article
        searchableItems.add(new SimpleProduct("Сок", 100));
        searchableItems.add(new Article("Статья о соках", "Все о натуральных соках"));
        searchableItems.add(new DiscountedProduct("Молоко", 80, 10));
        searchableItems.add(new Article("Статья о молоке", "Все о молоке и его пользе"));
    }

    public Set<Searchable> search(String searchTerm) {
        return searchableItems.stream()
                .filter(item -> item.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }

    public Searchable findBestMatch(String searchTerm) throws BestResultNotFound {
        Set<Searchable> results = search(searchTerm);
        if (results.isEmpty()) {
            throw new BestResultNotFound("Не найдено подходящих результатов для запроса: " + searchTerm);
        }
        return results.iterator().next();
    }

    public void run() {
        runSearch("сок");
        runBestMatch("молоко");
    }

    public void runSearch(String searchTerm) {
        Set<Searchable> results = search(searchTerm);
        if (results.isEmpty()) {
            System.out.println("Не найдено подходящих результатов для запроса: " + searchTerm);
        } else {
            results.forEach(result -> System.out.println(result.getStringRepresentation()));
        }
    }

    public void runBestMatch(String searchTerm) {
        try {
            Searchable bestMatch = findBestMatch(searchTerm);
            System.out.println("\nЛучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}
