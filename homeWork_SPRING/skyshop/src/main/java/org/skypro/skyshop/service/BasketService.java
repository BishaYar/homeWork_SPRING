package org.skypro.skyshop.service;

import org.skypro.skyshop.controller.NoSuchProductException;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final StorageService storageService;
    private final ProductBasket productBasket;

    @Autowired
    public BasketService(StorageService storageService, ProductBasket productBasket) {
        this.storageService = storageService;
        this.productBasket = productBasket;
    }

    public void addProductInBasket(UUID id) {
        Optional<Product> productOptional = storageService.getProductById(id);
        if (productOptional.isPresent()) {
            productBasket.addProductInBasket(id);
        } else
            throw new NoSuchProductException("Товар " + id + " не найден.");
    }

    public UserBasket getUserBasket() {
        Map<UUID, Integer> basketMap = productBasket.getBasket();
        var items = basketMap
                .entrySet().stream()
                .map( entry-> {
                    UUID idProd = entry.getKey();
                    int total = entry.getValue();
                    Product product = storageService.getProductById(idProd).orElseThrow(() -> new NoSuchProductException(
                            "Inconsistent state: product " + idProd + " exists in basket but missing in storage"));
                    return new BasketItem(product, total);
                })
                .collect(Collectors.toList());

        return new UserBasket(items);
    }
}
