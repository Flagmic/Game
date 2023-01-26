package game;

public abstract class Main{
	
	public static void main(String[] args){
		Game Game=new Game();	
		Button button=new Button();
		boolean create_button=true;
		Game.start();
		while(true) {
			//waits for game to end
			while(Game.IsRunning) {
				Game.GUI.remove(button);
				Game.GUI.repaint();
			}
			//creates button after game ends
			if(create_button) {
				Game.GUI.add(button);
				Game.GUI.repaint();
				create_button=false;
			}
			//Checks if game is refreshed
			Game.IsRunning=button.IsRunning;
			
			//makes new game
			if(Game.IsRunning) {
				Game.GUI.dood.setSpeed_y(-15);
				Game.GUI.requestFocus();
				Game.GUI.remove(button);
				button.IsRunning=false;
				Game.GUI.repaint();
				create_button=true;
			}
		}
	}
}
