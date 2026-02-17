package org.skypro.skyshop.search;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.SearchService;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.StorageService;

import java.util.Collection;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchService;

    @Test
    void whenIsEmptyStorage_thenStorageServiceReturnsNull() {

        Collection<Searchable> result = storageService.getAllSearchable();
        assertThat(result).isEmpty();
    }

    @Test
    void whenIsEmptyNotPattern_thenStorageServiceReturnNull() {

        UUID id = UUID.randomUUID();
        storageService.setMapProduct(id, new SimpleProduct(id, "печенье", 70));
        id = UUID.randomUUID();
        storageService.setMapProduct(id, new SimpleProduct(id, "молоко", 50));

        Collection<SearchResult> result = searchService.search("чай");

        assertThat(result).isEmpty();
    }

    @Test
    void whenFindObj_thenStorageServiceReturnSizeOne() {
        storageService = new StorageService();
        searchService = new SearchService(storageService);

        UUID id = UUID.randomUUID();
        storageService.setMapProduct(id, new SimpleProduct(id, "печенье", 70));
        id = UUID.randomUUID();
        storageService.setMapProduct(id, new SimpleProduct(id, "молоко", 50));
        id = UUID.randomUUID();
        storageService.setMapProduct(id, new SimpleProduct(id, "TestProduct", 70));

        Collection<SearchResult> result = searchService.search("Test");

        assertThat(result).hasSize(1);
    }
}
