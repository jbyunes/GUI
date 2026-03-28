package fr.uparis.informatique.cours.ig.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class OptionListener implements ActionListener {
	private static String []options = {
			"Blanc d'Espagne", 
			"Bleu de Klein", 
			"Rouge groseille", 
			"Vert pistache" };
	private JFrame theFrame;
	private JLabel theLabel;
	public OptionListener(JFrame f, JLabel l) {
		theFrame = f;
		theLabel = l;
		}
	public void actionPerformed(ActionEvent e) {
		int resultat = JOptionPane.showOptionDialog(theFrame,
				"C'est quoi ta couleur préférée ?",
				"Allez engage-toi!",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[2]
				);
		if (resultat>=0) {
			theLabel.setText("Je savais que tu aimais le "+options[resultat]);
		} else {
			theLabel.setText("Tu ne sais pas choisir ?");
		}
	}
}

