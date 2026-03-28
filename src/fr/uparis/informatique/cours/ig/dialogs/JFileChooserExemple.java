package fr.uparis.informatique.cours.ig.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;

public class JFileChooserExemple implements Runnable {
	public void run() {
		JFrame fenetre = new JFrame("Fenêtre");
		JLabel l = new JLabel("Une superbe et magnifique fenêtre");
		l.setPreferredSize(new Dimension(400,200));
		fenetre.getContentPane().setLayout(new BorderLayout());
		fenetre.getContentPane().add(l,BorderLayout.CENTER);
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("Fichier");
		JMenuItem mOpen = new JMenuItem("Ouvrir...");
		JMenuItem mSave = new JMenuItem("Sauver sous...");
		JMenuItem mQuit = new JMenuItem("Quitter");
		menu.add(mOpen);
		menu.add(mSave);
		menu.add(new JSeparator());
		menu.add(mQuit);
		mb.add(menu);
		fenetre.setJMenuBar(mb);
		mQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		JFileChooserListener a = new JFileChooserListener(fenetre);
		mOpen.setActionCommand("Open");
		mSave.setActionCommand("Save");
		mOpen.addActionListener(a);
		mSave.addActionListener(a);

		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new JFileChooserExemple());
	}
}
