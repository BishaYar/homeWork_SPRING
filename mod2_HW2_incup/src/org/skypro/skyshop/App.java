package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.LinkedList;

public class App {
    public static void main(String[] args) {

        SearchEngine searchEngine = new SearchEngine();

        SimpleProduct prod1 = null;
        try {
            prod1 = new SimpleProduct("печенье", 70);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        SimpleProduct prod2 = null;
        try {
            prod2 = new SimpleProduct("молоко", 50);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        SimpleProduct prod3 = null;
        try {
            prod3 = new SimpleProduct("мед", 150);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        SimpleProduct prod6 = new SimpleProduct("кофе растворимый", 100);
        SimpleProduct prod7 = new SimpleProduct("кофе зерновой", 150);

        DiscountedProduct prod4 = null;
        try {
            prod4 = new DiscountedProduct("колбаса", 120, 10);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        DiscountedProduct prod5 = null;
        try {
            prod5 = new DiscountedProduct("кофе", 100, 20);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        ProductBasket basket1 = new ProductBasket();
        //1 Добавление продукта в корзину.
        basket1.addProductInBasket(prod1);
        basket1.addProductInBasket(prod2);
        basket1.addProductInBasket(prod3);
        basket1.addProductInBasket(prod4);
        basket1.addProductInBasket(prod5);
        basket1.addProductInBasket(prod6);
        basket1.addProductInBasket(prod7);

        System.out.println("=== Печать содержимого корзины с товарами ===");
        basket1.printBasket();

        System.out.println("=== Печать удаленных товаров, товар есть в корзине ===");
        printEmptyDelList(basket1.deleteProductInBasket("мед"));

        basket1.listDelProduct.clear();

        System.out.println("=== Печать удаленных товаров, товара нет в корзине ===");
        printEmptyDelList(basket1.deleteProductInBasket("бур"));

        System.out.println("=== Печать содержимого корзины ===");
        basket1.printBasket();

        Article article1 = new Article("кофе", "кофе темной обжарки, с кислинкой");
        Article article2 = new Article("кофе", "кофе растворимый. кофе ароматный.");
        Article article3 = new Article("кофе", "кофе в капсулах, ароматный, вкусный");
        Article article4 = new Article("кофе", "кофе растворимый, кофе гранулированный, 180гр");
        Article article5 = new Article("кофе", "крем-кофе, кофе 100гр");
        Article article6 = new Article("кофе", "кофе зерновой");
        Article article7 = new Article("чай", "чай черный");

        searchEngine.addSearchable(article1);
        searchEngine.addSearchable(article2);
        searchEngine.addSearchable(article3);
        searchEngine.addSearchable(article4);
        searchEngine.addSearchable(article5);
        searchEngine.addSearchable(article6);
        searchEngine.addSearchable(article7);

        //результат поиска
        System.out.println("==================== ПОЛОЖИТЕЛЬНЫЙ результат поиска =====================");
        String searchStr = "кофе";
        System.out.println(searchEngine.findSearchableObj(searchStr));

        System.out.println("==================== ОТРИЦАТЕЛЬНЫЙ результат поиска =====================");
        searchStr = "бур";
        System.out.println(searchEngine.findSearchableObj(searchStr));

    }

    public static void printEmptyDelList(LinkedList<Product> list){
        if (list.isEmpty()) {
            System.out.println("Список пуст");
        } else
            System.out.println(list);
    }
}

