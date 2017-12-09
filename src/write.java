import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class write {

	static void save (String string){
//		System.out.println(tab.getValueAt(0,0));
//		System.out.println(tab.getColumnName(0));
//		System.out.println(tytul_tab);

		try{
        BufferedWriter writer = new BufferedWriter(new FileWriter(string) );
        
        String s = MEM.label.getText();
        s = s.replace("                            Tytuł tabeli: ","");
        writer.write("<title>"+s+"</title>");
        writer.newLine();

//zapisanie zawartosci nagłówków 
        writer.write("<head>");
        for(int j=0;j<MEM.tab.getColumnCount();j++){
            String na = (String) MEM.tab.getColumnName(j);
            if(na.isEmpty())continue;
            if(j!=MEM.tab.getColumnCount()-1) writer.write(na+"/");
            else writer.write(na);
        	}
        	writer.write("</head>");
            writer.newLine();
            
//zapisanie zwartości poszczególnych komórek tabeli        
        for(int i=0;i<MEM.tab.getRowCount();i++ ){
        	for(int j=0;j<MEM.tab.getColumnCount();j++){
            String na = (String) MEM.tab.getValueAt(i, j);

            if(na.isEmpty())continue;
            if(j==0)writer.write("<body>");
            if(j!=MEM.tab.getColumnCount()-1) writer.write(na+"/");
            else writer.write(na);
        	}
        	writer.write("</body>");
            writer.newLine();
        }
        writer.close();   
    }
    catch(IOException e){   }
}

	public void write () {
	}

}
