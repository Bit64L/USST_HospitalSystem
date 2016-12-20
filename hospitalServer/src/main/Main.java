package main;

import data.Data;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by m1580 on 2016/12/18.
 */
public class Main {
    public static int count=0;//记录运行线程数
    public static void main(String[] args){
        Data.initial();
        ServerSocket s=null;
        Scanner in=null;
        PrintWriter out=null;
        try {
            s = new ServerSocket(8888);
            while(true){
                Socket client = s.accept();
                System.out.println(Main.count+1+" 连接已建立！");
                Runnable r=new NewClient(client);
                Thread t=new Thread(r);
                t.start();
                Main.count++;
             }
               
        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
