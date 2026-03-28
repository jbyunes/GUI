package fr.uparis.informatique.cours.ig.layouts;
import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

public class GroupLayoutExemple implements Runnable {
  static private String [][]s = {
      { "Haricot", "Salade", "Petit pois" },
      { "Roquefort", "Fourme d'ambert", "Bleu d'auvergne" },
      { "Filet", "Macreuse", "Araignée" }
    };
  public void run() {
    JFrame fenetre = new JFrame(this.getClass().toString());
    Container c = fenetre.getContentPane();
    GroupLayout groupLayout = new GroupLayout(c);
    c.setLayout(groupLayout);

    JButton [][]b = new JButton[s.length][s[0].length];
    for (int i=0; i<s.length; i++) {
      for (int j=0; j<s[i].length; j++) {
        b[i][j] = new JButton(s[i][j]);
      }
    }
    
    SequentialGroup hsg = groupLayout.createSequentialGroup();
    for (int i=0; i<s.length; i++) {
      ParallelGroup pg = groupLayout.createParallelGroup();
      for (int j=0; j<s[i].length; j++) {
        pg.addComponent(b[i][j]);
      }
      hsg.addGroup(pg);
    }
    groupLayout.setHorizontalGroup(hsg);

    SequentialGroup vsg = groupLayout.createSequentialGroup();
    for (int j=0; j<s[0].length; j++) {
      ParallelGroup pg = groupLayout.createParallelGroup();
      for (int i=0; i<s.length; i++) {
        pg.addComponent(b[i][j]);
      }
      vsg.addGroup(pg);
    }
    groupLayout.setVerticalGroup(vsg);
    
    
    fenetre.pack(); // rangement «optimal»
    fenetre.setVisible(true);
  }
  public static void main(String []argv) {
    SwingUtilities.invokeLater(new GroupLayoutExemple());	
  }
}
