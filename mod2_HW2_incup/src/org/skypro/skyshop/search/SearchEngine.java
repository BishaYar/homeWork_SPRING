package org.skypro.skyshop.search;

public class SearchEngine {
    public Searchable[] searchables;

    public SearchEngine(int size) {
       searchables = new Searchable[size];
    }

    public Searchable[] search(String findText){
        Searchable[] searchable = new Searchable[5];
        int i = 0;
        for (Searchable search : searchables){
            if (search != null && search.getText().contains(findText)) {
                searchable[i] = search;
                i++;
            }
        }
        return searchable;
    }

    public void addSearchable(Searchable search){
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = search;
                break;
            } else {
                if (searchables[i].getText().equals(search.getText())) {
                    searchables[i] = search;
                    break;
                }
            }
        }
    }
}
