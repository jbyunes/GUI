package fr.uparis.informatique.cours.ig;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.net.URI;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImageOpPanel extends JPanel {
	private BufferedImage image;
	public ImageOpPanel() {
		try {
			URL url = new URI("https://yunes.informatique.univ-paris-diderot.fr/wp-content/uploads/fun/dip-1024x724.jpg").toURL();
			image = ImageIO.read(url); // synchronous loading...
			setPreferredSize(new Dimension(image.getWidth(null),image.getHeight(null)));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g) {
		float []f = {-1f,-1f,-1f,
				-1f, 8f,-1f,
				-1f,-1f,-1f};
		Graphics2D g2 = (Graphics2D)g;
		BufferedImageOp op = new ConvolveOp(new Kernel(3,3,f));
		g2.drawImage(image,op,0,0);
	}
}

