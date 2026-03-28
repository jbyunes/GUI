package fr.uparis.informatique.cours.ig;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ComposePanel extends JPanel {
	AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC);  
	float alpha = 1.0f;

	private final static int [] rules = {
			AlphaComposite.SRC,
			AlphaComposite.DST_IN,
			AlphaComposite.DST_OUT,
			AlphaComposite.DST_OVER,
			AlphaComposite.SRC_IN,
			AlphaComposite.SRC_OVER,
			AlphaComposite.SRC_OUT,
			AlphaComposite.CLEAR,
			AlphaComposite.XOR
	};

	public void changeRule(float alpha, int rule) {
		ac = AlphaComposite.getInstance(rules[rule], alpha);
		repaint();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		Dimension d = getSize();
		int w = d.width;
		int h = d.height; 

		BufferedImage buffImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gbi = buffImg.createGraphics();

		g2.setColor(Color.white);
		g2.fillRect(0, 0, d.width, d.height);

		int rectx = w/4;
		int recty = h/4;

		gbi.setColor(new Color(0.0f, 0.0f, 1.0f, 1.0f));
		gbi.fill(new Rectangle2D.Double(rectx, recty, 150, 100));
		gbi.setColor(new Color(1.0f, 0.0f, 0.0f, 1.0f));    
		gbi.setComposite(ac);
		gbi.fill(new Ellipse2D.Double(rectx+rectx/2,recty+recty/2,150,100));

		g2.drawImage(buffImg, null, 0, 0);
	}
}   
