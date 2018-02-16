package game;
import java.awt.EventQueue;

import org.hibernate.Session;

import account.Account;
import account.AccountException;

class XOGame {
	
	
	public static void main(String[] args) {
		
		
		
		System.out.println("Start");
		
		EventQueue.invokeLater(	new Runnable() {
			
			@Override
			public void run() {
				try {
					Account.createAccount("p1", "p1");
					Account.createAccount("p2", "p2");
				} catch (AccountException e1) {
					e1.printStackTrace();
				}
				try {
					new GameWindow( new GameState( Account.signIn("p1", "p1") , Account.signIn("p2", "p2") ) );
				} catch (AccountException e) {
					e.printStackTrace();
				}				
			}
		});
		
		
	}

}

