package game;

import java.util.Random;

public class Game extends Thread{
	boolean first=true;
	boolean IsRunning=true;
	GUI GUI=new GUI();
	int num_p=1;
	Platform[] Platforms=new Platform[30];
	Platform previous= new Platform();
	Random r=new Random();
	
		public synchronized void run(){
			while(true) {
		while(IsRunning) {
		GUI.dood.requestFocus();
		GUI.dood.tick();	
		
		//platform generation
		if(first) {
			Platforms[0]=previous;
			GUI.add(previous);
			first=false;
		}
			while(num_p<30) {
				Platform p=new Platform(previous);
				p.setLocation(r.nextInt(385),p.getY()-r.nextInt(50)-50);
				Platforms[num_p]=p;
				GUI.add(p);
				GUI.repaint();
				previous=p;
				num_p++;
			}
			
			//platform movement
			if(GUI.dood.getY()<=150) {
				GUI.Score.addScore(GUI.dood);
			if(GUI.dood.getSpeed_y()<0) {
				for(int i=0;i<num_p;i++) {
					Platforms[i].movePlatform(Platforms[i],GUI);
				}
				GUI.dood.setY(150);
			}
		}
		
		//jump/bounce on platforms
		if(GUI.dood.getSpeed_y()>0) {
		for(int i=0;i<num_p;i++) {
			if(Platforms[i]==null) {continue;}
			if(Platforms[i].canJump) {
			Platforms[i].jump(Platforms[i],GUI);
			}
			
			
			}
		}
		
			if(Platforms[0].getY()>560) {
				
				//removing platforms
				Platforms[0]=null;
				num_p--;
				
				//refreshing platform indexes
				for(int i=0;i<num_p;i++) {
				Platforms[i]=Platforms[i+1];
				Platforms[i+1]=null;
				}
				
			}
			//teleport from left to right and back
				if(GUI.dood.getX()+30<0) {
					GUI.dood.setX(420);
				}
				else if(GUI.dood.getX()+30>450) {
					GUI.dood.setX(-30);
			}
				
			//end/start of the game
				if(GUI.dood.getY()>=570) {
					IsRunning=false;
				}
				try {
					Game.sleep(5);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
		}
		System.out.println("a"); 
	}
	}
}
