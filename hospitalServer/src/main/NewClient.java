package main;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import person.*;
import registration.Registration;
import staff.OrderInformation;
import data.Data;

public class NewClient implements Runnable{
    private Socket i;
    public NewClient(Socket i){
        this.i=i;
    }
    public void run() {
        Administrator admin=null;
    	ObjectInputStream inObject=null;
    	ObjectOutputStream outObject=null;
        try {
            inObject=new ObjectInputStream(new BufferedInputStream(i.getInputStream()));
            outObject=new ObjectOutputStream(i.getOutputStream());
            String protocal=(String)inObject.readObject();
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
                    String info=(String) inObject.readObject();//读数据
            	    String[] infos=info.split("\\s");
                    outObject.writeObject("");//保持
                    outObject.flush();
            	    admin=(Administrator)inObject.readObject();//读对象
                    admin.addAdminStrator(infos[0],infos[1],infos[2]);
            	    System.out.println("添加成功");
                    break;
                case "0011"://显示所有账号信息
                    String accountsInfo=showAccounts();
                    outObject.writeObject(accountsInfo);
                    outObject.flush();
            		System.out.println("发送成功");
            		break;
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
                    OrderInformation orderInfor=new OrderInformation();
                    //判断是否是预约病人
                    boolean re=((Registration) reg).isOrdered((Patient) patient);
            		if(re){//如果是预约病人
            			orderInfor=reg.searchOrderInfor((Patient) patient);
            			outObject.writeObject(orderInfor);
                    }
                    else{
                        outObject.writeObject(null);
                    }
            		outObject.flush();
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
    public String showAccounts(){//显示所有账号信息
        String accountsInfo="";
        for(Administrator a:Data.administrators){
            accountsInfo+=a.getUserName()+" "+a.getPassword()+" "+a.getName()+" ";
            accountsInfo+="管理员$";
        }
        for(Doctor a:Data.doctors){
            accountsInfo+=a.getUserName()+" "+a.getPassword()+" "+a.getName()+" ";
            accountsInfo+="医生$";
        }
        for(Charger a:Data.chargers){
            accountsInfo+=a.getUserName()+" "+a.getPassword()+" "+a.getName()+" ";
            accountsInfo+="收费人员$";
        }
        for(Druggist a:Data.druggists){
            accountsInfo+=a.getUserName()+" "+a.getPassword()+" "+a.getName()+" ";
            accountsInfo+="药师$";
        }
        for(President a:Data.presidents){
            accountsInfo+=a.getUserName()+" "+a.getPassword()+" "+a.getName()+" ";
            accountsInfo+="院长$";
        }
        return accountsInfo;
    }
}