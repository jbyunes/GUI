package fr.uparis.informatique.cours.ig;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class ProgressMonitorExemple {
	private static class Task extends SwingWorker<Void, Void> implements PropertyChangeListener {
		private ProgressMonitor monitor;
		public Task(ProgressMonitor monitor) {
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
	public static void createUI() {
		final JFrame fenetre = new JFrame(ProgressMonitorExemple.class.toString());
		fenetre.getContentPane().setLayout(new FlowLayout());
		JLabel etiquette = new JLabel("<html><big>Yo!</big></html>");
		fenetre.getContentPane().add(etiquette);
		JButton b = new JButton("Start job");
		b.addActionListener(e -> {
			ProgressMonitor moniteur = new ProgressMonitor(fenetre.getContentPane(),"Boulot","",0,100);
			moniteur.setMillisToDecideToPopup(5000);
			Task t = new Task(moniteur);
			t.execute();
			b.setEnabled(false);
		});
		fenetre.getContentPane().add(b);
		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String []args) throws Exception {
		SwingUtilities.invokeLater(ProgressMonitorExemple::createUI);
	}
}
