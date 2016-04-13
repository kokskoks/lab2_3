package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class MockSequenceSearcher implements SequenceSearcher{

    private int searchCallCounter = 0;

    public int getSearchCallCounter() {
        return searchCallCounter;
    }

    public SearchResult search(int i, int[] ints) {
        searchCallCounter++;
        return new FakeSearchResult(false);
    }
}
