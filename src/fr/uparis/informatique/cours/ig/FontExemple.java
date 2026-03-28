package fr.uparis.informatique.cours.ig;

import java.awt.Container;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class FontExemple implements Runnable {
	public void run() {
		JFrame f = new JFrame("MonComposant");
		Container c = f.getContentPane();
		JMenu m = new JMenu("Polices");
		final JLabel l = new JLabel("Voix ambiguë d'un cœur qui, au zéphyr, préfère les jattes de kiwis.");
		c.add(l);
		String [] polices = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		JMenu [] sm = new JMenu[27];
		for (char ch='A'; ch<='Z'; ch++) {
			sm[ch-'A'] = new JMenu(""+ch);
			m.add(sm[ch-'A']);
		}
		sm[26] = new JMenu("Autres");
		m.add(sm[26]);
		FontListener fl = new FontListener(f,l);
		for (String s: polices) {
			JMenuItem mi = new JMenuItem(s);
			mi.addActionListener(fl);
			char ch = Character.toUpperCase(s.charAt(0));
			if (ch>='A' && ch<='Z') sm[ch-'A'].add(mi);
			else sm[26].add(mi);
		}
		JMenuBar mb = new JMenuBar();
		mb.add(m);
		f.setJMenuBar(mb);

		f.pack();
		f.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new FontExemple());
	}
}