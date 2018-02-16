package windows;

import java.awt.EventQueue;

import org.hibernate.Session;

import account.Account;
import account.AccountException;
import game.GameState;
import game.HibernateUtil;
import game.Player;

class XOGame {

	public static void main(String[] args) {

		System.out.println("Start");

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				/*try {
					Account.createAccount("p1", "p1");
					Account.createAccount("p2", "p2");
				} catch (AccountException e1) {
					e1.printStackTrace();
				}*/
				GameState gs;// = new GameState(Account.signIn("p1", "p1"), Account.signIn("p2", "p2") , 0);
				
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				session.beginTransaction();
				gs = session.get(GameState.class, new Integer(16) );
				session.getTransaction().commit();
				//GameState gs = new GameState(Account.signIn("p1", "p1"), Account.signIn("p2", "p2") , 0);
				new GameWindow(gs, new Player(0, gs));
			}
		});

	}

}
