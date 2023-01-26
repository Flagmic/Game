package game;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GUI extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;
	
	Character dood;
	Score Score=new Score();

	boolean d=false;
	boolean a=false;
	
	public GUI(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Doodle Jump");
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(450,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(Score);
		dood = new Character();
		this.add(dood);
		dood.setBackground(Color.red);
		dood.setOpaque(true);
		dood.addKeyListener(this);
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyChar()) {
		case 'a':
			if(d){dood.setSpeed_x(0);break;}
			dood.incSpeed_x(-2);
			a=true;
			break;
		case 's':
//			if(s) {dood.setSpeed_y(0);break;}
			dood.incSpeed_y(5);
//			s=true;
			break;
		case 'd':
			if(a){dood.setSpeed_x(0);break;}
			dood.incSpeed_x(2);
			d=true;
			break;
		}
		System.out.println(e.getKeyChar());
	}
	
	public void keyReleased(KeyEvent e) {

		switch(e.getKeyChar()) {
		case 'a':
			dood.incSpeed_x(2);
			a=false;
			break;
		case 'd':
			dood.incSpeed_x(-2);
			d=false;
			break;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
	
	}
	
}
