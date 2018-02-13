package game;
import java.awt.EventQueue;

import org.hibernate.Session;

class XOGame {
	
	static Session session;
	static void init()
	{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		//session.beginTransaction();		
	}
	static void commit()
	{
		session.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		
		init();
		
		System.out.println("Start");
		
		EventQueue.invokeLater(	new Runnable() {
			
			@Override
			public void run() {
				new GameWindow( new GameState() );				
			}
		});
		
		
	}

}

