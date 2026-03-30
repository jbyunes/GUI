package fr.uparis.informatique.cours.ig;

import module java.desktop;

public class ImageAsyncObserverExemple {
	public static void main(String [] args) {
		SwingUtilities.invokeLater(ImageAsyncObserverExemple::createInterface);
	}
	public static  void createInterface() {
		JFrame f = new JFrame("Yeah");
		Container c = f.getContentPane();
		ImageAsyncObserverPanel p = new ImageAsyncObserverPanel();
		c.add(p);
		f.pack();
		f.setVisible(true);
	}
}
