package fr.uparis.informatique.cours.ig;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings({ "serial", "deprecation" })
public class UndoRedoLabel extends JLabel implements Observer {
	public UndoRedoLabel() {
		super("0",SwingConstants.RIGHT);
	}
	public void update(Observable o,Object v) {
		setText(v.toString());
		// setText(((MyModel)o).getValue());
	}
}
