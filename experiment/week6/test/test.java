import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class test{
    public static void main(String[] args){
        FileReader fr = null;
		BufferedReader br = null;
		double[][] arrangers = new double[4][4];

		try {
			fr = new FileReader("arranger.dat");
			br = new BufferedReader(fr);

			String str = "";
            int iCount = 0;
			while ((str = br.readLine())!= null){
				int  jCount = 0;
				StringTokenizer line = new StringTokenizer(str,",");
				do{
                    arrangers[iCount][jCount] = Double.parseDouble(line.nextToken());
                    jCount ++ ;
				} while(line.hasMoreTokens());
                jCount = 0;
                iCount ++ ;
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				br.close();
				fr.close();
			} catch(IOException e)  {
				e.printStackTrace();
			}
		}

		 double[][] test = { { 4, 1, 4, 8 }, { 1, 1, 3, 2 },
		 { 2, 2, 5, 1 }, { 2, 2, 1, 4 } };
        
         for(int i = 0;i<4;i++)
            for(int j = 0; j<4; j++)
            System.out.println(" " + arrangers[i][j] + " ");

		

			FileWriter fw = null;
			try {
				fw = new FileWriter("final.dat");
	
				for(int iCount = 0; iCount < 4; iCount ++ ) {
					for(int jCount = 0; jCount < 4; jCount ++ ) {
						fw.write(test[iCount][jCount] + ", ");
					}
					fw.write("\n");
				}
	
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					fw.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
    }
}