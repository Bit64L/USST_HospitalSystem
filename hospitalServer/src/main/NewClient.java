package main;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

import person.*;
import registration.Registration;
import staff.HospitalDepartment;
import staff.OrderInformation;
import utility.DB;
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
                    admin.deleteChargeItem(chargerItemInfo1);
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
                    admin.deleteHospitalDepartment(officeInfo1);
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
                    admin.deleteMedicine(medicineId);
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
                case "0026"://根据简称查询收费项目和药品
                		break;
                case "2000"://挂号功能
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
                case "2001"://添加病人到医生就诊序列
                	Object doctor=inObject.readObject();
                    Registration reg_1=new Registration();
                    Doctor doc=reg_1.addDoctorPatient((Doctor) doctor, ((Doctor) doctor).getAddpatient());
                    if(doc!=null)
                    	outObject.writeObject(doc);
                    else 
                    	outObject.writeObject(null);
                     
             		outObject.flush();
             		break;
                case "2002"://添加未预约病人添加到医生队列中
                	Object patient_1=inObject.readObject();
                    Registration reg_2=new Registration();
                    Patient inPatient=reg_2.addDoctorNoAppointmentdPatient((Patient) patient_1);
                    if(inPatient!=null)
                    	outObject.writeObject(inPatient);
                    else
                    	outObject.writeObject(null);
                    
             		outObject.flush();
            		break;
                case "2003"://发送查看病人收费信息的请求:
                	Object patient_2=inObject.readObject();
                    Registration reg_3=new Registration();
                    Patient inPatient_1=reg_3.getPatientChargeItem(((Patient)patient_2).getId());
                    outObject.writeObject(inPatient_1);
                    
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
    public Object verify(Object person) throws SQLException{
    	String sqlStr="";
    	ResultSet rs=null;
    	DB db=new DB();
        if(person instanceof Administrator){
        	Administrator manager=(Administrator) person;
           sqlStr="select * from [Manager] where managerID="+manager.getUserName()+" and password='"+manager.getPassword()+"'";
           rs=db.select(sqlStr);
        	   if(rs.next()){
        		   manager.setUserName(""+rs.getInt("managerID"));
        		   manager.setPassword(rs.getString("password"));
        		   manager.setName(rs.getString("name"));
        		   return manager;
        	   }else{
        		   return null;
        	   }
           
        }else if(person instanceof Doctor){
        	Doctor doctor=(Doctor) person;
        	sqlStr="select * from [Doctor] where doctorID="+doctor.getUserName()+" and password='"+doctor.getPassword();
            rs=db.select(sqlStr);
            
            String hospitalDepartmentid="";
         	   if(rs.next()){
         		  hospitalDepartmentid=""+rs.getInt("hospitalDepartmentID");
         		  doctor.setUserName(""+rs.getInt("doctorID"));
         		  doctor.setPassword(rs.getString("password"));
         		  doctor.setName(rs.getString("name"));
         		  doctor.setCureNum(rs.getInt("cureNum"));
         		  doctor.setMoney(rs.getDouble("money"));
         		  doctor.setPatients(null);//病人队列为空
         		  //要把hospitalDepartment整个读出来
         		  HospitalDepartment hd=new HospitalDepartment();
         		 sqlStr="select * from [HospitalDepartment] where hospitalDepartmentid="+hospitalDepartmentid;
         		 rs=db.select(sqlStr);
         		 hd.setNo(""+rs.getInt("hospitalDepartmentID"));
         		 hd.setName(rs.getString("hospitalDepartmentName"));
         		 hd.setMoney(rs.getDouble("money"));
         		 hd.setRegisterNum(rs.getInt("registerNum"));
         		 doctor.setHospitalDepartment(hd);
         		   return doctor;
         	   }else{
         		   return null;
         	   }
         	   
         	   
         	   
         	   
        }else if(person instanceof Charger){
        	Charger charger= (Charger) person;
            sqlStr="select * from [Charger] where chargerID="+charger.getUserName()+" and password='"+charger.getPassword();
            rs=db.select(sqlStr);
         	   if(rs.next()){
         		   charger.setUserName(""+rs.getInt("chargerID"));
         		   charger.setPassword(rs.getString("password"));
         		   charger.setName(rs.getString("name"));
         		   return charger;
         	   }else{
         		   return null;
         	   }
        }else if(person instanceof Druggist){
        	Druggist druggist= (Druggist) person;
            sqlStr="select * from [Druggist] where druggistID="+druggist.getUserName()+" and password='"+druggist.getPassword();
            rs=db.select(sqlStr);
         	   if(rs.next()){
         		  druggist.setUserName(""+rs.getInt("chargerID"));
         		  druggist.setPassword(rs.getString("password"));
         		  druggist.setName(rs.getString("name"));
         		   return druggist;
         	   }else{
         		   return null;
         	   }
        }else if(person instanceof President){
        	President president= (President) person;
        	sqlStr="select * from [President] where presidentID="+president.getUserName()+" and password='"+president.getPassword();
            rs=db.select(sqlStr);
         	   if(rs.next()){
         		  president.setUserName(""+rs.getInt("chargerID"));
         		  president.setPassword(rs.getString("password"));
         		  president.setName(rs.getString("name"));
         		   return president;
         	   }else{
         		   return null;
         	   }
        }else{
            return null;
        }

        
    }
    //显示所有账号信息
    public String showAccounts(){
    	
    	
        String accountsInfo="";
        
        accountsInfo+=showAccountsForEach("select * from [Manager]", "manager", "管理员");
        accountsInfo+=showAccountsForEach("select * from [Doctor]", "doctor", "医生");
        accountsInfo+=showAccountsForEach("select * from [Charger]", "charger", "收费人员");
        accountsInfo+=showAccountsForEach("select * from [Druggist]", "druggist", "药师");
        accountsInfo+=showAccountsForEach("select * from [President]", "president", "院长");
        return accountsInfo;
    }
    public String showAccountsForEach(String sqlStr,String type,String chineseTypeName){ //返回一个表的所有账号信息
    	String accountsInfoForEach="";
    	DB db=new DB();
    	ResultSet rs=null;
    	rs=db.select(sqlStr);
    	while(true){
    		try {
				if(rs.next()){
					accountsInfoForEach+=rs.getString(type+"ID")+rs.getString("password")
					+rs.getString("name");
					accountsInfoForEach+=chineseTypeName+"$";
				}else{
					break;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	return accountsInfoForEach;
    	
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