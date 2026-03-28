package fr.uparis.informatique.cours.ig;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JFrameExemple implements Runnable {
	public void run() {
		JFrame maJFrame = new JFrame("Me voici!");
		maJFrame.setVisible(true);
	}
	public static void main(String []argv) {
		SwingUtilities.invokeLater(new JFrameExemple());	
	}
}
