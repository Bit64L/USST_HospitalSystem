package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by m1580 on 2016/12/14.
 */
public class LoginVerify{
        private Socket i;
        public LoginVerify(Socket i){
            this.i=i;
        }
        public void run() {
            InputStream inStream;
            OutputStream outStream;
            Scanner in = null;
            PrintWriter out = null;
            try {
                inStream = i.getInputStream();
                outStream = i.getOutputStream();

                in = new Scanner(inStream);
                out = new PrintWriter(outStream, true/*autoFlush*/);
                String str = in.nextLine();

                String[] strs = str.split("\\s");
                if (strs[0].equals("123")) {
                    out.print("true");
                    out.flush();
                } else {
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
