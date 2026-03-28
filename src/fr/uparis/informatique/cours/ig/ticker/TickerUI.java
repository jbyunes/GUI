package fr.uparis.informatique.cours.ig.ticker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

public class TickerUI extends ComponentUI {
	private Color color;
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Dimension getMinimumSize(JComponent c) {
		return new Dimension(50,50);
	}
	public Dimension getMaximumSize(JComponent c) {
		return new Dimension(500,500);
	}
	public Dimension getPreferredSize(JComponent c) {
		return new Dimension(100,100);
	}
	public void paint(Graphics g,JComponent co) {
		Dimension d = co.getSize();
		int length = Integer.min(d.width, d.height);
		length = length/2;
		Calendar c = Calendar.getInstance();
		int s = c.get(Calendar.SECOND);
		double angle = Math.PI/2-s*2*Math.PI/60;
		g.setColor(color);
		int x = (int)(length*Math.cos(angle));
		int y = (int)(length*Math.sin(angle));
		g.drawLine(d.width/2,d.height/2,d.width/2+x,d.height/2-y);
	}
	public static ComponentUI createUI() {
		return new TickerUI();
	}
}
