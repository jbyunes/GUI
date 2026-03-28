package fr.uparis.informatique.cours.ig.ticker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;

import javax.swing.JComponent;

public class AquaTickerUI extends TickerUI {
	public void paint(Graphics g, JComponent co) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(5));
		super.paint(g2, co);
	}
	static public AquaTickerUI createUI() {
		var ui = new AquaTickerUI();
		ui.setColor(Color.GREEN);
		return ui;
	}
}
