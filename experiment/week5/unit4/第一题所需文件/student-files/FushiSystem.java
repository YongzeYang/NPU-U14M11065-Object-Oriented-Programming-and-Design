
import java.io.*;
import java.util.Iterator;
import java.util.Random;

/**
 * This class implements a retest system.
 *
 * @author liYX&YangYY
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
 * @see FileFushiTestDatabaseLoader
 * @see FushiTestDatabaseLoader
 * @see StudentsFormatter
 * @see PlainTextStudentsFormatter
 * @see HTMLStudentsFormatter
 * @see XMLStudentsFormatter
 */
public class FushiSystem {

	private static BufferedReader stdIn =
			new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut =
			new PrintWriter(System.out, true);
	private static PrintWriter stdErr =
			new PrintWriter(System.err, true);

	private StudentCatalog studentCatalog;

	private static TestDatabase testDatabase;

	private StudentsFormatter studentsFormatter;

	/**
	 * Loads the information of the student catalog and the test database and starts
	 * the application.
	 * <p>
	 * The name of the file is specified in the command arguments
	 * </p>
	 *
	 * @param args String arguments.
	 * @throws IOException if there are errors in the input.
	 */
	public static void main(String[] args) throws IOException {

		if (args.length != 1) {
			stdErr.println("Usage: java FushiSystem filename");
		} else {

			TestDatabase testDatabase = null;

			try {
				FushiTestDatabaseLoader loader =
						new FileFushiTestDatabaseLoader();

				testDatabase = loader.loadTestDatabase(args[0]);
			} catch (FileNotFoundException fnfe) {
				stdErr.println("The file does not exist");

				System.exit(1);

			} catch (DataFormatException dfe) {
				stdErr.println("The file contains malformed data: "
						+ dfe.getMessage());

				System.exit(1);
			}

			FushiSystem  app = new FushiSystem(testDatabase);

			app.run();
		}
	}

	/**
	 * Constructs a <code>FushiSystem</code> object. Initialize the student catalog
	 * and the test database with the values specified in the parameters.
	 */
	public FushiSystem(TestDatabase initialTestDatabase) {

		this.testDatabase = initialTestDatabase;
		this.studentCatalog = loadStudent();

		studentsFormatter =
				PlainTextStudentsFormatter.getSingletonInstance();
	}

	/**
	 * Loads the information of a student catalog.
	 */
	private static StudentCatalog loadStudent() {
		StudentCatalog studentCatalog = new StudentCatalog();

		studentCatalog.addStudent(new Student("2019213001", "Wu Guangsheng"));
		studentCatalog.addStudent(new Student("2019213002", "Chen Shengdian"));
		studentCatalog.addStudent(new Student("2019213003", "Liu Zihao"));
		studentCatalog.addStudent(new Student("2019213004", "Chou Li"));
		studentCatalog.addStudent(new Student("2019213005", "Zheng Xize"));
		studentCatalog.addStudent(new Student("2019213006", "Li Mengqi"));
		studentCatalog.addStudent(new Student("2019213007", "Wang Zhi"));
		studentCatalog.addStudent(new Student("2019213008", "Zhang Tianyi"));
		studentCatalog.addStudent(new Student("2019213009", "Zhou Linlin"));
		studentCatalog.addStudent(new Student("2019213010", "Zhou Shuang"));
		studentCatalog.addStudent(new Student("2019213011", "Zhang Han"));
		studentCatalog.addStudent(new Student("2019213012", "Li Yiran"));
		studentCatalog.addStudent(new Student("2019213013", "Meng Zitao"));
		studentCatalog.addStudent(new Student("2019213014", "La Zhiao"));
		studentCatalog.addStudent(new Student("2019213015", "Zhang Yiming"));
		studentCatalog.addStudent(new Student("2019213016", "Li Hua"));
		studentCatalog.addStudent(new Student("2019213017", "Leng Ziqing"));
		studentCatalog.addStudent(new Student("2019213018", "Jin Can"));
		studentCatalog.addStudent(new Student("2019213019", "Zhu Wenjie"));
		studentCatalog.addStudent(new Student("2019213020", "Liu Meihan"));

		for (Student student : studentCatalog) {
			generateExamPaper(student);
		}

		return studentCatalog;
	}

	/**
	 * Presents the user with a menu of options and processes the selection.
	 */
	private void run() throws IOException {

		int  choice = getChoice();

		while (choice != 0) {

			switch (choice) {
				case 1:
					displayStudentCatalog();
					break;
				case 2:
					this.studentsFormatter = PlainTextStudentsFormatter.getSingletonInstance();
					writeFile(readFileName(), this.studentsFormatter.formatStudents(this.studentCatalog));
					break;
				case 3:
					this.studentsFormatter = HTMLStudentsFormatter.getSingletonInstance();
					writeFile(readFileName(), this.studentsFormatter.formatStudents(this.studentCatalog));
					break;

				case 4:
					this.studentsFormatter = XMLStudentsFormatter.getSingletonInstance();
					writeFile(readFileName(), this.studentsFormatter.formatStudents(this.studentCatalog));
					break;
				default:

					break;
			}

			choice = getChoice();
		}
	}

	/** Validates the user's choice. */
	private int getChoice() throws IOException {

		int  input;

		do  {
			try  {
				stdErr.println();
				stdErr.print("[0]  Quit\n"
						+ "[1]  Display student catalog\n"
						+ "[2]  Save test database (plain text)\n"
						+ "[3]  Save test database (HTML)\n"
						+ "[4]  Save test database (XML)\n"
						+ "choice> ");
				stdErr.flush();

				input = Integer.parseInt(stdIn.readLine());

				stdErr.println();

				if (0 <= input && 4 >= input)  {
					break;
				} else {
					stdErr.println("Invalid choice:  " + input);
				}
			} catch (NumberFormatException  nfe)  {
				stdErr.println(nfe);
			}
		}  while (true);

		return  input;
	}

	/**
	 * Displays the catalog of students.
	 */
	private void displayStudentCatalog() {

		if (this.studentCatalog.getNumberOfStudents() == 0) {
			stdErr.println("The catalog of students is empty");
		} else {
			for (Student student : this.studentCatalog) {
				stdOut.println(student.toString());
			}
		}
	}

	/**
	 * Generate a random retest paper for the student.
	 */
	private static void generateExamPaper(Student student)  {

		if (testDatabase.getNumberOfTests() < 10) {
			stdErr.println("There are less than ten test questions in the test question bank, "
					+ "and the test paper cannot be generated.");
		} else {

			int[] testTypeNums = new int[3];
			for (int i = 0; i < testTypeNums.length; i++) {
				testTypeNums[i] = 0;
			}
			Iterator<Test> iterator = testDatabase.iterator();
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

			int allTestCount = testDatabase.getNumberOfTests();

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

	/*
	 * Prompts the user for a file name (the name of the file that
	 * will store the test database) and returns the user's
	 * response.
	 */
	private  String readFileName() throws IOException  {

		stdErr.print("File name> ");
		stdErr.flush();

		return stdIn.readLine();
	}

	/*
	 * Creates a new file (which has the specified name) and writes
	 * the specified string to the new file
	 */
	private void writeFile(String fileName, String content)
			throws IOException {

		/* PLACE YOUR CODE HERE */
			// to do
	}
}