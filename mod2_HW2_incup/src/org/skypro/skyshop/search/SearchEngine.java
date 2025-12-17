package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> treeSet = new TreeSet<>(new SortedSearchableComparator());

    public void addSearchable(Searchable search){
        treeSet.add(search);
    }

    public Set<Searchable> findSearchableObj(String search) {
        Set<Searchable> setFind = new TreeSet<>(new SortedSearchableComparator());

        for (Searchable el : treeSet) {
            if (el != null && el.getText().contains(search)) {
                setFind.add(el);
            }
        }
        return setFind;
    }
}
