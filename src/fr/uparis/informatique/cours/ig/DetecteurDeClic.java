package fr.uparis.informatique.cours.ig;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DetecteurDeClic implements MouseListener {
	public void mousePressed(MouseEvent e) {
		System.out.println("Là, tu fais mal! en position "+e.getX()+","+e.getY());
	}
	public void mouseReleased(MouseEvent e) {
		System.out.println("La pression se relâche, c'est cool");
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("Bouton n°"+e.getButton());
		System.out.println("J'ai bien reçu ton poke : "+e.getClickCount());
	}
	public void mouseEntered(MouseEvent e) {
		System.out.println("Buenos días, ràton!");
	}
	public void mouseExited(MouseEvent e) {
		System.out.println("C'est ça, tire-toi...");
	}
}