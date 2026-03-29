package fr.uparis.informatique.cours.ig.mvc;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class ActiveModel extends SubmissionPublisher<Integer> {
	private int valeur;
	public ActiveModel() {
		valeur = 0;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int v) {
		valeur = v;
		submit(valeur);
	}
	@Override
	public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
		super.subscribe(subscriber);
		submit(valeur); // on new subscriber
	}
}

