package fr.uparis.informatique.cours.ig;
import module java.desktop;

public class MouseMotionListenerExample {
	public static void createUI() {
		JFrame f = new JFrame("MouseListenerExample");
		JLabel l = new JLabel("Vas-y, joue avec la souris!");
		l.setPreferredSize(new Dimension(500,500));
		l.addMouseListener(new DetecteurDeClicBis());
		f.getContentPane().add(l);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(MouseMotionListenerExample::createUI);
	}
}
