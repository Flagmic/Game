package game;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Button extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean IsRunning=false;
	
	public Button() {
		this.setText("New Game");
		this.setBounds(175,275,100,30);
		this.setBackground(Color.yellow);
		ActionListener button_pressed_action=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IsRunning=true;
			}
		};
		this.addActionListener(button_pressed_action);
	}

}
