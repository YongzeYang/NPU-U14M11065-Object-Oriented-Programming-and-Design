/*!Begin Snippet:file*/

package fushiSystemFactory;

/**
 * This class models a formatter generator. 
 *
 * @author YangYongze(id:2019302768)
 * @version 1.1.0
 */
public class StudentsFormatterMaker  {
    
    /**
     * Generates a <code>StudentsFormatter</code> object.
     *
     * @param choice  the choice of the type of formatter.
     * @return Formatter of Students by choice index. Returns 
     *         <code>null</code> if the choice is invalid.
     */
    public static StudentsFormatter generateFormatter(int choice)  {

        switch(choice) {
            case 1:
                return PlainTextStudentsFormatter.getSingletonInstance();
            
            case 2:
                return HTMLStudentsFormatter.getSingletonInstance();

            case 3:
                return XMLStudentsFormatter.getSingletonInstance();

        }
        return null;

    }
}
/*!End Snippet:file*/