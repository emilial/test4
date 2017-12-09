import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class zamknij extends JDialog {
  public zamknij(JFrame parent, String title, String message) {
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds( (screenSize.width-1000)/2, (screenSize.height-600)/2, 100, 100);

    JPanel messagePane = new JPanel();
    messagePane.add(new JLabel(message));
    getContentPane().add(messagePane);
    JPanel buttonPane = new JPanel();
    JButton button = new JButton("TAK"); 
    JButton button2 = new JButton("NIE"); 
    buttonPane.add(button); 
    buttonPane.add(button2);     
    button.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonActionPerformed(evt);
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
  
  private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_element2ActionPerformed
	    setVisible(false); 
	    System.exit(0);
  }
  private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_element2ActionPerformed
	    setVisible(false); 
	    dispose();
  }
  
  public static void main(String[] a) {
	  zamknij dlg = new zamknij(new JFrame(), "title", "message");
  }
}