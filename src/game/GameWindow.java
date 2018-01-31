package game;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class GameWindow extends JFrame{

	JButton buttonTab[][] = new JButton[3][3];
	
	GameState state;
	
	public GameWindow( GameState state ) {
		super("XOgame");
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
		this.state = state;
		GameState test = new GameState();
		session.save(test);
		
		session.getTransaction().commit();
		 
        HibernateUtil.getSessionFactory().close();
		
		setSize(200, 200);		
		setVisible(true);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}
}
