/*!Begin Snippet:file*/

package fushiSystemStrategy;

/**
 * This class models an English test. It extends {@link Test} and
 * adds the following information:
 * <ol>
 * <li>the type of the questions of the English test, a <code>String</code></li>
 * </ol>
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see Test
 */
public class EnglishTest extends Test {
    
    /* The type of the questions of the English test. */
    private String type;

    /**
     * Constructs a <code>EnglishTest</code> object.
     *
     * @param initialCode  the identification code of the English test.
     * @param initialTitle  the title of the English test.
     * @param initialDifficultyDegree  the difficulty degree of the English test.
     * @param initialScoreCriteria  the score criteria of the English test.
     * @param initialType the type of the English test
     */
    public EnglishTest(String initialCode, String initialTitle, int initialDifficultyDegree, 
                        String initialScoreCriteria, String initialType) {
        
        super(initialCode, initialTitle, initialDifficultyDegree, initialScoreCriteria);

        this.type = initialType;
    }

    /**
     * Returns the type of the English test.
     *
     * @return  the type of the English test.
     */
    public String getType() {

        return this.type;
    }

    /**
     * Resets the type of the test.
     *
     * @param newType  the new type of the test.
     */
    public void setType(String newType) {

        this.type = newType;
    }

    /*
    /**
     * Returns the string representation of this English test.
     *
     * @return  the string representation of this English test.
     *
    public String toString() {
        
        return super.toString() + " | " + getType();
    }
    */
    
}
/*!End Snippet:file*/