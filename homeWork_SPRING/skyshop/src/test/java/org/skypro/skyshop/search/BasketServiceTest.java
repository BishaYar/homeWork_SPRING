package org.skypro.skyshop.search;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.StorageService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    @Mock
    private StorageService storageService;

    @Mock
    private ProductBasket productBasket;

    @InjectMocks
    private BasketService basketService;

    @Test
    void whenAddProductNotStorage_thenStorageServiceReturnsException() {
        UUID invalidId = UUID.fromString("9a273668-d075-47a6-8619-8777f71f614c");

        assertThrows(NoSuchProductException.class, () -> basketService.addProductInBasket(invalidId));
    }

    @Test
    void whenAddProductExistsStorage_thenStorageServiceAddProduct() {

        UUID validId = UUID.fromString("fe4273c8-7e75-4529-8ca0-59edf13d65a5");
        Product mockProduct = new SimpleProduct(validId, "product", 70);

        when(storageService.getProductById(validId)).thenReturn(Optional.of(mockProduct));

        basketService.addProductInBasket(validId);

        verify(productBasket, times(1)).addProductInBasket(validId);
    }

    @Test
    void whenGetEmptyBasket_thenReturnsEmptyMap() {

        when(productBasket.getBasket()).thenReturn(Collections.emptyMap());

        List<BasketItem> list = basketService.getUserBasket().getBasketItem();

        assertThat(list).isEmpty();
        assertThat(basketService.getUserBasket().getTotal()).isZero();
    }

    @Test
    void whenGetFullBasket_thenReturnsFullMap() {

        UUID idPr1 = UUID.fromString("fe4273c8-7e75-4529-8ca0-59edf13d65a5");
        UUID idPr2 = UUID.fromString("fe4273c8-7e75-4529-8ca0-59edf13d65ac");

        Map<UUID, Integer> mapBasket = new HashMap<>();
        mapBasket.put(idPr1, 1);
        mapBasket.put(idPr2, 3);

        Product product1 = new SimpleProduct(idPr1, "product 1", 70);
        Product product2 = new SimpleProduct(idPr2, "product 2", 10);
        Integer total = 100;

        when(productBasket.getBasket()).thenReturn(mapBasket);

        when(storageService.getProductById(idPr1)).thenReturn(Optional.of(product1));
        when(storageService.getProductById(idPr2)).thenReturn(Optional.of(product2));

        UserBasket userBasket = basketService.getUserBasket();

        assertThat(userBasket.getBasketItem()).hasSize(2);
        assertThat(userBasket.getTotal()).isEqualTo(total);

        verify(productBasket, times(1)).getBasket();
        verify(storageService, times(1)).getProductById(idPr1);
        verify(storageService, times(1)).getProductById(idPr2);
    }
}
