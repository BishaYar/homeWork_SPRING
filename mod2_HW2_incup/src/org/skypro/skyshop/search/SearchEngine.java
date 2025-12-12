package org.skypro.skyshop.search;

import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final Map<String, Searchable> treeMap = new TreeMap<>();

    public void addSearchable(Searchable search){
        treeMap.put(search.getText(), search);
    }

    public Map<String, Searchable> findSearchableObj(String search) {
        Map<String, Searchable> mapFind = new TreeMap<>();

        for (Map.Entry<String, Searchable> el : treeMap.entrySet()) {
            if (el != null && el.getKey().contains(search)) {
                mapFind.put(el.getKey(), el.getValue());
            }
        }
        return mapFind;
    }
}
