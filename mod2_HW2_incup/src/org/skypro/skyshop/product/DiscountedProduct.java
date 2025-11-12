package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePriceProduct;
    private final int discount;

    public DiscountedProduct(String name, int basePriceProd, int price) {
        super(name);
        basePriceProduct = basePriceProd;
        discount = price;
    }

    @Override
    public String getNameProduct() {
        return nameProduct;
    }

    @Override
    public int getPriceProduct() {
        return basePriceProduct - (basePriceProduct / 100 * discount);
    }

    @Override
    public String toString(){
        return "<" + nameProduct + ">: <" + getPriceProduct() + "> (<" + discount + "%>)";
    }

    @Override
    public boolean isSpecial(){
        return true;
    }
}
