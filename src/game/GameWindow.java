package game;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class GameWindow extends JFrame{

	MyButton buttonTab[][] = new MyButton[3][3];
	
	GameState state;
	Player player;
	
	public GameWindow( GameState state ) {
		super("XOgame");
		player = new Player(1 , state) {
		};
		this.state = state;
		getContentPane().setLayout(new GridLayout(3, 3));
		
		int xy=0;
		for (MyButton[] myButtons : buttonTab) {
			for (MyButton myButton : myButtons) {
				myButton = new MyButton(player);
				myButton.setmyX(xy%3);
				myButton.setmyY(xy/3);
				xy++;
				getContentPane().add(myButton);
			}
		}	
		
		setSize(200, 200);		
		setVisible(true);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}
	
}
