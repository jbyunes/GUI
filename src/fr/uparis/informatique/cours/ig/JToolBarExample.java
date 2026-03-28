package fr.uparis.informatique.cours.ig;

import java.awt.*;
import javax.swing.*;

public class JToolBarExample implements Runnable {
	public void run() {
		JFrame f = new JFrame(getClass().getName());
		Container c = f.getContentPane();
		c.setLayout(new BorderLayout());

		JToolBar tb = new JToolBar(SwingConstants.HORIZONTAL);
		tb.setFloatable(true);
		tb.setRollover(true);
		for (int i=0; i<6; i++) {
			if (i==3) {
				tb.add(new JToolBar.Separator());
				continue;
			}
			JButton b = new JButton("Bouton "+(i+1));
			b.setToolTipText("Aide pour "+b.getText());
			tb.add(b);
		}
		tb.addSeparator();

		c.add(tb,BorderLayout.NORTH);

		JLabel l = new JLabel("Example de barre d'outils flottante",JLabel.CENTER);
		l.setPreferredSize(new Dimension(400,200));
		c.add(l,BorderLayout.CENTER);

		f.pack();
		f.setVisible(true);
	}
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new JToolBarExample());
	}
}

