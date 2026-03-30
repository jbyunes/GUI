package fr.uparis.informatique.cours.ig;

import module java.desktop;

public class WheelExemple implements Runnable {
	public void run() {
		JFrame f = new JFrame("WheelExemple");
		JLabel l = new JLabel("Vas-y, bouge la roue!");
		l.setPreferredSize(new Dimension(500,500));
		JSlider s = new JSlider(SwingConstants.VERTICAL,0,200,100);
		s.addMouseWheelListener(new WheelListener(s));
		JTextArea t = new JTextArea(20,20);
		t.addMouseWheelListener(new WheelListener(s));
		f.getContentPane().setLayout(new BoxLayout(f.getContentPane(),BoxLayout.X_AXIS));
		f.getContentPane().add(l);
		f.getContentPane().add(s);
		f.getContentPane().add(t);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new WheelExemple());
	}
}
