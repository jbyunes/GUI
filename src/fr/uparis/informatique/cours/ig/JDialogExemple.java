package fr.uparis.informatique.cours.ig;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class JDialogExemple implements Runnable {
	public void run() {
		JDialog monJDialog = new JDialog((java.awt.Frame)null);
		monJDialog.setSize(500,500);
		monJDialog.setVisible(true);
	}
	public static void main(String []argv) {
		SwingUtilities.invokeLater(new JDialogExemple());	
	}
}