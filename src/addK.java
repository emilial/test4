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

public class addK extends JDialog implements ActionListener{
	
	private JComboBox phaseChoices = null;
    private JComboBox wyborBox=null;
	JTextField tytul, il_kolumn;
	String disp, Tyt= "";
	static int IL_k;
	
	static String vor = "przed";
	static String after = "po";
	static int value = 0;
	
  public addK(JFrame parent, String title, String message) {
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds( (screenSize.width-1000)/2, (screenSize.height-600)/2, 100, 100);
//    setSize (400,600);
    
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
    
    JLabel il_k;
    il_k = new JLabel("Ilość kolumn: ");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 2;
    pane.add(il_k, c);
    
    il_kolumn = new IntegerField(5);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 2;
	c.gridy = 2;
    pane.add(il_kolumn, c);
      
    getContentPane().add(pane, BorderLayout.NORTH);

    value = 0; 
    JRadioButton vorButton = new JRadioButton(vor);
    vorButton.setMnemonic(KeyEvent.VK_B);
    vorButton.setActionCommand(vor);
    vorButton.setSelected(true);
    JRadioButton afterButton = new JRadioButton(after);
    afterButton.setMnemonic(KeyEvent.VK_C);
    afterButton.setActionCommand(after);
    afterButton.setSelected(true);


    // zgrupowanie radio buttons
    ButtonGroup group = new ButtonGroup();
    group.add(vorButton);
    group.add(afterButton);

    // rejestracja słuchacza
    // rejestracja słuchacza
    // rejestracja słuchacza
    vorButton.addActionListener(this);
    afterButton.addActionListener(this);

    // ustawienie radio buttons w kolumnie na panelu
    JPanel radioPanel = new JPanel(new GridBagLayout());
    radioPanel.add(vorButton);
    radioPanel.add(afterButton);

    getContentPane().add(radioPanel, BorderLayout.CENTER);
    
    //hfhfhfhdrtfhrs
    
    JPanel buttonPane = new JPanel();
    JButton button = new JButton("Dodaj"); 
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
	  addK dlg = new addK(new JFrame(), "title", "message");
  }
  public void actionPerformed(ActionEvent e) {
//		System.out.println(e.getActionCommand());
		if (e.getActionCommand()=="po") value = 1;
		else value = 0;
//		System.out.println(value);
	}
  
  public void UactionPerformed(ActionEvent e) {
		IL_k = ((IntegerField) il_kolumn).getInt();
		
		if ( (il_kolumn.getText() != null) && (il_kolumn.getText().length() > 0)) {
			disp = "Dodano " + IL_k+" kolumn.";
			MEM.dodaj_k();

	        button2ActionPerformed(null);
		} else  {
			disp = "Pole `ilość kolumn` nie może pozostać puste !";
		}
		JOptionPane.showMessageDialog(null, disp);
	}
}

