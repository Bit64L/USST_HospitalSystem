package person;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import data.Data;
import staff.*;
import utility.DB;
public class Administrator implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String name;
	public Administrator(String userName, String password,String name) {
		this.userName = userName;
		this.password = password;
		this.name = name;
	}
	public Administrator(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//添加管理员账号
	public void addAdminStrator(String userName,String password,String name){
		String sqlStr="insert into [Manager](password,name) values('"+password+"','"+name+"')";
		DB db=new DB();
		boolean result=db.insert(sqlStr);
		if(result){
			System.out.println("添加管理员成功");
		}
	}
	//添加医生账户
	public void addDoctor(String userName,String password,String name,HospitalDepartment hospitalDepartment){
		String hdid=hospitalDepartment.getNo();
		String hdname=hospitalDepartment.getName();
		String sqlStr="insert into [Doctor](password,name,hospitalDepartmentID,hospitalDepartmentName)"
				+ " values('"+password+"','"+name+"',"+hdid+",'"+hdname+"')";
		DB db=new DB();
		boolean result=db.insert(sqlStr);
		if(result){
			System.out.println("添加医生成功");
		}
	}
	//添加挂号收费人员账户
	public void addCharger(String userName,String password,String name){
		String sqlStr="insert into [Charger](password,name) values('"+password+"','"+name+"')";
		DB db=new DB();
		boolean result=db.insert(sqlStr);
		if(result){
			System.out.println("添加收费人员成功");
		}
	}
	//添加药师
	public void addDruggist(String userName,String password,String name){
		String sqlStr="insert into [Druggist](password,name) values('"+password+"','"+name+"')";
		DB db=new DB();
		boolean result=db.insert(sqlStr);
		if(result){
			System.out.println("添加药师成功");
		}
	}
	//添加院长
	public void addPresident(String userName,String password,String name){
		String sqlStr="insert into [President](password,name) values('"+password+"','"+name+"')";
		DB db=new DB();
		boolean result=db.insert(sqlStr);
		if(result){
			System.out.println("添加院长成功");
		}
	}

	//添加科室
	public void addHospitalDepartment(String name) throws IOException{
		String sqlStr="insert into [HospitalDepartment](hospitalDepartmentName) values('"+name+"')";
		DB db=new DB();
		boolean result=db.insert(sqlStr);
		if(result){
			System.out.println("添加科室成功");
		}
	}
	//添加药品
	public void addMedicine(String name,String shortName,String unit,double price,int deposit){
		String sqlStr="insert into [Medicine](name,shortName,unit,price,deposit) values('"+name+"','"
				+shortName+"','"+unit+"',"+price+","+deposit+")";
		DB db=new DB();
		boolean result=db.insert(sqlStr);
		if(result){
			System.out.println("添加药品成功");
		}
	}
	//添加收费项目
	public void addChargeItem(String name,String shortName,String unit,double price){
		String sqlStr="insert into [ChargeItem](name,shortName,unit,price) values('"+name+"','"
				+shortName+"','"+unit+"',"+price+")";
		DB db=new DB();
		boolean result=db.insert(sqlStr);
		if(result){
			System.out.println("添加收费项目成功");
		}
	}
	
	
	//修改账户
	public void alterAccount(String userName,String password,String name){
		String tableName="";
		String idName="";
		int id=Integer.parseInt(userName);
		if(id<2000){
			tableName="Manager";
			idName="managerID";
		}else if(id<3000){
			tableName="Doctor";
			idName="doctorID";
		}else if(id<4000){
			tableName="Charger";
			idName="chargerID";
		}else if(id<5000){
			tableName="Druggist";
			idName="druggistID";
		}else if(id<6000){
			tableName="President";
			idName="presidentID";
		}
		String sqlStr="update ["+tableName+"] set name='"+name+"',password='"+password+"' where "+idName+"='"+userName+"'";
		DB db=new DB();
		boolean result=db.update(sqlStr);
		if(result){
			System.out.println("修改"+tableName+"表成功");
		}
	}
	//修改科室
	public String alterHospital(String no,String newName) throws IOException{
		String sqlStr="update [HospitalDepartment] set hospitalDepartmentName='"+newName+"'"+" where hospitalDepartmentID="+"'"+no+"'";
		DB db=new DB();
		boolean result=db.update(sqlStr);
		if(result){
			return "修改科室表成功";
		}else
			return "无该科室！";
	}
	//修改药品
	public String alterMedicine(String No,String name,String shortName,String newUnit,String newPrice,String deposit){
		String sqlStr="update [Medicine] set name='"+name+"',shortName='"+shortName+"',unit='"+newUnit+"',price="+newPrice+",deposit="+deposit
				+" where medicineID="+No;
		DB db=new DB();
		boolean result=db.update(sqlStr);
		if(result){
			return "修改药品表成功";
		}else
			return "无该药品！";
	}
	//修改收费项目
	public String alterChargeItem(String No,String newName,String newShortName,String newUnit,String newPrice) throws IOException{
		String sqlStr="update [ChargeItem] set name='"+newName+"',shortName='"+newShortName+"',unit='"+newUnit+"',price="+newPrice
				+" where chargeitemID="+No;
		DB db=new DB();
		boolean result=db.update(sqlStr);
		if(result){
			return "修改收费项目表成功";
		}else
			return "无该收费项目！";
	}
	//删除账号
	public void deleteAccount(String userName) throws IOException{
		String tableName="";
		String idName="";
		int id=Integer.parseInt(userName);
		if(id<2000){
			tableName="Manager";
			idName="managerID";
		}else if(id<3000){
			tableName="Doctor";
			idName="doctorID";
		}else if(id<4000){
			tableName="Charger";
			idName="chargerID";
		}else if(id<5000){
			tableName="Druggist";
			idName="druggistID";
		}else if(id<6000){
			tableName="President";
			idName="presidentID";
		}
		String sqlStr="delete from["+tableName+"] where "+idName+"="+userName;
		DB db=new DB();
		boolean result=db.delete(sqlStr);
		if(result){
			System.out.println("删除账号成功");
		}else
			System.out.println("删除账号失败");
	}
	//删除科室
	public String deleteHospitalDepartment(String name){
		String sqlStr="delete from [HospitalDepartment] where hospitalDepartmentID="+name;
		DB db=new DB();
		boolean result=db.delete(sqlStr);
		if(result){
			return "删除科室成功";
		}else
			return "删除科室失败";
	}
	//删除药品
	public String deleteMedicine(String name) throws IOException{
		String sqlStr="delete from [Medicine] where medicineID="+name;
		DB db=new DB();
		boolean result=db.delete(sqlStr);
		if(result){
			return "删除药品成功";
		}else
			return "删除药品失败";
	}
	//删除项目
	public String deleteChargeItem(String no) throws IOException{
		String sqlStr="delete from [ChargeItem] where chargeitemID="+no;
		DB db=new DB();
		boolean result=db.delete(sqlStr);
		if(result){
			return "删除项目成功";
		}else
			return "删除项目失败";
	}
	//将改变的结果写回文件
	/*public void writeAccount(String fileName) throws IOException{
		FileWriter file = new FileWriter(fileName);
		for(Account a : Administor.accounts){
			file.write(a.getUserName()+" "+a.getPassword()+a.getType());
		}
		file.close();
	}*/
	/*public void writeHospitalDepartment(String fileName) throws IOException{
		FileWriter file = new FileWriter(fileName);
		for(HospitalDepartment a : Data.hospitalDepartments){
			file.write(a.getName()+" "+a.getNo());
		}
		file.close();
	}
	public void writeMedicine(String fileName) throws IOException{
		FileWriter file = new FileWriter(fileName);
		for(Medicine a : Data.medicines){
			file.write(a.getName()+" "+a.getShortName()+" "+a.getUnit()+" "+a.getPrice()+" "+a.getNo());
		}
		file.close();
	}
	public void writeChargeItem(String fileName) throws IOException{
		FileWriter file = new FileWriter(fileName);
		for(ChargeItem a : Data.chargeItems){
			file.write(a.getName()+" "+a.getShortName()+" "+a.getUnit()+" "+a.getPrice()+" "+a.getNo());
		}
		file.close();
	}*/
/*	public static void main(String[] args) throws IOException {
		Administor admin = new Administor("123456","000000");
		for(Administor.Account a:Administor.accounts){
			System.out.println(a.getUserName()+" "+a.getPassword()+" "+a.getType());
		}
		for(Administor.HospitalDepartment a:Administor.hospitalDepartments){
			System.out.println(a.getName());
		}
		for(Administor.Medicine a:Administor.medicines){
			System.out.println(a.getName()+" "+a.getShortName()+" "+a.getUnit()+" "+a.getPrice());
		}
		for(Administor.ChargeItem a:Administor.chargeItems){
			System.out.println(a.getName()+" "+a.getShortName()+" "+a.getUnit()+" "+a.getPrice());
		}
	}*/
}

