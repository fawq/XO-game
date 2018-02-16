package game;

public class Player {
	
	
	int role = -1; //-1 unset 
	public GameState state;
	
	public Player(int role , GameState state) {
		this.role = role;
		this.state = state;
	}
	
	public void move(int x , int y)
	{
		System.out.println("Player.move()");
		state.change( x , y , role);
	}
	
	public int getRole()
	{
		return role;
	}
	
	
}
