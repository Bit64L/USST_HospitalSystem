package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class server {
	// ip="192.168.0.103";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createServer();
	}
	
	
	static ServerSocket server=null;
	static Socket socket=null;
	public static void createServer(){
	
	try {
		server=new ServerSocket(8888);
		while(true){
			System.out.println("等待登录");
			socket=server.accept();
			System.out.println("连接成功");
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			String rec=null;
			rec=br.readLine();
			while(rec!=null){
				String status=rec.substring(0, 2);
				System.out.println(status);
				if(status.equals("lg")){
					String[] nameAndPassword=rec.substring(2).split(":");
					String name=nameAndPassword[0];
					String password=nameAndPassword[1];
					System.out.println(password+name);
					String selectsqlStr="select account,password from users where account="+"'"+name+"'and password="+"'"+password+"'";

					jdbc sqlServer=new jdbc();
					ResultSet rs=sqlServer.select(selectsqlStr);
					if(rs.next()){
						System.out.println("登录成功");
						PrintWriter os=new PrintWriter(socket.getOutputStream());
						String send="";
						send="success";
						
						os.println(send);
						os.flush();
					}else{
						System.out.println("登录失败");
						PrintWriter os=new PrintWriter(socket.getOutputStream());
						String send="";
						send="failure";
						os.println(send);
						os.flush();
					}
				}
				rec=br.readLine();
			}
			}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
