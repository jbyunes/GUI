package fr.uparis.informatique.cours.ig.mvc;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

@SuppressWarnings("deprecation")
public class ActiveView1 extends JLabel implements Observer { 
	private static final long serialVersionUID = 1L;
	
	public void update(Observable source,Object datas) {
		ActiveModel m = (ActiveModel)source;
		setText("Value="+m.getValeur());
	}
}

