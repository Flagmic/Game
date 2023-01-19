package game;

import java.awt.event.ActionListener;

public abstract class Main implements ActionListener{
	
	public static void main(String[] args){
		Game Game=new Game();	
		Button button=new Button();
		boolean create_button=true;
		while(true) {
			while(Game.IsRunning) {
				create_button=true;
				Game.start();
				Game.GUI.remove(button);
				Game.GUI.repaint();
			}
			
			if(create_button) {
				Game.GUI.add(button);
				Game.GUI.repaint();
				create_button=false;
			}
			
			Game.IsRunning=button.IsRunning;

			Game.GUI.requestFocus();
			//makes new game
			if(Game.IsRunning) {
				Game.GUI.dispose();
				Game=new Game();
				button=new Button();
				Game.GUI.add(button);
				Game.GUI.repaint();
			}
		}
	}
}
