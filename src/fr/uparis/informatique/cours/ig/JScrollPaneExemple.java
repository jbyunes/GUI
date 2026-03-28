package fr.uparis.informatique.cours.ig;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class JScrollPaneExemple {
	public JScrollPaneExemple() {
		JFrame fenetre = new JFrame(this.getClass().toString());
		Icon jardin = Utils.imageFrom("images/JardinAbbePierre.jpg");
		JLabel image = new JLabel(jardin);
		JScrollPane panneau = new JScrollPane(image);
		fenetre.getContentPane().add(panneau);
		panneau.setPreferredSize(new Dimension(200,200));
		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JScrollPaneExemple();
			}
		});
	}
}
