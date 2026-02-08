package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@SessionScope
@Component
public class ProductBasket {
    private final Map<UUID, Integer> basketMap = new HashMap<>();

    public void addProductInBasket(UUID id) {
        basketMap.computeIfAbsent(id, k -> 0);
        basketMap.put(id, basketMap.get(id) + 1);
    }

    public Map<UUID, Integer> getBasket() {
        return Collections.unmodifiableMap(basketMap);
    }
}
