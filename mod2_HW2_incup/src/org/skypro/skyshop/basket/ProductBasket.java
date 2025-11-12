package org.skypro.skyshop.basket;

import java.io.PrintStream;
import java.util.Arrays;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class ProductBasket {
    private final Product[] product = new Product[5];

    public void addProductInBasket(Product addProduct) {
        for(int i = 0; i < product.length; ++i) {
            if (product[i] == null) {
                product[i] = addProduct;
                break;
            }
        }
    }

    public int getCostBasket() {
        int cost = 0;

        for(Product prod : this.product) {
            if (prod != null) {
                cost += prod.getPriceProduct();
            }
        }

        return cost;
    }

    public void printBasket() {
        int i = 0;
        int countSpecProd = 0;

        for(Product prod : product) {
            if (prod != null) {
                System.out.println(prod.toString());
                i++;
                if (prod.isSpecial()) {
                    countSpecProd++;
                }
            }
        }

        if (i > 0) {
            System.out.println("Итого: " + this.getCostBasket());
            System.out.println("Специальных товаров: <" + countSpecProd + ">");
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean findProduct(String nameProd) {
        for(Product prod : this.product) {
            if (prod != null && prod.getNameProduct().equals(nameProd)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(product, null);
    }
}

