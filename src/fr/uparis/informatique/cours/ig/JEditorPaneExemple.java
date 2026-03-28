package fr.uparis.informatique.cours.ig;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.StyledEditorKit;

public class JEditorPaneExemple implements Runnable {
	public static void main(String [] a) {
		SwingUtilities.invokeLater(new JEditorPaneExemple());
	}
	public void run() {
		JFrame f = new JFrame(this.getClass().getName());
		Container c = f.getContentPane();
		c.setLayout(new FlowLayout());
		try {
			final JEditorPane e = new JEditorPane();
			e.setPreferredSize(new Dimension(500,500));
//			e.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
			e.setEditable(false);
			e.setPage(Utils.urlFrom("misc/test.html"));
			e.addHyperlinkListener(new HyperlinkListener() {
				public void hyperlinkUpdate(HyperlinkEvent ev) {
					if (ev.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
						try {
							e.setPage(ev.getURL());
						} catch(IOException e) {
							e.printStackTrace();
						}
				}
			});
			System.out.println(e.getDocument());
			System.out.println(e.getContentType());
			final JTextPane e2 = new JTextPane();
			e2.setEditorKit(new StyledEditorKit());
			e2.setDocument(e.getDocument());
			System.out.println(e2.getDocument());
			System.out.println(e2.getContentType());
			c.add(e);
			c.add(e2);
			f.pack();
			f.setVisible(true);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}