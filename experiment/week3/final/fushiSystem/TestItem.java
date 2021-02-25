/*!Begin Snippet:file*/

package fushiSystem;

import java.util.*;

/**
 * This class models a test item in an exam paper. It contains the following
 * information:
 * <ol>
 * <li>the test of the test item, a <code>Test</code></li>
 * <li>the score of the test item, a <code>double</code></li>
 * </ol>
 *
 * @author YangYongze(id:2019302768)
 * @version 1.1.0
 * @see Test
 */
public class TestItem {

    /* The test of the test item. */
    private Test test;

    /* The score of the test item. */
    private double score;
    
    /**
     * Constructs a <code>TestItem</code> object.
     *
     * @param initialTest  the test of the test item.
     * @param initialScore  the score of the test item.
     */
    public TestItem(Test initialTest, double initialScore) {
        this.test = initialTest;
        this.score = initialScore;
    }

    /**
     * Returns the test of the test item.
     *
     * @return  the test of the test item.
     */
    public Test getTest() {

        return this.test;
    }
    
    /**
     * Resets the test of the test item.
     *
     * @param newTest  the test of the test item.
     */
    public void setTest(Test newTest) {

        this.test = newTest;
    }

    /**
     * Returns the score of the test item.
     *
     * @return  the score of the test item.
     */
    public double getScore() {

        return this.score;
    }

    /**
     * Resets the score of the test item.
     *
     * @param newScore  the score of the test item.
     */
    public void setScore(double newScore) {

        this.score = newScore;
    }

    /**
     * Returns <code>true</code> if this test item is equal to the argument
     * 
     * @param o  object with which this test item is compared.
     * @return  <code>true</code> if this test item is equal to
     *          the argument; <code>false</code> otherwise.       
     */
    @Override
    public boolean equals(Object o) {

        if (o == this)
            return true;
        
            if (!(o instanceof TestItem)) {
            return false;
        }
        
        TestItem testItem = (TestItem) o;
        
        return Objects.equals(test, testItem.test) && score == testItem.score;
    }
}
/*!End Snippet:file*/