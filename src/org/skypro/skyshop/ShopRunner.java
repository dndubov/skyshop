package org.skypro.skyshop;
import java.util.Set;
import org.skypro.skyshop.product.Searchable;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.BestResultNotFound;

public class ShopRunner {
    private SearchEngine searchEngine;

    public ShopRunner(SearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }

    public void run() {
        runSearch("сок");
        runBestMatch("молоко");
    }

    public void runSearch(String searchTerm) {
        Set<Searchable> results = searchEngine.search(searchTerm);
        if (results.isEmpty()) {
            System.out.println("Не найдено подходящих результатов для запроса: " + searchTerm);
        } else {
            results.forEach(result -> System.out.println(result.getStringRepresentation()));
        }
    }

    public void runBestMatch(String searchTerm) {
        try {
            Searchable bestMatch = searchEngine.findBestMatch(searchTerm);
            System.out.println("\nЛучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}
