package fr.uparis.informatique.cours.ig.ticker;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.EventListenerList;

public abstract class TickerModel implements AncestorListener {
	protected EventListenerList listeners;
	public TickerModel() {
		listeners = new EventListenerList();
	}
	public void addTickerListener(TickerListener tl) {
		listeners.add(TickerListener.class,tl);
	}
	public void removeTickerListener(TickerListener tl) {
		listeners.remove(TickerListener.class,tl);
	}
	@Override
	public void ancestorAdded(AncestorEvent event) {
	}
	@Override
	public void ancestorRemoved(AncestorEvent event) {
		stop();
	}
	@Override
	public void ancestorMoved(AncestorEvent event) {
	}

	public abstract void setDelay(int s);
	public abstract void start();
	public abstract void stop();
}
