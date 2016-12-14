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
                System.out.println("连接已建立！");
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
    public void run(){
        InputStream inStream;
        OutputStream outStream;
        Scanner in = null;
        PrintWriter out = null;
        try {
            inStream=i.getInputStream();
            outStream=i.getOutputStream();

            in=new Scanner(inStream);
            out = new PrintWriter(outStream,true/*autoFlush*/);
            
            String str=in.nextLine();//读入客户端送来的数据

            String[] strs=str.split("\\s");
            if(strs[0].equals("123")){
                out.print("true");
                out.flush();
            }
            else {
                out.print("false");
                out.flush();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        in.close();
        out.close();
    }
}