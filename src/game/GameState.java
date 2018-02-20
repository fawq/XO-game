package game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.Session;
import org.hibernate.annotations.Type;

import account.Account;
import account.AccountException;
import javassist.compiler.ast.IntConst;



@Entity
public class GameState {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	public int[][] tab;
	int turn = -1; // -1 unset, 0 O , 1 X
	
	@ManyToOne
	Account playerX , playerO;

	
	private GameState()
	{
		
	}
	public GameState(Account x , Account o , int whoStart)
	{
		turn = whoStart;
		playerX = x;
		playerO = o;
		tab = new int[3][3];
		for (int[] cs : tab) {
			for (int i = 0; i < cs.length; i++) {
				cs[i] = -1;
			}
		}
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	
		session.save(this);
		session.getTransaction().commit();		
	}
	
	boolean change(int x , int y , int state)
	{
		if(state != turn)return false;

		if(tab[x][y] == -1)
		{
			tab[x][y] = state;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			turn=(++turn)%2;
			System.out.println(turn);
			session.update(this);
			session.getTransaction().commit();		
			return true;
		}
		return false;
	}
	
	public void update()
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		GameState gs = session.get(GameState.class , new Integer(id));
		session.getTransaction().commit();	
		
		this.tab = gs.tab;
		this.turn = gs.turn;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public int[][] getTab() {
		return tab;
	}

	public void setTab(int[][] tab) {
		this.tab = tab;
	}


	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	public Account getPlayerX() {
		return playerX;
	}

	public void setPlayerX(Account playerX) {
		this.playerX = playerX;
	}

	public Account getPlayerO() {
		return playerO;
	}

	public void setPlayerO(Account playerO) {
		this.playerO = playerO;
	}
	
	/*public static void main(String[] args) {
		try {
			Account.createAccount("p1", "p1");
			Account.createAccount("p2", "p2");
		} catch (AccountException e1) {
			e1.printStackTrace();
		}
		System.out.println("Account Created");
		try {
			new GameState(account.Account.signIn("p1", "p1"),account.Account.signIn("p2", "p2")).getTab();
			
		} catch (AccountException e) {
			
			e.printStackTrace();
		}
	}*/
}
