package game;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Button extends JButton{
	private static final long serialVersionUID = 1L;
	boolean IsRunning=false;
	Score Score;
	
	public Button() {
		this.setText("New dood");
		this.setBounds(175,275,100,30);
		this.setBackground(Color.yellow);
		ActionListener button_pressed_action=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IsRunning=true;
//				Score.setScore_0();
			}
		};
		this.addActionListener(button_pressed_action);
	}

}
