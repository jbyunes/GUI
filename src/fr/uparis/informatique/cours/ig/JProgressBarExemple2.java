package fr.uparis.informatique.cours.ig;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class JProgressBarExemple2 {
	public JProgressBarExemple2() {
		JFrame fenetre = new JFrame(this.getClass().toString());
		final JProgressBar barre = new JProgressBar(SwingConstants.HORIZONTAL,0,100);
		barre.setIndeterminate(true);
		barre.setValue(0);
		barre.setStringPainted(true);
		fenetre.getContentPane().add(barre);
		fenetre.pack();
		fenetre.setVisible(true);
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(5000);
					barre.setIndeterminate(false);
					for (int i=1; i<=100; i++) {
						barre.setValue(i);
						Thread.sleep(50);
					}
				} catch(Exception e) {
				}
				barre.setEnabled(false);
				barre.setIndeterminate(true);
			}
		}).start();
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(JProgressBarExemple2::new);
	}
}
