import javax.swing.JButton;
import javax.swing.JFrame;

public class GameWindow extends JFrame{

	JButton buttonTab[][] = new JButton[3][3];
	
	GameState state;
	
	public GameWindow( GameState state ) {
		super("XOgame");
		this.state = state;
		
		setSize(200, 200);		
		setVisible(true);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}
}
