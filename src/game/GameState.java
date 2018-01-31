package game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class GameState {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	int tab = 2;
	int turn = -1; // -1 unset, 0 O , 1 X
	
	public int getTab() {
		return tab;
	}

	public void setTab(int tab) {
		this.tab = tab;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	GameState()
	{
		/*for(int[] i : tab)
		{
			for(int j : i)
			{
				j = -1;
			}
		}*/
	}
	
	boolean change(int x , int y , int state)
	{
		/*if(tab[x][y] == -1)
		{
			tab[x][y] = state;
			return true;
		}*/
		return false;
	}
}
