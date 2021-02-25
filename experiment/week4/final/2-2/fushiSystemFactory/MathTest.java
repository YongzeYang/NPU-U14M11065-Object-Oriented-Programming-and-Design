/*!Begin Snippet:file*/

package fushiSystemFactory;

/**
 * This class models a Math test. It extends {@link Test} and
 * adds the following information:
 * <ol>
 * <li>the photo URL of the Math test, a <code>String</code></li>
 * <li>the calculation Process of the Math test, a <code>String</code></li>
 * </ol>
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see Test
 */
public class MathTest extends Test {
    
    /* The photo URL of the Math test. */
    private String photoURL;
    
    /* The calculation Process of the Math test. */
    private String calculationProcess;

    /**
     * Constructs a <code>MathTest</code> object.
     *
     * @param initialCode  the identification code of the Math test.
     * @param initialTitle  the title of the Math test.
     * @param initialDifficultyDegree  the difficulty degree of the Math test.
     * @param initialScoreCriteria  the score criteria of the Math test.
     * @param initialCalculationProcess the calculation Process of the Math test.
     * @param initialPhotoURL the photo URL of the Math test.
     */
    public MathTest(String initialCode, String initialTitle, int initialDifficultyDegree, 
                    String initialScoreCriteria, String initialPhotoURL, 
                    String initialCalculationProcess) {

        super(initialCode, initialTitle, initialDifficultyDegree, initialScoreCriteria);

        this.photoURL = initialPhotoURL;
        this.calculationProcess = initialCalculationProcess;
    }

    /**
     * Returns the photo URL of the Math test.
     *
     * @return  the photo URL of the Math test.
     */
    public String getPhotoURL() {

        return this.photoURL;
    }

    /**
     * Returns the calculation Process of the Math test.
     *
     * @return  the calculation Process of the Math test.
     */
    public String getCalculationProcess() {

        return this.calculationProcess;
    }

    /**
     * Resets the photo URL of the Math test.
     *
     * @param newPhotoURL  the new photo URL of the Math test.
     */
    public void setPhotoURL(String newPhotoURL) {

        this.photoURL = newPhotoURL;
    }

    /**
     * Resets the calculation Process of the Math test.
     *
     * @param  newCalculationProcess the new calculation Process of the Math test.
     */
    public void setCalculationProcess(String newCalculationProcess) {

        this.calculationProcess = newCalculationProcess;
    }

    /**
     * Returns the string representation of this Math test.
     *
     * @return  the string representation of this Math test.
     
    public String toString() {
        
        return super.toString() + " | " + getPhotoURL() 
                + " | " + getCalculationProcess();
    }*/
}
/*!End Snippet:file*/