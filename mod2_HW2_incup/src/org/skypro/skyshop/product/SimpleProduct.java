package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int priceProduct;

    public SimpleProduct(String name, int price) {
        super(name);
        try {
            this.priceProduct = price;
            checkPriceProduct(price);
        }
        catch (IllegalArgumentException exception){
            exception.printStackTrace();
        }
    }

    public static void checkPriceProduct(int price) throws IllegalArgumentException {
        if (price < 1) {
            throw new IllegalArgumentException("Цена должна быть не меньше 1");
        }
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