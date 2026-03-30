package fr.uparis.informatique.cours.ig;

import module java.desktop;

public class ImageIOExemple {
	public static void main(String [] args) {
		SwingUtilities.invokeLater(ImageIOExemple::createUI);
	}
	public static void createUI() {
		JFrame f = new JFrame("ImageIO Exemple");
		Container c = f.getContentPane();
		ImageIOPanel p = new ImageIOPanel();
		c.add(p);
		f.pack();
		f.setVisible(true);
	}
}
