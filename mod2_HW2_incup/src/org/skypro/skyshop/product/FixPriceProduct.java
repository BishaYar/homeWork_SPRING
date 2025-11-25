package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    private static final int FIX_PRICE = 335;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPriceProduct() {
        return FIX_PRICE;
    }

    @Override
    public String toString(){
        return "<" + nameProduct + ">: Фиксированная цена <" + getPriceProduct() + ">";
    }

}
