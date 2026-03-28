package fr.uparis.informatique.cours.ig;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JButtonExemple implements Runnable {
	public void run() {
		JFrame maJFrame = new JFrame("Me voici!");
		JButton monBouton = new JButton("Cliquez-moi!");
		maJFrame.getContentPane().add(monBouton);
		maJFrame.pack();
		maJFrame.setVisible(true);
	}
	public static void main(String []argv) {
		SwingUtilities.invokeLater(new JButtonExemple());	
	}
}