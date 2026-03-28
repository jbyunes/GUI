package fr.uparis.informatique.cours.ig;

import javax.swing.AbstractSpinnerModel;

@SuppressWarnings("serial")
public class JSpinnerModel extends AbstractSpinnerModel {
    private static String s = "Jean-Baptiste Yunès";
    private int index;
    public JSpinnerModel() {
      index = 0;
    }
    public Object getNextValue() {
      if (index==s.length()-2) return null;
      index++;
      fireStateChanged();
      return getValue();
    }
    public Object getPreviousValue() {
      if (index==0) return null;
      index--;
      fireStateChanged();
      return getValue();
    }
    public Object getValue() {
      return ""+s.charAt(index)+s.charAt(index+1);
    }
    public void setValue(Object o) {
      //      fireStateChanged();
    }
  }
