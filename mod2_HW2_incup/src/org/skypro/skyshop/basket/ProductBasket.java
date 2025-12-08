package org.skypro.skyshop.basket;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    LinkedList<Product> listProduct = new LinkedList<>();
    public LinkedList<Product> listDelProduct = new LinkedList<>();

    public void addProductInBasket(Product product) {
        listProduct.add(product);
    }

    public LinkedList<Product> deleteProductInBasket(String name) {
        Iterator<Product> iterator = listProduct.iterator();

        while (iterator.hasNext()){
            Product el = iterator.next();
            if (el.getText().equals(name)){
                iterator.remove();
                listDelProduct.add(el);
            }
        }
        return listDelProduct;
    }

    public int getCostBasket() {
        int cost = 0;

        for(Product prod : listProduct) {
            if (prod != null) {
                cost += prod.getPriceProduct();
            }
        }

        return cost;
    }

    public void printBasket() {
        int i = 0;

        for(Product prod : listProduct) {
            if (prod != null) {
                ++i;
                PrintStream var10000 = System.out;
                String var10001 = prod.getText();
                var10000.println("<" + var10001 + ">: <" + prod.getPriceProduct() + ">");
            }
        }

        if (i > 0) {
            System.out.println("Итого: " + this.getCostBasket());
        } else {
            System.out.println("В корзине пусто");
        }
    }
}