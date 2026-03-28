package fr.uparis.informatique.cours.ig;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.List;

public class MyFocusPolicy extends FocusTraversalPolicy {
	List<Component> components;
	public MyFocusPolicy(List<Component> c) {
		components = c;
	}
	public Component getComponentAfter(Container c,Component cp) {
		int index = components.indexOf(cp);
		index = index+2;
		if (index>=components.size())
			if (index%2==0) index = 1;
			else index=0;
		return components.get(index);
	}
	public Component getComponentBefore(Container c,Component cp) {
		int index = components.indexOf(cp);
		index = index-2;
		System.out.println("before  ="+index+" "+(index%2));
		if (index<0) {
			if (index%2==0) {
				if (components.size()%2==0) index = components.size()-1;
				else index=components.size()-2;
			} else {
				if (components.size()%2==0) index = components.size()-2;
				else index=components.size()-1;
			}
		}
		return components.get(index);
	}
	public Component getDefaultComponent(Container c) {
		return components.get(5);
	}
	public Component getLastComponent(Container c) {
		return components.getLast();
	}
	public Component getFirstComponent(Container c) {
		return components.getFirst();
	}
}

