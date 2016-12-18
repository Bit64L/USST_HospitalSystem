package main;

import data.Data;
import server.Login;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by m1580 on 2016/12/18.
 */
public class Main {
    public static void main(String[] args){
        Data.initial();
        int i=0;
        ServerSocket s=null;
        Scanner in=null;
        PrintWriter out=null;
        try {
            s = new ServerSocket(8888);
            while(true){
                Socket client = s.accept();
                System.out.println(i+1+" 连接已建立！");
               // in=new Scanner(new InputStreamReader(client.getInputStream(),"UTF-8"));
              //  out=new PrintWriter(new OutputStreamWriter(client.getOutputStream(),"UTF-8"));
              //  String protocal=in.nextLine();//获得协议号
              //  in.close();
             //   out.close();
               // switch (protocal){
               //     case "0001":
                        Runnable r=new Login(client);
                        Thread t=new Thread(r);
                        t.start();
             //          break;
              // }
               i++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
