package fr.uparis.informatique.cours.ig.mvc;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class ActiveModel extends Observable {
	private int valeur;
	public ActiveModel() {
		valeur = 0;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int v) {
		valeur = v;
		setChanged();
		notifyObservers();
	}

}

