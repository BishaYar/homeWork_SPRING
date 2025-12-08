package org.skypro.skyshop.basket;

import java.util.*;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    Map<String, List<Product>> mapProdBasket = new HashMap<>();
    public LinkedList<Product> listDelProduct = new LinkedList<>();

    public void addProductInBasket(String nameProd, Product product) {
        mapProdBasket.computeIfAbsent(nameProd, k->new ArrayList<>()).add(product);
    }

    public LinkedList<Product> deleteProductInBasket(String name) {
        for (Map.Entry<String, List<Product>> el : mapProdBasket.entrySet()) {

            for (Product el1 : el.getValue()) {
                if (el1.getText().equals(name)) {
                    listDelProduct.add(el1);
                }
            }

            el.getValue().removeIf(s->s.getText().equals(name));
        }
        for(Product el : listDelProduct){
            mapProdBasket.remove(el.getText());
        }

        return listDelProduct;
    }

    public int getCostBasket() {
        int cost = 0;

        for (Map.Entry<String, List<Product>> el : mapProdBasket.entrySet())
        {
            for(Product prod : el.getValue()) {
                if (prod != null) {
                    cost += prod.getPriceProduct();
                }
            }
        }

        return cost;
    }

    public void printBasket() {
        int i = 0;

        for (Map.Entry<String, List<Product>> el : mapProdBasket.entrySet())
        {
            if (el != null) {
                i++;
                System.out.println(el.getKey() + " " + el.getValue());
            }
        }

        if (i > 0) {
            System.out.println("Итого: " + this.getCostBasket());
        } else {
            System.out.println("В корзине пусто");
        }
    }
}