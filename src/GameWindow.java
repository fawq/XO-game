import javax.swing.JButton;
import javax.swing.JFrame;

public class GameWindow extends JFrame{

	JButton buttonTab[][] = new JButton[3][3];
	
	GameState state;
	
	public GameWindow( GameState state ) {
		this.state = state;
			
	}
}
