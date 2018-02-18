package windows;

import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoadingWindow extends JFrame {

	public LoadingWindow() {
		super("Loading...");
		getContentPane().setLayout(new GridLayout());
		
		JLabel loading = new JLabel("Loading...");
		getContentPane().add(loading);
		setVisible(true);
		setSize(200, 200);		
		setLocation(200, 200);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					XOGame.sqlLoadThread.join();
					XOGame.frame = new LoginWindow();
					LoadingWindow.this.dispose();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			}
		}).start();
	}


}
