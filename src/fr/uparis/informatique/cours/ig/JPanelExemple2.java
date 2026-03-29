package fr.uparis.informatique.cours.ig;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JPanelExemple2 {
	public JPanelExemple2() {
		JFrame fenetre = new JFrame(this.getClass().toString());
		JPanel panneau1 = new JPanel();
		panneau1.setBackground(Color.BLACK);
		fenetre.getContentPane().add(panneau1);
		for (int i=0; i<4; i++) {
			panneau1.add(new JButton("Bouton "+Integer.toString(i)));
		}
		JPanel panneau2 = new JPanel();
		panneau2.setBackground(Color.RED);
		panneau2.setPreferredSize(new Dimension(200,200));
		panneau1.add(panneau2);
		for (int i=0; i<5; i++) {
			panneau2.add(new JLabel("Label "+Integer.toString(i)));
		}
		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JPanelExemple2();
			}
		});
	}
}
