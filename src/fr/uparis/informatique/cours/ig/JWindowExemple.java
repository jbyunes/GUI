package fr.uparis.informatique.cours.ig;

import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class JWindowExemple implements Runnable {
	public void run() {
		JWindow maJWindow = new JWindow();
		maJWindow.setSize(500,500);
		maJWindow.setVisible(true);
	}
	public static void main(String []argv) {
		SwingUtilities.invokeLater(new JWindowExemple());	
	}
}