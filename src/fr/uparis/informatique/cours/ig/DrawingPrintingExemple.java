package fr.uparis.informatique.cours.ig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class DrawingPrintingExemple implements Runnable {
	public void run() {
		JFrame f = new JFrame("Drawing");
		final DrawingPanel l = new DrawingPanel();
		f.getContentPane().add(l);
		JMenu m = new JMenu("Fichier");
		JMenuItem mi1 = new JMenuItem("Imprimer");
		JMenuItem mi2 = new JMenuItem("Quitter");
		m.add(mi1);
		m.add(mi2);
		JMenuBar mb = new JMenuBar();
		mb.add(m);
		f.setJMenuBar(mb);
		f.pack();
		f.setVisible(true);

		mi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob pj = PrinterJob.getPrinterJob();
				pj.setJobName("Un magnifique dessin");
				pj.setPrintable(l);
				if (pj.printDialog()) { // ask user
					try {
						pj.print(); // do the trick
					} catch(PrinterException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		mi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new DrawingPrintingExemple());
	}
}
