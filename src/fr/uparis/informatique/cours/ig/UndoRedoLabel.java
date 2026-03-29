package fr.uparis.informatique.cours.ig;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class UndoRedoLabel extends JLabel implements Subscriber<Integer> {
	private Subscription subscription;
	public UndoRedoLabel() {
		super("--",SwingConstants.RIGHT);
	}
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
	}
	@Override
	public void onNext(Integer item) {
		setText(item.toString());	
		this.subscription.request(1);
	}
	@Override
	public void onError(Throwable throwable) {
	}
	@Override
	public void onComplete() {
	}
}
