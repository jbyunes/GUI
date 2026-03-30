package fr.uparis.informatique.cours.ig;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.net.URI;
import java.net.URL;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImageAsyncObserverPanel extends JPanel implements ImageObserver {
	private Image image;
	private boolean onLoad;
	private int percent, height;
	public ImageAsyncObserverPanel() {
		try {
			String file = "https://yunes.informatique.univ-paris-diderot.fr/wp-content/uploads/fun/dip-1024x724.jpg";
			URL url = new URI(file).toURL();
			image = Toolkit.getDefaultToolkit().getImage(url); // asynchronous loading
			image = image.getScaledInstance(500,300,Image.SCALE_DEFAULT); // scale it
		} catch(Exception e) {
			e.printStackTrace();
		}
		setPreferredSize(new Dimension(500,300));
		onLoad = true;
		percent = 0;
		height = 300;
	}
	public void paintComponent(Graphics g) {
		System.out.println("paint "+onLoad);
		g.clearRect(0,0,500,300);
		g.drawImage(image,0,0,this);
		if (onLoad) {
			System.out.println(percent+"%");
			g.drawString("ON LOAD "+percent+"%",100,100);
		}
	}

	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		System.out.println("image update");
		if ((infoflags&(HEIGHT))!=0) {
			System.out.println("height");
			this.height = height;
		}
		if ((infoflags&(WIDTH))!=0) {
			System.out.println("width");
		}
		if ((infoflags&(FRAMEBITS | SOMEBITS))!=0) {
			//        System.out.println("bits");
			//        onLoad = true;
			//        repaint();
			//        return true;
		}
		if ((infoflags&(ALLBITS|ERROR|ABORT))!=0) {
			System.out.println("allbits, etc");
			onLoad = (infoflags&ALLBITS)==0;
			repaint(); // one last paint
			return false;
		}
		if (this.height!=0) percent = (int)(y*100.0/this.height);
		System.out.println(this.height+" "+y);
		repaint(); // animate %
		return true;
	}
}
