package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePriceProduct;
    private final int discount;

    public DiscountedProduct(String name, int basePriceProd, int disc) {
        super(name);
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
