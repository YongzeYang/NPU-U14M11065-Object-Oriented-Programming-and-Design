/*!Begin Snippet:file*/

package fushiSystem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Maintains the information of a exam paper for a student.
 * Contains a collection of {@link TestItem} objects.
 *
 * @author YangYongze(id:2019302768)
 * @version 1.1.0
 * @see TestItem
 */
public class ExamPaper implements Iterable<TestItem> {

    /* Collection of <code>TestItem</code> objects.*/
    private  ArrayList<TestItem> testItems; 

    /**
     * Constructs an empty test paper.
     */
    public ExamPaper() {

        this.testItems = new ArrayList<TestItem>();
    }

    /**
     * Returns an iterator over the test items in this paper.
     *
     * return  an {@link Iterator} of {@link TestItem}
     */
    @Override
    public Iterator<TestItem> iterator() {

        return this.testItems.iterator();
    }

    /**
     * Adds a {@link TestItem} object to this paper.
     *
     * @param testItem  the {@link TestItem} object.
     */  
    public void addTestItem(TestItem testItem) {

        this.testItems.add(testItem);
    }

    
    /**
     * Removes a {@link TestItem} object to this paper.
     *
     * @param testItem  the {@link TestItem} object.
     */ 
    public void removeTestItem(TestItem testItem) {
        
        this.testItems.remove(testItem);
    }

    /**
     * Returns the total score of the exam paper.
     * 
     * @return the total score of the exam paper 
     */
    public double getTotalScore() {

        Iterator<TestItem> e = testItems.iterator();

        double total = 0;

        for(int i=0;i<testItems.size();i++){
            total += e.next().getScore();
        }

        return total;
    }

    /**
     * Returns the number of test items in the paper.
     *
     * @return the number of {@link TestItem} objects in this paper.
     */
    public int getNumberOfItems() {

        return this.testItems.size();
    }

    /**
     * Returns the {@link TestItem} object with the index.
     *
     * @param index  the index of an item.
     * @return  The {@link TestItem} object with the specified
     *          index. Returns <code>null</code> if the object with
     *          the index is out of range.
     */
    public TestItem getTestItem(int index) {

        Iterator<TestItem> e = testItems.iterator();

        if(index<0||index>testItems.size())return null;

        else{
            for(int i = 0;i<index;i++){
                e.next();
            }

            return e.next();
        }
    }
}
/*!End Snippet:file*/