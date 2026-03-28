package fr.uparis.informatique.cours.ig;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PLAFExemple implements Runnable {
	public void run() {
		final JFrame f = new JFrame("PLAF test");
		JMenu m = new JMenu("Fichier");
		JMenuItem miOpen = new JMenuItem("Ouvrir...");
		JMenuItem miQuit = new JMenuItem("Quitter");
		m.add(miOpen);
		m.add(new JSeparator());
		m.add(miQuit);
		JMenuBar mb = new JMenuBar();
		mb.add(m);

		JMenu mlaf = new JMenu("L&F");
		for (UIManager.LookAndFeelInfo i : UIManager.getInstalledLookAndFeels()) {
			final String n = i.getClassName();
			System.out.println(n);
			JMenuItem mi = new JMenuItem(i.getName());
			mi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						UIManager.setLookAndFeel(n);
						SwingUtilities.updateComponentTreeUI(f);
						f.pack();
					} catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			mlaf.add(mi);
		}
		mb.add(mlaf);
		f.setJMenuBar(mb);

		Container c = f.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JButton("Yo!"));
		c.add(new JSlider());

		f.pack();
		f.setVisible(true);
	}
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new PLAFExemple());
	}
}