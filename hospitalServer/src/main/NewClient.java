package main;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

import person.*;
import registration.Registration;
import utility.DB;
import data.Data;
import order_duan.Order;
import staff.*;

public class NewClient implements Runnable {
	private Socket i;

	public NewClient(Socket i) {
		this.i = i;
	}

	public void run() {
		String[] strs = null;
		Object person = null;
		Administrator admin = null;
		Doctor doctor=null;
		ObjectInputStream inObject = null;
		ObjectOutputStream outObject = null;
		DB db = new DB();
		String sqlStr = "";
		CachedRowSet crs = null;
		ResultSet rs=null;
		try {
			inObject = new ObjectInputStream(new BufferedInputStream(i.getInputStream()));
			outObject = new ObjectOutputStream(i.getOutputStream());
			String protocal = (String) inObject.readObject();
			switch (protocal) {
			case "0001":// 登录
				person = inObject.readObject();
				person = verify(person);
				if (person != null) {// 返回完整对象
					outObject.writeObject(person);
				} else {
					outObject.writeObject(null);
				}
				outObject.flush();
				break;
			case "0010":// 添加系统账号
				String info = (String) inObject.readObject();// 读数据
				String[] infos = info.split("\\s");
				outObject.writeObject("");// 保持
				outObject.flush();
				admin = (Administrator) inObject.readObject();// 读对象
				add(admin, infos[0], infos[1], infos[2], infos[3], infos[4]);// 添加账号
				System.out.println("添加成功");
				break;
			case "0011":// 显示所有账号信息
				String accountsInfo = showAccounts();
				outObject.writeObject(accountsInfo);
				outObject.flush();
				System.out.println("发送成功");
				break;
			case "0012":// 删除账号
				String account = (String) inObject.readObject();// 读数据
				admin = (Administrator) inObject.readObject();// 读对象
				admin.deleteAccount(account);
				System.out.println("删除成功");
				break;
			case "0013":// 添加科室信息
				String officeInfo = (String) inObject.readObject();
				//String[] officeInfos = officeInfo.split("\\s");
				admin = (Administrator) inObject.readObject();
				admin.addHospitalDepartment(officeInfo);
				System.out.println("添加成功");
				break;
			case "0014":// 修改账户信息
				String accountInfo = (String) inObject.readObject();
				admin = (Administrator) inObject.readObject();
				strs = accountInfo.split("\\s");
				admin.alterAccount(strs[0], strs[1], strs[2]);
				System.out.println("修改成功");
				break;
			case "0015":// 增加收费项目
				String chargeItem = (String) inObject.readObject();
				admin = (Administrator) inObject.readObject();
				strs = chargeItem.split("\\s");
				admin.addChargeItem(strs[0], strs[1], strs[2], Double.parseDouble(strs[3]));
				System.out.println("添加成功");
				break;
			case "0016":// 修改收费项目
				String chargerItemInfo = (String) inObject.readObject();
				admin = (Administrator) inObject.readObject();
				strs = chargerItemInfo.split("\\s");
				admin.alterChargeItem(strs[0], strs[1], strs[2], strs[3], strs[4]);
				System.out.println("修改成功");
				break;
			case "0017":// 删除收费项目
				String chargerItemInfo1 = (String) inObject.readObject();// 读数据
				admin = (Administrator) inObject.readObject();// 读对象
				admin.deleteChargeItem(chargerItemInfo1);
				System.out.println("删除成功");
				break;
			case "0018":// 修改科室信息
				String officeInfo2 = (String) inObject.readObject();
				admin = (Administrator) inObject.readObject();
				strs = officeInfo2.split("\\s");
				admin.alterHospital(strs[0], strs[1]);
				System.out.println("修改成功");
				break;
			case "0019":// 删除科室信息
				String officeInfo1 = (String) inObject.readObject();// 读数据
				admin = (Administrator) inObject.readObject();// 读对象
				admin.deleteHospitalDepartment(officeInfo1);
				System.out.println("删除成功");
				break;
			case "0020":// 修改药品信息
				String medicineInfo = (String) inObject.readObject();
				admin = (Administrator) inObject.readObject();
				strs = medicineInfo.split("\\s");
				admin.alterMedicine(strs[0], strs[1], strs[2], strs[2], strs[3], strs[4]);
				System.out.println("修改成功");
				break;
			case "0021":// 删除药品信息
				String medicineId = (String) inObject.readObject();// 读数据
				admin = (Administrator) inObject.readObject();// 读对象
				admin.deleteMedicine(medicineId);
				System.out.println("删除成功");
				break;
			case "0022":// 增加药品
				String medicineInfo1 = (String) inObject.readObject();
				admin = (Administrator) inObject.readObject();
				strs = medicineInfo1.split("\\s");
				admin.addMedicine(strs[0], strs[1], strs[2], Double.parseDouble(strs[3]), Integer.parseInt(strs[4])
				);
				System.out.println("添加成功");
				break;
			case "0023":// 显示所有收费信息
				String chargeInfo = showChargeItem();
				outObject.writeObject(chargeInfo);
				outObject.flush();
				System.out.println("发送成功");
				break;
			case "0024":// 显示所有药品信息
				String medicineInfo2 = showMedicine();
				outObject.writeObject(medicineInfo2);
				outObject.flush();
				System.out.println("发送成功");
				break;
			case "0025":// 显示所有科室信息
				String office = showOffice();
				outObject.writeObject(office);
				outObject.flush();
				System.out.println("发送成功");
				break;
			case "0026":// 根据简称和数量给病人开处方并返回简称对应的名称
				String jc = (String) inObject.readObject();
				doctor = (Doctor)inObject.readObject();
				String[] jcs = jc.split("\\s");// 简称+数量+类型(药品或者是收费项目)
				String name = prescribe(doctor,jcs[0],jcs[1],jcs[2]);//开处方
				outObject.writeObject(name);
				outObject.flush();
				outObject.close();
				break;
			case "0027"://更新doctor对象
				doctor=(Doctor)inObject.readObject();
				Doctor newDoctor;
				newDoctor=updateDoctor(doctor);
				outObject.writeObject(newDoctor);
				outObject.flush();
				System.out.println("更新成功");
				break;
			case "0028"://医生病人队列的第一个病人完成看病
				doctor=(Doctor)inObject.readObject();
				finish(doctor);
				break;
			case "2000":// 挂号功能
				Object patient = inObject.readObject();
				Registration reg = new Registration();
				OrderInformation orderInfor = new OrderInformation();
				// 判断是否是预约病人
				boolean re = ((Registration) reg).isOrder((Patient) patient);
				if (re) {// 如果是预约病人
					orderInfor = reg.searchOrderInfor((Patient) patient);
					outObject.writeObject(orderInfor);
				} else {
					outObject.writeObject(null);
				}
				outObject.flush();
				break;
			case "2001":// 添加预约病人到医生就诊序列
				Object patient_1 = inObject.readObject();
				Registration reg_1 = new Registration();
				Patient inPatient_1 = reg_1.addDoctorAppointmentPatient((Patient) patient_1);
				if (inPatient_1 != null)
					outObject.writeObject(inPatient_1);
				else
					outObject.writeObject(null);

				outObject.flush();
				break;
			case "2002":// 添加未预约病人到医生队列中
				Object patient_2 = inObject.readObject();
				Registration reg_2 = new Registration();
				Patient inPatient_2 = reg_2.addDoctorNoAppointmentPatient((Patient) patient_2);
				if (inPatient_2 != null)
					outObject.writeObject(inPatient_2);
				else
					outObject.writeObject(null);

				outObject.flush();
				break;
			case "2003":// 发送查看病人收费信息的请求:
				Object patient_3 = inObject.readObject();
				Registration reg_3 = new Registration();
				Patient inPatient_3 = reg_3.getPatientChargeItem(((Patient) patient_3).getId());
				outObject.writeObject(inPatient_3);

				outObject.flush();
				break;
			case "2004":// 提交病人已缴费的信息
				Object patient_4 = inObject.readObject();
				Registration reg_4 = new Registration();
				Patient inPatient_4 = reg_4.confirmPatientPayment((Patient) patient_4);
				outObject.writeObject(inPatient_4);

				outObject.flush();
				break;

			case "院长要医生信息":
				System.out.println("收到院长要医生信息请求");
				sqlStr = "select name,cureNum,cureMoney from [Doctor]";
				crs = db.selectGetCashedRowSet(sqlStr);
				outObject.writeObject(crs);
				
				outObject.flush();
			case "院长要科室信息":
				System.out.println("收到院长要科室信息请求");
				sqlStr = "select hospitalDepartmentName,registerNum,money from [HospitalDepartment]";
				crs = db.selectGetCashedRowSet(sqlStr);
				outObject.writeObject(crs);
				
				outObject.flush();
				break;
			case "院长要药品信息":
				System.out.println("收到院长要药品信息请求");
				sqlStr = "select name,deposit from [Medicine]";
				crs = db.selectGetCashedRowSet(sqlStr);
				outObject.writeObject(crs);
				
				outObject.flush();
				break;
			case"药师要registerPatients Arraylist":
				System.out.println("收到药师要registerPatients Arraylist请求");
				ArrayList<Patient> repati=Data.registerPatients;
				outObject.writeObject(repati);
				outObject.flush();
				
			case "药房端修改药品库存":
				System.out.println("收到药房端修改药品库存请求");
				
				ArrayList<Medicine> medicine=(ArrayList<Medicine>) inObject.readObject();
				for(Medicine m:medicine){
					String id=m.getNo();
					int number=m.getNumber();
					sqlStr="update [medicine] set deposit=deposit-"+number+" where medicineID="+id;
					db.update(sqlStr);
				}
				outObject.writeObject("更新库存成功！");
				outObject.flush();
				
				
			case "预约要科室信息":
				System.out.println("收到预约端要科室信息请求");
				sqlStr="select hospitalDepartmentName from [HospitalDepartment]";
				rs=db.select(sqlStr);
				String hospitalDepartmentNames="";
				while(true){
					if(rs.next()){
						hospitalDepartmentNames=hospitalDepartmentNames+rs.getString("hospitalDepartmentName")+":";
					}else{
						break;
					}
				}
				outObject.writeObject(hospitalDepartmentNames);
				outObject.flush();
			case "预约端要预约":
				Order order=(Order) inObject.readObject();
				System.out.println("收到预约端要预约的请求");
                String patientID=order.patientID;
       			String name2=order.name;
       			String sex=order.sex;
       			int age=order.age;
       			String phoneNumber=order.phoneNumber;
       			String hospitalDepartmentName=order.hospitalDepartmentName;
       			sqlStr="select hospitalDepartmentID from [HospitalDepartment] where hospitalDepartmentName='"+hospitalDepartmentName+"'";
       			rs=db.select(sqlStr);
       			int hospitalDepartmentID=0;
       			if(rs.next()){
       				hospitalDepartmentID=rs.getInt("hospitalDepartmentID");}
       			
       			String orderTime=order.orderTime;
                   
       			sqlStr="insert into [Appointment](patientID,name,sex,age,phoneNumber,"
       					+ "hospitalDepartmentID,hospitalDepartmentName,orderTime) values"+"('"+patientID+"','"+
       					name2+"','"+sex+"',"+age+",'"+phoneNumber+"',"+hospitalDepartmentID+",'"+hospitalDepartmentName
       					+"','"+orderTime+"')";
       			
                   		//写入数据库
            
                   		boolean result=db.insert(sqlStr);
                   		if(result){
                   			outObject.writeObject("预约成功");
                   			outObject.flush();
                   		}
                   		
                   		
             
                  
                   		
                   		
                   		
                   		
                   		
                   inObject.close();
                   outObject.close();
			}
			inObject.close();
			outObject.close();
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Main.count--;

	}

	//验证用户名和密码
	public Object verify(Object person) throws SQLException {
		String sqlStr = "";
		ResultSet rs = null;
		DB db = new DB();
		if (person instanceof Administrator) {
			Administrator manager = (Administrator) person;
			sqlStr = "select * from [Manager] where managerID=" + manager.getUserName() + " and password='"
					+ manager.getPassword() + "'";
			rs = db.select(sqlStr);
			if (rs.next()) {
				manager.setUserName("" + rs.getInt("managerID"));
				manager.setPassword(rs.getString("password"));
				manager.setName(rs.getString("name"));
				return manager;
			} else {
				return null;
			}

		} else if (person instanceof Doctor) {
			Doctor doctor = (Doctor) person;
			sqlStr = "select * from [Doctor] where doctorID=" + doctor.getUserName() + " and password="
					+ doctor.getPassword();
			rs = db.select(sqlStr);

			String hospitalDepartmentid = "";
			if (rs.next()) {
				hospitalDepartmentid = "" + rs.getInt("hospitalDepartmentID");
				doctor.setUserName("" + rs.getInt("doctorID"));
				doctor.setPassword(rs.getString("password"));
				doctor.setName(rs.getString("name"));
				doctor.setCureNum(rs.getInt("cureNum"));
				doctor.setMoney(rs.getDouble("curemoney"));
				// 要把hospitalDepartment整个读出来
				HospitalDepartment hd = new HospitalDepartment();
				sqlStr = "select * from [HospitalDepartment] where hospitalDepartmentid=" + hospitalDepartmentid;
				rs = db.select(sqlStr);
				rs.next();//初始rs引用的位置在结果集的前一行
				hd.setNo("" + rs.getInt("hospitalDepartmentID"));
				hd.setName(rs.getString("hospitalDepartmentName"));
				hd.setMoney(rs.getDouble("money"));
				hd.setRegisterNum(rs.getInt("registerNum"));
				doctor.setHospitalDepartment(hd);
				Data.doctors.add(doctor);
				/***模拟一个数据****/
				doctor.getPatients().add(Data.patientSample);
				return doctor;
			} else {
				return null;
			}

		} else if (person instanceof Charger) {
			Charger charger = (Charger) person;
			sqlStr = "select * from [Charger] where chargerID=" + charger.getUserName() + " and password='" + charger.getPassword()+"';";
			rs = db.select(sqlStr);
			if (rs.next()) {
				charger.setUserName("" + rs.getInt("chargerID"));
				charger.setPassword(rs.getString("password"));
				charger.setName(rs.getString("name"));
				return charger;
			} else {
				return null;
			}
		} else if (person instanceof Druggist) {
			Druggist druggist = (Druggist) person;
			sqlStr = "select * from [Druggist] where druggistID=" + druggist.getUserName() + " and password='"
					+ druggist.getPassword()+"'";
			rs = db.select(sqlStr);
			if (rs.next()) {
				druggist.setUserName("" + rs.getInt("druggistID"));
				druggist.setPassword(rs.getString("password"));
				druggist.setName(rs.getString("name"));
				return druggist;
			} else {
				return null;
			}
		} else if (person instanceof President) {
			President president = (President) person;
			sqlStr = "select * from [President] where presidentID=" + president.getUserName() + " and password='"
					+ president.getPassword()+"'";
			rs = db.select(sqlStr);
			if (rs.next()) {
				president.setUserName("" + rs.getInt("presidentID"));
				president.setPassword(rs.getString("password"));
				president.setName(rs.getString("name"));
				return president;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

	// 显示所有账号信息
	public String showAccounts() {

		String accountsInfo = "";

		accountsInfo += showAccountsForEach("select * from [Manager]", "manager", "管理员");
		accountsInfo += showAccountsForEach("select * from [Doctor]", "doctor", "医生");
		accountsInfo += showAccountsForEach("select * from [Charger]", "charger", "收费人员");
		accountsInfo += showAccountsForEach("select * from [Druggist]", "druggist", "药师");
		accountsInfo += showAccountsForEach("select * from [President]", "president", "院长");
		return accountsInfo;
	}

	public String showAccountsForEach(String sqlStr, String type, String chineseTypeName) { // 返回一个表的所有账号信息
		String accountsInfoForEach = "";
		DB db = new DB();
		ResultSet rs = null;
		rs = db.select(sqlStr);
		while (true) {
			try {
				if (rs.next()) {
					accountsInfoForEach += rs.getString(type + "ID") +"\t"+ rs.getString("password") + "\t"+rs.getString("name") +"\t";
					accountsInfoForEach += chineseTypeName + "$";
				} else {
					break;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return accountsInfoForEach;

	}

	// 添加账号
	public void add(Administrator admin, String userName, String password, String name, String type,
			String hospitalDepartment) {
		switch (type) {
		case "管理员":
			admin.addAdminStrator(userName, password, name);
			break;
		case "收费人员":
			admin.addCharger(userName, password, name);
			break;
		case "医生":
			DB db=new DB();
			String sql="select * from hospitalDepartment where hospitalDepartmentName="+"'"+hospitalDepartment+"'";
			ResultSet rs=null;
			rs=db.select(sql);	
			try {
				rs.next();
				HospitalDepartment a =new HospitalDepartment(rs.getString("hospitalDepartmentName"),rs.getString("hospitalDepartmentID"));
				admin.addDoctor(userName, password, name, a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "药师":
			admin.addDruggist(userName, password, name);
			break;
		case "院长":
			admin.addPresident(userName, password, name);
			break;

		}
	}

	// 显示所有收费项目
	public String showChargeItem() {
		String str = "";
		DB db=new DB();
		String sql="select * from ChargeItem";
		ResultSet rs=null;
		try{
			rs=db.select(sql);
			String singal="";
			while(rs.next()){
				singal=rs.getString("chargeitemID")+" "+rs.getString("name")+" "+rs.getString("shortName")+" "+rs.getString("unit")+" "+rs.getString("price");
				str+=singal+"$";
			}
		}catch(Exception e){
			
		}
		return str;
	}

	// 显示所有药品信息
	public String showMedicine() {
		String str = "";
		DB db=new DB();
		String sql="select * from Medicine";
		ResultSet rs=null;
		try{
			rs=db.select(sql);
			String singal="";
			while(rs.next()){
				singal=rs.getString("medicineID")+" "+rs.getString("name")+" "+rs.getString("shortName")+" "+rs.getString("unit")+" "+rs.getString("price");
				str+=singal+"$";
			}
		}catch(Exception e){
			
		}
		return str;
	}

	// 显示所有科室信息
	public String showOffice() {
		String str = "";
		DB db=new DB();
		String sql="select * from HospitalDepartment";
		ResultSet rs=null;
		try{
			rs=db.select(sql);
			String singal="";
			while(rs.next()){
				singal=rs.getString("hospitalDepartmentID")+" "+rs.getString("hospitalDepartmentName");
				str+=singal+"$";
			}
		}catch(Exception e){
			
		}
		return str;
	}

	// 开处方
	public String prescribe(Doctor doctor,String jc, String num,String type) {
		String s = "";
		DB db = new DB();
		ResultSet rs = null;
		for(Doctor a:Data.doctors){
			if(a.getUserName().equals(doctor.getUserName())){
				doctor=a;
				break;
			}
		}
		try {
			if (type.equals("药品")) {
				String sql="select * from medicine where shortName="+"'"+jc+"'";
				rs = db.select(sql);
				rs.next();//注意
				Medicine medicine=new Medicine(rs.getString("name"),rs.getString("shortName"),rs.getString("unit"),rs.getDouble("price"),rs.getString("medicineID"));
				medicine.setNumber(Integer.parseInt(num));//设置药品数量
				doctor.getPatients().get(0).setAmount(doctor.getPatients().get(0).getAmount()+medicine.getAmount());//修改病人应支付金额
				doctor.getPatients().get(0).getMedicines().add(medicine);//添加病人的药品
				String patientId=doctor.getPatients().get(0).getId();
				/*for(Patient p:Data.registerPatients){
					if(p.getId().equals(patientId)){
						p.getMedicines().add(medicine);
					}
				}	*/			
				s=medicine.getName();//返回名称
				
			} else {
				String sql="select * from chargeItem where shortName="+"'"+jc+"'";
				rs = db.select(sql);
				rs.next();//注意
				ChargeItem chargeItem=new ChargeItem(rs.getString("name"),rs.getString("shortName"),rs.getString("unit"),rs.getDouble("price"),rs.getString("chargeItemID"));
				chargeItem.setNumber(Integer.parseInt(num));//设置检查次数
				doctor.getPatients().get(0).setAmount(doctor.getPatients().get(0).getAmount()+chargeItem.getAmount());//修改病人应支付金额
				doctor.getPatients().get(0).getChargeItems().add(chargeItem);//添加病人的收费项目
				String patientId=doctor.getPatients().get(0).getId();
				/*for(Patient p:Data.registerPatients){
					if(p.getId().equals(patientId)){
						p.getChargeItems().add(chargeItem);
					}
				}	*/	
				s=chargeItem.getName();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	//更新医生对象
	public Doctor updateDoctor(Doctor doctor){
		for(Doctor a:Data.doctors){
			if(doctor.getUserName().equals(a.getUserName())){
				return a;
			}
		}
		return null;
	}

	
	//医生的病人队列第一个病人完成看病
	public void finish(Doctor doctor){
		for(Doctor a:Data.doctors){
			if(a.getUserName().equals(doctor.getUserName())){
				doctor=a;
				break;
			}
		}
		//写回医生的cureNum和money
		
		DB db = new DB();
		float money=0;
		int num=0;
		ResultSet rs=null;
		try {
			String sql="select * from doctor where doctorID="+"'"+doctor.getUserName()+"'";
			rs=db.select(sql);
			rs.next();
			money=Float.parseFloat(rs.getString("cureMoney"));
			num=Integer.parseInt(rs.getString("cureNum"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		money+=doctor.getPatients().get(0).getAmount();
		num+=1;
		String sql = "update Doctor set cureMoney="+"'"+money+"',"+"cureNum="+"'"+num+"'"+"from doctor where doctorID="+"'"+doctor.getUserName()+"'";
		db.insert(sql);
		db.closeAll();
		//未开处方病人转为已开处方病人
		Patient temp=doctor.getPatients().get(0);
		doctor.getPatients().remove(0);
		doctor.getPatientsFinish().add(temp);
	}

}