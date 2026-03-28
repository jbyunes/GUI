package fr.uparis.informatique.cours.ig.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ConfirmListener implements ActionListener {
	private JFrame theFrame;
	private JLabel theLabel;
	public ConfirmListener(JFrame f, JLabel l) {
		theFrame = f;
		theLabel = l;
		}
	public void actionPerformed(ActionEvent e) {
		int resultat = JOptionPane.showConfirmDialog(theFrame,
				"Avec vos yeux cernés, "+
						"vous me semblez bien fatigué.\n"+
						"Désirez-vous vous reposer ?",
						"Prenez une décision une fois dans votre vie!",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE);
		if (resultat==JOptionPane.YES_OPTION) {
			System.out.println("Feignasse!");
		}
		String s = switch(resultat) {
			case JOptionPane.YES_OPTION -> "YES";
			case JOptionPane.NO_OPTION -> "NO";
			case JOptionPane.CANCEL_OPTION -> "CANCEL";
			case JOptionPane.CLOSED_OPTION -> "CLOSED";
			default -> "???";
		};
		theLabel.setText(s);
	}
}

