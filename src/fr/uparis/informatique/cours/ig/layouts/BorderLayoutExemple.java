package fr.uparis.informatique.cours.ig.layouts;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class BorderLayoutExemple implements Runnable {
	public void run() {
		JFrame maJFrame = new JFrame("Me voici!");
		maJFrame.getContentPane().setLayout(new BorderLayout());
		JLabel nord = new JLabel("Nord",SwingConstants.CENTER);
		JLabel sud = new JLabel("Sud",SwingConstants.CENTER);
		JLabel est = new JLabel("Est");
		JLabel ouest = new JLabel("Ouest");
		JLabel centre = new JLabel("Centre",SwingConstants.CENTER);
		centre.setOpaque(true);
		centre.setBackground(Color.RED);
		maJFrame.getContentPane().add(nord,BorderLayout.NORTH);
		maJFrame.getContentPane().add(sud,BorderLayout.SOUTH);
		maJFrame.getContentPane().add(est,BorderLayout.EAST);
		maJFrame.getContentPane().add(ouest,BorderLayout.WEST);
		maJFrame.getContentPane().add(centre,BorderLayout.CENTER);
		maJFrame.pack(); // rangement «optimal»
		maJFrame.setVisible(true);
	}
	public static void main(String []argv) {
		SwingUtilities.invokeLater(new BorderLayoutExemple());	
	}
}
