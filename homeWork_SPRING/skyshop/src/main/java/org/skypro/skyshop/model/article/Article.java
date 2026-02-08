package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public final class Article implements Searchable, Comparable<Article> {
    private final String nameArticle;
    private final String textArticle;
    private final UUID id;

    public Article(UUID id, String name, String text){
        this.id = id;
        nameArticle = name;
        textArticle = text;
    }

    @Override
    public UUID getId(){
        return id;
    }

    @Override
    public String toString() {
        return nameArticle + " " + textArticle;
    }

    @Override
    @JsonIgnore
    public String getSearchTerm() {
        return toString();
    }

    @Override
    @JsonIgnore
    public String getContentType() {
        return "articles";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Article art = (Article) obj;
        return Objects.equals(nameArticle, art.nameArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameArticle);
    }

    @Override
    public int compareTo(Article obj) {
        return this.getSearchTerm().compareTo(obj.getSearchTerm());
    }
}
