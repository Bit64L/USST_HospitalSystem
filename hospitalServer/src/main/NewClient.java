package main;

<<<<<<< HEAD
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import person.*;
import registration.Registration;
=======
>>>>>>> origin/master
import data.Data;
import person.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
            String str = in.nextLine();
            String mess=str.substring(4);//获得信息
            String[] strs=str.split("\\s");
            String protocal=strs[0];//获得协议号
            strs=mess.split("\\s");
            switch(protocal){
            	case "0001":
            		Person person=verify(strs[0],strs[1],strs[2]);
            		if(person!=null){
                        //输出对象序列
                    }
                    else{

                    }
            		out.flush();
            		break;
<<<<<<< HEAD
                case "0012":
                    String account=(String)inObject.readObject();//读数据
                    admin=(Administrator)inObject.readObject();//读对象
                    admin.deleteAccount(account);
                    System.out.print("删除成功");
                    break;
                case "0013":
                    String officeInfo=(String)inObject.readObject();
                    String[] officeInfos=officeInfo.split("\\s");
                    admin=(Administrator)inObject.readObject();
                    admin.addHospitalDepartment(officeInfos[0],officeInfos[1]);
                    System.out.print("添加成功");
                    break;
                case "2000":
                	Object patient=inObject.readObject();
                	
                	Registration reg=new Registration();
                	//判断是否是预约病人
                	boolean re=reg.isOrderd((Patient) patient);
                	
                	if(re){
                		System.out.println("是预约病人");
                		Object outPatientInfor=reg.searchOrderInfor((Patient) patient);
                		outObject.writeObject(outPatientInfor);
                	}
                	else{
                		System.out.println("不是预约病人");
                	}
            		break;
=======
            	case "0010":
>>>>>>> origin/master

                    break;
            		
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