package fr.uparis.informatique.cours.ig;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class BadCustomPaintingExemple implements Runnable {
	public void run() {
		JFrame f = new JFrame("MonComposant");
		JLabel n = new JLabel("North");
		final JLabel l = new JLabel("Coucou");
		Container c = f.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(n,BorderLayout.NORTH);
		c.add(l,BorderLayout.CENTER);

		f.pack();
		f.setVisible(true);
		new Thread(new Runnable() {
			public void run() {
				try {
					for (int i=0; i<1000; i++) {
						Thread.sleep(50);
						Graphics2D g = (Graphics2D)l.getGraphics();
						g.setColor(Color.RED);
						g.setStroke(new BasicStroke(5));
						g.drawLine(i,0,l.getSize().width-i,l.getSize().height);
					}
				} catch(Exception e) {}
			}
		}).start();
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new BadCustomPaintingExemple());
	}
}
