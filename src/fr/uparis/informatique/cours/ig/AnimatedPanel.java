package fr.uparis.informatique.cours.ig;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings({ "serial" })
public  class AnimatedPanel extends JPanel {
	private BufferedImage image1, image2, im2;
	LookupOp op;
	byte []b = new byte[256];
	byte [][]bs = { b, b, b, new byte[256] };
	public AnimatedPanel() {
		try {
			setPreferredSize(new Dimension(200,200));
			image1 = ImageIO.read(Utils.urlFrom("images/i2.jpeg"));
			im2 = new BufferedImage(image1.getWidth(),image1.getHeight(),BufferedImage.TYPE_INT_ARGB);
			im2.getGraphics().drawImage(image1,0,0,null);
			image2 = im2;
			image1 = ImageIO.read(Utils.urlFrom("images/i1.jpeg"));
			for (int i=0; i<256; i++) b[i] = (byte)(i);
			for (int i=0; i<256; i++) bs[3][i] = (byte)(255);
			ByteLookupTable tab = new ByteLookupTable(0,bs);
			op = new LookupOp(tab,null);
			setPreferredSize(new Dimension(image2.getWidth(), 2*image2.getHeight()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.RED);
		g2.fillRect(0,0,image2.getWidth(),2*image2.getHeight());
		g2.drawImage(image1,0,0,null);
		g2.drawImage(image2,0,0,null);
		g2.drawImage(image2,0,image2.getHeight(),null);
	}
	public void setValue(int v) {
		System.out.println(v);
		for (int i=0; i<256; i++) {
			bs[3][i] = (byte)(v);
		}
		ByteLookupTable tab = new ByteLookupTable(0, bs);
	    op = new LookupOp(tab, null);
	    image2 = op.filter(im2, null);
		repaint();
	}
}

