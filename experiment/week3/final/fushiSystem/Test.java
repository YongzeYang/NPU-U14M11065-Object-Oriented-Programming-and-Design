/*!Begin Snippet:file*/

package fushiSystem;

import java.util.Objects;

/**
 * This class models a test in an test item. It contains the following
 * information:
 * <ol>
 * <li>the identification code of the test, a <code>String</code></li>
 * <li>the title of the test, a <code>String</code></li>
 * <li>the difficulty degree of the test, an <code>int</code></li>
 * <li>the score criteria of the test, a <code>String</code></li>
 * </ol>
 *
 * @author YangYongze(id:2019302768)
 * @version 1.1.0
 */
public class Test {

    /* The identification code of the test. */
    private String code;

    /* The title of the test. */
    private String title;

    /* The difficulty degree of the test. */
    private int difficultyDegree;

    /* The score criteria of the product. */
    private String scoreCriteria;

    /**
     * Constructs a <code>Product</code> object.
     *
     * @param initialCode  the identification code of the test.
     * @param initialTitle  the title of the test.
     * @param initialDifficultyDegree  the difficulty degree of the test.
     * @param initialScoreCriteria  the score criteria of the test.
     */
    public Test(String initialCode, String initialTitle, 
                int initialDifficultyDegree, String initialScoreCriteria) {
                    
        this.code = initialCode;
        this.title = initialTitle;
        this.difficultyDegree = initialDifficultyDegree;
        this.scoreCriteria = initialScoreCriteria;
    }

    /**
     * Returns the identification code of the test.
     *
     * @return  the identification code of the test.
     */
    public String getCode() {

        return this.code;
    }

    /**
     * Resets the identification code of the test.
     *
     * @param newCode  the new identification code of the test.
     */
    public void setCode(String newCode) {

        this.code = newCode;
    }

    /**
     * Returns the title of the test.
     *
     * @return  the title of the test.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Resets the title of the test.
     *
     * @param newTitle  the new title of the test.
     */
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    /**
     * Returns the difficulty degree of the test.
     *
     * @return  the new difficulty degree of the test.
     */   
    public int getDifficultyDegree() {
        return this.difficultyDegree;
    }

    /**
     * Resets the difficulty degree of the test.
     *
     * @param newDifficultyDegree  the new difficulty degree of the test.
     */
    public void setDifficultyDegree(int newDifficultyDegree) {
        this.difficultyDegree = newDifficultyDegree;
    }

    /**
     * Returns the score criteria of the test.
     *
     * @return  the new score criteria of the test.
     */     
    public String getScoreCriteria() {
        return this.scoreCriteria;
    }

    /**
     * Resets the score criteria of the test.
     *
     * @param newScoreCriteria  the new score criteria of the test.
     */
    public void setScoreCriteria(String newScoreCriteria) {
        this.scoreCriteria = newScoreCriteria;
    }

    /**
     * Returns <code>true</code> if this test is equal to the argument
     * 
     * @param Object  object with which this test is compared.
     * @return  <code>true</code> if this test is equal to
     *          the argument; <code>false</code> otherwise.       
     */
    @Override
    public boolean equals(Object o) {

        if (o == this)
            return true;

        if (!(o instanceof Test)) {
            return false;
        }

        Test test = (Test) o;

        return Objects.equals(code, test.code) && Objects.equals(title, test.title) 
                && difficultyDegree == test.difficultyDegree 
                && Objects.equals(scoreCriteria, test.scoreCriteria);
    }

    /**
     * Returns the string representation of this test.
     *
     * @return  the string representation of this test.
     */
    @Override
    public String toString() {

        return getCode()+" | "+getTitle() + " | " + getDifficultyDegree();
    }
}
/*!End Snippet:file*/