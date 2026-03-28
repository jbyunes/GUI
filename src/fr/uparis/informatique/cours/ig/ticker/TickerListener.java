package fr.uparis.informatique.cours.ig.ticker;

import java.util.EventListener;

public interface TickerListener extends EventListener {
	  public abstract void tickPerformed(TickerEvent te);
	}
