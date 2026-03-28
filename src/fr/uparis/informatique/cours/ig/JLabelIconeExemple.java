package fr.uparis.informatique.cours.ig;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class JLabelIconeExemple implements Runnable {
	public void run() {
		JFrame maJFrame = new JFrame("Me voici!");
		ImageIcon i = Utils.imageFrom("images/coucou.gif");
		JLabel monLabel = new JLabel("Coucou, je suis là",i,SwingConstants.LEFT);
		maJFrame.getContentPane().add(monLabel);
		maJFrame.pack();
		maJFrame.setVisible(true);
	}
	public static void main(String []argv) {
		SwingUtilities.invokeLater(new JLabelIconeExemple());	
	}
}