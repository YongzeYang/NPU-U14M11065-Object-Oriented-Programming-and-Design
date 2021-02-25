/*!Begin Snippet:file*/

package fushiSystem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Maintains the information of a student catalog for retest system.
 * Contains a collection of {@link Student} objects.
 *
 * @author YangYongze(id:2019302768)
 * @version 1.1.0
 * @see Student
 */
public class StudentCatalog implements Iterable<Student> {
    
    /* Collection of <code>Student</code> objects.*/
    private ArrayList<Student> students;

    /**
     * Constructs an empty student catalog.
     */
    public StudentCatalog() {

        this.students = new ArrayList<Student>();
    }

    /**
     * Returns an iterator over the students in this student catalog.
     *
     * return  an {@link Iterator} of {@link Student}
     */
    @Override
    public Iterator<Student> iterator() {

        return this.students.iterator();
    }

    /**
     * Adds a {@link Student} object to this student catalog.
     *
     * @param student  the {@link Student} object.
     */    
    public void addStudent(Student student) {

        this.students.add(student);
    }

    /**
     * Removes a {@link Student} object to this student catalog.
     *
     * @param student  the {@link Student} object.
     */ 
    public void removeStudent(Student student) {

        this.students.remove(student);
    }

    /**
     * Returns the {@link Student} object with the specified
     * <code>id</code>.
     *
     * @param id  the id of an item.
     * @return  The {@link Student} object with the specified
     *          id. Returns <code>null</code> if the object with
     *          the id is not found.
     */
    public Student getStudent(String id) {

        for(Student student : this.students) {
            if(student.getId().equals(id)) {
                return student;
            }
        }

        return null;
    }

    /**
     * Returns the {@link Student} object with the index.
     *
     * @param index  the index of an item.
     * @return  The {@link Student} object with the specified
     *          index. Returns <code>null</code> if the object with
     *          the index is out of range.
     */
    public Student getStudent(int index) {

        Iterator<Student> e = students.iterator();

        if(index<0||index>students.size()) return null;

        else{
            for(int i = 0;i<index;i++) {

                e.next();
            }

            return e.next();
        }
    }

    /**
     * Returns the number of students in the student catalog.
     *
     * @return the number of {@link Student} objects in this student catalog.
     */
    public int getNumberOfStudents() {

        return this.students.size();
    }
}
/*!End Snippet:file*/