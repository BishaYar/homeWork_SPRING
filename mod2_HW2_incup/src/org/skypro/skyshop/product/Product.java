package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    protected final String nameProduct;

    protected Product(String nameProduct) {
        if (nameProduct == null) {
            throw new IllegalArgumentException("Строка наименования не заполнена, такой товар добавить нельзя");
        } else if (nameProduct.isBlank()){
            throw new IllegalArgumentException("Строка наименования пустая, такой товар добавить нельзя");
        }
         this.nameProduct = nameProduct;
    }

    public abstract int getPriceProduct();

    public abstract String toString();

    @Override
    public String getText() {
        return nameProduct;
    }
}

