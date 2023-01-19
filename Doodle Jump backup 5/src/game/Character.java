package game;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Character extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon image;
	private int x;
	private int y;
	private double speed_x;
	private double speed_y;
	final private int size_x=60;
	final private int size_y=60;
	
	public void setImage(ImageIcon image) {
		this.image=image;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double getSpeed_x() {
		return speed_x;
	}
	public void incSpeed_y(double speed) {
		this.speed_y += speed;
	}
	public void setSpeed_y(double speed) {
		this.speed_y = speed;
	}
	public double getSpeed_y() {
		return speed_y;
	}
	public void incSpeed_x(double speed) {
		this.speed_x += speed;
	}
	public void setSpeed_x(double speed) {
		this.speed_x = speed;
	}
	public int getSize_y() {
		return size_y;
	}
	public int getSize_x() {
		return size_x;
	}
	public Character() {
		this.setBounds(250,0,size_x,size_y);
		ImageIcon a=new ImageIcon("Pictures\\scrongle.jpg");
		setIcon(new ImageIcon(a.getImage().getScaledInstance(size_x, size_y, Image.SCALE_DEFAULT)));
		setSpeed_x(0.0);
		setSpeed_y(0.0);
		
	}
	public void tick() {
		if(this.getSpeed_x()>2)
			this.setSpeed_x(2);
		
		if(this.getSpeed_y()>5)
			this.setSpeed_y(5);
		
		if(this.getSpeed_x()<-2)
			this.setSpeed_x(-2);
		
		if(this.getSpeed_y()<-5)
			this.setSpeed_y(-5);
		x+=speed_x;
		y+=speed_y;
		speed_y+=0.06;
		this.setLocation(this.getX(),this.getY() );
	}

}
