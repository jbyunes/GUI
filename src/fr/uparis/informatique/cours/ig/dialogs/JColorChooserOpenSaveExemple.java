package fr.uparis.informatique.cours.ig.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

class OpenSaveListener implements ActionListener {
	private ColorableDrawingPanel p;
	private static JFileChooser c = new JFileChooser();
	public OpenSaveListener(ColorableDrawingPanel p) {
		this.p = p;
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		String command = ((JMenuItem)(e.getSource())).getActionCommand();
		int resultat = switch(command) {
		case "open" -> c.showOpenDialog(null);
		case "save" -> c.showSaveDialog(null);
		default -> -1;
		};
		if (resultat == JFileChooser.APPROVE_OPTION) {
			File f = c.getSelectedFile();
			System.out.println(f);
			switch(command) {
			case "open":
				try {
					p.setImage(ImageIO.read(f));
				} catch(Exception ex) {
					System.err.println("Something's wrong reading");
				}
			case "save":
				try {
					ImageIO.write(p.getImage(),"png",f);
				} catch(Exception ex) {
					System.err.println("Something's wrong writing");
				}
			}
		}
	}
}

public class JColorChooserOpenSaveExemple implements Runnable {
	public void run() {
		JFrame f = new JFrame("Drawing & ColorChooser");
		final ColorableDrawingPanel l = new ColorableDrawingPanel();
		f.getContentPane().add(l);
		JMenu m = new JMenu("Fichier");
		JMenuItem open = new JMenuItem("Ouvrir...");
		JMenuItem save = new JMenuItem("Sauver...");
		JMenuItem mi1 = new JMenuItem("Imprimer");
		JMenuItem mi2 = new JMenuItem("Quitter");
		m.add(open);
		m.add(save);
		m.add(new JSeparator());
		m.add(mi1);
		m.add(new JSeparator());
		m.add(mi2);
		JMenuBar mb = new JMenuBar();
		mb.add(m);
		f.setJMenuBar(mb);
		f.pack();
		f.setVisible(true);
		JColorChooser cc = new JColorChooser(l.getForeground());
		JDialog d = new JDialog(f);
		d.getContentPane().add(cc);
		d.pack();
		d.setVisible(true);
		cc.getSelectionModel().addChangeListener(l);

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
		open.setActionCommand("open");
		ActionListener al = new OpenSaveListener(l);
		open.addActionListener(al);
		save.setActionCommand("save");
		save.addActionListener(al);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new JColorChooserOpenSaveExemple());
		for (var x : ImageIO.getWriterFormatNames()) {
			System.out.println(x);
		}
		for (var x : ImageIO.getWriterFileSuffixes()) {
			System.out.println("."+x);
		}
		for (var x : ImageIO.getWriterMIMETypes()) {
			System.out.println("mime "+x);
		}
	}
}
