/*!Begin Snippet:file*/

package fushiSystemStrategy;

/**
 * This class implements a method that obtains a plain text
 * representation of a {@link StudentCatalog} object.
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see StudentsFormatter
 * @see StudentCatalog
 * @see Student
 * @see TestItem
 */
public class PlainTextStudentsFormatter implements StudentsFormatter{

    /* Line separator */
    private final static String NEW_LINE = System.getProperty("line.separator");

    /* single instance of this class */
    static private PlainTextStudentsFormatter singletonInstance = null;

    /**
     * Obtains the single instance of class
     * <code>PlainTextStudentsFormatter</code>
     *
     * @return the single instance of class
     *         <code>PlainTextStudentsFormatter</code>
     */     
    static public PlainTextStudentsFormatter getSingletonInstance(){
        if(singletonInstance == null) {
            singletonInstance = new PlainTextStudentsFormatter();
        }

        return singletonInstance;
    }


    /*
     * The constructor is declared private so other classes cannot
     * create an instance of this class.
     */
    private PlainTextStudentsFormatter() {

    }

    /**
     * Obtains a text representation of the student catalog.
     *
     * @param studentCatalog  the student catalog.
     * @return  a text representation of the specified
     *          {@link StudentCatalog} object.
     */
    @Override
    public String formatStudents(StudentCatalog studentCatalog) {

        String out = "" + NEW_LINE;

        for(Student student : studentCatalog ) {
            out += student.getId() + "_" + student.getName();

            for(TestItem testItem : student.getExamPaper()) {

                Test test = testItem.getTest();
                out += "_" + test.getCode();
            }
            out += NEW_LINE;
        }
        return out;
    }
    
}
/*!End Snippet:file*/