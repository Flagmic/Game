package game;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Platform extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int width=60;
	private int height=10;
	private double speed=0;

	
	public Platform() {
		setLocation(0,550);
		this.setSize(width, height);
		ImageIcon a=new ImageIcon("Pictures\\platform.png");
		this.setIcon(new ImageIcon(a.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));
		this.setOpaque(true);
		this.setBackground(Color.blue);		
	}
	public Platform(Platform p) {
		setBounds(p.getX(),p.getY(),p.getWidth(),p.getHeight());
		this.setOpaque(true);
		this.setBackground(Color.blue);
		ImageIcon a=new ImageIcon("Pictures\\platform.png");
		this.setIcon(new ImageIcon(a.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));
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
	public void checkJump(Platform Platform, GUI GUI) {
				if(Platform.getY()<=GUI.dood.getY()+GUI.dood.getHeight()) {
					if(Platform.getY()>=GUI.dood.getY()+(GUI.dood.getHeight()*4)/5) {
						if(Platform.getX()<=GUI.dood.getX()+GUI.dood.getWidth()) {
							if(Platform.getX()>=GUI.dood.getX()-Platform.getWidth()) {
								GUI.dood.setSpeed_y(-11);
							}
						}
					}
				}
	}
	public void movePlatform(Platform Platform, GUI GUI) {
		Platform.setSpeed(GUI.dood.getSpeed_y()*-1);
		Platform.tick(GUI.dood);
		if(Platform.getSpeed()!=0) {
			Platform.setSpeed(Platform.getSpeed()+0.05);
	}
	}
}
