package game;
import java.awt.EventQueue;

public class XOGame {
	public static void main(String[] args) {
		System.out.println("Start");
		EventQueue.invokeLater(	new Runnable() {
			
			@Override
			public void run() {
				new GameWindow( new GameState() );				
			}
		});
		
	}

}
