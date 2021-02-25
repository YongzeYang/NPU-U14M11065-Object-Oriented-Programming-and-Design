/*!Begin Snippet:file*/


package fushiSystemStrategy;

/**
 * This class implements a method that obtains a XML
 * representation of a {@link StudentCatalog} object.
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see StudentsFormatter
 * @see StudentCatalog
 * @see Student
 * @see TestItem
 */
public class XMLStudentsFormatter implements StudentsFormatter {
    
    /* Line separator */
    private final static String NEW_LINE = System.getProperty("line.separator");

    /* single instance of this class */
    static private XMLStudentsFormatter singletonInstance = null;

    /**
     * Obtains a XML representation of the student catalog.
     *
     * @param studentCatalog  the student catalog.
     * @return  a XML representation of the specified
     *          {@link StudentCatalog} object.
     */
    @Override
    public String formatStudents(StudentCatalog studentCatalog) {
        String out = "<StudentCatalog>"
                + NEW_LINE;

        for(Student student : studentCatalog){
            out += "  <student id=\"" +student.getId() + "\" name=\"" + student.getName() + "\">"
                + NEW_LINE
                +  "    <ExamPaper>"
                + NEW_LINE;
            if(student.getExamPaper().getNumberOfItems() > 0) {
                for(TestItem testItem : student.getExamPaper()) {
                    out += "      "
                            + "<Test code=\""
                            + testItem.getTest().getCode()
                            + "\">"
                            + testItem.getTest().getTitle()
                            + "</Test>"
                            + NEW_LINE;
                }

                out += "    </ExamPaper>" 
                        + NEW_LINE
                        +"  </Student>" 
                        + NEW_LINE ;
            }
        }

        out += "</StudentCatalog>";
        
        return out;
    }
    
    /**
     * Obtains the single instance of class
     * <code>XMLStudentsFormatter</code>
     *
     * @return the single instance of class
     *         <code>XMLStudentsFormatter</code>
     */      
    static public XMLStudentsFormatter getSingletonInstance() {

        if (singletonInstance == null) {
            singletonInstance = new XMLStudentsFormatter();
        }

        return singletonInstance;
    }

    /*
     * The constructor is declared private so other classes cannot
     * create an instance of this class.
     */
    private XMLStudentsFormatter() {

    }
}
/*!End Snippet:file*/