package org.skypro.skyshop.product;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + text; // Комбинированный термин поиска: название и текст статьи
    }

    @Override
    public String getContentType() {
        return "ARTICLE"; // Тип контента — статья
    }

    @Override
    public String getStringRepresentation() {
        return title + " — тип " + getContentType(); // Представление объекта в виде строки
    }

    @Override
    public String getName() {
        return title; // Для поиска используем название статьи
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }
}
