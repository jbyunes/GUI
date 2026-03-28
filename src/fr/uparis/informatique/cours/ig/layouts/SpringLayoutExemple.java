package fr.uparis.informatique.cours.ig.layouts;
import javax.swing.*;
import java.awt.*;

public class SpringLayoutExemple {
  public static void createUI() {
    JFrame fenetre = new JFrame(SpringLayoutExemple.class.toString());
    Container c = fenetre.getContentPane();
    SpringLayout springLayout = new SpringLayout();
    c.setLayout(springLayout);

    JButton b0 = new JButton("ok");
    c.add(b0);
    JButton b1 = new JButton("l'ombre de ta main");
    c.add(b1);
    JTextField b2 = new JTextField("You jumped in front of my car when you");
    c.add(b2);

    Spring sp = Spring.constant(50);
    springLayout.putConstraint(SpringLayout.WEST,b0,5,SpringLayout.WEST,c);
    springLayout.putConstraint(SpringLayout.WEST,b1,sp,SpringLayout.EAST,b0);
    springLayout.putConstraint(SpringLayout.WEST,b2,15,SpringLayout.EAST,b1);
    springLayout.putConstraint(SpringLayout.EAST,c,15,SpringLayout.EAST,b2);

    springLayout.putConstraint(SpringLayout.NORTH,b0,5,SpringLayout.NORTH,c);
    springLayout.putConstraint(SpringLayout.NORTH,b1,5,SpringLayout.NORTH,c);
    springLayout.putConstraint(SpringLayout.NORTH,b2,5,SpringLayout.NORTH,c);
    springLayout.putConstraint(SpringLayout.SOUTH,c,50,SpringLayout.SOUTH,b2);
    
    fenetre.pack();
    fenetre.setVisible(true);
  }
  public static void main(String []argv) {
    SwingUtilities.invokeLater(SpringLayoutExemple::createUI);	
  }
}
