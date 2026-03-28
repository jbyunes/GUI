package fr.uparis.informatique.cours.ig;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AlphaExemple {
	public static void createUI() {
		JFrame fenetre = new JFrame("Alpha Exemple");
		fenetre.getContentPane().setLayout(new BorderLayout());
		JButton b = new JButton("Go");
		final AlphaJPanel a = new AlphaJPanel();
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.switchOn();
			}
		});
		fenetre.getContentPane().add(b,BorderLayout.NORTH);
		fenetre.getContentPane().add(a,BorderLayout.CENTER);
		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String []a) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createUI();
			}
		});
	}
}
