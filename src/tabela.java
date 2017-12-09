import javax.script.ScriptException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.Map.Entry;

import javax.swing.*;

public class tabela extends DefaultTableModel {
	
    static String nagl[] = new String[10];
	static String body[][] = new String[4][4];
	static int row = 0; 
	static int columns = 0;
	static String Tyt = "";
	static String f = "";
    final Map<String,Object> vals = new HashMap<String,Object>();

    public tabela (int rowCount, int columnCount) {
        super(rowCount, columnCount);
//        super("wczytywanie pliku");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 //       setVisible(true);
 //       pack();
    }

    @Override
    public Object getValueAt(int row, int columns) {
            Object obj = super.getValueAt(row, columns);
           
            if(obj==null) return "";
           
            String v = obj.toString();
            if(v.startsWith("="))
                    return eval(v);
            else
                    return v;
           
    }
   
    private void linkEvents(){
        
        ListSelectionListener listener = new ListSelectionListener(){
                @Override
                public void valueChanged(ListSelectionEvent e) {
                 int col=MEM.tab.getSelectedColumn();     
                 int row = MEM.tab.getSelectedRow();
                 if(col<0 || row<0) return;
//                 evalField.setText(MEM22.model.getFormula(row, col)+"");
               
                }       
};
       
	MEM.tab.getColumnModel().getSelectionModel()
.addListSelectionListener(listener);
	MEM.tab.getSelectionModel().addListSelectionListener(listener);
              
}
    
    
    private Object eval(final String formula){
        String f = formula.substring(1).toUpperCase();
//        Map<String, Object> vals = MEM22.model.getVals();
        Set<Entry<String, Object>> es = vals.entrySet();

               return "";    
       }
    
    public Object getFormula(int row, int columns){
     return super.getValueAt(row, columns);
    }

    @Override
    public void setValueAt(Object value, int row, int columns) {
            super.setValueAt(value, row, columns);
            String k =Character.toString((char) (columns+65))+""+(row+1);
            try{
             double d = Double.parseDouble(value+"");
             vals.put(k,d);
            }catch(Exception e){
                    vals.put(k, ""+value);
            }
           
            MEM.tab.repaint();
           
    }
    
    public Map<String,Object> getVals(){
        return vals;   
       }
    
    public static void main(String[] args) {
		new tabela(row, columns);
    }
    
    //wczytanie danych iz pliku *.MEM
    public static void file(String f) throws IOException {
		row = 0;
		columns =0;
		body = new String[20][20];

    		// czytanie pliku
    		FileReader fr = new FileReader(f);
    		BufferedReader br = new BufferedReader(fr);
    		String s;

    		while((s = br.readLine()) != null)
    			{
    	        boolean starts2 = s.startsWith("<body>");

    			if (starts2 == true){
    				String splited = s.substring(6,s.length()-7); 
        			row++;
    			}
    			}
    		fr.close();


    		body = new String[row][columns];
    		row = 0;
    		columns =0;
        		// czytanie pliku
        		FileReader fr2 = new FileReader(f);
        		BufferedReader br2 = new BufferedReader(fr2);
        		String s2;

        		while((s2 = br2.readLine()) != null)
        			{
        //			System.out.println(s2);
        	        boolean starts = s2.startsWith("<title>");
        	        boolean starts1 = s2.startsWith("<head>");
        	        boolean starts2 = s2.startsWith("<body>");

        			if (starts == true){
        				Tyt = s2.substring(7,s2.length()-8);
        			}
        			if (starts1 == true){
        				String splited = s2.substring(6,s2.length()-7); 
        				nagl = splited.split("/");
        				columns = splited.split("/").length;
        			}
        			if (starts2 == true){
        				String splited = s2.substring(6,s2.length()-7); 
        			//wyciagnięcie poszczególnych komórek tabeli
        				body[row] = splited.split("/");
        	//    		System.out.println(body[row][0]);
            			row++;
        			}
        			}
    		fr2.close();
    	}
}