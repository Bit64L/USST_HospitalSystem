package function;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import person.Administrator;
import person.Doctor;

public class Login {
	private String type;
	private String userName;
	private String password;
	public Login(String userName,String password,String type){
		this.userName=userName;
		this.password=password;
		this.type=type;
	}
	public Object login(){
		Socket s=null;
		ObjectInputStream inObject=null;
		ObjectOutputStream outObject=null;
		Object person=null;
		try {
			s=new Socket("127.0.0.1",8888);
			outObject=new ObjectOutputStream(s.getOutputStream());
			/*送到服务器*/
			outObject.writeObject("0001");
			switch(type){
				case "管理员":
					person=new Administrator(userName,password);
					outObject.writeObject(person);
					outObject.flush();
					break;
				case "医生":
					person=new Doctor(userName,password);
					outObject.writeObject(person);
					outObject.flush();
					break;
				case "药师":
					break;
				case "收费人员":
					break;
				case "院长":
					break;
			}
			outObject.flush();
			/*获取服务器结果*/
			inObject=new ObjectInputStream(s.getInputStream());
			person=inObject.readObject();	
			
			s.close();
			inObject.close();
			outObject.close();
			return person;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
