package fr.uparis.informatique.cours.ig.mvc;

import java.awt.*;
import javax.swing.*;

public class ActiveMVC {
	private static final ActiveModel model = new ActiveModel();
	public static void createUI() {
		JFrame f = new JFrame("MVC");
		ActiveView1 v1 = new ActiveView1();
		ActiveView1 v2 = new ActiveView1();
		model.subscribe(v1);
		model.subscribe(v2);
		JButton b = new JButton("+1");
		ActiveController c = new ActiveController(model);
		b.addActionListener(c);

		f.getContentPane().setLayout(new FlowLayout());
		f.getContentPane().add(v1);
		f.getContentPane().add(v2);
		f.getContentPane().add(b);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String []args) throws Exception {
		SwingUtilities.invokeAndWait(ActiveMVC::createUI);
		
		new ActiveAutoController(model).start();
	}
}
