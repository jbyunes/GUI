package fr.uparis.informatique.cours.ig;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class ProgressMonitorExemple {
	public static void createUI() {
		final JFrame fenetre = new JFrame(ProgressMonitorExemple.class.toString());
		fenetre.getContentPane().setLayout(new FlowLayout());
		JLabel etiquette = new JLabel("<html><big>Hey!</big></html>");
		fenetre.getContentPane().add(etiquette);
		JButton b = new JButton("Start job");
		b.addActionListener(e -> {
			ProgressMonitor moniteur = new ProgressMonitor(fenetre.getContentPane(),"Boulot","",0,100);
			moniteur.setMillisToDecideToPopup(5000);
			ProgressTask t = new ProgressTask(moniteur);
			t.execute();
			b.setEnabled(false);
		});
		fenetre.getContentPane().add(b);
		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String []args) throws Exception {
		SwingUtilities.invokeLater(ProgressMonitorExemple::createUI);
	}
}
