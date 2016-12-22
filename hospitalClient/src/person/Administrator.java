package person;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import data.Data;
import staff.*;
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
		Data.administrators.add(new Administrator(userName,password,name));
	}
	//添加医生账户
	public void addDoctor(String userName,String password,String name,HospitalDepartment hospitalDepartment){
		Data.doctors.add(new Doctor(userName,password,name,hospitalDepartment));
	}
	//添加挂号收费人员账户
	public void addCharger(String userName,String password,String name){
		Data.chargers.add(new Charger(userName,password,name));
	}
	//添加药师
	public void addDruggist(String userName,String password,String name){
		Data.chargers.add(new Charger(userName,password,name));
	}
	//添加院长
	public void addPresident(String userName,String password,String name){
		Data.chargers.add(new Charger(userName,password,name));
	}

	//添加科室
	public void addHospitalDepartment(String name,String no) throws IOException{
		Data.hospitalDepartments.add(new HospitalDepartment(name,no));
	}
	//添加药品
	public void addMedicine(String name,String shortName,String unit,double price,String no,int deposit) throws IOException{
		Data.medicines.add(new Medicine(name,shortName,unit,price,no,deposit));
	}
	//添加收费项目
	public void addChargeItem(String name,String shortName,String unit,double price,String no){
		Data.chargeItems.add(new ChargeItem(name,shortName,unit,price,no));
	}
	//修改账户
	public void alterAccount(String userName,String password,String name){
		for(Administrator a:Data.administrators){
			if(a.getUserName().equals(userName)){
				a.setPassword(password);
				a.setName(name);
			}
		}
		for(Doctor a:Data.doctors){
			if(a.getUserName().equals(userName)){
				a.setPassword(password);
				a.setName(name);
			}
		}
		for(Charger a:Data.chargers){
			if(a.getUserName().equals(userName)){
				a.setPassword(password);
				a.setName(name);
			}
		}
		for(Druggist a:Data.druggists){
			if(a.getUserName().equals(userName)){
				a.setPassword(password);
				a.setName(name);
			}
		}
		for(President a:Data.presidents){
			if(a.getUserName().equals(userName)){
				a.setPassword(password);
				a.setName(name);
			}
		}
	}
	//修改科室
	public String alterHospital(String no,String newName) throws IOException{
		int mark=0;
		for(HospitalDepartment a : Data.hospitalDepartments){
			if(a.getNo().equals(no)){
				a.setName(newName);
				mark=1;
				break;
			}
		}
		//writeAccount("hospitalDepartment.txt");
		if(mark==0) return "无该科室！";
		return "修改成功！";
	}
	//修改药品
	public String alterMedicine(String No,String name,String shortName,String newUnit,String newPrice,String deposit){
		int mark=0;
		for(Medicine a : Data.medicines){
			if(a.getNo().equals(No)){
				a.setName(name);
				a.setShortName(shortName);
				a.setUnit(newUnit);
				double price = Double.parseDouble(newPrice);
				a.setPrice(price);
				a.setDeposit(Integer.parseInt(deposit));
				mark=1;
				break;
			}
		}
		//writeAccount("medicine.txt");
		if(mark==0) return "无该药品！";
		return "修改成功！";
	}
	//修改收费项目
	public String alterChargeItem(String No,String newName,String newShortName,String newUnit,String newPrice) throws IOException{
		int mark=0;
		for(ChargeItem a : Data.chargeItems){
			if(a.getNo().equals(No)){
				a.setName(newName);
				a.setShortName(newShortName);
				a.setUnit(newUnit);
				double price = Double.parseDouble(newPrice);
				a.setPrice(price);
				mark=1;
				break;
			}
		}
		//writeAccount("chargeItem.txt");
		if(mark==0) return "无该项目！";
		return "修改成功！";
	}
	//删除账号
	public void deleteAccount(String userName) throws IOException{
		for(Administrator a:Data.administrators){
			if(a.getUserName().equals(userName)){
				Data.administrators.remove(a);
				return;
			}
		}
		for(Charger a:Data.chargers){
			if(a.getUserName().equals(userName)){
				Data.chargers.remove(a);
				return;
			}
		}

		for(Doctor a:Data.doctors){
			if(a.getUserName().equals(userName)){
				Data.doctors.remove(a);
				return;
			}
		}
		for(Druggist a:Data.druggists){
			if(a.getUserName().equals(userName)){
				Data.druggists.remove(a);
				return;
			}
		}
		for(President a:Data.presidents){
			if(a.getUserName().equals(userName)){
				Data.presidents.remove(a);
				return;
			}
		}
	}
	//删除科室
	public String deleteHospitalDepartment(String name){
		int mark=0;
		for(HospitalDepartment a:Data.hospitalDepartments){
			if(a.getName().equals(name)){
				Data.hospitalDepartments.remove(a);
				mark=1;
				break;
			}
		}
		//writeAccount("hospitalDepartment.txt");
		if(mark==0) return "删除失败！";
		return "删除成功！";
	}
	//删除药品
	public String deleteMedicine(String name) throws IOException{
		int mark=0;
		for(Medicine a:Data.medicines){
			if(a.getName().equals(name)){
				Data.medicines.remove(a);
				mark=1;
				break;
			}
		}
		//writeAccount("medicine.txt");
		if(mark==0) return "删除失败！";
		return "删除成功！";
	}
	//删除项目
	public String deleteChargeItem(String name) throws IOException{
		int mark=0;
		for(ChargeItem a:Data.chargeItems){
			if(a.getName().equals(name)){
				Data.medicines.remove(a);
				mark=1;
				break;
			}
		}
		//writeAccount("chargeItem.txt");
		if(mark==0) return "删除失败！";
		return "删除成功！";
	}
	//将改变的结果写回文件
	/*public void writeAccount(String fileName) throws IOException{
		FileWriter file = new FileWriter(fileName);
		for(Account a : Administor.accounts){
			file.write(a.getUserName()+" "+a.getPassword()+a.getType());
		}
		file.close();
	}*/
	public void writeHospitalDepartment(String fileName) throws IOException{
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
	}
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

