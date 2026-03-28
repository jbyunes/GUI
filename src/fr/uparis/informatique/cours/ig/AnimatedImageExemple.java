package fr.uparis.informatique.cours.ig;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AnimatedImageExemple implements Runnable {
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new AnimatedImageExemple());
	}
	public void run() {
		JFrame f = new JFrame(this.getClass().getName());
		Container c = f.getContentPane();
		c.setLayout(new BorderLayout());
		final AnimatedPanel p = new AnimatedPanel();
		c.add(p,BorderLayout.CENTER);
		JSlider s = new JSlider(SwingConstants.HORIZONTAL,0,255,255);
		s.setMajorTickSpacing(20);
		s.setPaintTicks(true);
		s.setLabelTable(s.createStandardLabels(50));
		s.setPaintLabels(true);
		c.add(s,BorderLayout.SOUTH);
		s.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				p.setValue(((JSlider)(e.getSource())).getValue());
			}
		});
		f.pack();
		f.setVisible(true);
	}
}