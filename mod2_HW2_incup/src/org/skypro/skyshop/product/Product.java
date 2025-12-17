package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product prod = (Product) obj;
        return Objects.equals(nameProduct, prod.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct);
    }
}

