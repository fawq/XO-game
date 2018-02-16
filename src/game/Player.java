package game;

public abstract class Player {
	
	
	int role = -1; //-1 unset 
	GameState state;
	
	public Player(int role , GameState state) {
		this.role = role;
		this.state = state;
	}
	
	void move(int x , int y)
	{
		System.out.println("Player.move()");
		state.change( x , y , role);
		//XOGame.init();
		//XOGame.session.beginTransaction();
		//XOGame.session.save(state);
		//XOGame.commit();
	}
	
	
}
