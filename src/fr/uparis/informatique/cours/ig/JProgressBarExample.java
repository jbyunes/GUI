package fr.uparis.informatique.cours.ig;
import java.awt.*;

import javax.swing.*;

public class JProgressBarExample {
	static private LongJob lj;
	public static void createUI() {
		JFrame f = new JFrame("ProgressBarExample");
		Container c = f.getContentPane();
		JLabel result = new JLabel("...");
		c.add(result);
		c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
		JProgressBar pb = new JProgressBar(SwingConstants.HORIZONTAL,0,100);
		pb.setValue(0);
		pb.setStringPainted(true);
		pb.setIndeterminate(true);
		c.add(pb);
		JButton b = new JButton("Allez!");
		c.add(b);
		DoIt doit = new DoIt(pb,result);
		b.addActionListener(doit);
		JButton click = new JButton("Click!");
		c.add(click);
		click.addActionListener(System.out::println);
		f.pack();
		f.setVisible(true);

		lj = doit.getJob();
	}
	public static void main(String [] args) throws Exception {
		SwingUtilities.invokeAndWait(JProgressBarExample::createUI);
		System.out.println("Waitin' in v(m)ain...");
		// 'til can get enough...
		var value = lj.get(); // LongJob is a Future
		System.out.println("Got "+value);
	}
}
