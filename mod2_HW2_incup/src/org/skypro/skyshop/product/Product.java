package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    protected String nameProduct;

    protected Product(String nameProduct) {
        try {
            isEmpty(nameProduct);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        this.nameProduct = nameProduct;
    }

    public static void isEmpty(String name) throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("Строка наименования не заполнена, такой товар добавить нельзя");
        } else if (name.isBlank()){
            throw new IllegalArgumentException("Строка наименования пустая, такой товар добавить нельзя");
        }
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

