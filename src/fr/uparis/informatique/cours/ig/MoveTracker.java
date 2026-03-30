package fr.uparis.informatique.cours.ig;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MoveTracker implements MouseMotionListener {
	public void mouseDragged(MouseEvent e) {
		System.out.println("dragged ("+e.getX()+','+e.getY()+')');
	}
	public void mouseMoved(MouseEvent e) {
		System.out.println("moved ("+e.getX()+','+e.getY()+')');
	}
}

