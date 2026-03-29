package fr.uparis.informatique.cours.ig;

import javax.swing.JFrame;
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