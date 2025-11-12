package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;


public class App {
    public static void main(String[] args) {
        SimpleProduct prod1 = new SimpleProduct("кофе", 500);
        SimpleProduct prod2 = new SimpleProduct("молоко", 100);
        DiscountedProduct prod3 = new DiscountedProduct("печенье", 200,10);
        DiscountedProduct prod4 = new DiscountedProduct("рыба", 300, 15);
        FixPriceProduct prod5 = new FixPriceProduct("колбаса");

        ProductBasket basket1 = new ProductBasket();
        //Добавление продукта в корзину.
        basket1.addProductInBasket(prod1);
        basket1.addProductInBasket(prod5);
        basket1.addProductInBasket(prod3);
        basket1.addProductInBasket(prod4);
        basket1.addProductInBasket(prod2);

        System.out.println("=== Печать содержимого корзины с несколькими товарами ===");
        basket1.printBasket();
    }
}

