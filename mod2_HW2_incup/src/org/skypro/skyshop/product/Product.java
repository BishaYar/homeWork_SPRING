package org.skypro.skyshop.product;

public abstract class Product {
    protected final String nameProduct;

    protected Product(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public abstract String getNameProduct();

    public abstract int getPriceProduct();

    public abstract String toString();

    public abstract boolean isSpecial();
}
