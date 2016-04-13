package edu.iis.mto.similarity;

import org.junit.Before;

public class SimilarityFinderResultTest {


    private SimilarityFinder similarityFinder;

    @Before
    public void setUp(){
        similarityFinder = new SimilarityFinder(new FakeSequenceSearcher());
    }

}
