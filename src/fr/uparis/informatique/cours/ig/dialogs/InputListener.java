package fr.uparis.informatique.cours.ig.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InputListener implements ActionListener {
	private JFrame theFrame;
	public InputListener(JFrame f) { theFrame = f; }
	public void actionPerformed(ActionEvent e) {
		String []options = { "Blanc d'Espagne", 
				"Bleu Klein", 
				"Rouge groseille", 
		"Vert pistache" };
		Object résultat = JOptionPane.showInputDialog(theFrame,
				"Je préfère le",
				"Allez engage-toi!",
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[2]
				);
		if (résultat!=null)
			System.out.println("C'est fou, car je savais que ta couleur préférée était le "+résultat);
	}
}

