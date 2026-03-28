package fr.uparis.informatique.cours.ig.ticker;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TickerExemple implements Runnable,ActionListener {
	private JFrame f;
	private Ticker ticker;
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		try {
			UIManager.setLookAndFeel(name);
			SwingUtilities.updateComponentTreeUI(f);
		} catch(Exception ex) {}
	}
	public void run() {
		f = new JFrame("Essai");

		JMenu m = new JMenu("Look & Feels");
		UIManager.LookAndFeelInfo[]infos = UIManager.getInstalledLookAndFeels();
		for (var i: infos) {
			JMenuItem mi = new JMenuItem(i.getName());
			mi.setActionCommand(i.getClassName());
			mi.addActionListener(this);
			m.add(mi);
		}
		JMenuBar mb = new JMenuBar();
		f.setJMenuBar(mb);
		mb.add(m);

		ticker = new Ticker();
		JLabel l = new JLabel("--");
		TickerListener tl = new MonListener(l);
		ticker.addTickerListener(tl);
		TickerListener tl2 = new MonAutreListener();
		ticker.addTickerListener(tl2);
		Container c = f.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(ticker,BorderLayout.CENTER);
		c.add(l,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
		ticker.setDelay(3);
		ticker.start();
	}
	public static void main(String []a) {
		SwingUtilities.invokeLater(new Thread(new TickerExemple()));
	}
}

class MonListener implements TickerListener {
	private JLabel label;
	public MonListener(JLabel l) {
		label = l;
	}
	public void tickPerformed(TickerEvent te) {
		label.setText(""+te.getCount());
	}
}

class MonAutreListener implements TickerListener {
	public void tickPerformed(TickerEvent te) {
		System.out.println("Tick "+te.getCount());
	}
}
