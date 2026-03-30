package fr.uparis.informatique.cours.ig;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

public class MnemoniquesExemple implements Runnable {
	public void run() {
		JFrame fenetre = new JFrame("Un exemple avec des menus");
		JLabel label = new JLabel("Bla bla bla bla");
		fenetre.getContentPane().add(label);

		// 1 menu 1 (pour la table 12)...
		JMenu menu1 = new JMenu("Fichier");
		menu1.setMnemonic(KeyEvent.VK_F);
		JMenuItem quitter = new JMenuItem("Quitter",KeyEvent.VK_Q);
		menu1.add(quitter);

		// 1 menu 1 (pour la table 8)...
		JMenu menu2 = new JMenu("Édition");
		menu2.setMnemonic(KeyEvent.VK_E);
		JMenuItem undo = new JMenuItem("Défaire",KeyEvent.VK_D);
		JMenuItem redo = new JMenuItem("Refaire",KeyEvent.VK_R);
		menu2.add(undo);
		menu2.add(redo);

		JMenu menu3 = new JMenu("Chercher");
		menu3.setMnemonic(KeyEvent.VK_C);
		menu3.add(new JMenuItem("En avant",KeyEvent.VK_A));
		menu3.add(new JMenuItem("En arrière",KeyEvent.VK_Z));
		menu2.add(new JSeparator());
		menu2.add(menu3);

		// 1 barre de menu
		JMenuBar barre = new JMenuBar();
		barre.add(menu1);
		barre.add(menu2);

		// on accroche le tout a la fenetre
		fenetre.setJMenuBar(barre);

		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new MnemoniquesExemple());
	}
}
