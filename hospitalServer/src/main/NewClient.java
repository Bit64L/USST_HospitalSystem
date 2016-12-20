package main;

import person.*;
import data.*;

import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class NewClient implements Runnable{
    private Socket i;
    public NewClient(Socket i){
        this.i=i;
    }
    public void run() {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in=new Scanner(new InputStreamReader(i.getInputStream(),"UTF-8"));
            out=new PrintWriter(new OutputStreamWriter(i.getOutputStream(),"UTF-8"));
            String str = in.nextLine();//读入客户端发来的字符串
            String[] strs=str.split("\\s");//第0个为协议号
            switch(strs[0]){
            	case "0001":
            		boolean bool=verify(strs[1],strs[2],strs[3]);
            		if(bool==true) out.println("true");
                    else out.println("false");
            		out.flush();
            		break;
            	case "0002":
            		
            }
         
            
            
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Main.count--;
        in.close();
        out.close();
    }
    public boolean verify(String userName,String password,String type){
        if(type.equals("管理员")){
            for(Administrator a : Data.administrators){
                if(a.getUserName().equals(userName) && a.getPassword().equals(password)){
                    return true;
                }
            }
        }else if(type.equals("医生")){
            for(Doctor a : Data.doctors){
                if(a.getUserName().equals(userName) && a.getPassword().equals(password)){
                    return true;
                }
            }
        }else if(type.equals("收费人员")){
            for(Charger a : Data.chargers){
                if(a.getUserName().equals(userName) && a.getPassword().equals(password)){
                    return true;
                }
            }
        }else if(type.equals("药师")){
            for(Druggist a : Data.druggists) {
                if (a.getUserName().equals(userName) && a.getPassword().equals(password)) {
                    return true;
                }
            }
        }else if(type.equals("院长")){
                for(President a : Data.presidents){
                    if(a.getUserName().equals(userName) && a.getPassword().equals(password)){
                        return true;
                    }
                }
        }else{
            return false;
        }

        return false;
    }
}