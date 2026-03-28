package fr.uparis.informatique.cours.ig;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class JComponentExemple {
	public JComponentExemple() {
		JFrame fenetre = new JFrame(this.getClass().toString());
		JLabel etiquette = new JLabel("<html><body><p>Une femme mariée à un homme qui la trompe avec la femme de son amant,<p> laquelle trompe son mari avec le sien et qui en est réduite à tromper son amant<p> avec celui de sa femme parce que son amant est son mari et<p> que la femme de son époux  est la maîtresse d'un homme déshonoré par l'amant d'une femme dont<P> le mari trompe sa maîtresse avec la femme de son amant ne sait plus où elle en est ni ce qu'elle doit faire<p>  pour ne pas compliquer encore une situation qui l'est déjà suffisamment comme ça.</p></body></html>");
		//    etiquette.setOpaque(true);
		etiquette.setBackground(Color.YELLOW);
		etiquette.setForeground(Color.BLUE);
		etiquette.setFont(Font.decode("Times-36"));
		etiquette.setToolTipText("texte de Pierre Dac ou de sa sœur personne ne sait vraiment…");
		//    fenetre.getContentPane().add(etiquette);
		fenetre.add(etiquette);
		fenetre.pack();
		fenetre.setVisible(true);
	}
	public static void main(String []args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JComponentExemple();
			}
		});
	}
}
