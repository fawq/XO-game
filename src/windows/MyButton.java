package windows;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

import game.Player;

public class MyButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4137618880183077003L;
	int myx, myy;
	Player player;

	public MyButton(Player p, int x ,int y) {
		
		super();
		myx = x;
		myy= y;
		player = p;
		updateButton();
		
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.move(myx, myy);
				
				updateButton();				
			}
		});
	}
	
	private void updateButton()
	{
		setText(new String(""+player.state.tab[myx][myy] ));
		setEnabled(  player.state.tab[myx][myy]==-1);
	}

	/*public MyButton(Player p, Icon arg0) {
		super(arg0);
		player = p;
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.move(myx, myy);
				setText(new String(player.state.tab[myx] , myy ,myy ));

			}
		});
	}

	public MyButton(Player p, javax.swing.Action a) {
		super(a);
		player = p;
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.move(myx, myy);
				setText(new String(player.state.tab[myx] , myy ,myy ));

			}
		});
	}

	public MyButton(Player p, String text, Icon icon) {
		super(text, icon);
		player = p;
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.move(myx, myy);
				setText(new String(player.state.tab[myx] , myy ,myy ));

			}
		});
	}

	public MyButton(Player p, String text) {
		super(text);
		player = p;
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.move(myx, myy);
				setText(new String(player.state.tab[myx] , myy ,myy ));

			}
		});
	}*/
	
	public int getmyX() {
		return myx;
	}

	public void setmyX(int x) {
		this.myx = x;
	}

	public int getmyY() {
		return myy;
	}

	public void setmyY(int y) {
		this.myy = y;
	}
}
