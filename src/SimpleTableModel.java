import java.util.HashMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

       // *********************************************************
        class SimpleTableModel extends DefaultTableModel{

                final Map<String,Object> vals = new HashMap<String,Object>();
               
                public SimpleTableModel(int rowCount, int columnCount) {
                        super(rowCount, columnCount);
                }
/*
                @Override
                public Object getValueAt(int row, int column) {
                        Object obj = super.getValueAt(row, column);
                       
                        if(obj==null) return "";
                       
                        String v = obj.toString();
                        if(v.startsWith("="))
               //                 return eval(v);
             //           else
                                return v;
                       
                }
               
                public Object getFormula(int row, int column){
                 return super.getValueAt(row, column);
                }

                @Override
                public void setValueAt(Object value, int row, int column) {
                        super.setValueAt(value, row, column);
                        String k =Character.toString((char) (column+65))+""+(row+1);
                        try{
                         double d = Double.parseDouble(value+"");
                         vals.put(k,d);
                        }catch(Exception e){
                                vals.put(k, ""+value);
                        }
                       
        //                table.repaint();
                       
                }
               
                public Map<String,Object> getVals(){
                 return vals;   
                }
         */      
        }
        // *********************************************************
    