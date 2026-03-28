package fr.uparis.informatique.cours.ig.layouts;
import javax.swing.*;
import java.awt.*;

public class OverlayLayoutExemple {
  public static void createUI() {
    JFrame fenetre = new JFrame(OverlayLayoutExemple.class.toString());
    Container c = fenetre.getContentPane();
    OverlayLayout overlayLayout = new OverlayLayout(c);
    c.setLayout(overlayLayout);

    c.add(new JButton("ok"));
    c.add(new JButton("l'ombre de ta main"));
    c.add(new JButton("You jumped in front of my car when you"));
    
    fenetre.pack(); // rangement «optimal»
    fenetre.setVisible(true);
  }
  public static void main(String []argv) {
    SwingUtilities.invokeLater(OverlayLayoutExemple::createUI);	
  }
}
