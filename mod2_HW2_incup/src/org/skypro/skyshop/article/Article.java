package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public final class Article implements Searchable, Comparable<Article> {
    private final String nameArticle;
    private final String textArticle;

    public Article(String name, String text){
        nameArticle = name;
        textArticle = text;
    }

    @Override
    public String toString() {
        return nameArticle + " " + textArticle;
    }

    @Override
    public String getText() {
        return toString();
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
        return this.getText().compareTo(obj.getText());
    }
}
