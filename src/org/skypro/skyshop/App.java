package org.skypro.skyshop;

import org.skypro.skyshop.search.SearchEngine;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();
        ShopRunner runner = new ShopRunner(searchEngine);
        runner.run();
    }
}
