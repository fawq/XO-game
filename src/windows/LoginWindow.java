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
import account.AccountExistException;
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
					
				} catch (AccountExistException e1) {
					
					try {
						XOGame.localAccount = Account.createAccount(loginField.getText(), passwordField.getText());
					} catch (AccountException e2) {
						e2.printStackTrace();
					}
				}
				catch (AccountException e2)
				{
					e2.printStackTrace();
				}
				
				XOGame.changeFrame(new GameMenuWindow());
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
