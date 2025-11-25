package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePriceProduct;
    private int discount;

    public DiscountedProduct(String name, int basePriceProd, int disc) {
        super(name);

        try {
            checkPriceProduct(basePriceProd, disc);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
        basePriceProduct = basePriceProd;
        discount = disc;
    }

    public static void checkPriceProduct(int basePrice, int disc) throws IllegalArgumentException{
        if (basePrice <= 1) {
            throw new IllegalArgumentException("Цена должна быть не меньше 1");
        }
        if (disc < 0 || disc > 100) {
            throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100 процентов включительно");
        }
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
