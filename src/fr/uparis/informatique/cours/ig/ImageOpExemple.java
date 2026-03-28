package fr.uparis.informatique.cours.ig;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ImageOpExemple implements Runnable {
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new ImageOpExemple());
	}
	public void run() {
		JFrame f = new JFrame(this.getClass().getName());
		Container c = f.getContentPane();
		ImageOpPanel p = new ImageOpPanel();
		c.add(p);
		f.pack();
		f.setVisible(true);
	}
}
