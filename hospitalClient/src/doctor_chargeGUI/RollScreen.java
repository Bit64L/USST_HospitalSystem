package doctor_chargeGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RollScreen extends JFrame{
	
	RollScreen(){
		add(new MPanel("这是移动的语句"));
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		JFrame frame = new RollScreen();
		frame.setTitle("RollScreen");
		frame.setSize(280, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
static class MPanel extends JPanel{
	private String message = "welcome to java!";
	private int xZuoBiao = 0;
	private int yZuoBiao = 30;
	
	
	public MPanel(String message){
		this.message=message;
		Timer timer = new Timer(500,new TimerListener());
	    timer.start();
	}
	
protected void paintComponent(Graphics g){
	super.paintComponent(g);
	g.setColor(Color.MAGENTA);
	if(xZuoBiao>getWidth()){
		xZuoBiao=-20;
	}
	xZuoBiao+=10;
	g.drawString(message, xZuoBiao, yZuoBiao);
}
class TimerListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		repaint();
	}
}

}
}
