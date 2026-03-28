package fr.uparis.informatique.cours.ig.modality;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class AppModalListener implements ActionListener {
	private JFrame theFrame;
	public AppModalListener(JFrame f) { theFrame = f; }
	public void actionPerformed(ActionEvent e) {
		final JDialog dialog = new JDialog(theFrame);
		if (theFrame!=null) {
			dialog.setTitle("Attached to "+theFrame.getTitle());
			dialog.setLocationRelativeTo(theFrame);
		}
		Dialog.ModalityType type = Dialog.ModalityType.APPLICATION_MODAL;
		dialog.setModalityType(type);
		if (dialog.getModalityType()!=type) {
			System.out.println("Modality not supported");
		}
		JButton b = new JButton("Bye");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
			}
		});
		dialog.getContentPane().add(b);
		dialog.pack();
		dialog.setVisible(true);
	}
}

