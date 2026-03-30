package fr.uparis.informatique.cours.ig;

import module java.desktop;
import java.net.URI;
import java.net.URL;

public class ImageTrackingExemple {
	public static void main(String [] args) {
		SwingUtilities.invokeLater(ImageTrackingExemple::createUI);
	}
	public static void createUI() {
		JFrame f = new JFrame("Image loading...");
		Container c = f.getContentPane();
		ImageTrackingPanel p = new ImageTrackingPanel();
		c.add(p);
		f.pack();
		f.setVisible(true);
	}
}
