package fr.uparis.informatique.cours.ig.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class PassiveController extends SubmissionPublisher<Integer> implements ActionListener {
	private PassiveModel m;

	public PassiveController(PassiveModel m ) {
		this.m = m;
	}
	public void actionPerformed(ActionEvent e) {
		m.setValeur(m.getValeur()+1);
		updateViews();
	}  
	public void updateViews() {
		submit(m.getValeur());
	}
	@Override
	public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
		super.subscribe(subscriber);
		submit(m.getValeur()); // on new subscriber
	}
}
