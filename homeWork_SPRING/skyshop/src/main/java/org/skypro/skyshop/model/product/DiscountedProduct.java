package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private final int basePriceProduct;
    private final int discount;

    public DiscountedProduct(UUID id, String name, int basePriceProd, int disc) {
        super(id, name);
        if (basePriceProd <= 1) {
            throw new IllegalArgumentException("Цена должна быть не меньше 1");
        }
        if (disc < 0 || disc > 100) {
            throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100 процентов включительно");
        }

        basePriceProduct = basePriceProd;
        discount = disc;
    }

    @Override
    public int getPriceProduct() {
        return basePriceProduct - (basePriceProduct / 100 * discount);
    }

    @Override
    public String toString() {
        return "<" + nameProduct + ">: <" + getPriceProduct() + "> (<" + discount + "%>)";
    }
}
