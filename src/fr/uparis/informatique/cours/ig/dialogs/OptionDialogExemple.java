package fr.uparis.informatique.cours.ig.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class OptionDialogExemple implements Runnable {
	public void run() {
		JFrame fenetre = new JFrame("Fenetre1");
		JLabel l = new JLabel("Une superbe et magnifique fenêtre");
		JButton b = new JButton("Vas-y tapes-moi!");
		l.setPreferredSize(new Dimension(400,400));
		fenetre.getContentPane().setLayout(new BorderLayout());
		fenetre.getContentPane().add(l,BorderLayout.CENTER);
		fenetre.getContentPane().add(b,BorderLayout.SOUTH);
		b.addActionListener(new OptionListener(fenetre, l));

		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new OptionDialogExemple());
	}
}
