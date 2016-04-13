package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


public class SimilarityFinderResultTest {


    private SimilarityFinder similarityFinder;

    public static final int[] EMPTY_SEQUENCE = {};
    public static final int[] SEQUENCE_ONE = {1,2,3,4,5};
    public static final int[] SEQUENCE_TWO = {2,3,4};
    public static final int[] SEQUENCE_THREE = {5,6,7};



    @Before
    public void setUp(){
        similarityFinder = new SimilarityFinder(new FakeSequenceSearcher());
    }

    @Test
    public void emptySequences(){
        double similarity = similarityFinder.calculateJackardSimilarity(EMPTY_SEQUENCE,EMPTY_SEQUENCE);
        assertThat(similarity, is(1.0d));
    }

    @Test
    public void sameSequences(){
        double similarity = similarityFinder.calculateJackardSimilarity(SEQUENCE_ONE,SEQUENCE_ONE);
        assertThat(similarity, is(1.0d));
    }

    @Test
    public void sequencesWithoutCommonElements(){
        double similarity = similarityFinder.calculateJackardSimilarity(SEQUENCE_TWO,SEQUENCE_THREE);
        assertThat(similarity, is(0.0d));
    }

    @Test
    public void sequenceIncludesOtherSequence(){
        double similarity = similarityFinder.calculateJackardSimilarity(SEQUENCE_TWO,SEQUENCE_ONE);
        double expectedSimilarity = SEQUENCE_TWO.length / (double)SEQUENCE_ONE.length;
        assertThat(similarity, is(expectedSimilarity));
    }

    @Test
    public void sequencesHaveSomeCommonMembers(){
        double similarity = similarityFinder.calculateJackardSimilarity(SEQUENCE_THREE,SEQUENCE_ONE);
        double expectedSimilarity = 1 / (double)(SEQUENCE_ONE.length + SEQUENCE_THREE.length - 1);
        assertThat(similarity, is(expectedSimilarity));
    }

}
