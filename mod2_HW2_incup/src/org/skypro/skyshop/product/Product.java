package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    protected final String nameProduct;

    protected Product(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public abstract int getPriceProduct();

    public abstract String toString();

    @Override
    public String getText() {
        return nameProduct;
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }
}

