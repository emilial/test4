
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

public class tyt_modyf extends JDialog {
	
	public static Object tytulT;
	static JTextField tytul;
	public String disp, Tyt = "";
	private String title;
	
  public tyt_modyf(JFrame parent, String title, String message) {
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
  
	przerwa = new JLabel(" ");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 2;
    pane.add(przerwa, c);
   
    JLabel tytulT;
    tytulT = new JLabel("   Nowy tytuł tabeli: ");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 3;
    pane.add(tytulT, c);
    
    tytul = new JTextField(title, 30);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 2;
	c.gridy = 3;
    pane.add(tytul, c);
    
    przerwa = new JLabel(" ");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 6;
    pane.add(przerwa, c);
    	
	
    getContentPane().add(pane);
	
    JPanel buttonPane = new JPanel();
    JButton button = new JButton("Zmień"); 
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
	  tyt_modyf dlg = new tyt_modyf(new JFrame(), title, "message");
  }
  
  public void UactionPerformed(ActionEvent e) {
		Tyt = tytul.getText();
		
		if ((Tyt != null) && (Tyt.length() > 0)) {
			disp = "Zmieniono tytuł na: " + tytul.getText();
			MEM.refreshTyt(tytul.getText());
		} else  {
			disp = "Pole nie może pozostać puste !";
		}
		JOptionPane.showMessageDialog(null, disp);
		button2ActionPerformed(null);
	}
}