
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

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class nagl_modyf extends JDialog {
	
	public static Object tytulT;
    static JTextField nag[] = new JTextField[tabela.columns];
	public String disp = "";
	private int j;
	private JTextField col_$i; 
	
  public nagl_modyf(JFrame parent, String title, String message) {
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds( (screenSize.width-1000)/2, (screenSize.height-600)/2, 100, 100);
    
    
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
   
    JLabel tytulT;
    tytulT = new JLabel("   Edytuj zawartość nagłówków: ");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 3;
    pane.add(tytulT, c);
    
    for (int $i = 0; $i<tabela.columns; $i++){
//		System.out.println("kolumny"+tabela.columns);

 //   	final JTextField col_$i;
    	nag[$i] = new JTextField(tabela.nagl[$i], 30);		
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx = 2;
    	c.gridy = 4+$i;
    	pane.add(nag[$i], c);
    	j=$i;
//        System.out.println(nag[$i].getText());
    }
	
    getContentPane().add(pane);
	
    JPanel buttonPane = new JPanel();
    JButton button = new JButton("Zatwierdź"); 
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
  
  public void main(String[] a) {
	  nagl_modyf dlg = new nagl_modyf(new JFrame(),"", "message");
  }
  
  public void UactionPerformed(ActionEvent e) {
//		Tyt = col_$i.getText();
      //System.out.println(nag[$j].getText()+"khdfkyhgfjy");

	    for (int $i = 0; $i<tabela.columns; $i++){
			tabela.nagl[$i] = nag[$i].getText();
	    	j=$i;
//	        System.out.println(nag[$i].getText());

	    }
			disp = "Zapisano zmiany";
		MEM.refreshNagl("j");

		JOptionPane.showMessageDialog(null, disp);
		button2ActionPerformed(null);
	}
}
