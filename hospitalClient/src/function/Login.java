package function;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Login {
	private String type;
	private String userName;
	private String password;
	public Login(String userName,String password,String type){
		this.userName=userName;
		this.password=password;
		this.type=type;
	}
	public boolean login(){
		Socket s=null;
		Scanner in=null;
		PrintWriter out=null;
		try {
			s=new Socket("127.0.0.1",8888);
			in=new Scanner(new InputStreamReader(s.getInputStream(),"UTF-8"));
			out=new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"UTF-8"));
			/*送到服务器*/
			//out.println("0001");
			//out.flush();
			out.println(userName+" "+password+" "+type);
			out.flush();
			/*获取服务器结果*/
			String str=in.nextLine();
			s.close();
			in.close();
			out.close();
			if(str.equals("true")) return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
