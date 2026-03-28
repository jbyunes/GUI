package fr.uparis.informatique.cours.ig.ticker;

import javax.swing.Timer;

public class DefaultTickerModel extends TickerModel {
	private int secondes;
	private int delay;
	private Ticker ticker;
	private Timer timer;
	public DefaultTickerModel(Ticker t) {
		delay = 1;
		secondes = 0;
		ticker = t;
	}
	public  void setDelay(int s) {
		delay = s;
	}
	public  void start() {
		if (timer!=null && timer.isRunning()) return; // only once
		timer = new Timer(1000,e -> tick());
		timer.start();
	}
	private void fireTickerEvent() {
		TickerEvent e = new TickerEvent(this, secondes);
		TickerListener []l = listeners.getListeners(TickerListener.class);
		for (var t: l) {
			t.tickPerformed(e);
		}
	}
	public void tick() {
		secondes++;
		if (secondes%delay==0) fireTickerEvent();
		ticker.repaint();
	}
	public void stop() {
		if (timer==null || !timer.isRunning()) return;
		timer.stop();
	}
}
