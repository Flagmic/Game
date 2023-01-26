package game;

import java.awt.TextArea;

public class Score extends TextArea{
	private static final long serialVersionUID = 1L;
	
	int score=0;
		
	public Score() {
		this.setBounds(360, 0, 100, 20);
		this.setText("0");
//		this.setEditable(false);
	}
	public void addScore(Character dood) {
		if(dood.getSpeed_y()<0)
		score-=dood.getSpeed_y();
		this.setText(Integer.toString(score));
	}
	public void setScore_0() {
		score=0;
		this.setText(Integer.toString(score));
	}
}
