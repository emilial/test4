import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class file{

public file(String File, String Title, int Rows, int Columns, String[] Head, String[][] Tab) throws IOException {
	
	startStr = new java.lang.String();
	title = new java.lang.String();
	String[] head = null;
	String tab[][] = new String[500][500];
	int rows = 0; 
	int columns = 0;

	File = "tab.MEM";
		// czytanie pliku
		FileReader fr = new FileReader(File);
		BufferedReader br = new BufferedReader(fr);
		String s;

		while((s = br.readLine()) != null)
			{
//			System.out.println(s);
			
	        boolean starts = s.startsWith("<title>");
	        boolean starts1 = s.startsWith("<head>");
	        boolean starts2 = s.startsWith("<body>");

			if (starts == true){
//				System.out.println("true title ");
				title = s.substring(7,s.length()-8);
//				System.out.println(title);
			}

			if (starts1 == true){
//				System.out.println("true head ");
				
				String splited = s.substring(6,s.length()-7); 
				head = splited.split("/");
				for (int i = 0 ; i < head.length ; i++) {
//				    System.out.println(head [i]);
//				    System.out.println(head.length);
				}
				columns = head.length;
			}

			if (starts2 == true){
//				System.out.println("true body ");
			
				String splited = s.substring(6,s.length()-7); 
			//wyciagnięcie poszczególnych komórek tabeli

				tab[rows] = splited.split("/");

//				System.out.println(rows);  
				for (int i = 0 ; i < columns ; i++) {
//					System.out.println(tab[0][i]);
//					System.out.println(tab[rows][i]);
				}
			rows++;
			}
			
			}
		fr.close();
	}
public static void main(String[] a) throws IOException {
	  file dlg = new file(file, title, rows, columns, head, tab);
}

//deklaracje zmiennych
public java.lang.String startStr;
public static java.lang.String title;
public static java.lang.String file;
public static String tab[][];
public static String head[];
public static int columns;
public static int rows;
}
