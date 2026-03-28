package fr.uparis.informatique.cours.ig;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DefaultColorsExemple implements Runnable {
	public void run() {
		JFrame f = new JFrame("MonComposant");
		Container c = f.getContentPane();
		c.setLayout(new GridLayout(4,4));
		c.add(new ColorLabel(Color.BLACK));
		c.add(new ColorLabel(Color.BLUE));
		c.add(new ColorLabel(Color.CYAN));
		c.add(new ColorLabel(Color.DARK_GRAY));
		c.add(new ColorLabel(Color.GRAY));
		c.add(new ColorLabel(Color.GREEN));
		c.add(new ColorLabel(Color.LIGHT_GRAY));
		c.add(new ColorLabel(Color.MAGENTA));
		c.add(new ColorLabel(Color.ORANGE));
		c.add(new ColorLabel(Color.PINK));
		c.add(new ColorLabel(Color.RED));
		c.add(new ColorLabel(Color.WHITE));
		c.add(new ColorLabel(Color.YELLOW));

		f.pack();
		f.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new DefaultColorsExemple());
	}
}