import javax.script.ScriptException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.Map.Entry;
import javax.swing.*;

public class importT {

//public class tabela extends DefaultTableModel {
	
    static String nagl[] = new String[10];
	static String body[][] = new String[4][4];
	static int row = 0; 
	static int columns = 0;
	static String Tyt = "";
	static String f = "";
	static String f2;
    final Map<String,Object> vals = new HashMap<String,Object>();
    
    //wczytanie danych z pliku *.tex
    public static void file(String f) throws IOException {
//		System.out.println(" próba wczytania pliku "+f);

		row = 0;
		columns =0;
		body = new String[20][20];
		
		int t1 = 0,t2 = 0, k=0;
    		// czytanie pliku
    		FileReader fr = new FileReader(f);
    		BufferedReader br = new BufferedReader(fr);
    		String st;
    		String s;

    		while((st = br.readLine()) != null) {
    			s = st.trim();
    	        boolean starts2 = s.startsWith("\\title");
    			if (starts2 == true){
  			      
    				for(int i=0;i<s.length(); i++)
  			      {
  			         if(s.charAt(i)=='%') k=i;
  			      }
    				if (k==0)
    				for(int i=0;i<s.length(); i++)
    			      {
    			         if(s.charAt(i)=='{') t1=i;
    			         if(s.charAt(i)=='}') t2=i;
    			      }
    				else
        				for(int i=0;i<k; i++)
      			      {
      			         if(s.charAt(i)=='{') t1=i;
      			         if(s.charAt(i)=='}') t2=i;
      			      }
    			      
    				String splited = s.substring(t1+1,t2); 
 //   		        System.out.println(s);
//    		        System.out.println(splited);
    		        Tyt = splited;
    			}
    			starts2 = s.startsWith("\\begin{tabular}");

    			if (starts2 == true){
    				String s1 = s.replace("\\begin{tabular}",""); 
//    		        System.out.println(s1);

    				
    				for(int i=0;i<s1.length(); i++)
    			      {
    			         if(s1.charAt(i)=='%') k=i;
    			      }
      				if (k==0)
      				for(int i=0;i<s1.length(); i++)
      			      {
      			         if(s1.charAt(i)=='{') t1=i;
      			         if(s1.charAt(i)=='}') t2=i;
      			      }
      				else
          				for(int i=0;i<k; i++)
        			      {
        			         if(s1.charAt(i)=='{') t1=i;
        			         if(s1.charAt(i)=='}') t2=i;
        			      }
      				
    				String splited = s1.substring(t1+1,t2); 
 			       for (int i = 0; i < splited.length(); i++)
 			       {
 			    	   char r = splited.charAt(i);
 			    	   if(r== 'l' || r== 'r' || r== 'c')
 			    	   columns++;
 			       }
 			       
//    				System.out.println(splited);
//    		        System.out.println("kolumny "+columns);
    			}

    			starts2 = s.startsWith("\\");
    			boolean starts3 = s.startsWith("%");
    			
    			if (starts2 == false & starts3 == false & s.length ( ) > 0){
    				
  //  				System.out.println(s);
    			row++;
    			}
    			}
//			System.out.println("row "+row);

    		fr.close();

    		nagl = new String[columns];
    		body = new String[row-1][columns];
    		row = 0;
//	        System.out.println("kolumny "+columns);

    		//columns =0;
	        k=0;
        		// czytanie pliku
        		FileReader fr2 = new FileReader(f);
        		BufferedReader br2 = new BufferedReader(fr2);
        		String s2;

        		while((s2 = br2.readLine()) != null) {
        			s = s2.trim();
//        			System.out.println(columns);
        	        boolean starts2 = s.startsWith("\\");
        			boolean starts3 = s.startsWith("%");
        			
        			if (starts2 == false & starts3 == false & s.length ( ) > 0){
        				
        				s = s.replace("\\","");
        				s = s.replaceAll(" ","");

//        	        	System.out.println(s);
        				k=0;
        	        	for(int i=0;i<s.length(); i++)
      			      {
      			         if(s.charAt(i)=='%') k=i;
      			      }
        				String s1;
						if (k!=0) s1 = s.substring(0,k); 
						else s1 = s;
        				//System.out.println(k);
        	        	//System.out.println(s1);
       	
        	        	if(row == 0){ nagl = s1.split("&");
        	        	}
        	        	else{
                		body[row-1] = s1.split("&");
        	        	}
        	        	row++;
        			}
        			}
//	        	System.out.println("bog "+body[1][0]);

    		fr2.close();

    		String string = f;    		
    		String f2 = string.replace(".tex", "_impT.MEM");
    		
    		try{
    	        BufferedWriter writer = new BufferedWriter(new FileWriter(f2) );    	        
 
    	        writer.write("<title>"+Tyt+"</title>");
    	        writer.newLine();

    	//zapisanie zawartosci nagłówków 
    	        writer.write("<head>");

    	        for(int j=0;j<columns;j++){
    	            String na = (String) nagl[j];
    	            if(na.isEmpty())continue;
    	            if(j!=columns-1) writer.write(na+"/");
    	            else writer.write(na);
    	        	}
    	        	writer.write("</head>");
    	            writer.newLine();
    	            
    	//zapisanie zwartości poszczególnych komórek tabeli        
    	        for(int i=0;i<row-1;i++ ){
    	        	for(int j=0;j<columns;j++){
    	            String na = body[i][j];

    	            if(na.isEmpty())continue;
    	            if(j==0)writer.write("<body>");
    	            if(j!=columns-1) writer.write(na+"/");
    	            else writer.write(na);
    	        	}
    	        	writer.write("</body>");
    	            writer.newLine();
    	        }
    	        writer.close();   
    	    }
    	    catch(IOException e){   }
    	}   	
}