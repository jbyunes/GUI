package fr.uparis.informatique.cours.ig;

import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ProgressMonitor;
import javax.swing.SwingWorker;

public class ProgressTask extends SwingWorker<Void, Void> implements PropertyChangeListener {
	private ProgressMonitor monitor;
	public ProgressTask(ProgressMonitor monitor) {
		this.monitor = monitor;
		this.addPropertyChangeListener(this);
	}
	@Override
	public Void doInBackground() {
		int progress = 0;
		setProgress(progress);
		try {
			Thread.sleep(1000);
			while (progress < 100 && !isCancelled()) {
				Thread.sleep(100);
				progress += 1;
				setProgress(progress);
				System.out.println("ici"+progress);
			}
		} catch (InterruptedException ignore) {}
		return null;
	}

	@Override
	public void done() {
		try { Thread.sleep(1000); }
		catch (InterruptedException e) { }
		monitor.close();
	}
	public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName() ) {
            int progress = (Integer) evt.getNewValue();
            monitor.setProgress(progress);
			monitor.setNote("Je bosse dur moi..."+progress+"%");
            if (monitor.isCanceled() || isDone()) {
                Toolkit.getDefaultToolkit().beep();
                if (monitor.isCanceled()) {
                    this.cancel(true);
                } else {
                	monitor.setNote("Terminé");
                }
            }
        }
 
    }
}
