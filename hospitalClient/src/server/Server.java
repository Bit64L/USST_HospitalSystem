package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        int i=0;
        ServerSocket s=null;
        try {
            s = new ServerSocket(8888);
            while(true){
                Socket client = s.accept();
                System.out.println(i+1+" 连接已建立！");
                Runnable r=new NewClient(client);
                Thread t=new Thread(r);
                t.start();
                i++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

class NewClient implements Runnable{
    private Socket i;
    public NewClient(Socket i){
        this.i=i;
    }
    public void run() {
        InputStream inStream;//输入流
        OutputStream outStream;//输出流
        Scanner in = null;
        PrintWriter out = null;
        try {
            inStream = i.getInputStream();
            outStream = i.getOutputStream();

            in = new Scanner(inStream);
            out = new PrintWriter(outStream, true/*autoFlush*/);
            String str = in.nextLine();//读入功能

            if(str.equals("001")){//登录验证
                str=in.nextLine();
                String[] strs=str.split("\\s");

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        in.close();
        out.close();
    }
}