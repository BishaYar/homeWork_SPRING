package org.skypro.skyshop.search;

import java.util.ArrayList;

public class SearchEngine {
    ArrayList<Searchable> listSearchables = new ArrayList<>();

    public void addSearchable(Searchable search){
        listSearchables.add(search);
    }

    public ArrayList<Searchable> findSearchableObj(String search) {
        ArrayList<Searchable> findListSearch = new ArrayList<>();
        for (Searchable el : listSearchables){
            if (el != null && el.getText().contains(search)) {
                findListSearch.add(el);
            }
        }
        return findListSearch;
    }
}
