/*!Begin Snippet:file*/

package fushiSystemStrategy;

import java.util.*;

/**
 * This class models a student. It contains the following 
 * information:
 * <ol>
 * <li>the identification code of the student, a <code>String</code></li>
 * <li>the name of the student, a <code>String</code></li>
 * <li>the exam paper of the student, an <code>ExamPaper</code></li>
 * </ol>
 *
 * @author YangYongze(id:2019302768)
 * @version 1.1.0
 * @see ExamPaper
 */
public class Student{
    /* The identification code of the student. */
    private String id;

    /* The name of the student. */
    private String name;

    /* The exam paper of the student. */
    private ExamPaper examPaper;
    

    /**
     * Constructs a <code>Student</code> object.
     * 
     * @param initialId  the id of the student.
     * @param initialName  the name of the student.
     */
    public Student(String initialId, String initialName) {
        this.id = initialId;
        this.name = initialName;
    }

    /**
     * Constructs a <code>Student</code> object.
     * 
     * @param initialId  the id of the student.
     * @param initialName  the name of the student.
     * @param initialExamPaper  the exam paper of the student.
     */
    public Student(String initialId, String initialName, ExamPaper initialExamPaper) {
        this.id = initialId;
        this.name = initialName;
        this.examPaper = initialExamPaper;
    }

    /**
     * Returns the identification code of the student.
     *
     * @return  the identification code of the student.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Resets the identification code of the student.
     *
     * @param newId  the new identification code of the student.
     */    
    public void setId(String newId) {
        this.id = newId;
    }


    /**
     * Returns the name of the student.
     *
     * @return  the name of the student.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Resets the name of the student.
     *
     * @param newName  the new name of the student.
     */       
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Returns the exam paper of the student.
     *
     * @return  the exam paper of the student.
     */ 
    public ExamPaper getExamPaper() {

        return this.examPaper;
    }

    /**
     * Resets the exam paper of the student.
     *
     * @param newExamPaper  the new exam paper of the student.
     */   
    public void setExamPaper(ExamPaper newExamPaper) {

        this.examPaper = newExamPaper;
    }

    /**
     * Returns <code>true</code> if this student is equal to the argument
     * 
     * @param o  object with which this student is compared.
     * @return  <code>true</code> if this student is equal to
     *          the argument; <code>false</code> otherwise.       
     */
    @Override
    public boolean equals(Object o) {

        if (o == this)
            return true;

        if (!(o instanceof Student)) {
            return false;
        }

        Student student = (Student) o;

        return Objects.equals(id, student.id) && Objects.equals(name, student.name);
    }

    /**
     * Returns the string representation of this student.
     *
     * @return  the string representation of this student.
     */
    @Override
    public String toString() {

        return  getId() + "_" + getName();   
    }
}
/*!End Snippet:file*/