package fr.uparis.informatique.cours.ig.ticker;

import java.util.EventObject;

@SuppressWarnings("serial")
public class TickerEvent extends EventObject {
	private int count;
	public TickerEvent(Object source, int count) {
		super(source);
		this.count = count;
	}
	public int getCount() {
		return count;
	}
}
