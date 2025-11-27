package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFoundException;
import org.skypro.skyshop.search.SearchEngine;

public class App {
    public static void main(String[] args) {

        SearchEngine searchEngine = new SearchEngine(10);

        System.err.println("==== Демонстрация проверки данных ПУСТОЙ СТРОКИ class SimpleProduct ====");
        try {
            SimpleProduct prod1 = new SimpleProduct("", 70);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        System.err.println("==== Демонстрация проверки данных NULL class SimpleProduct ====");
        try {
            SimpleProduct prod2 = new SimpleProduct(null, 1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        System.err.println("==== Демонстрация проверки цены class SimpleProduct ====");
        try {
            SimpleProduct prod2 = new SimpleProduct("молоко", 0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        System.err.println("==== Демонстрация проверки данных завешенного % скидки class DiscountedProduct ====");
        try {
            DiscountedProduct prod4 = new DiscountedProduct("печенье", 50,120);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        System.err.println("==== Демонстрация проверки цены class DiscountedProduct ====");
        try {
            DiscountedProduct prod5 = new DiscountedProduct("рыба", 0, 70);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        Article article1 = new Article("кофе", "кофе темной обжарки, с кислинкой");
        Article article2 = new Article("кофе", "кофе растворимый. кофе ароматный.");
        Article article3 = new Article("кофе", "кофе в капсулах, ароматный, вкусный");
        Article article4 = new Article("кофе", "кофе растворимый, кофе гранулированный, 180гр");

        searchEngine.addSearchable(article1);
        searchEngine.addSearchable(article2);
        searchEngine.addSearchable(article3);
        searchEngine.addSearchable(article4);

        //результат поиска
        System.out.println("==================== ПОЛОЖИТЕЛЬНЫЙ результат поиска =====================");
        String searchStr = "кофе";
        try {
            System.out.println(searchEngine.findSearchableObj(searchStr).getText());
        } catch (BestResultNotFoundException e) {
            e.printStackTrace();
        }

        System.err.println("==================== ОТРИЦАТЕЛЬНЫЙ результат поиска =====================");
        searchStr = "бур";
        try {
            searchEngine.findSearchableObj(searchStr);
        } catch (BestResultNotFoundException e) {
            e.printStackTrace();
        }
    }
}

