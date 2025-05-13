package org.skypro.skyshop.search;

import org.skypro.skyshop.product.*;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class SearchEngine {
    private Set<Searchable> searchableItems = new HashSet<>();

    public SearchEngine() {
        // Добавляем конкретные реализации Product
        searchableItems.add(new SimpleProduct("Сок", 100));
        searchableItems.add(new Article("Статья о соках", "Все о натуральных соках"));
        searchableItems.add(new DiscountedProduct("Молоко", 80, 10));
        searchableItems.add(new Article("Статья о молоке", "Все о молоке и его пользе"));
    }

    public Set<Searchable> search(String searchTerm) {
        Set<Searchable> results = new TreeSet<>(new SearchableComparator());
        for (Searchable item : searchableItems) {
            if (item.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    public Searchable findBestMatch(String searchTerm) throws BestResultNotFound {
        Set<Searchable> results = search(searchTerm);
        if (results.isEmpty()) {
            throw new BestResultNotFound("Не найдено подходящих результатов для запроса: " + searchTerm);
        }
        return results.iterator().next();
    }
}
