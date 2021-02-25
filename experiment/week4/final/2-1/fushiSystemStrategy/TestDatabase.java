/*!Begin Snippet:file*/

package fushiSystemStrategy;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Maintains the information of a test database for retest system.
 * Contains a collection of {@link Test} objects.
 *
 * @author YangYongze(id:2019302768)
 * @version 1.1.0
 * @see Test
 */
public class TestDatabase implements Iterable<Test> {
    
    /* Collection of <code>Test</code> objects.*/
    private ArrayList<Test> tests;

    /**
     * Constructs an empty test database.
     */
    public TestDatabase(){
        this.tests = new ArrayList<Test>();
    }

    /**
     * Returns an iterator over the tests in this test database.
     *
     * return  an {@link Iterator} of {@link Test}
     */    
    @Override
    public Iterator<Test> iterator() {
        return this.tests.iterator();
    }

    /**
     * Adds a {@link Test} object to this test database.
     *
     * @param test  the {@link Test} object.
     */      
    public void addTest(Test test) {
        this.tests.add(test);
    }

    /**
     * Removes a {@link Test} object to this test database.
     *
     * @param test  the {@link Test} object.
     */ 
    public void removeTest(Test test) {
        this.tests.remove(test);
    }

    /**
     * Returns the {@link Test} object with the index.
     *
     * @param index  the index of an item.
     * @return  The {@link Test} object with the specified
     *          index. Returns <code>null</code> if the object with
     *          the index is out of range.
     */
    public Test getTest(int index) 
    {
        Iterator<Test> e = tests.iterator();

        if(index<0||index>tests.size())return null;
        
        else{
            for(int i = 1;i<index;i++){
                e.next();
            }
            
            return e.next();
        }
    }

    /**
     * Returns the {@link Test} object with the specified
     * <code>code</code>.
     *
     * @param code  the code of an item.
     * @return  The {@link Test} object with the specified
     *          code. Returns <code>null</code> if the object with
     *          the code is not found.
     */
    public Test getTest(String code) {

        for(Test test : this.tests) {

            if(test.getCode().equals(code)) {

                return test;
            }
        }
        
        return null;
    }

    /**
     * Returns the number of tests in the test database.
     *
     * @return the number of {@link Test} objects in this test database.
     */
    public int getNumberOfTests() {

        return this.tests.size();
    }
}
/*!End Snippet:file*/