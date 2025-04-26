package org.skypro.skyshop.product;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или содержать только пробелы.");
        }
        this.name = name;
    }

    @Override
    public String getSearchTerm() {
        return name; // Возвращаем название товара как термин для поиска
    }

    @Override
    public String getContentType() {
        return "PRODUCT"; // Тип контента — товар
    }

    @Override
    public String getStringRepresentation() {
        return getName() + " — тип " + getContentType(); // Представление объекта в виде строки
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();
    public abstract boolean isSpecial();
    public abstract String toString();
}
