package fr.uparis.informatique.cours.ig.layouts;
import javax.swing.*;
import java.awt.*;

public class FlowLayoutExemple {
  public static void createUI() {
    JFrame fenetre = new JFrame(FlowLayoutExemple.class.toString());
    fenetre.getContentPane().setLayout(new FlowLayout());
    for (int i=0; i<10; i++) {
      JButton b = new JButton("Bouton "+i);
      fenetre.getContentPane().add(b);
    }
    fenetre.pack(); // rangement «optimal»
    fenetre.setVisible(true);
  }
  public static void main(String []argv) {
    SwingUtilities.invokeLater(FlowLayoutExemple::createUI);	
  }
}
