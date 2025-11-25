package org.skypro.skyshop.search;

public interface Searchable {
    String getText();

    String getTypeContent();

    default void getStringRepresentation(){
        System.out.println("Имя - " + getText() + " - тип " + getTypeContent());
    }
}
