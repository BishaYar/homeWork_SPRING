package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> basketItem;
    private Integer total;

    public UserBasket(List<BasketItem> basketItem) {
        this.basketItem = basketItem;
    }

    public List<BasketItem> getBasketItem() {
        return basketItem;
    }

    public int getTotal() {
        total = basketItem.stream()
                .mapToInt(item -> item.getProduct().getPriceProduct() * item.getCount())
                .reduce(0, Integer::sum);
        return total;
    }
}
