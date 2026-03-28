package fr.uparis.informatique.cours.ig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class DoIt implements ActionListener {
	LongJob lj;
	public DoIt(JProgressBar pb, JLabel l) {
		lj = new LongJob(pb,l);
	}
	public void actionPerformed(ActionEvent e) {
		if (!lj.isDone()) {
			lj.execute();
		}
	}
	public LongJob getJob() {
		return lj;
	}
}