
public abstract class Player {
	
	int role = -1; //-1 unset 
	GameState state;
	
	public Player(int role , GameState state) {
		this.role = role;
		this.state = state;
	}
	
	void move(int x , int y)
	{
		state.change( x , y , role);
	}
	
	
}
