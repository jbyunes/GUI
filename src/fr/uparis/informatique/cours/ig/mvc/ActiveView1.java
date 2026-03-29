package fr.uparis.informatique.cours.ig.mvc;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import javax.swing.JLabel;

public class ActiveView1 extends JLabel implements Subscriber<Integer> { 
	private static final long serialVersionUID = 1L;
	private Subscription subscription;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(Integer item) {
		setText("Value="+item);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
	}

	@Override
	public void onComplete() {
	}
}

