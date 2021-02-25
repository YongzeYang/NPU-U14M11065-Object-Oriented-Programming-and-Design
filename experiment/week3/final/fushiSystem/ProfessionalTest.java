/*!Begin Snippet:file*/

package fushiSystem;

/**
 * This class models a Professional test. It extends {@link Test} and
 * adds the following information:
 * <ol>
 * <li>the program instruction of the Professional test, a <code>String</code></li>
 * <li>the program body of the Professional test, a <code>String</code></li>
 * <li>the photo URL of the Professional test, a <code>String</code></li>
 * </ol>
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see Test
 */
public class ProfessionalTest extends Test{
    
    /* the program instruction of the Professional test. */
    private String programInstruction;

    /* the program body of the Professional test. */
    private String programing;

    /* the photo URL of the Professional test. */
    private String photoURL;

    /**
     * Constructs a <code>EnglishTest</code> object.
     *
     * @param initialCode  the identification code of the Professional test.
     * @param initialTitle  the title of the Professional test.
     * @param initialDifficultyDegree  the difficulty degree of the Professional test.
     * @param initialScoreCriteria  the score criteria of the Professional test.
     * @param initialProgramInstruction the program instruction of the Professional test.
     * @param initialPrograming the program body of the Professional test.
     * @param initialPhotoURL the photo URL of the Professional test.
     */
    public ProfessionalTest(String initialCode, String initialTitle, int initialDifficultyDegree, 
                            String initialScoreCriteria, String initialProgramInstruction, 
                            String initialPrograming, String initialPhotoURL) {
        
        super(initialCode, initialTitle, initialDifficultyDegree, initialScoreCriteria);

        this.programInstruction = initialProgramInstruction;
        this.programing = initialPrograming;
        this.photoURL = initialPhotoURL;
    }
    
    /**
     * Returns the program instruction of the Professional test.
     *
     * @return  the program instruction of the Professional test.
     */   
    public String getProgramInstruction() {

        return this.programInstruction;
    }


    /**
     * Resets the program instruction of the Professional test.
     *
     * @param  newProgramInstruction the new program instruction of the Professional test.
     */  
    public void setProgramInstruction(String newProgramInstruction) {

        this.programInstruction = newProgramInstruction;
    }

    /**
     * Returns the program body of the Professional test.
     *
     * @return  the program body of the Professional test.
     */  
    public String getPrograming() {

        return this.programing;
    }

    /**
     * Resets the program body of the Professional test.
     *
     * @param newPrograming  the program body of the Professional test.
     */ 
    public void setPrograming(String newPrograming) {

        this.programing = newPrograming;
    }

    /**
     * Returns the photo URL of the Professional test.
     *
     * @return  the photo URL of the Professional test.
     */ 
    public String getPhotoURL() {

        return this.photoURL;
    }

    /**
     * Resets the photo URL of the Professional test.
     *
     * @param  newPhotoURL the new photo URL of the Professional test.
     */ 
    public void setPhotoURL(String newPhotoURL) {

        this.photoURL = newPhotoURL;
    }

    /**
     * Returns the string representation of this Professional test.
     *
     * @return  the string representation of this Professional test.
     
    public String toString() {

        return super.toString() + " | " + getProgramInstruction() 
                + " | " + getPrograming() + " | " + getPhotoURL();
    }*/
}
/*!End Snippet:file*/