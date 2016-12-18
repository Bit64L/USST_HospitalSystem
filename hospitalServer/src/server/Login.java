package server;

import person.*;
import data.*;

import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Login implements Runnable{
    private Socket i;
    //private String str;
    public Login(Socket i){
        this.i=i;
    //    this.str=str;
    }
    public void run() {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in=new Scanner(new InputStreamReader(i.getInputStream(),"UTF-8"));
            out=new PrintWriter(new OutputStreamWriter(i.getOutputStream(),"UTF-8"));
            String str = in.nextLine();//读入客户端发来的字符串
            String[] strs=str.split("\\s");
            boolean bool=verify(strs[0],strs[1],strs[2]);
            if(bool==true) out.println("true");
            else out.println("false");
            out.flush();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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