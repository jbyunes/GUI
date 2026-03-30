package fr.uparis.informatique.cours.ig;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URI;
import java.net.URL;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImageAsyncPanel extends JPanel {
	private Image image;
	public ImageAsyncPanel() {
		try {
			URL url = new URI("https://yunes.informatique.univ-paris-diderot.fr/wp-content/uploads/fun/dip-1024x724.jpg").toURL();
			image = Toolkit.getDefaultToolkit().getImage(url); // asynchronous loading
		} catch(Exception e) {
			e.printStackTrace();
		}
		setPreferredSize(new Dimension(500,500));
	}
	public void paintComponent(Graphics g) {
		g.drawImage(image,0,0,this); // this to track end of loading...
	}
}

