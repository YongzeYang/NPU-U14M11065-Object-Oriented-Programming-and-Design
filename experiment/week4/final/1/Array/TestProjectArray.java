import java.io.*;

/**
 * Tests the class <code>ProjectArray</code>
 *
 * @author name
 * @version 1.0.0
 * @see projectArray
 * @see Project
 */
public class TestProjectArray {

	/* Standard output stream */
	private static PrintWriter stdOut = new PrintWriter(System.out, true);

	/* Standard error stream */
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	/* Variables that contains the test objects */
	private Project first;
	private Project second;
	private Project third;
	private Project fourth;
	private Project[] empty;
	private Project[] array;
	private int nonProjectId;

	/**
	 * Tests methods of class {@link ProjectArray}
	 *
	 * @param args
	 *            not used
	 */
	public static void main(String args[]) {

		stdOut.println("");
		stdOut.println("Testing class ProjectArray...");

		TestProjectArray tester = new TestProjectArray();

		if (tester.testMakeArray() & tester.testCopyArray() & tester.testGetProject() & tester.testCountLowerPrice()
				& tester.testSumPrice() & tester.testGetLowestPrice() & tester.testIncreaseAll()
				& tester.testDisplayAll()) {
			stdOut.println("All tests passed");
		}
	}

	/**
	 * Displays a message in the standard error stream if the value specified by
	 * parameter <code>condition<code> is <code>false</code>.
	 *
	 * @param message
	 *            the error message.
	 * @param condition
	 *            the test condition.
	 * @return the value of <code>condition</code>
	 */
	public static boolean assertTrue(String message, boolean condition) {

		if (!condition) {
			stdErr.print("** Test failure ");
			stdErr.println(message);

			return false;
		} else {

			return true;
		}

	}

	/** Assign the initial value to the test variables */
	private void setUp() {

		first = new Project(101, "First", 1000.0);
		second = new Project(102, "Second", 100.0);
		third = new Project(103, "Third", 1000.0);
		fourth = new Project(104, "Fourth", 500.0);

		nonProjectId = 106;

		empty = new Project[0];

		array = new Project[4];
		array[0] = first;
		array[1] = second;
		array[2] = third;
		array[3] = fourth;
	}

	/**
	 * Tests the method <code>makeArray</code>.
	 *
	 * @return <code>true</code> if all test passed; otherwise returns
	 *         <code>false</code>.
	 */
	public boolean testMakeArray() {

		setUp();

		boolean test = true;

		Project[] result = ProjectArray.makeArray(first, second, third);

		test = test && assertTrue("1, testing method makeArray", result instanceof Project[]);
		test = test && assertTrue("2, testing method makeArray", result.length == 3);
		test = test && assertTrue("3, testing method makeArray", result[0].equals(first));
		test = test && assertTrue("4, testing method makeArray", result[1].equals(second));
		test = test && assertTrue("5, testing method makeArray", result[2].equals(third));

		return test;
	}

	/**
	 * Tests the method <code>copyArray</code>.
	 *
	 * @return <code>true</code> if all test passed; otherwise returns
	 *         <code>false</code>.
	 */
	public boolean testCopyArray() {

		setUp();

		boolean test = true;

		Project[] resultEmpty = ProjectArray.copyArray(empty);

		test = test && assertTrue("1, testing method copyArray", resultEmpty instanceof Project[]);
		test = test && assertTrue("2, testing method copyArray", resultEmpty.length == 0);

		Project resultArray[] = ProjectArray.copyArray(array);

		test = test && assertTrue("3, testing method copyArray", resultArray instanceof Project[]);
		test = test && assertTrue("4, testing method copyArray", resultArray.length == 4);
		test = test && assertTrue("5, testing method copyArray", resultArray[0] == first);
		test = test && assertTrue("6, testing method copyArray", resultArray[1] == second);
		test = test && assertTrue("7, testing method copyArray", resultArray[2] == third);
		test = test && assertTrue("8, testing method copyArray", resultArray[3] == fourth);

		return test;
	}

