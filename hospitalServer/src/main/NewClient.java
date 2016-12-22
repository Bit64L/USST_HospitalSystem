package main;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import person.*;
import registration.Registration;
import staff.HospitalDepartment;
import staff.OrderInformation;
import data.Data;
import staff.*;
public class NewClient implements Runnable{
    private Socket i;
    public NewClient(Socket i){
        this.i=i;
    }
    public void run() {
        String[] strs=null;
        Object person=null;
        Administrator admin=null;
    	ObjectInputStream inObject=null;
    	ObjectOutputStream outObject=null;
        try {
            inObject=new ObjectInputStream(new BufferedInputStream(i.getInputStream()));
            outObject=new ObjectOutputStream(i.getOutputStream());
            String protocal=(String)inObject.readObject();
            switch(protocal){
            	case "0001"://登录
                    person=inObject.readObject();
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
            	    admin=(Administrator) inObject.readObject();//读对象
                    add(admin,infos[0],infos[1],infos[2],infos[3],infos[4]);//添加账号
            	    System.out.println("添加成功");
                    break;
                case "0011"://显示所有账号信息
                    String accountsInfo=showAccounts();
                    outObject.writeObject(accountsInfo);
                    outObject.flush();
            		System.out.println("发送成功");
            		break;
                case "0012"://删除账号
                    String account=(String)inObject.readObject();//读数据
                    admin=(Administrator)inObject.readObject();//读对象
                    admin.deleteAccount(account);
                    System.out.println("删除成功");
                    break;
                case "0013"://添加科室信息
                    String officeInfo=(String)inObject.readObject();
                    String[] officeInfos=officeInfo.split("\\s");
                    admin=(Administrator)inObject.readObject();
                    admin.addHospitalDepartment(officeInfos[0],officeInfos[1]);
                    System.out.println("添加成功");
                    break;
                case "0014"://修改账户信息
                    String accountInfo=(String)inObject.readObject();
                    admin=(Administrator)inObject.readObject();
                    strs=accountInfo.split("\\s");
                    admin.alterAccount(strs[0],strs[1],strs[2]);
                    System.out.println("修改成功");
                    break;
                case "0015"://增加收费项目
                    String chargeItem=(String)inObject.readObject();
                    admin=(Administrator)inObject.readObject();
                    strs=chargeItem.split("\\s");
                    admin.addChargeItem(strs[0],strs[1],strs[2],Double.parseDouble(strs[3]),strs[4]);
                    System.out.println("添加成功");
                case "0016"://修改收费项目
                    String chargerItemInfo=(String)inObject.readObject();
                    admin=(Administrator)inObject.readObject();
                    strs=chargerItemInfo.split("\\s");
                    admin.alterChargeItem(strs[0],strs[1],strs[2],strs[3],strs[4]);
                    System.out.println("修改成功");
                    break;
                case "0017"://删除收费项目
                    String chargerItemInfo1=(String)inObject.readObject();//读数据
                    admin=(Administrator)inObject.readObject();//读对象
                    admin.deleteAccount(chargerItemInfo1);
                    System.out.println("删除成功");
                    break;
                case "0018"://修改科室信息
                    String officeInfo2=(String)inObject.readObject();
                    admin=(Administrator)inObject.readObject();
                    strs=officeInfo2.split("\\s");
                    admin.alterHospital(strs[0],strs[1]);
                    System.out.println("修改成功");
                    break;
                case "0019"://删除科室信息
                    String officeInfo1=(String)inObject.readObject();//读数据
                    admin=(Administrator)inObject.readObject();//读对象
                    admin.deleteAccount(officeInfo1);
                    System.out.println("删除成功");
                    break;
                case "0020"://修改药品信息
                    String medicineInfo=(String)inObject.readObject();
                    admin=(Administrator)inObject.readObject();
                    strs=medicineInfo.split("\\s");
                    admin.alterMedicine(strs[0],strs[1],strs[2],strs[2],strs[3],strs[4]);
                    System.out.println("修改成功");
                    break;
                case "0021"://删除药品信息
                    String medicineId=(String)inObject.readObject();//读数据
                    admin=(Administrator)inObject.readObject();//读对象
                    admin.deleteAccount(medicineId);
                    System.out.println("删除成功");
                    break;
                case "0022"://增加药品
                    String medicineInfo1=(String)inObject.readObject();
                    admin=(Administrator)inObject.readObject();
                    strs=medicineInfo1.split("\\s");
                    admin.addMedicine(strs[0],strs[1],strs[2],Double.parseDouble(strs[3]),strs[4],Integer.parseInt(strs[5]));
                    System.out.println("添加成功");
                    break;
                case "0023"://显示所有收费信息
                    String chargeInfo=showChargeItem();
                    outObject.writeObject(chargeInfo);
                    outObject.flush();
                    System.out.println("发送成功");
                    break;
                case "0024"://显示所有药品信息
                    String medicineInfo2=showMedicine();
                    outObject.writeObject(medicineInfo2);
                    outObject.flush();
                    System.out.println("发送成功");
                    break;
                case "0025"://显示所有科室信息
                    String office=showOffice();
                    outObject.writeObject(office);
                    outObject.flush();
                    System.out.println("发送成功");
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
    //显示所有账号信息
    public String showAccounts(){
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
    //添加账号
    public void add(Administrator admin,String userName,String password,String name,String type,String hospitalDepartment){
        switch (type){
            case "管理员":
                admin.addAdminStrator(userName,password,name);
                break;
            case "收费人员":
                admin.addCharger(userName,password,name);
                break;
            case "医生":
                for(HospitalDepartment a:Data.hospitalDepartments){
                    if(a.getName().equals(hospitalDepartment)){
                        admin.addDoctor(userName,password,name,a);
                    }
                }
                break;
            case "药师":
                admin.addDruggist(userName,password,name);
                break;
            case "院长":
                admin.addPresident(userName,password,name);
                break;

        }
    }
    //显示所有收费信息
    public String showChargeItem(){
        String str="";
        for(ChargeItem a: Data.chargeItems){
            str+=a.getName()+" "+a.getNo();
            str+="$";
        }
        return str;
    }
    //显示所有药品信息
    public String showMedicine(){
        String str="";
        for(Medicine a: Data.medicines){
            str+=a.getName()+" "+a.getNo();
            str+="$";
        }
        return str;
    }
    //显示所有科室信息
    public String showOffice(){
        String str="";
        for(HospitalDepartment a: Data.hospitalDepartments){
            str+=a.getName()+" "+a.getNo();
            str+="$";
        }
        return str;
    }

}