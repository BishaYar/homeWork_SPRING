package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private final int priceProduct;

    public SimpleProduct(UUID id, String name, int price) {
        super(id, name);
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