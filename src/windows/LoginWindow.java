package windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.hibernate.Session;

import account.Account;
import account.AccountException;
import game.GameState;
import game.HibernateUtil;
import game.Player;

public class LoginWindow extends JFrame{
	
	public LoginWindow() {
		super("Sign In");
		getContentPane().setLayout(new GridLayout(5, 5));
		
		JTextField loginField = new JTextField();
		loginField.setText("guest");
		
		getContentPane().add(loginField);
		
		
		JTextField passwordField = new JTextField();
		
		getContentPane().add(passwordField);
		
		
		JButton loginButton = new JButton();
		loginButton.setText("Sign in");
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					XOGame.localAccount = Account.signIn(loginField.getText(), passwordField.getText());
					
				} catch (AccountException e1) {
					e1.printStackTrace();
				}
				
				GameState gs;
				
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				session.beginTransaction();
				gs = session.get(GameState.class, new Integer(16));
				session.getTransaction().commit();			
				
				XOGame.changeFrame(new GameWindow(gs, new Player(0, gs)));
				dispose();
				
			}
		});
		
		getContentPane().add(loginButton);
		
		setVisible(true);
		setSize(200, 200);		
		setLocation(200, 200);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
