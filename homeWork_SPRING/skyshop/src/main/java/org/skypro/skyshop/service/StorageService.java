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
        UUID id = UUID.randomUUID();
        setMapProduct(id, new SimpleProduct(id, "печенье", 70));
        id = UUID.randomUUID();
        setMapProduct(id, new SimpleProduct(id, "молоко", 50));
        id = UUID.randomUUID();
        setMapProduct(id, new SimpleProduct(id, "мед", 150));
        id = UUID.randomUUID();
        setMapProduct(id,new DiscountedProduct(id, "колбаса", 120, 10));
        id = UUID.randomUUID();
        setMapProduct(id, new DiscountedProduct(id, "кофе", 100, 20));
        id = UUID.randomUUID();
        setMapProduct(id, new DiscountedProduct(id, "кофе растворим", 80, 10));

        id = UUID.randomUUID();
        setMapArticle(id, new Article(id, "кофе темной обжарки, с кислинкой", "кофе"));
        id = UUID.randomUUID();
        setMapArticle(id, new Article(id, "кофе автрастворимый. кофе ароматный.", "кофе"));
        id = UUID.randomUUID();
        setMapArticle(id, new Article(id, "кофе авкаапсулах, ароматный, вкусный", "кофе"));
        id = UUID.randomUUID();
        setMapArticle(id, new Article(id, "кофе растворимый, кофе гранулированный, 180гр", "кофе"));
        id = UUID.randomUUID();
        setMapArticle(id, new Article(id, "чай в пакетиках", "чай"));
        id = UUID.randomUUID();
        setMapArticle(id, new Article(id, "чай зеленый", "чай"));
        id = UUID.randomUUID();
        setMapArticle(id, new Article(id, "чай черный", "чай"));
    }

    private void setMapProduct(UUID id, Product product) {
        mapProduct.put(id, product);
    }

    private void setMapArticle(UUID id, Article article) {
        mapArticle.put(id, article);
    }

    public Collection<Product> getMapProduct() {
        return mapProduct.values();
    }

    public Collection<Article> getMapArticle() {
        return mapArticle.values();
    }

    public Collection<Searchable> getAllSearcheble() {
        List<Searchable> allList = new ArrayList<>();
        allList.addAll(getMapProduct());
        allList.addAll(getMapArticle());
        return allList;
    }
    
    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(mapProduct.get(id));
    }
}
