package fr.uparis.informatique.cours.ig;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URI;
import java.net.URL;

import javax.swing.JPanel;

public @SuppressWarnings("serial")
class ImageTrackingPanel extends JPanel {
	private static final int N=5;
	private static final int M=10;
	private Image [][] images;
	private MediaTracker track;
	public ImageTrackingPanel() {
		track = new MediaTracker(this);

		setPreferredSize(new Dimension(68*N,35*M));
		images = new Image[N][M];
		new Thread(new Runnable() {
			public void run() {
				for (int i=0; i<N; i++) {
					for (int j=0; j<M; j++) {
						try {
							String file = "https://yunes.informatique.univ-paris-diderot.fr/raw/images/zorglub"+i+"-"+j+".png";
							System.out.println("Loading "+file);
							URL url = new URI(file).toURL();
							images[i][j] = Toolkit.getDefaultToolkit().getImage(url).getScaledInstance(68,35,Image.SCALE_SMOOTH); // asynchronous loading
							track.addImage(images[i][j],i*N+j);
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
				System.out.println("Wait for loads");
				try {
					ImageTrackingPanel.this.track.waitForAll();
				} catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("Loaded, painting now enforced");
				ImageTrackingPanel.this.repaint();
			}
		}).start();
	}
	public void paintComponent(Graphics g) {
		System.out.println("paintComponent");
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.println("Image: "+images[i][j]);
				if (images[i][j]!=null && track.checkID(i*N+j)) {
					g.drawImage(images[i][j],68*i,35*j,null);
				} else {
					g.drawString("on load",68*i,35*j+15);
				}
			}
		}
	}
}

