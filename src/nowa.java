import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class nowa extends JDialog {
	
	static JTextField tytul;
	JTextField il_wiersz, il_kolumn;
	String disp, Tyt = "";
	static int IL_w;
	static int IL_k;
	
  public nowa(JFrame parent, String title, String message) {
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds( (screenSize.width-1000)/2, (screenSize.height-600)/2, 100, 100);
//    setSize (400,600);
    
    JPanel pane = new JPanel();
    pane.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	c.fill = GridBagConstraints.HORIZONTAL;
	
	JLabel wiadomosc;
	wiadomosc = new JLabel(message);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 0;
    pane.add(wiadomosc, c);
    
	JLabel przerwa;
	przerwa = new JLabel(" ");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 1;
    pane.add(przerwa, c);
  
	przerwa = new JLabel(" ");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 2;
    pane.add(przerwa, c);
   
    JLabel tytulT;
    tytulT = new JLabel("Tytuł tabeli: ");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 3;
    pane.add(tytulT, c);
    
    tytul = new JTextField("Nowa tabela", 25);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 2;
	c.gridy = 3;
    pane.add(tytul, c);
    
    JLabel il_w;
    il_w = new JLabel("Ilość wierszy: ");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 4;
    pane.add(il_w, c);
    
    il_wiersz = new IntegerField(3);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 2;
	c.gridy = 4;
    pane.add(il_wiersz, c);
    	
    JLabel il_k;
    il_k = new JLabel("Ilość kolumn: ");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 5;
    pane.add(il_k, c);
    
    il_kolumn = new IntegerField(3);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 2;
	c.gridy = 5;
    pane.add(il_kolumn, c);
    
    przerwa = new JLabel(" ");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 6;
    pane.add(przerwa, c);
    	
	
    getContentPane().add(pane);
	
    JPanel buttonPane = new JPanel();
    JButton button = new JButton("Utwórz"); 
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
  
  private void buttonActionPerformed(java.awt.event.ActionEvent evt) {
	    setVisible(false);
	    dispose();
  }
  private void button2ActionPerformed(java.awt.event.ActionEvent evt) {
	    setVisible(false); 
	    dispose();
  }
  
  public static void main(String[] a) {
	  nowa dlg = new nowa(new JFrame(), "title", "message");
  }
  
  public void UactionPerformed(ActionEvent e) {
		Tyt = tytul.getText();
		IL_w = ((IntegerField) il_wiersz).getInt();
		IL_k = ((IntegerField) il_kolumn).getInt();
		
		if ((Tyt != null) && (Tyt.length() > 0)
				&& (il_wiersz.getText() != null) && (il_wiersz.getText().length() > 0)
				&& (il_kolumn.getText() != null) && (il_kolumn.getText().length() > 0)) {
			disp = "Utworzono nową tabelę.\nTytuł: " + tytul.getText()+" \nWymiary: "+IL_w+" x "+IL_k;	
			MEM.create_newT();
	        buttonActionPerformed(null);

		} else  {
			disp = "Żadne pole nie może pozostać puste !";
		}
		JOptionPane.showMessageDialog(null, disp);
	}
}