import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class writeTex {

	static void save (String string){
//		System.out.println(tab.getValueAt(0,0));
//		System.out.println(tab.getColumnName(0));
//		System.out.println(tytul_tab);

		try{
        BufferedWriter writer = new BufferedWriter(new FileWriter(string) );
        
        
        writer.write("\\documentclass[11pt,a4paper]{article}");
        writer.newLine();
        writer.write("\\usepackage{polski}");
        writer.newLine();
        writer.write("\\usepackage[utf8]{inputenc} ");
        writer.newLine();
        writer.write("\\usepackage[utf8]{inputenc} ");
        writer.newLine();

        
        String s = MEM.label.getText();
        s = s.replace("                            Tytuł tabeli: ","");
        writer.write("\\title{"+s+"}");
        writer.newLine();
        writer.write("\\author{} ");
        writer.newLine();
        writer.write("\\date{} ");
        writer.newLine();
        writer.write("\\begin{document} ");
        writer.newLine();
        writer.write("\\maketitle ");
        writer.newLine();  
        writer.write("\\begin{tabular}{|");
        for(int j=0;j<MEM.tab.getColumnCount();j++){
            String na = "l|";
            writer.write(na);
        }

        writer.write("} ");
        writer.newLine();
        writer.write("\\hline ");
        writer.newLine();
        
        
//zapisanie zawartosci nagłówków 
//        writer.write("<head>");
        for(int j=0;j<MEM.tab.getColumnCount();j++){
            String na = (String) MEM.tab.getColumnName(j);
            if(na.isEmpty())continue;
            if(j!=MEM.tab.getColumnCount()-1) writer.write(na+" & ");
            else writer.write(na);
        	}
    		writer.write(" \\\\");
        	writer.newLine();
            writer.write("\\hline ");
            writer.newLine();
            
//zapisanie zwartości poszczególnych komórek tabeli        
        for(int i=0;i<MEM.tab.getRowCount();i++ ){
        	for(int j=0;j<MEM.tab.getColumnCount();j++){
            String na = (String) MEM.tab.getValueAt(i, j);

            if(na.isEmpty())continue;
 //           if(j==0)writer.write("<body>");
            if(j!=MEM.tab.getColumnCount()-1) writer.write(na+" & ");
            else writer.write(na);
        	}
        	writer.write(" \\\\");
            writer.newLine();
        }
        writer.write("\\hline ");
        writer.newLine();  
        writer.write("\\end{tabular}");
        writer.newLine();
        writer.write("\\end{document} "); 
        
        writer.close();   
    }
    catch(IOException e){   }
}

	public void writeTex () {
	}
}
