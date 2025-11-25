package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {
    private final String nameArticle;
    private final String textArticle;

    public Article(String name, String text){
        nameArticle = name;
        textArticle = text;
    }

    @Override
    public String toString(){
        return nameArticle + "\n" + textArticle;
    }

    @Override
    public String getText() {
        return toString();
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }
}
