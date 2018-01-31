import javax.swing.JButton;
import javax.swing.JFrame;

import org.hibernate.Session;

public class GameWindow extends JFrame{

	JButton buttonTab[][] = new JButton[3][3];
	
	GameState state;
	
	public GameWindow( GameState state ) {
		super("XOgame");
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
		this.state = state;
		session.save(state);
		
		setSize(200, 200);		
		setVisible(true);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}
}
