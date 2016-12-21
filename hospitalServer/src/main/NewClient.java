package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import data.Data;
import person.Administrator;
import person.Charger;
import person.Doctor;
import person.Druggist;
import person.Person;
import person.President;

public class NewClient implements Runnable{
    private Socket i;
    public NewClient(Socket i){
        this.i=i;
    }
    public void run() {
        //Scanner in = null;
        //PrintWriter out = null;
    	ObjectInputStream inObject=null;
    	ObjectOutputStream outObject=null;
        try {
            //in=new Scanner(new InputStreamReader(i.getInputStream(),"UTF-8"));
            //out=new PrintWriter(new OutputStreamWriter(i.getOutputStream(),"UTF-8"));
            inObject=new ObjectInputStream(i.getInputStream());
            outObject=new ObjectOutputStream(i.getOutputStream());
            String str=(String)inObject.readObject();
            String mess=str.substring(4);//获得信息
            String[] strs=str.split("\\s");
            String protocal=strs[0];//获得协议号
            strs=mess.split("\\s");
            switch(protocal){
            	case "0001":
            		Person person=verify(strs[0],strs[1],strs[2]);
            		if(person!=null){
                        //输出对象序列
            			outObject.writeObject(person);
                    }
                    else{

                    }
            		outObject.flush();
            		break;
            	case "0010":

                    break;
            		
            }
            inObject.close();
            outObject.close();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Main.count--;
        
    }
    public Person verify(String userName,String password,String type){
        if(type.equals("管理员")){
            for(Administrator a : Data.administrators){
                if(a.getUserName().equals(userName) && a.getPassword().equals(password)){
                    return a;
                }
            }
        }else if(type.equals("医生")){
            for(Doctor a : Data.doctors){
                if(a.getUserName().equals(userName) && a.getPassword().equals(password)){
                    return a;
                }
            }
        }else if(type.equals("收费人员")){
            for(Charger a : Data.chargers){
                if(a.getUserName().equals(userName) && a.getPassword().equals(password)){
                    return a;
                }
            }
        }else if(type.equals("药师")){
            for(Druggist a : Data.druggists) {
                if (a.getUserName().equals(userName) && a.getPassword().equals(password)) {
                    return a;
                }
            }
        }else if(type.equals("院长")){
                for(President a : Data.presidents){
                    if(a.getUserName().equals(userName) && a.getPassword().equals(password)){
                        return a;
                    }
                }
        }else{
            return null;
        }

        return null;
    }

}