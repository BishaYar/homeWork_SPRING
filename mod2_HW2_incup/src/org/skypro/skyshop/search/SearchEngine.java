package org.skypro.skyshop.search;

public class SearchEngine {
    public Searchable[] searchables;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
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

    public Searchable findSearchableObj(String search) {
        int [] maxRepeat = new int[searchables.length];
        int max = 0;
        Searchable searchFind = null;

        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] != null) {
                maxRepeat[i] = getSearchTerm(searchables[i].toString(), search);
            } else maxRepeat[i] = 0;
        }

        int index = -1;
        for (int i = 0; i < searchables.length; i++){
            if (max < maxRepeat[i]) {
                max = maxRepeat[i];
                index = i;
            }
        }

        try {
            isNullObj(index, search);
        } catch (BestResultNotFoundException e) {
            e.printStackTrace();
        }

        if (index != -1) {
            searchFind = searchables[index];
        }

        return searchFind;
    }

    public static void isNullObj(int index, String str) throws BestResultNotFoundException{
        if (index == -1) {
            throw new BestResultNotFoundException("Совпадений не найдено для '" + str + "'");
        }
    }

    public int getSearchTerm(String strObj, String strFind) {
        int index = 0;
        int count = 0;
        int indexStr = strObj.indexOf(strFind, index);
        while (indexStr != -1) {
            count++;
            index = indexStr + strFind.length();
            indexStr = strObj.indexOf(strFind, index);
        }
        return count;
    }
}
