package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class SimilarityFinderBehaviourTest {

    private SimilarityFinder similarityFinder;
    private MockSequenceSearcher mockSequenceSearcher;

    public static final int[] EMPTY_SEQUENCE = {};
    public static final int[] SEQUENCE_ONE = {1};
    public static final int[] SEQUENCE_TWO = {2,3,4};



    @Before
    public void setUp(){
        mockSequenceSearcher = new MockSequenceSearcher();
        similarityFinder = new SimilarityFinder(mockSequenceSearcher);
    }

    @Test
    public void checkSearchCallCounterForEmptySequence(){
        similarityFinder.calculateJackardSimilarity(EMPTY_SEQUENCE,SEQUENCE_ONE);
        assertThat(mockSequenceSearcher.getSearchCallCounter(), is(0));
    }


    @Test
    public void checkSearchCallCounterOneElementSequence(){
        similarityFinder.calculateJackardSimilarity(SEQUENCE_ONE,SEQUENCE_ONE);
        assertThat(mockSequenceSearcher.getSearchCallCounter(), is(1));
    }


    @Test
    public void checkSearchCallCounterThreeElementSequence(){
        similarityFinder.calculateJackardSimilarity(SEQUENCE_TWO,SEQUENCE_ONE);
        assertThat(mockSequenceSearcher.getSearchCallCounter(), is(3));
    }

}
