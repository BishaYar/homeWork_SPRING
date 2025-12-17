package org.skypro.skyshop.search;

import java.util.Comparator;

public class SortedSearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable obj1, Searchable obj2) {
        int comp = Integer.compare(obj2.getText().length(), obj1.getText().length());
        if (comp == 0) {
            return obj1.getText().compareTo(obj2.getText());
        } else
            return comp;
    }
}
