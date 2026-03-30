package fr.uparis.informatique.cours.ig;

import module java.desktop;

public class ImageAsyncLoadingExemple {
	public static void main(String [] args) {
		SwingUtilities.invokeLater(ImageAsyncLoadingExemple::createUI);
	}
	public static void createUI() {
		JFrame f = new JFrame("Async loading");
		Container c = f.getContentPane();
		ImageAsyncPanel p = new ImageAsyncPanel();
		c.add(p);
		f.pack();
		f.setVisible(true);
	}
}
