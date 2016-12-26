package rollscreen;

import javax.swing.*;

import data.Data;
import jdk.nashorn.internal.runtime.events.RecompilationEvent;
import person.Patient;
import utility.DB;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.TimerTask;

public class RollScreen extends JFrame{
	ArrayList<String> list =new ArrayList<String>();
	private JTextField textField;
	Patient p = new Patient();
	Data data = new Data();
	
	RollScreen(){
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		MPanel mp =new MPanel(null);
		textField = new JTextField();
		textField.setBounds(418, 240, 6, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		
		//**通讯**//
		Socket socket=null;
		ObjectInputStream inobj=null;
		ObjectOutputStream outobj=null;
				
		try {	
			socket=new Socket("101.94.249.251",8888);
			outobj=new ObjectOutputStream(socket.getOutputStream());
			inobj=new ObjectInputStream(socket.getInputStream());
			outobj.writeObject("药师要registerPatients Arraylist");
			outobj.flush();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			
			ArrayList<Patient> repatient=(ArrayList<Patient>) inobj.readObject();
			String[] arr1 = new String[repatient.size()];
			String[] arr2 = new String[repatient.size()];
			if(repatient!=null&&repatient.size()>0)
			{
				for(int i=0;i<repatient.size();i++)
				{
					
					System.out.println(repatient.get(i).getName());
					arr1[i]=repatient.get(i).getName();
					arr2[i]=repatient.get(i).getHospitalDepartment().getName();
					textField.setText(textField.getText()+"        第"+(i+1)+"号病人姓名: "+arr1[i]+"    就诊科室    "+arr2[i]+"  ");
					getContentPane().add(new MPanel(textField.getText()));
				}
			}
			else {
				System.out.println("队列为空");
				//mp.setMessage("队列为空");
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();}
		}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		JFrame frame = new RollScreen();
		JTextField frame1 = new JTextField();
		frame.setTitle("RollScreen");
		frame.setSize(260, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
static class MPanel extends JPanel{
	private String message = "welcome to java!";
	public String getMessage() {
	return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
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
	
	String[] args = null;
	RollScreen.main(args);
}

class TimerListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		repaint();
		Timer t =null;
		t = new Timer(500,this);
		t.start();
	}
}

}
}