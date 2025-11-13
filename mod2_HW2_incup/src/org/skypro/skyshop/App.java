package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        SearchEngine searchEngine = new SearchEngine(10);

        SimpleProduct prod1 = new SimpleProduct("кофе", 500);
        SimpleProduct prod2 = new SimpleProduct("молоко", 100);
        DiscountedProduct prod3 = new DiscountedProduct("печенье", 200,10);
        DiscountedProduct prod4 = new DiscountedProduct("рыба", 300, 15);
        FixPriceProduct prod5 = new FixPriceProduct("колбаса");

        Article article1 = new Article("кофе", "кофе темной обжарки");
        Article article2 = new Article("кофе", "кофе растворимый");
        Article article3 = new Article("колбаса", "колбаса вареная");
        Article article4 = new Article("колбаса", "колбаса сырокопченая");

        searchEngine.addSearchable(prod1);
        searchEngine.addSearchable(prod2);
        searchEngine.addSearchable(prod3);
        searchEngine.addSearchable(prod4);
        searchEngine.addSearchable(prod5);

        searchEngine.addSearchable(article1);
        searchEngine.addSearchable(article2);
        searchEngine.addSearchable(article3);
        searchEngine.addSearchable(article4);
        searchEngine.addSearchable(prod1);

        //массив данных
        System.out.println(Arrays.toString(searchEngine.searchables));

        //результат поиска
        System.out.println("=== Результат поиска продукта: кофе ===");
        printSearch(searchEngine, "кофе");

        System.out.println("=== Результат поиска продукта: печенье ===");
        printSearch(searchEngine, "печенье");

        System.out.println("=== Результат поиска продукта: вода ===");
        printSearch(searchEngine, "вода");

    }
    public static void printSearch(SearchEngine searchEngine, String name){
        for (Searchable search : searchEngine.search(name)){
            if (search != null) {
                search.getStringRepresentation();
            }
        }
    }
}

