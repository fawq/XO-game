package windows;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import org.hibernate.Session;

import account.Account;
import game.GameState;
import game.HibernateUtil;
import game.Player;

public class GameMenuWindow extends JFrame {

	private int width = 400, height = 400;
	JList<String> gameList;
	ArrayList<GameState> list;
	DefaultListModel<String> listModel;

	public GameMenuWindow() {
		super("Menu");

		setVisible(true);
		setSize(width, height);
		setLocation(200, 200);

		getContentPane().setLayout(null);

		JLabel label = new JLabel("Chose game");
		label.setBounds(0, 0, width, height / 10);
		getContentPane().add(label);

		JButton play = new JButton("Play");
		play.setBounds(0, (int) (0.6 * height), width / 2, (int) (0.2 * height));
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				GameState gs;

				gs = list.get(gameList.getSelectedIndex());
				if (gs.getPlayerO().getName().equals(XOGame.localAccount.getName())) {
					XOGame.changeFrame(new GameWindow(gs, new Player(0, gs)));
				} else {
					XOGame.changeFrame(new GameWindow(gs, new Player(1, gs)));
				}

				dispose();
			}
		});
		getContentPane().add(play);

		JTextField nickField = new JTextField();
		nickField.setBounds(width / 2, (int) (0.6 * height), width / 2, height / 10);
		getContentPane().add(nickField);

		JButton createGameButton = new JButton("Create game");
		createGameButton.setBounds(width/2, (int)(0.7*height), width/2, height/10);
		createGameButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				session.beginTransaction();

				Account opponent = session.get(Account.class, nickField.getText());

				session.getTransaction().commit();

				if (opponent == null) {
					throw new NullPointerException();
					//return;
				}

				GameState temp;

				if (new Random().nextBoolean()) {
					list.add(temp = new GameState(XOGame.localAccount, opponent, 1));
				} else {
					list.add(temp = new GameState(XOGame.localAccount, opponent, 0));
				}
				listModel.addElement(get_info(temp));
				gameList.setModel(listModel);

			}
		});

		getContentPane().add(createGameButton);

		JScrollPane scrollPane;
		
		listModel = new DefaultListModel<>();
			
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();


		list = new ArrayList<>(
				session.createQuery("from GameState where playero_name = '" + XOGame.localAccount.getName()
						+ "' or playerx_name = '" + XOGame.localAccount.getName() + "'").list());

		session.getTransaction().commit();
		
		
		for (GameState gameState : list) {

			String gameInfo = get_info(gameState);

			listModel.addElement(gameInfo);
		}

		gameList = new JList<>(listModel);

		scrollPane = new JScrollPane(gameList);
		scrollPane.setBounds(0, height / 10, width, height / 2);

		getContentPane().add(scrollPane);

	}

	private String get_info(GameState gameState) {
		String gameInfo;

		if (XOGame.localAccount.getName().equals(gameState.getPlayerO().getName())) {
			gameInfo = "Against: " + gameState.getPlayerX().getName();
		} else {
			gameInfo = "Against: " + gameState.getPlayerO().getName();
		}
		if (gameState.getTurn() > 1) {
			gameInfo += "Game Ended";
		} else if ((gameState.getTurn() == 0 && XOGame.localAccount.getName().equals(gameState.getPlayerO().getName()))
				|| (gameState.getTurn() == 1
						&& XOGame.localAccount.getName().equals(gameState.getPlayerX().getName()))) {
			gameInfo += "Your turn";
		} else {
			gameInfo += "Waiting for opponent";
		}

		return gameInfo;
	}

}
