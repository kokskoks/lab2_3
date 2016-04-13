package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class FakeSearchResult implements SearchResult{

    private final boolean found;


    public FakeSearchResult(boolean found) {
        this.found = found;
    }

    public boolean isFound() {
        return found;
    }

    public int getPosition() {
        return 0;
    }
}
