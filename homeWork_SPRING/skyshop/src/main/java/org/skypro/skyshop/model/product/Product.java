package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    protected final String nameProduct;
    private final UUID id;

    protected Product(UUID id, String nameProduct) {
        this.id = id;
        if (nameProduct == null) {
            throw new IllegalArgumentException("Строка наименования не заполнена, такой товар добавить нельзя");
        } else if (nameProduct.isBlank()){
            throw new IllegalArgumentException("Строка наименования пустая, такой товар добавить нельзя");
        }
        this.nameProduct = nameProduct;
    }

    public abstract int getPriceProduct();

    public abstract String toString();

    @Override
    public UUID getId(){
        return id;
    }

    @Override
    @JsonIgnore
    public String getSearchTerm() {
        return nameProduct;
    }

    @Override
    @JsonIgnore
    public String getContentType(){
        return "products";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product prod = (Product) obj;
        return Objects.equals(nameProduct, prod.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct);
    }
}

