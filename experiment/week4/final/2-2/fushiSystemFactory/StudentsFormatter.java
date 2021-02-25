/*!Begin Snippet:file*/

package fushiSystemFactory;

/**
 * This interface defines a method that obtains a string
 * representation of a {@link StudentCatalog} object.
 *
 * @author yongze_yang(2019302768)
 * @version  1.0.0
 * @see StudentCatalog
 */
public interface StudentsFormatter {

    /**
     * Obtains the string representation of the student catalog.
     *
     * @param studentCatalog  the student catalog.
     * @return  the string representation of the specified
     *          {@link StudentCatalog} object.
     */
    String formatStudents(StudentCatalog studentCatalog);


}
/*!End Snippet:file*/