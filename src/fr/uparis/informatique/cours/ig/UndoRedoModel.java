package fr.uparis.informatique.cours.ig;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class UndoRedoModel extends Observable {
	private int value;
	public UndoRedoModel() {
		value = 0;
	}
	public void add(int v) {
		value += v;
		setChanged();
		notifyObservers(value);
	}
	public int getValue() {
		return value;
	}
}

