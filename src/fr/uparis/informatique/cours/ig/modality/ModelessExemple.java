package fr.uparis.informatique.cours.ig.modality;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ModelessExemple implements Runnable {
	public void run() {
		JFrame fenetre1 = new JFrame("Fenetre1");
		JLabel l1 = new JLabel("Une superbe et magnifique fenêtre");
		JButton b1 = new JButton("Vas-y tapes-moi!");
		l1.setPreferredSize(new Dimension(400,400));
		fenetre1.getContentPane().setLayout(new BorderLayout());
		fenetre1.getContentPane().add(l1,BorderLayout.CENTER);
		fenetre1.getContentPane().add(b1,BorderLayout.SOUTH);
		b1.addActionListener(new ModelessListener(fenetre1));

		JFrame fenetre2 = new JFrame("Fenetre2");
		JLabel l2 = new JLabel("Une autre magnifique fenêtre");
		JButton b2 = new JButton("Vas-y tapes-moi!");
		l2.setPreferredSize(new Dimension(400,400));
		fenetre2.getContentPane().setLayout(new BorderLayout());
		fenetre2.getContentPane().add(l2,BorderLayout.CENTER);
		fenetre2.getContentPane().add(b2,BorderLayout.SOUTH);
		b2.addActionListener(new ModelessListener(null));

		fenetre1.pack();
		fenetre2.pack();
		fenetre1.setVisible(true);
		fenetre2.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new ModelessExemple());
	}
}
