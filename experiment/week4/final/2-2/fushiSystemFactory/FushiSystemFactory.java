package fushiSystemFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Random;

/**
 * This class implements a retest system.
 *
 * @author liYX, YangYY, YangYongze(id:2019302768)
 * @version 1.1.0
 * @see EnglishTest
 * @see ExamPaper
 * @see MathTest
 * @see ProfessionalTest
 * @see Student
 * @see StudentCatalog
 * @see Test
 * @see TestDatabase
 * @see TestItem
 * @see HTMLStudentsFormatter
 * @see XMLStudentsFormatter
 * @see PlainTextStudentsFormatter
 * @see StudentsFormatter
 */
public class FushiSystemFactory {

	private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	private StudentCatalog studentCatalog;
	private TestDatabase testDatabase;
	private StudentsFormatter studentsFormatter;

	/**
	 * Loads the information of the student catalog and the test database and starts
	 * the application.
	 *
	 * @param args String arguments. Not used.
	 * @throws IOException if there are errors in the input.
	 */
	public static void main(String[] args) throws IOException {

		FushiSystemFactory app = new FushiSystemFactory();

		app.run();
	}

	/**
	 * Creates a <code>FushiSystem</code> object.
	 */
	public FushiSystemFactory() {

		testDatabase  = loadTestDatabase();
		studentCatalog = loadStudent();
		studentsFormatter = null;
	}

	/**
	 * Loads the information of a test database.
	 */
	private static TestDatabase loadTestDatabase() {

		TestDatabase testDatabase = new TestDatabase();

		testDatabase.addTest(new EnglishTest("E001", "Translate the following text into English.", 2,
				"Smooth, fluent and without language problems or wrong words", "C-E"));
		testDatabase.addTest(new EnglishTest("E002", "Translate the following article content.", 3,
				"Clear logic and no language problems", "E-C"));
		testDatabase.addTest(new EnglishTest("E003", "Choose the correct answer based on the content being played.", 3,
				"Correct answer", "Hearing"));
		testDatabase.addTest(new EnglishTest("E004", "Translate the following Chinese in English.", 2,
				"No grammatical errors", "C-E"));
		testDatabase.addTest(
				new EnglishTest("E005", "Translate the following English in Chinese.", 2, "Sentence fluent", "E-C"));
		testDatabase.addTest(new EnglishTest("E006", "Choose the correct answer based on contextual dialogue", 2,
				"Right", "Hearing"));
		testDatabase.addTest(
				new EnglishTest("E007", "Translate the following article content.", 3, "Smooth and fluent", "C-E"));
		testDatabase.addTest(new EnglishTest("E008", "Translate to Chinese", 3, "Complete translation", "E-C"));
		testDatabase.addTest(new EnglishTest("E009", "Listen to the dialogue and choose Xiao Ming’s weekend schedule.",
				3, "Correct answer", "Hearing"));
		testDatabase.addTest(new EnglishTest("E010", "Translate the following text into English.", 2,
				"Use the correct words and smooth", "C-E"));

		testDatabase.addTest(new MathTest("M001", "Find the inflection points of the following functions.", 2, "Right",
				"no image", "no"));
		testDatabase
				.addTest(new MathTest("M002", "Which of the following series converge?", 3, "Right", "no image", "no"));
		testDatabase.addTest(new MathTest("M003", "Find the differential equation of the following function.", 3,
				"Necessary problem-solving process", "no image",
				"The first step is to find the integral. The second step is to find the value of the constant c."));
		testDatabase.addTest(new MathTest("M004", "Find the angle between the two planes A and B.", 2, "Correct answer",
				"http://image.com/m004", "no"));
		testDatabase.addTest(new MathTest("M005", "Several extreme points in the figure below.", 3, "Right",
				"http://image.com/m005", "no"));
		testDatabase.addTest(new MathTest("M006", "Find the inflection points of the following functions.", 2, "Right",
				"no image", "no"));
		testDatabase.addTest(new MathTest("M007", "Find the differential equation of the following function.", 3,
				"Clear problem solving process and correct value", "no image",
				"Find the value of the constant b and the differential equation"));
		testDatabase
				.addTest(new MathTest("M008", "The area enclosed by the following curve and the coordinate axis is?", 1,
						"Correct answer", "http://image.com/m008", "no"));
		testDatabase.addTest(new MathTest("M009", "Find general solutions of differential equations.", 2,
				"The parameters are correct", "no image", "Find the value of the parameter"));
		testDatabase
				.addTest(new MathTest("M010", "Find the function f(x).", 2, "Right", "http://image.com/m009", "no"));

		testDatabase.addTest(new ProfessionalTest("P001", "What are the characteristics of JAVA language?", 1, "Right",
				"Name at least three of the characteristics", "no", "no image"));
		testDatabase.addTest(new ProfessionalTest("P002",
				"Fill in the following blanks to realize the calculation of the sum of the numbers between 1-200 that are not divisible by 5.",
				2, "Correct result at run", "Fill in the code in the blank.", "no", "http://image.com/p002"));
		testDatabase.addTest(new ProfessionalTest("P003", "The time complexity of the algorithm refers to?", 1,
				"Correct answer", "no", "no", "no image"));
		testDatabase.addTest(new ProfessionalTest("P004", "The number sequence bai is: 1,1,1,2,3,4,6,...", 3,
				"Correct result at run", "Calculation formula when filling in n.",
				"int main()\n" + "{int a[21]={0,1,1},i;\n" + " for(i=1;i<21;i++)\n"
						+ "   if(i<3) printf(\"%d \",a[i]);\n" + "     else printf(\"%d \",______);\n"
						+ " printf(\"\\n when n is 20：%d\\n\",a[20]);\n" + " return 0;\n" + "}",
				"no image"));
		testDatabase.addTest(new ProfessionalTest("P005",
				"The design of the database includes two aspects of design content, they are?", 2, "Similar in meaning",
				"no", "no", "no image"));
		testDatabase.addTest(new ProfessionalTest("P006", "The difference between java and c.", 2,
				"At least three points", "At least three points", "no", "no image"));
		testDatabase.addTest(new ProfessionalTest("P007", "The difference between process and thread.", 3,
				"At least three points", "At least three points", "no", "no image"));
		testDatabase.addTest(new ProfessionalTest("P008", "The time complexity of the following code is?", 1, "Right",
				"no", "no", "http://image.com/p008"));
		testDatabase.addTest(new ProfessionalTest("P009", "Benefits of thread pool.", 3, "Can name the key benefits",
				"no", "no", "no image"));
		testDatabase.addTest(new ProfessionalTest("P010", "Enter 5 numbers to find their maximum and average.", 3,
				"Correct result at run", "Time complexity cannot exceed n.)", "no", "no image"));

		return testDatabase;
	}

