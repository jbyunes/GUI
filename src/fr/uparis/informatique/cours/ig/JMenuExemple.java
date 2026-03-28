package fr.uparis.informatique.cours.ig;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class JMenuExemple implements Runnable {
	public void run() {
		JFrame fenetre = new JFrame("Un exemple avec des menus");
		JLabel label = new JLabel("Bla bla bla bla");
		fenetre.getContentPane().add(label);

		// 1 menu 1 (pour la table 12)...
		JMenu menu1 = new JMenu("Fichier");
		JMenuItem quitter = new JMenuItem("Quitter");
		menu1.add(quitter);

		// 1 menu 1 (pour la table 8)...
		JMenu menu2 = new JMenu("Édition");
		JMenuItem undo = new JMenuItem("Défaire");
		JMenuItem redo = new JMenuItem("Refaire");
		menu2.add(undo);
		menu2.add(redo);

		// 1 barre de menu
		JMenuBar barre = new JMenuBar();
		barre.add(menu1);
		barre.add(menu2);

		// on accroche le tout à la fenêtre
		fenetre.setJMenuBar(barre);

		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new JMenuExemple());
	}
}