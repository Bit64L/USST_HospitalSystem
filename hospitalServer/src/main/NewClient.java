package main;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import person.*;
import data.Data;

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
            inObject=new ObjectInputStream(new BufferedInputStream(i.getInputStream()));
            outObject=new ObjectOutputStream(i.getOutputStream());
            String protocal=(String)inObject.readObject();
            //outObject.writeObject("");
            switch(protocal){
            	case "0001"://登录
                    Object person=inObject.readObject();
                    person=verify(person);
            		if(person!=null){//返回完整对象
            			outObject.writeObject(person);
                    }
                    else{
                        outObject.writeObject(null);
                    }
            		outObject.flush();
            		break;
            	case "0010"://添加系统账号
                    String info=(String) inObject.readObject();
                    //outObject.writeObject("");//保持
            	    String[] infos=info.split("\\s");
                    outObject.writeObject("");//保持
            	    Administrator admin=(Administrator)inObject.readObject();
                    admin.addAdminStrator(infos[0],infos[1],infos[2]);
            	    System.out.print("添加成功");
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
    public Object verify(Object person){
        if(person instanceof Administrator){
            Administrator admin=(Administrator)person;
            for(Administrator a : Data.administrators){
                if(a.getUserName().equals(admin.getUserName()) && a.getPassword().equals(admin.getUserName())){
                    return a;
                }
            }
        }else if(person instanceof Doctor){
            Doctor doctor=(Doctor)person;
            for(Doctor a : Data.doctors){
                if(a.getUserName().equals(doctor.getUserName()) && a.getPassword().equals(doctor.getPassword())){
                    return a;
                }
            }
        }else if(person instanceof Charger){
            Charger charger=(Charger)person;
            for(Charger a : Data.chargers){
                if(a.getUserName().equals(charger.getUserName()) && a.getPassword().equals(charger.getPassword())){
                    return a;
                }
            }
        }else if(person instanceof Druggist){
            Druggist druggist=(Druggist)person;
            for(Druggist a : Data.druggists) {
                if (a.getUserName().equals(druggist.getUserName()) && a.getPassword().equals(druggist.getPassword())) {
                    return a;
                }
            }
        }else if(person instanceof President){
            President president=(President)person;
            for(President a : Data.presidents){
                    if(a.getUserName().equals(president.getUserName()) && a.getPassword().equals(president.getPassword())){
                        return a;
                    }
            }
        }else{
            return null;
        }

        return null;
    }

}