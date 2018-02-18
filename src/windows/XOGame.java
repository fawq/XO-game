package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JWindow;

import org.hibernate.Session;
import org.junit.internal.runners.statements.RunAfters;

import account.Account;
import account.AccountException;
import game.GameState;
import game.HibernateUtil;
import game.Player;

class XOGame {

	static JFrame frame;
	static Thread sqlLoadThread;
	static Account localAccount;

	public static void changeFrame(JFrame frame) {

		try {
			sqlLoadThread.join();
			System.out.println("Load()");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		XOGame.frame = frame;

	}

	public static void main(String[] args) {

		System.out.println("Start");
		sqlLoadThread = new Thread(new Runnable() {

			@Override
			public void run() {
				HibernateUtil.getSessionFactory();
			}
		});
		sqlLoadThread.start();
		// new LoginWindow();
		// new JWindow(new LoginWindow());

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				frame = new LoadingWindow();

				/*
				 * GameState gs;// = new GameState(Account.signIn("p1", "p1"),
				 * Account.signIn("p2", "p2") , 0);
				 * 
				 * Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				 * session.beginTransaction(); gs = session.get(GameState.class, new
				 * Integer(16)); session.getTransaction().commit(); // GameState gs = new
				 * GameState(Account.signIn("p1", "p1"), Account.signIn("p2", // "p2") , 0); new
				 * GameWindow(gs, new Player(0, gs));
				 */

			}
		});

	}

}
