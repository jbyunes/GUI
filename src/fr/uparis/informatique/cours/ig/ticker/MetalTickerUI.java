package fr.uparis.informatique.cours.ig.ticker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;

import javax.swing.JComponent;

public class MetalTickerUI extends TickerUI {
	public void paint(Graphics g,JComponent co) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(12));
		setColor(Color.WHITE);
		super.paint(g2, co);
		g2.setStroke(new BasicStroke(6));
		setColor(Color.GRAY);
		super.paint(g2, co);
		g2.setStroke(new BasicStroke(2));
		setColor(Color.BLACK);
		super.paint(g2, co);
	}
	static public MetalTickerUI createUI() {
		return new MetalTickerUI();
	}
}
