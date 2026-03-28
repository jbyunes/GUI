package fr.uparis.informatique.cours.ig.layouts;
import javax.swing.*;

public class BoxLayoutExemple {
	public static void createUI() {
		JFrame fenetre = new JFrame(BoxLayoutExemple.class.toString());
		fenetre.getContentPane().setLayout(
			new BoxLayout(fenetre.getContentPane(),
			BoxLayout.Y_AXIS));
		for (int i=0; i<10; i++) {
			JButton b = new JButton("Bouton "+i);
			fenetre.getContentPane().add(b);
		}
		fenetre.pack(); // rangement «optimal»
		fenetre.setVisible(true);
	}
	public static void main(String []argv) {
		SwingUtilities.invokeLater(BoxLayoutExemple::createUI);	
	}
}
