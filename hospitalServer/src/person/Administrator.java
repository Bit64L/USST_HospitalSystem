package person;

import staff.ChargeItem;
import staff.HospitalDepartment;
import staff.Medicine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Administrator extends Person{

	private ArrayList<Doctor> doctors=new ArrayList<>();
	private ArrayList<Charger> chargers=new ArrayList<>();

	static ArrayList<HospitalDepartment> hospitalDepartments = new ArrayList<>();
	static ArrayList<Medicine> medicines = new ArrayList<>();
	static ArrayList<ChargeItem> chargeItems = new ArrayList<>();

	public Administrator(String userName, String password,String name,String id) {
		super(userName,password,name,id);
	}
	//娣诲姞鍖荤敓璐︽埛
	public void addDoctor(String userName,String password,String name,String id,HospitalDepartment hospitalDepartment) throws IOException{
		doctors.add(new Doctor(userName,password,name,id,hospitalDepartment));
		//writeAccount("account.txt");
	}
	//娣诲姞鎸傚彿鏀惰垂浜哄憳璐︽埛
	public void addCharger(String userName,String password,String name,String id) throws IOException{
		chargers.add(new Charger(userName,password,name,id));
		//writeAccount("account.txt");
	}
	//娣诲姞绉戝
	public void addHospitalDepartment(String name,String no) throws IOException{
		Administrator.hospitalDepartments.add(new HospitalDepartment(name,no));
		//writeAccount("hospitalDepartment.txt");
	}
	//娣诲姞鑽搧
	public void addMedicine(String name,String shortName,String unit,double price,String no,int deposit) throws IOException{
		Administrator.medicines.add(new Medicine(name,shortName,unit,price,no,deposit));
		//writeAccount("medicine.txt");
	}
	//娣诲姞鏀惰垂椤圭洰
	public void addChargeItem(String name,String shortName,String unit,double price,String no) throws IOException{
		Administrator.chargeItems.add(new ChargeItem(name,shortName,unit,price,no));
		//writeAccount("chargeItem.txt");
	}
	//淇敼璐︽埛
	/*public String alterAccount(String userName,String newPassword,String newType) throws IOException{
		int mark=0;
		for(Account a : Administor.accounts){
			if(a.getUserName().equals(userName)){
				a.setPassword(newPassword);
				a.setType(newType);
				mark=1;
				break;
			}
		}
		//writeAccount("account.txt");
		if(mark==0) return "鏃犺璐﹀彿锛�";
		return "淇敼鎴愬姛锛�";
	}*/
	//淇敼绉戝
	public String alterHospital(String no,String newName) throws IOException{
		int mark=0;
		for(HospitalDepartment a : Administrator.hospitalDepartments){
			if(a.getNo().equals(no)){
				a.setName(newName);
				mark=1;
				break;
			}
		}
		//writeAccount("hospitalDepartment.txt");
		if(mark==0) return "鏃犺绉戝锛�";
		return "淇敼鎴愬姛锛�";
	}
	//淇敼鑽搧
	public String alterMedicine(String shortName,String newNo,String newUnit,String newPrice) throws IOException{
		int mark=0;
		for(Medicine a : Administrator.medicines){
			if(a.getShortName().equals(shortName)){
				a.setNo(newNo);
				a.setUnit(newUnit);
				double price = Double.parseDouble(newPrice);
				a.setPrice(price);
				mark=1;
				break;
			}
		}
		//writeAccount("medicine.txt");
		if(mark==0) return "鏃犺鑽搧锛�";
		return "淇敼鎴愬姛锛�";
	}
	//淇敼鏀惰垂椤圭洰
	public String alterChargeItem(String shortName,String newNo,String newUnit,String newPrice) throws IOException{
		int mark=0;
		for(ChargeItem a : Administrator.chargeItems){
			if(a.getShortName().equals(shortName)){
				a.setNo(newNo);
				a.setUnit(newUnit);
				double price = Double.parseDouble(newPrice);
				a.setPrice(price);
				mark=1;
				break;
			}
		}
		//writeAccount("chargeItem.txt");
		if(mark==0) return "鏃犺椤圭洰锛�";
		return "淇敼鎴愬姛锛�";
	}
	//鍒犻櫎璐﹀彿
	/*public String deleteAccount(String userName) throws IOException{
		int mark=0;
		for(Account a:Administor.accounts){
			if(a.getUserName().equals(userName)){
				accounts.remove(a);
				mark=1;
				break;
			}
		}
		writeAccount("account.txt");
		if(mark==0) return "鍒犻櫎澶辫触锛�";
		return "鍒犻櫎鎴愬姛锛�";
	}*/
	//鍒犻櫎绉戝
	public String deleteHospitalDepartment(String name) throws IOException{
		int mark=0;
		for(HospitalDepartment a:Administrator.hospitalDepartments){
			if(a.getName().equals(name)){
				hospitalDepartments.remove(a);
				mark=1;
				break;
			}
		}
		//writeAccount("hospitalDepartment.txt");
		if(mark==0) return "鍒犻櫎澶辫触锛�";
		return "鍒犻櫎鎴愬姛锛�";
	}
	//鍒犻櫎鑽搧
	public String deleteMedicine(String name) throws IOException{
		int mark=0;
		for(Medicine a:Administrator.medicines){
			if(a.getName().equals(name)){
				medicines.remove(a);
				mark=1;
				break;
			}
		}
		//writeAccount("medicine.txt");
		if(mark==0) return "鍒犻櫎澶辫触锛�";
		return "鍒犻櫎鎴愬姛锛�";
	}
	//鍒犻櫎椤圭洰
	public String deleteChargeItem(String name) throws IOException{
		int mark=0;
		for(ChargeItem a:Administrator.chargeItems){
			if(a.getName().equals(name)){
				medicines.remove(a);
				mark=1;
				break;
			}
		}
		//writeAccount("chargeItem.txt");
		if(mark==0) return "鍒犻櫎澶辫触锛�";
		return "鍒犻櫎鎴愬姛锛�";
	}
	//灏嗘敼鍙樼殑缁撴灉鍐欏洖鏂囦欢
	/*public void writeAccount(String fileName) throws IOException{
		FileWriter file = new FileWriter(fileName);
		for(Account a : Administor.accounts){
			file.write(a.getUserName()+" "+a.getPassword()+a.getType());
		}
		file.close();
	}*/
	public void writeHospitalDepartment(String fileName) throws IOException{
		FileWriter file = new FileWriter(fileName);
		for(HospitalDepartment a : Administrator.hospitalDepartments){
			file.write(a.getName()+" "+a.getNo());
		}
		file.close();
	}
	public void writeMedicine(String fileName) throws IOException{
		FileWriter file = new FileWriter(fileName);
		for(Medicine a : Administrator.medicines){
			file.write(a.getName()+" "+a.getShortName()+" "+a.getUnit()+" "+a.getPrice()+" "+a.getNo());
		}
		file.close();
	}
	public void writeChargeItem(String fileName) throws IOException{
		FileWriter file = new FileWriter(fileName);
		for(ChargeItem a : Administrator.chargeItems){
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

