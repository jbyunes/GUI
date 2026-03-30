package fr.uparis.informatique.cours.ig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class AsyncTaskLauncher implements ActionListener {
	AsyncLongTask lj;
	public AsyncTaskLauncher(JProgressBar pb, JLabel l) {
		lj = new AsyncLongTask(pb,l);
	}
	public void actionPerformed(ActionEvent e) {
		if (!lj.isDone()) {
			lj.execute();
		}
	}
	public AsyncLongTask getJob() {
		return lj;
	}
}