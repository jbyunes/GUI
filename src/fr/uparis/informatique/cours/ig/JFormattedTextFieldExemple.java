package fr.uparis.informatique.cours.ig;
import javax.swing.*;
import java.text.*;
import java.util.*;

public class JFormattedTextFieldExemple {
	public static void createUI() {
		JFrame fenetre = new JFrame(JFormattedTextFieldExemple.class.toString());

		JPanel panneau = new JPanel();
		panneau.add(new JLabel("Ton nom :"));
		panneau.add(new JTextField("Vas-y tapes quelque chose!"));
		panneau.add(new JLabel("File-moi ton mot de passe :"));
		panneau.add(new JPasswordField(15));
		panneau.add(new JLabel("Fais pas ton timide, file-moi ta date de naissance :"));
		Format f = new SimpleDateFormat("dd/mm/yyyy");
		JFormattedTextField ftf = new JFormattedTextField(f);
		ftf.setValue(new Date());
		panneau.add(ftf);

		fenetre.add(panneau);
		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(JFormattedTextFieldExemple::createUI);
	}
}
