package fr.uparis.informatique.cours.ig.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class JFileChooserListener implements ActionListener {
	private JFrame theFrame;
	public JFileChooserListener(JFrame f) {
		theFrame = f;
	}
	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.setMultiSelectionEnabled(false);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setFileFilter(new PrefixFilter('a'));
		fc.setFileFilter(new PrefixFilter('b'));
		int résultat;
		if (e.getActionCommand().equals("Open"))
			résultat = fc.showOpenDialog(theFrame);
		else
			résultat = fc.showSaveDialog(theFrame);
		if (résultat == JFileChooser.APPROVE_OPTION) {
			System.out.println(fc.getSelectedFile());
		}
	}
}

