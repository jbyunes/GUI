package fr.uparis.informatique.cours.ig.mvc;

public class ActiveAutoController extends Thread {
	private ActiveModel model;
	public ActiveAutoController(ActiveModel m) {
		this.model = m;
	}
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				model.setValeur(model.getValeur()+1);
			}
			catch(InterruptedException e) {}
		}
	}
}
