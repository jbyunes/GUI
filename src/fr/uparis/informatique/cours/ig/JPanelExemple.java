package fr.uparis.informatique.cours.ig;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JPanelExemple {
	public static JPanel createPanel() {
		JPanel panneau = new JPanel();
		for (int i=0; i<4; i++) {
			panneau.add(new JButton("Bouton "+Integer.toString(i)));
		}
		return panneau;
	}
	public JPanelExemple() {
		JFrame fenetre = new JFrame(this.getClass().toString());
		fenetre.getContentPane().setLayout(new FlowLayout());
		JPanel panneau = createPanel();
		fenetre.getContentPane().add(panneau);
		panneau.setOpaque(true);
		panneau.setBackground(Color.DARK_GRAY);
		
		JPanel panneau2 = createPanel();
		fenetre.getContentPane().add(panneau2);
		panneau2.setOpaque(true);
		panneau2.setBackground(Color.LIGHT_GRAY);

		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JPanelExemple();
			}
		});
	}
}