	/**
	 * Tests the method <code>getProject</code>.
	 *
	 * @return <code>true</code> if all test passed; otherwise returns
	 *         <code>false</code>.
	 */
	public boolean testGetProject() {

		setUp();

		boolean test = true;

		test = test && assertTrue("1, testing method getProject", ProjectArray.getProject(empty, nonProjectId) == null);

		Project project;

		project = ProjectArray.getProject(array, first.getId());
		test = test && assertTrue("2, testing method getProject", project != null && project.equals(first));
		project = ProjectArray.getProject(array, second.getId());
		test = test && assertTrue("3, testing method getProject", project != null && project.equals(second));
		project = ProjectArray.getProject(array, third.getId());
		test = test && assertTrue("4, testing method getProject", project != null && project.equals(third));
		project = ProjectArray.getProject(array, fourth.getId());
		test = test && assertTrue("5, testing method getProject", project != null && project.equals(fourth));
		test = test && assertTrue("6, testing method getProject", ProjectArray.getProject(array, nonProjectId) == null);

		return test;
	}

	/**
	 * Tests the method <code>countLowerPrice</code>.
	 *
	 * @return <code>true</code> if all test passed; otherwise returns
	 *         <code>false</code>.
	 */
	public boolean testCountLowerPrice() {

		setUp();

		boolean test = true;

		test = test && assertTrue("1, testing method countLowerPrice", ProjectArray.countLowerPrice(empty, 0.0) == 0);

		test = test && assertTrue("2, testing method countLowerPrice", ProjectArray.countLowerPrice(array, 0.0) == 0);
		test = test
				&& assertTrue("3, testing method countLowerPrice", ProjectArray.countLowerPrice(array, 200.0) == 1);
		test = test && assertTrue("4, testing method countLowerPrice",
				ProjectArray.countLowerPrice(array, 100000.0) == 4);

		return test;
	}

	/**
	 * Tests the method <code>sumPrice</code>
	 *
	 * @return <code>true</code> if all test passed; otherwise returns
	 *         <code>false</code>.
	 */
	public boolean testSumPrice() {

		setUp();

		boolean test = true;

		test = test && assertTrue("1, testing method sumPrice", ProjectArray.sumPrice(empty) == 0.0);

		test = test && assertTrue("2, testing method sumPrice", ProjectArray.sumPrice(array) == first.getPrice()
				+ second.getPrice() + third.getPrice() + fourth.getPrice());

		return test;
	}

	/**
	 * Tests the method <code>getLowestPrice</code>
	 *
	 * @return <code>true</code> if test passed; otherwise returns
	 *         <code>false</code>.
	 */
	public boolean testGetLowestPrice() {

		setUp();

		boolean test = true;

		test = test && assertTrue("1, testing method getLowestPrice", ProjectArray.getLowestPrice(array) == 100);

		Project[] arrayTwo = new Project[5];
		arrayTwo[0] = new Project(101, "First", 2000.0);
		arrayTwo[1] = new Project(102, "Second", 100.0);
		arrayTwo[2] = new Project(103, "Third", 1000.0);
		arrayTwo[3] = new Project(104, "Fourth", 500.0);
		arrayTwo[4] = new Project(105, "Fifth", 500.0);

		test = test && assertTrue("2, testing method getLowestPrice", ProjectArray.getLowestPrice(arrayTwo) == 100);

		return test;
	}

	/**
	 * Tests the method <code>increaseAll</code>.
	 *
	 * @return <code>true</code> if all test passed; otherwise returns
	 *         <code>false</code>.
	 */
	public boolean testIncreaseAll() {

		setUp();

		boolean test = true;

		double amount = 100.0;
		double salaryFirst = first.getPrice();
		double salarySecond = second.getPrice();
		double salaryThird = third.getPrice();
		double salaryFourth = fourth.getPrice();

		ProjectArray.increaseAll(array, amount);
		test = test && assertTrue("1, testing method increaseAll", array[0].getPrice() == salaryFirst + amount);
		test = test && assertTrue("2, testing method increaseAll", array[1].getPrice() == salarySecond + amount);
		test = test && assertTrue("3, testing method increaseAll", array[2].getPrice() == salaryThird + amount);
		test = test && assertTrue("4, testing method increaseAll", array[3].getPrice() == salaryFourth + amount);

		return test;
	}

	/**
	 * Tests the method <code>displayAll</code>.
	 *
	 * @return <code>true</code> if all test passed; otherwise returns
	 *         <code>false</code>.
	 */
	public boolean testDisplayAll() {

		setUp();

		boolean test = true;

		test = test && assertTrue("1, testing method displayAll", ProjectArray.displayAll(empty).equals(""));

		String result = ProjectArray.displayAll(array);

		test = test && assertTrue("2, testing method displayAll", ProjectArray.displayAll(array).equals(
				first.toString() + "\n" + second.toString() + "\n" + third.toString() + "\n" + fourth.toString()));

		return test;
	}
}