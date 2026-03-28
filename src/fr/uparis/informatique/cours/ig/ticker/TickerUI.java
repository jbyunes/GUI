package fr.uparis.informatique.cours.ig.ticker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

public class TickerUI extends ComponentUI {
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
	    int t = d.width<d.height?d.width:d.height;
	    t = t/2;
	    Calendar c = Calendar.getInstance();
	    int s = c.get(Calendar.SECOND);
	    double angle = Math.PI/2-s*2*Math.PI/60;
	    g.setColor(Color.RED);
	    int x = (int)(t*Math.cos(angle));
	    int y = (int)(t*Math.sin(angle));
	    g.drawLine(d.width/2,d.height/2,d.width/2+x,d.height/2-y);
	  }
	  public static ComponentUI createUI() {
	    return new TickerUI();
	  }
	}