	/**
	 * Loads the information of a student catalog.
	 */
	private StudentCatalog loadStudent() {
		StudentCatalog studentCatalog = new StudentCatalog();

		studentCatalog.addStudent(new Student("2019213001", "吴广胜"));
		studentCatalog.addStudent(new Student("2019213002", "陈盛典"));
		studentCatalog.addStudent(new Student("2019213003", "刘子豪"));
		studentCatalog.addStudent(new Student("2019213004", "仇历"));
		studentCatalog.addStudent(new Student("2019213005", "郑西泽"));
		studentCatalog.addStudent(new Student("2019213006", "李梦琪"));
		studentCatalog.addStudent(new Student("2019213007", "王志"));
		studentCatalog.addStudent(new Student("2019213008", "张天一"));
		studentCatalog.addStudent(new Student("2019213009", "周琳琳"));
		studentCatalog.addStudent(new Student("2019213010", "周爽"));

		for (Student student : studentCatalog) {
			generateExamPaper(student);
		}

		return studentCatalog;
	}

	/**
	 * Presents the user with a menu of options and processes the selection.
	 */
	private void run() throws IOException {

		int choice = getChoice();

		while (choice != 0) {
			studentsFormatter = StudentsFormatterMaker.generateFormatter(choice);
			displayStudents();
			choice = getChoice();
		}
	}

	/** Validates the user's choice. */
	private int getChoice() throws IOException {

		int input;

		do {
			try {
				stdErr.println();
				stdErr.print("[0]  Quit\n" + "[1]  Display Plain Text\n" + "[2]  Display HTML\n"
						+ "[3]  Display XML\n" + "choice> ");
				stdErr.flush();

				input = Integer.parseInt(stdIn.readLine());

				stdErr.println();

				if (0 <= input && 8 >= input) {
					break;
				} else {
					stdErr.println("Invalid choice:  " + input);
				}
			} catch (NumberFormatException nfe) {
				stdErr.println(nfe);
			}
		} while (true);

		return input;
	}

	/**
	 * Generate a random retest paper for the student.
	 */
	private void generateExamPaper(Student student)  {

			if (this.testDatabase.getNumberOfTests() < 10) {
				stdErr.println("There are less than ten test questions in the test question bank, "
						+ "and the test paper cannot be generated.");
			} else {

				int[] testTypeNums = new int[3];
				for (int i = 0; i < testTypeNums.length; i++) {
					testTypeNums[i] = 0;
				}
				Iterator<Test> iterator = this.testDatabase.iterator();
				while (iterator.hasNext()) {
					Test test = iterator.next();
					if (test instanceof EnglishTest) {
						testTypeNums[0]++;
					} else if (test instanceof MathTest) {
						testTypeNums[1]++;
					} else if (test instanceof ProfessionalTest) {
						testTypeNums[2]++;
					}
				}

				if (testTypeNums[0] < 3 || testTypeNums[1] < 3 || testTypeNums[2] < 4) {
					stdErr.println("There are not enough English questions or math questions or professional "
							+ "questions in the test database.");
					return;
				}
				//采用随机生成试卷
				Random random = new Random();
				ExamPaper examPaper = new ExamPaper();

				for (int i = 0; i < testTypeNums.length; i++) {
					testTypeNums[i] = 0;
				}

				int allTestCount = this.testDatabase.getNumberOfTests();

				boolean[] testIsChoose = new boolean[allTestCount];

				while (examPaper.getNumberOfItems() < 10) {

					int target = random.nextInt(allTestCount);
					Test test = testDatabase.getTest(target);

					if (test instanceof EnglishTest) {
						if (testTypeNums[0] < 3 && (!testIsChoose[target])) {
							testTypeNums[0]++;
							examPaper.addTestItem(new TestItem(test, 0));
							testIsChoose[target] = true;
						}
					} else if (test instanceof MathTest) {
						if (testTypeNums[1] < 3 && (!testIsChoose[target])) {
							testTypeNums[1]++;
							examPaper.addTestItem(new TestItem(test, 0));
							testIsChoose[target] = true;
						}
					} else if (test instanceof ProfessionalTest) {
						if (testTypeNums[2] < 4 && (!testIsChoose[target])) {
							testTypeNums[2]++;
							examPaper.addTestItem(new TestItem(test, 0));
							testIsChoose[target] = true;
						}
					}

				}
				student.setExamPaper(examPaper);
			}
	}


	/**
	 * Displays the students in the current format.
	 */
	private void displayStudents() {

		stdOut.println(
				studentsFormatter.formatStudents(studentCatalog));
	}

}
