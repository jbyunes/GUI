package fr.uparis.informatique.cours.ig;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PaintPanel extends JPanel {
	public PaintPanel() {
		setPreferredSize(new Dimension(200,200));
	}
	public void paintComponent(Graphics g) {
		System.out.println("paintComponent "+System.currentTimeMillis());
	}
}

