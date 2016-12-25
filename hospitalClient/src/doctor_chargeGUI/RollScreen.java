package doctor_chargeGUI;

import javax.swing.*;

import utility.DB;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class RollScreen extends JFrame{
	//DB db = new DB();
	//President president=new President();// new 
	ArrayList<String> list =new ArrayList<String>();
	DB db = new DB();
	ResultSet rs = null;//db.select("select*from Doctor");
	private JTextField textField;
	
	RollScreen(){
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(418, 240, 6, 21);
		panel.add(textField);
		textField.setColumns(10);
		//add(new MPanel("这是移动的语句"));
		rs = db.select("select*from Doctor");//president.getDoctorInformation(president);  //new 
		while(true)
		{
			try {
				if(rs.next())
				{
					{
						list.add(rs.getString(1));
					}
					//rs.findColumn("name");
					//a=rs.getString("name");
					getContentPane().add(new MPanel(" 医生姓名："+rs.getString("name")+" 就诊数量："+rs.getInt("cureNum")));
					//System.out.println(mp.getText());
					//add(new MPanel("医生姓名"+array));
				}
				else{
					break;
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
		if(list!=null&&list.size()>0)
		{
			String[] arr = new String[list.size()];
			for(int i=0;i<list.size();i++)
			{
				arr[i]=list.get(i);
				System.out.println(arr[i]);
				textField.setText(textField.getText()+"     病人："+arr[i]);
				getContentPane().add(new MPanel(textField.getText()));
			}
		}
		
	}
	
//	private MPanel MPanel() {
//		// TODO 自动生成的方法存根
//		return null;
//	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		JFrame frame = new RollScreen();
		JTextField frame1 = new JTextField();
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
		//System.out.println(this.message);
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