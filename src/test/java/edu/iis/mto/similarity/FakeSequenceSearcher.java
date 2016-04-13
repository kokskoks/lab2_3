package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.Arrays;

public class FakeSequenceSearcher implements SequenceSearcher {
    public SearchResult search(int i, int[] ints) {
        boolean isFound = false;

        for(int number : ints){
            if(number == i){
                isFound = true;
                break;
            }
        }

        return new FakeSearchResult(isFound);
    }
}
