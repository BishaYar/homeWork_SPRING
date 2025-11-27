package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int priceProduct;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price < 1) {
            throw new IllegalArgumentException("Цена должна быть не меньше 1");
        }
        this.priceProduct = price;
    }

    @Override
    public int getPriceProduct() {
        return priceProduct;
    }

    @Override
    public String toString(){
        return "<" + nameProduct + ">: <" + priceProduct + ">";
    }
}