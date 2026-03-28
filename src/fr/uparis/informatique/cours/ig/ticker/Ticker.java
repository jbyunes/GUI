package fr.uparis.informatique.cours.ig.ticker;

import java.lang.reflect.Method;

import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;

@SuppressWarnings("serial")
public class Ticker extends JComponent {
	private String packageName = this.getClass().getPackage().getName();
	private TickerModel model;
	public Ticker() {
		TickerModel tm = new DefaultTickerModel(this);
		this.addAncestorListener(tm);
		ComponentUI ui = new TickerUI();
		setUI(ui);
		model = tm;
		this.addAncestorListener(tm);
	}
	public void addTickerListener(TickerListener tl) {
		model.addTickerListener(tl);
	}
	public void removeTickerListener(TickerListener tl) {
		model.removeTickerListener(tl);
	}
	public void setDelay(int secondes) {
		model.setDelay(secondes);
	}
	public void start() {
		model.start();
	}
	public void stop() {
		model.stop();
	}
	public void updateUI() {
		String n = UIManager.getLookAndFeel().getID();
		n = packageName+"."+n+"TickerUI";
		System.out.println("Here ["+n+"]");
		Class<?> cl = null;
		try {
			cl = Class.forName(n);
		} catch(Exception e) {
			cl = TickerUI.class;
			System.out.println("No "+n+" available, defaulted to "+cl);
		}
		try {
			Method m = cl.getDeclaredMethod("createUI");
			Object o = m.invoke(cl);
			setUI((ComponentUI)o);
			repaint();
		} catch(Exception e) {
			System.err.println("Problem while calling createUI for "+n);
		}
	}
}
