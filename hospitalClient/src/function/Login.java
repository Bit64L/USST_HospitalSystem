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
		Object person=null;//接收服务器发来的对象
		try {
			s=new Socket("127.0.0.1",8888);
			outObject=new ObjectOutputStream(s.getOutputStream());
			/*送到服务器*/
			outObject.writeObject("0001"+" "+userName+" "+password+" "+type);
			outObject.flush();
			/*获取服务器结果*/
			inObject=new ObjectInputStream(s.getInputStream());
			 person=(Administrator)inObject.readObject();
			s.close();
			inObject.close();
			outObject.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}
}
