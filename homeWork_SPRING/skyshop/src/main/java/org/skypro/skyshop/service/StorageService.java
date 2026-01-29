package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> mapProduct = new HashMap<>();
    private final Map<UUID, Article> mapArticle = new HashMap<>();

    public StorageService() {
        setMapProduct(new SimpleProduct(UUID.randomUUID(), "печенье", 70));
        setMapProduct(new SimpleProduct(UUID.randomUUID(), "молоко", 50));
        setMapProduct(new SimpleProduct(UUID.randomUUID(), "мед", 150));
        setMapProduct(new DiscountedProduct(UUID.randomUUID(), "колбаса", 120, 10));
        setMapProduct(new DiscountedProduct(UUID.randomUUID(), "кофе", 100, 20));
        setMapProduct(new DiscountedProduct(UUID.randomUUID(), "кофе растворим", 80, 10));

        setMapArticle(new Article(UUID.randomUUID(), "кофе темной обжарки, с кислинкой", "кофе"));
        setMapArticle(new Article(UUID.randomUUID(), "кофе автрастворимый. кофе ароматный.", "кофе"));
        setMapArticle(new Article(UUID.randomUUID(), "кофе авкаапсулах, ароматный, вкусный", "кофе"));
        setMapArticle(new Article(UUID.randomUUID(), "кофе растворимый, кофе гранулированный, 180гр", "кофе"));
        setMapArticle(new Article(UUID.randomUUID(), "чай в пакетиках", "чай"));
        setMapArticle(new Article(UUID.randomUUID(), "чай зеленый", "чай"));
        setMapArticle(new Article(UUID.randomUUID(), "чай черный", "чай"));
    }

    private void setMapProduct(Product product){
        mapProduct.put(UUID.randomUUID(), product);
    }

    private void setMapArticle(Article article){
        mapArticle.put(UUID.randomUUID(), article);
    }

    public Collection<Product> getMapProduct(){
        return mapProduct.values();
    }

    public Collection<Article> getMapArticle(){
        return mapArticle.values();
    }

    public Collection<Searchable> getAllSearcheble(){
        List<Searchable> allList = new ArrayList<>();
        allList.addAll(getMapProduct());
        allList.addAll(getMapArticle());
        return allList;
    }
}
