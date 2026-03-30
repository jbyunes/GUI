package fr.uparis.informatique.cours.ig;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URI;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImageIOPanel extends JPanel {
	private Image image;
	public ImageIOPanel() {
		try {
			URL url = new URI("https://yunes.informatique.univ-paris-diderot.fr/wp-content/uploads/fun/dip-1024x724.jpg").toURL();
			image = ImageIO.read(url); // synchronous loading...
			setPreferredSize(new Dimension(image.getWidth(null)/2,image.getHeight(null)/2));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g) {
		g.drawImage(image,0,0,image.getWidth(null)/2,image.getHeight(null)/2,null);
	}
}

