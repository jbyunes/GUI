package fr.uparis.informatique.cours.ig;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DetecteurDeClicBis implements MouseListener {
	private DetecteurDeMouvement dm;
	private boolean moveDetected;
	public DetecteurDeClicBis() {
		dm = new DetecteurDeMouvement();
		moveDetected = false;
	}
	public void mousePressed(MouseEvent e) {
		((Component)e.getSource()).addMouseMotionListener(dm);
		System.out.println("Ok, c'est parti!");
	}
	public void mouseReleased(MouseEvent e) {
		((Component)e.getSource()).removeMouseMotionListener(dm);
		System.out.println("Stop, y'en a marre!");
	}
	public void mouseClicked(MouseEvent e) {
		if (!moveDetected) {
			((Component)e.getSource()).addMouseMotionListener(dm);
			System.out.println("On y va");
		}
		else {
			((Component)e.getSource()).removeMouseMotionListener(dm);
			System.out.println("Basta");
		}
		moveDetected = !moveDetected;
	}
	public void mouseEntered(MouseEvent e) {
		System.out.println("Entered");
	}
	public void mouseExited(MouseEvent e) {
		System.out.println("Exited");
	}
}

