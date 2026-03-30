package fr.uparis.informatique.cours.ig;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CustomJPanel extends JPanel {
	public CustomJPanel() {
		setBackground(Color.RED);
		setPreferredSize(new Dimension(1000,800));
	}
	public void paintComponent(Graphics g) {
		System.out.println("PAINT "+g.hashCode());
		super.paintComponent(g); // do the default, at least bg filled
		Color c = Color.RED;
		Dimension d = getSize();
		int l = d.width/20-2;
		int h = d.height/20-2;
		for (int i=0; i<10; i++) {
			g.setColor(c);
			g.fillRect(0+l*i,0+i*h,d.width-i*2*l,d.height-i*2*h);
			c = c.darker();
		}
	}
}

