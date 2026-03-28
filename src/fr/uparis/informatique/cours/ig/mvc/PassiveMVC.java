package fr.uparis.informatique.cours.ig.mvc;

import java.awt.*;
import javax.swing.*;

public class PassiveMVC {
	public static void createUI() {
		PassiveModel m = new PassiveModel();
		JFrame f = new JFrame("MVC");
		PassiveView1 v1 = new PassiveView1();
		PassiveView1 v2 = new PassiveView1();
		PassiveView3 v3 = new PassiveView3();
		PassiveView1 v4 = new PassiveView1();
		PassiveView2 v5 = new PassiveView2();
		JButton b = new JButton("+1");
		PassiveController c = new PassiveController(m);
		c.addView(v1);
		c.addView(v2);
		c.addView(v3);
		c.addView(v4);
		c.addView(v5);
		b.addActionListener(c);

		f.getContentPane().setLayout(new FlowLayout());
		f.getContentPane().add(v1);
		f.getContentPane().add(v2);
		f.getContentPane().add(v3);
		f.getContentPane().add(v4);
		f.getContentPane().add(v5);
		f.getContentPane().add(b);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(PassiveMVC::createUI);
	}
}
