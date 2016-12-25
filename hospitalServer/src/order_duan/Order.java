package order_duan;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Order implements Serializable{
	public String patientID;
	public String name;
	public String sex;
	public int age;
	public String phoneNumber;
	public String hospitalDepartmentName;
	public String orderTime;
	public Order(String patientID,String name,String sex,int age,String phoneNumber,String hospitalDepartmentName,String orderTime) {
		// TODO Auto-generated constructor stub
		this.patientID=patientID;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.phoneNumber=phoneNumber;
		this.hospitalDepartmentName=hospitalDepartmentName;
		this.orderTime=orderTime;
	}
	public void wanttoorder(Order order) {
		// TODO Auto-generated method stub
		Socket socket=null;
		ObjectInputStream inobj=null;
		ObjectOutputStream outobj=null;
		try {
			socket=new Socket("101.94.249.251",8888);
			outobj=new ObjectOutputStream(socket.getOutputStream());
			outobj.writeObject("预约端要预约");
			outobj.flush();
			outobj.writeObject(order);
			outobj.flush();
			String result;
			
			try {
				inobj=new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
				result = (String) inobj.readObject();
				if(result.equals("预约成功")){
					JOptionPane.showMessageDialog(null, "预约成功！");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			socket.close();
			outobj.close();
			inobj.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		
	}
	
	
	
	
	
	
}
