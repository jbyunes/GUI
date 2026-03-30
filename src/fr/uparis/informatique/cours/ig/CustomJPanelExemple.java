package fr.uparis.informatique.cours.ig;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class CustomJPanelExemple implements Runnable {
	public void run() {
		JFrame f = new JFrame("MonComposant");
		JLabel l1 = new JLabel("Ici");
		l1.setBackground(Color.BLUE);
		l1.setForeground(Color.WHITE);
		l1.setOpaque(true);

		JLabel l2 = new JLabel("Là");
		CustomJPanel m = new CustomJPanel();
		Container c = f.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(l1,BorderLayout.NORTH);
		c.add(m,BorderLayout.CENTER);
		c.add(l2,BorderLayout.SOUTH);
		JButton b = new JButton("Bonjour");
		m.add(b);

		f.pack();
		f.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new CustomJPanelExemple());
	}
}
