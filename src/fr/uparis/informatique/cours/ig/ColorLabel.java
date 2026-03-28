package fr.uparis.informatique.cours.ig;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ColorLabel extends JLabel {
	private Color c;
	public ColorLabel(Color c) {
		this.c = c;
		setOpaque(true);
		setBackground(c);
		setText(c.toString());
		setPreferredSize(new Dimension(150,150));
	}
	public void setBackground(Color c) {
		super.setBackground(this.c);
	}
}

