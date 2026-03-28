package fr.uparis.informatique.cours.ig;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FocusTraversalExemple implements Runnable {
	public void run() {
		JFrame f = new JFrame("Focus traversal Exemple");
		Container c = f.getContentPane();
		c.setLayout(new GridLayout(3,4));

		List<Component> tfs = new ArrayList<>();
		for (int x=0; x<3; x++) {
			for (int y=0; y<4; y++) {
				JTextField tf = new JTextField(10);
				tfs.add(tf);
				c.add(tf);
			}
		}

		f.setFocusTraversalPolicy(new MyFocusPolicy(tfs));

		f.pack();
		f.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new FocusTraversalExemple());
	}
}
