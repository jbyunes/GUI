package fr.uparis.informatique.cours.ig.mvc;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import javax.swing.JLabel;

public class PassiveView3 extends JLabel  implements Subscriber<Integer> { 
	private static final long serialVersionUID = 1L;
	private Subscription subscription;

	public void update(PassiveModel m) {
	}
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(Integer item) {
		String text = "";
		if (item<10) text = "<10";
		else
			if (item<20) text = "dans [10,20)";
			else text = "grosse valeur!";
		setText(text);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
	}

	@Override
	public void onComplete() {
	}

}
