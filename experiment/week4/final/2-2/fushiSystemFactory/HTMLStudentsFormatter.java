/*!Begin Snippet:file*/


package fushiSystemFactory;

/**
 * This class implements a method that obtains a HTML
 * representation of a {@link StudentCatalog} object.
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see StudentsFormatter
 * @see StudentCatalog
 * @see Student
 * @see TestItem
 */
public class HTMLStudentsFormatter implements StudentsFormatter {

    /* Line separator */
    private final static String NEW_LINE = System.getProperty("line.separator");
    
    /* single instance of this class */
    static private HTMLStudentsFormatter singletonInstance = null;

    /**
     * Obtains a HTML representation of the student catalog.
     *
     * @param studentCatalog  the student catalog.
     * @return  a HTML representation of the specified
     *          {@link StudentCatalog} object.
     */
    @Override
    public String formatStudents(StudentCatalog studentCatalog) {
        
        String out = "<html>"
                + NEW_LINE
                + "  <body>"
                + NEW_LINE + ""
                + "    <center><h2>Student Catalog</h2></center>"
                + NEW_LINE;

        for(Student student : studentCatalog){
            out += "    <hr>"
                + NEW_LINE
                +  "    <h4>" +student.getId() + " " + student.getName() + "</h4>"
                + NEW_LINE;
            if(student.getExamPaper().getNumberOfItems() > 0) {
                out += "      <blockquote>" + NEW_LINE;

                for(TestItem testItem : student.getExamPaper()) {
                    out += "         "
                            + testItem.getTest().getCode()
                            + " "
                            + testItem.getTest().getTitle()
                            + "<br>"
                            + NEW_LINE;
                }

                out += "      </blockquote>" 
                        + NEW_LINE;

            }
        }

        out += "  </body>" 
                + NEW_LINE 
                + "</html>";
        
        return out;
    }
    
    /**
     * Obtains the single instance of class
     * <code>HTMLStudentsFormatter</code>
     *
     * @return the single instance of class
     *         <code>HTMLStudentsFormatter</code>
     */    
    static public HTMLStudentsFormatter getSingletonInstance() {

        if (singletonInstance == null) {
            singletonInstance = new HTMLStudentsFormatter();
        }

        return singletonInstance;
    }

    /*
     * The constructor is declared private so other classes cannot
     * create an instance of this class.
     */
    private HTMLStudentsFormatter(){

    }

}
/*!End Snippet:file*/