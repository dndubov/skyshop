package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercent;

    public DiscountedProduct(String name, int basePrice, int discountPercent) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена продукта должна быть больше 0.");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть от 0 до 100.");
        }
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        return basePrice * (100 - discountPercent) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s: %d руб. (скидка %d%%)", getName(), getPrice(), discountPercent);
    }

    @Override
    public String getStringRepresentation() {
        return String.format("%s — тип %s, цена со скидкой %d руб. (скидка %d%%, была %d руб.)",
                getName(), getContentType(), getPrice(), discountPercent, basePrice);
    }
}
