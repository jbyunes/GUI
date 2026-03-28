package fr.uparis.informatique.cours.ig;

import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class LongJob extends SwingWorker<Integer,Integer> {
	private JProgressBar pb;
	private JLabel label;
	private int sum;
	public LongJob(JProgressBar pb, JLabel l) {
		this.pb = pb;
		this.label = l;
		this.sum = 0;
	}
	private final int N = 200;
	// This is the task to be done in background...
	public Integer doInBackground() {
		pb.setIndeterminate(false);
		Random r = new Random();
		for (int i=0; i<=N; i++) {
			try {
				if (i<20 || i>40) {
					Thread.sleep(100+r.nextInt(500));
				}
				if (i==40) {
					Thread.sleep(5000);
				}
				// Feed the GUI !
				publish(i);
				// Advance computation
				sum += i;
				setProgress(100*i/N);
			} catch(InterruptedException e) {
			}
		}
		return sum;
	}

	// This is what has to be done under GUI's thread control...
	public void process(List<Integer> l) {
		this.label.setText(l.toString()+" : "+sum);
		this.pb.setValue(this.getProgress());
	}

	// RIP 'Lizard King', 7/3/71
	// This is the end, my only friend, the end, no safety or surprise, the end
	public void done() {
		//	pb.setVisible(false);
		try {
			this.label.setText("Sum is "+this.get());
		} catch(Exception e) {
			System.err.println("Oups");
		}
		//	firePropertyChange("done",false,true);
	}
}

