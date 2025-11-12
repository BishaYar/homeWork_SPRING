package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int priceProduct;

    public SimpleProduct(String name, int price) {
        super(name);
        this.priceProduct = price;
    }

    @Override
    public String getNameProduct() {
        return nameProduct;
    }

    @Override
    public int getPriceProduct() {
        return priceProduct;
    }

    @Override
    public String toString(){
        return "<" + nameProduct + ">: <" + priceProduct + ">";
    }

    @Override
    public boolean isSpecial(){
        return false;
    }
}