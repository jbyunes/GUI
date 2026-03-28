package fr.uparis.informatique.cours.ig;

import javax.swing.*;

public class JLabelExemple implements Runnable {
	public void run() {
		JFrame maJFrame = new JFrame("Me voici!");
		JLabel monLabel = new JLabel("Coucou, je suis là");
		maJFrame.getContentPane().add(monLabel);
		maJFrame.pack();
		maJFrame.setVisible(true);
	}
	public static void main(String []argv) {
		SwingUtilities.invokeLater(new JLabelExemple());	
	}
}