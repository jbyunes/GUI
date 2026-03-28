package fr.uparis.informatique.cours.ig;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PaintComponentExemple {
	public static void main(String []args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame f = new JFrame("essai");
				PaintPanel p = new PaintPanel();
				f.setContentPane(p);
				f.pack();
				f.setVisible(true);
			}
		});
	}
}