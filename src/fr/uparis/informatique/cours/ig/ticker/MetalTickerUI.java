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
	    Dimension d = co.getSize();
	    int t = d.width<d.height?d.width:d.height;
	    t = t/2;
	    Calendar c = Calendar.getInstance();
	    int s = c.get(Calendar.SECOND);
	    double angle = Math.PI/2-s*2*Math.PI/60;
	    ((Graphics2D)g).setStroke(new BasicStroke(12));
	    g.setColor(Color.WHITE);
	    int x = (int)(t*Math.cos(angle));
	    int y = (int)(t*Math.sin(angle));
	    g.drawLine(d.width/2,d.height/2,d.width/2+x,d.height/2-y);
	    ((Graphics2D)g).setStroke(new BasicStroke(8));
	    g.setColor(Color.GRAY);
	    g.drawLine(d.width/2,d.height/2,d.width/2+x,d.height/2-y);
	    ((Graphics2D)g).setStroke(new BasicStroke(4));
	    g.setColor(Color.BLACK);
	    g.drawLine(d.width/2,d.height/2,d.width/2+x,d.height/2-y);
	  }
	  static public MetalTickerUI createUI() {
	    return new MetalTickerUI();
	  }
	}
