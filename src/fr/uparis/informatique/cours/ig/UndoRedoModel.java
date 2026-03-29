package fr.uparis.informatique.cours.ig;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class UndoRedoModel extends SubmissionPublisher<Integer> {
	private int value;
	public UndoRedoModel() {
		value = 0;
	}
	public void add(int v) {
		value += v;
		submit(value);
	}
	public int getValue() {
		return value;
	}
	@Override
	public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
		super.subscribe(subscriber);
		submit(value); // on new subscriber
	}
}

