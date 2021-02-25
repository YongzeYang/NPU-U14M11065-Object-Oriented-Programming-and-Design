import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * ����ʽ����
 * 
 * @author Administrator
 * @version 1.00
 */
public class Arranger {

	private static BufferedReader stdIn = new BufferedReader(
			new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	private double[][] arrangerMatrix;
	private double arrangerResult = 1.0;

	/**
	 * ����ʽ������򣬶���ʹ�á�,���ָ�������ļ�����������<br/>
	 * �ļ���ʽʾ����<br/>
	 * <li>4, 1, 4, 8</li> <li>1, 1, 3, 2</li> <li>2, 2, 5, 1</li> <li>2, 2, 1,
	 * 4</li>
	 * 
	 * @param args
	 *            ����ʽ�����ļ�
	 * @throws IOException
	 *             ����ȡ�û��������ʱ�׳�
	 */
	public static void main(String args[]) throws IOException {

		// double[][] arrangers = { { 4, 1, 4, 8 }, { 1, 1, 3, 2 },
		// { 2, 2, 5, 1 }, { 2, 2, 1, 4 } };
		if (args.length != 1) {
			stdErr.println("Usage: java arranger filename");
		} else {
			try {
				Arranger application = new Arranger();
				application.arrFunction(readFile(args[0]));
				application.run();
			} catch (IOException fnfe) {
				stdErr.println("The file does not exist or ");
				System.exit(1);
			}

		}

	}

	/**
	 * �չ��췽��
	 */
	public Arranger() {

	}

	/**
	 * ��ȡָ���������ļ����������ת������λ������
	 * 
	 * @param arrangerFileName
	 *            ����ʽ�������ļ�
	 * @return ��������ʽ���ݵĶ�ά����
	 * @throws IOException
	 */
	private static double[][] readFile(String arrangerFileName)
			throws IOException {
		//��д��Ĵ���

	}

	/**
	 * ������������ʽ���ļ���ʹ�á�,���ָ�
	 * 
	 * @param fileName
	 *            �ļ�����
	 * @throws IOException
	 */
	private void saveMatrix(String fileName) throws IOException {

		//��д��Ĵ���

	}

	/**
	 * �����û���ѡ��ִ����Ӧ����
	 */
	private void run() throws IOException {

		int choice = getChoice();

		while (choice != 0) {
			if (choice == 1) {
				displayMatrix();
			} else if (choice == 2) {
				saveMatrix(readFilename());
			} else if (choice == 3) {
				displayResult();
			}
			choice = getChoice();
		}
	}

	/**
	 * ��ʾ���˵���������û�������ѡ��
	 * 
	 * @return �����û�������ѡ��Χ��0��3֮��
	 * @throws IOException
	 */
	private int getChoice() throws IOException {

		int input;
		do {
			try {
				stdErr.println();
				stdErr.print("[0]  Quit\n" + "[1]  Display Matrix\n"
						+ "[2]  Save Matrix to File (Plain Text)\n"
						+ "[3]  Display Arranger Result\n" + "choice> ");
				stdErr.flush();

				input = Integer.parseInt(stdIn.readLine());

				stdErr.println();

				if (0 <= input && 3 >= input) {
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
	 * ����Guass ��ȥ���Ѵ�������ʽ������ת���������������ʽ������
	 * 
	 * @param ����ʽ��2ά����
	 */
	private void arrFunction(double[][] arrangers) {// 
		double k = 0;
		for (int p = 0; p < arrangers[0].length - 1; p++) {
			for (int r = p + 1; r < arrangers.length; r++) {
				k = arrangers[r][p] / arrangers[p][p];
				arrangers[r][p] = 0;
				for (int c = p + 1; c < arrangers[0].length; c++) {
					arrangers[r][c] = arrangers[r][c] - k * arrangers[p][c];
				}// u
			}// r
		}// c
		arrangerMatrix = new double[arrangers.length][arrangers[0].length];
		for (int i = 0; i < arrangers.length; i++) {
			for (int j = 0; j < arrangers[0].length; j++) {
				arrangerMatrix[i][j] = arrangers[i][j];
				if (i == j) {
					arrangerResult = arrangerResult * arrangers[i][j];
				}// �������Խ�����˵Ľ��
				// System.out.println (a[i][j]+" ");
			}// j
		}// i
	}

	/**
	 * ��ʾ�ó�������������ʽ
	 */
	private void displayMatrix() {
		stdOut.println();
		for (int i = 0; i < arrangerMatrix.length; i++) {
			for (int j = 0; j < arrangerMatrix[0].length; j++) {
				stdOut.print(arrangerMatrix[i][j] + " ");
			}// j
			stdOut.println();
		}// i
	}

	/**
	 * ��ʾ����ʽ������
	 */
	private void displayResult() {
		stdOut.println("The result is " + arrangerResult);
	}

	/**
	 * Prompts the user for a filename (the name of the file that will store the
	 * sales information) and returns the user's response.
	 * 
	 * @return name of a file
	 */
	private String readFilename() throws IOException {

		stdErr.print("Filename> ");
		stdErr.flush();
		return stdIn.readLine();
	}
}
