package game;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Platform extends JLabel{
	private static final long serialVersionUID = 1L;
	
	boolean breakable=false;
	boolean canJump=true;
	
	private int width=60;
	private int height=10;
	private double speed=0;

	
	public Platform() {
		setLocation(0,550);
		this.setSize(width, height);
		this.setBackground(Color.blue);
		ImageIcon a=new ImageIcon("Pictures\\platform.png");
		this.setIcon(new ImageIcon(a.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));
		this.setOpaque(true);
	}
	public Platform(Platform p) {
		int isBreakable;
		Random r=new Random();
		isBreakable=r.nextInt(10)+1;
		this.setBackground(Color.blue);
		setBounds(p.getX(),p.getY(),p.getWidth(),p.getHeight());
		this.setOpaque(true);
		ImageIcon a=new ImageIcon("Pictures\\platform.png");
		this.setIcon(new ImageIcon(a.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));
		if(isBreakable<=3) {
			breakable=true;
			ImageIcon b=new ImageIcon("Pictures\\breakyplatform.png");
			this.setIcon(new ImageIcon(b.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));
//			this.setBackground(Color.black);
		}
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public void tick(Character dood) {
		setLocation(getX(),getY()-(int)dood.getSpeed_y());
	}
	public boolean checkJump(Platform Platform, GUI GUI) {
			if(Platform.canJump) {
				if(Platform.getY()<=GUI.dood.getY()+GUI.dood.getHeight()) {
					if(Platform.getY()>=GUI.dood.getY()+(GUI.dood.getHeight()*4)/5) {
						if(Platform.getX()<=GUI.dood.getX()+GUI.dood.getWidth()) {
							if(Platform.getX()>=GUI.dood.getX()-Platform.getWidth()) {

								return true;
							}
						}
					}
				}
			}
				return false;
	}
	public void jump(Platform Platform, GUI GUI) {
		if(Platform.getY()<=GUI.dood.getY()+GUI.dood.getHeight()) {
			if(Platform.getY()>=GUI.dood.getY()+(GUI.dood.getHeight()*4)/5) {
				if(Platform.getX()<=GUI.dood.getX()+GUI.dood.getWidth()) {
					if(Platform.getX()>=GUI.dood.getX()-Platform.getWidth()) {
						GUI.dood.setSpeed_y(-5);
						if(Platform.breakable) {
							Platform.canJump=false;
							Platform.setIcon(null);
							Platform.setBackground(null);
						}
					}
				}
			}
		}
}
	public void movePlatform(Platform Platform, GUI GUI) {
		Platform.setSpeed(GUI.dood.getSpeed_y()*-1);
		Platform.tick(GUI.dood);
		if(Platform.getSpeed()!=0) {
			Platform.setSpeed(Platform.getSpeed()+0.06);
	}

	}
}
