package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.*;

public class App {
    public static void main(String[] args) {

        ProductBasket basket1 = new ProductBasket();
        //1 Добавление продукта в корзину
        basket1.addProductInBasket("печенье", new SimpleProduct("печенье", 70));
        basket1.addProductInBasket("молоко", new SimpleProduct("молоко", 50));
        basket1.addProductInBasket("мед", new SimpleProduct("мед", 150));
        basket1.addProductInBasket("колбаса", new DiscountedProduct("колбаса", 120, 10));
        basket1.addProductInBasket("кофе", new DiscountedProduct("кофе", 100, 20));
        basket1.addProductInBasket("кофе", new DiscountedProduct("кофе растворим", 80, 10));

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
        Article article5 = new Article("чай", "чай в пакетиках");
        Article article6 = new Article("чай", "чай зеленый");
        Article article7 = new Article("чай", "чай черный");

        SearchEngine searchEngine = new SearchEngine();
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
        printSearchList((TreeMap<String, Searchable>) searchEngine.findSearchableObj(searchStr));

        System.out.println("==================== ОТРИЦАТЕЛЬНЫЙ результат поиска =====================");
        searchStr = "бур";
        printSearchList((TreeMap<String, Searchable>) searchEngine.findSearchableObj(searchStr));

    }

    public static void printEmptyDelList(LinkedList<Product> list){
        if (list.isEmpty()) {
            System.out.println("Список пуст");
        } else
            System.out.println(list);
    }

    public static void printSearchList(TreeMap<String, Searchable> map){
        for(Map.Entry<String, Searchable> el : map.entrySet()){
            System.out.println(el);
        }
    }
}

