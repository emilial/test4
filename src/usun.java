import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class usun extends JDialog {
	static String str1;
	public static String str2, str3;
	
  public usun(JFrame parent, String title, String message, String str1, String str2) {
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds( (screenSize.width-1000)/2, (screenSize.height-600)/2, 100, 100);
//    setSize (400,600);
 str3=str2;
    
    JPanel pane = new JPanel();
    pane.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	c.fill = GridBagConstraints.HORIZONTAL;
	    
	JLabel przerwa;
	przerwa = new JLabel(" ");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 1;
    pane.add(przerwa, c);
    
    JLabel il_w;
    il_w = new JLabel("Czy na pewno chcesz usunąć"+str1+"?");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 2;
    pane.add(il_w, c);
    
	JLabel przerwa2 = new JLabel(" ");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 3;
    pane.add(przerwa2, c);
      
    getContentPane().add(pane, BorderLayout.NORTH);


    JPanel buttonPane = new JPanel();
    JButton button = new JButton("Usuń"); 
    JButton button2 = new JButton("Anuluj"); 
    buttonPane.add(button); 
    buttonPane.add(button2);     
    button.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	UactionPerformed(evt);
        }
    });
    button2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            button2ActionPerformed(evt);
        }
    });
    
    getContentPane().add(buttonPane, BorderLayout.SOUTH);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    pack(); 
    setVisible(true);
  }

  private void button2ActionPerformed(java.awt.event.ActionEvent evt) {
	    setVisible(false); 
	    dispose();
  }
  
  public static void main(String[] a) {
	  usun dlg = new usun(new JFrame(), "", "",str1,str3);
  }
  
  public void UactionPerformed(ActionEvent e) {
	  String disp = "Usunięto zaznaczon"+str3;
	  if (str3 == "y wiersz") 
		  MEM.usun_w();
	  if (str3 == "ą kolumnę")
		  MEM.usun_k();
	  button2ActionPerformed(null);
	  JOptionPane.showMessageDialog(null, disp);
	}
}

