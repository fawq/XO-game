package game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class GameState {

	@Id
	int id;
	char[][] tab;
	int turn = -1; // -1 unset, 0 O , 1 X

	GameState()
	{
		tab = new char[3][3];
	}
	
	boolean change(int x , int y , int state)
	{
		if(tab[x][y] == -1)
		{
			tab[x][y] = (char) state;
			return true;
		}
		return false;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTab() {
		String temp = new String(tab[0]);
		temp = temp + new String(tab[1]) + new String(tab[2]);
		
		return temp;
	}

	public void setTab(String tab) {
		int i = 0;
		char[][] temp = new char[3][3];
		for (char[] cs : temp) {
			for (char c : cs) {
				c = tab.charAt(i++);
			}
		}
		this.tab = temp;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
}
