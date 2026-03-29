package fr.uparis.informatique.cours.ig.mvc;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class PassiveView2 extends JSlider implements Subscriber<Integer> { 
	private Subscription subscription;

	private static final long serialVersionUID = 1L;
	public PassiveView2() {
		this.setMinimum(0);
		this.setMaximum(100);
		this.setOrientation(SwingConstants.HORIZONTAL);
		this.setMinorTickSpacing(10);
		this.setMajorTickSpacing(20);
		this.setPaintTicks(true);
		this.setPaintLabels(true);
		this.setEnabled(false);
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(Integer item) {
		setValue(item);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
	}

	@Override
	public void onComplete() {
	}
}
