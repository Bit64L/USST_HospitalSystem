package Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Administor {
	private String userName;
	private String password;
	static ArrayList<Account> accounts = new ArrayList<>();
	static ArrayList<HospitalDepartment> hospitalDepartments = new ArrayList<>();
	static ArrayList<Medicine> medicines = new ArrayList<>();
	static ArrayList<ChargeItem> chargeItems = new ArrayList<>();
	//ϵͳ�˻���
	class Account{
		private String userName;
		private String password;
		private String type;
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
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Account(String userName,String password,String type){
			this.userName=userName;
			this.password=password;
			this.type=type;
		}
	}
	//ҽԺ������
	class HospitalDepartment{
		private String name;
		private String no;//���
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getNo() {
			return no;
		}

		public void setNo(String no) {
			this.no = no;
		}

		public HospitalDepartment(String name,String no){
			this.name = name;
			this.no = no;
		}
		
	}
	//ҩƷ��
	class Medicine{
		private String name;
		private String shortName;//ƴ������
		private String unit;
		private double price;
		private String no;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getShortName() {
			return shortName;
		}
		public void setShortName(String shortName) {
			this.shortName = shortName;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		
		public String getUnit() {
			return unit;
		}
		public void setUnit(String unit) {
			this.unit = unit;
		}
		
		public String getNo() {
			return no;
		}
		public void setNo(String no) {
			this.no = no;
		}
		public Medicine(String name,String shortName,String unit,double price,String no){
			this.name=name;
			this.shortName=shortName;
			this.unit=unit;
			this.price=price;
			this.no=no;
		}
	}
	//�շ���Ŀ��
	class ChargeItem{
		private String name;
		private String shortName;
		private String unit;
		private double price;
		private String no;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getShortName() {
			return shortName;
		}
		public void setShortName(String shortName) {
			this.shortName = shortName;
		}
		public String getUnit() {
			return unit;
		}
		public void setUnit(String unit) {
			this.unit = unit;
		}
		
		public String getNo() {
			return no;
		}
		public void setNo(String no) {
			this.no = no;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public ChargeItem(String name,String shortName,String unit,double price,String no){
			this.name=name;
			this.shortName=shortName;
			this.price=price;
			this.unit=unit;
			this.no=no;
		}
	}
	//��ʼ�������ļ��������ݽṹ
	public Administor(String userName,String password) throws IOException{
		this.userName=userName;
		this.password=password;
		Scanner in = new Scanner(//�����˺�
				new FileInputStream(".\\data\\account.txt"));
		while(true){
			try{
				String str=in.nextLine();
				String[] strs=str.split("\\s");
				Administor.Account account=new Administor.Account(strs[0],strs[1],strs[2]);
				Administor.accounts.add(account);
			}catch(Exception NoSuchElementException){
				in.close();
				break;
			}
		}
		in = new Scanner(//����ҽԺ����
				new FileInputStream(".\\data\\hospitalDepartment.txt"));
		while(true){
			try{
				String str=in.nextLine();
				String[] strs=str.split("\\s");
				Administor.HospitalDepartment hospitalDepartment=new Administor.HospitalDepartment(strs[0],strs[1]);
				Administor.hospitalDepartments.add(hospitalDepartment);
			}catch(Exception NoSuchElementException){
				in.close();
				break;
			}
		}
		in = new Scanner(//����ҩƷ��Ϣ
				new FileInputStream(".\\data\\medicine.txt"));
		while(true){
			try{
				String str=in.nextLine();
				String[] strs=str.split("\\s");
				double price = Double.parseDouble(strs[3]);
				Administor.Medicine medicine=new Administor.Medicine(strs[0],strs[1],strs[2],price,strs[4]);
				Administor.medicines.add(medicine);
			}catch(Exception NoSuchElementException){
				in.close();
				break;
			}
		}
		in = new Scanner(//�����շ���Ŀ
				new FileInputStream(".\\data\\chargeItem.txt"));
		while(true){
			try{
				String str=in.nextLine();
				String[] strs=str.split("\\s");
				double price = Double.parseDouble(strs[3]);
				Administor.ChargeItem chargeItem=new Administor.ChargeItem(strs[0],strs[1],strs[2],price,strs[4]);
				Administor.chargeItems.add(chargeItem);
			}catch(Exception NoSuchElementException){
				in.close();
				break;
			}
		}
	}
	
	//����˻�
	public void addAccount(String userName,String password,String type){
		Administor.accounts.add(new Account(userName,password,type));
	}
	//��ӿ���
	public void addHospitalDepartment(String name,String no){
		Administor.hospitalDepartments.add(new HospitalDepartment(name,no));
	}
	//���ҩƷ
	public void addMedicine(String name,String shortName,String unit,double price,String no){
		Administor.medicines.add(new Medicine(name,shortName,unit,price,no));
	}
	//����շ���Ŀ
	public void addChargeItem(String name,String shortName,String unit,double price,String no){
		Administor.chargeItems.add(new ChargeItem(name,shortName,unit,price,no));
	}
	//�޸��˻�
	public String alterAccount(String userName,String newPassword,String newType){
		int mark=0;
		for(Account a : Administor.accounts){
			if(a.getUserName().equals(userName)){
				a.setPassword(newPassword);
				a.setType(newType);
				mark=1;
				break;
			}
		}
		if(mark==0) return "�޸��˺ţ�";
		return "�޸ĳɹ���";
	}
	//�޸Ŀ���
	public String alterHospital(String no,String newName){
		int mark=0;
		for(HospitalDepartment a : Administor.hospitalDepartments){
			if(a.getNo().equals(no)){
				a.setName(newName);
				mark=1;
				break;
			}
		}
		if(mark==0) return "�޸ÿ��ң�";
		return "�޸ĳɹ���";
	}
	//�޸�ҩƷ
	public String alterMedicine(String shortName,String newNo,String newUnit,String newPrice){
		int mark=0;
		for(Medicine a : Administor.medicines){
			if(a.getShortName().equals(shortName)){
				a.setNo(newNo);
				a.setUnit(newUnit);
				double price = Double.parseDouble(newPrice);
				a.setPrice(price);
				mark=1;
				break;
			}
		}
		if(mark==0) return "�޸�ҩƷ��";
		return "�޸ĳɹ���";
	}
	//�޸��շ���Ŀ
	public String alterChargeItem(String shortName,String newNo,String newUnit,String newPrice){
		int mark=0;
		for(ChargeItem a : Administor.chargeItems){
			if(a.getShortName().equals(shortName)){
				a.setNo(newNo);
				a.setUnit(newUnit);
				double price = Double.parseDouble(newPrice);
				a.setPrice(price);
				mark=1;
				break;
			}
		}
		if(mark==0) return "�޸���Ŀ��";
		return "�޸ĳɹ���";
	}
	//ɾ���˺�
	public String deleteAccount(String userName){
		int mark=0;
		for(Account a:Administor.accounts){
			if(a.getUserName().equals(userName)){
				accounts.remove(a);
				mark=1;
				break;
			}
		}
		if(mark==0) return "ɾ��ʧ�ܣ�";
		return "ɾ���ɹ���";
	}
	//ɾ������
	public String deleteHospitalDepartment(String name){
		int mark=0;
		for(HospitalDepartment a:Administor.hospitalDepartments){
			if(a.getName().equals(name)){
				hospitalDepartments.remove(a);
				mark=1;
				break;
			}
		}
		if(mark==0) return "ɾ��ʧ�ܣ�";
		return "ɾ���ɹ���";
	}
	//ɾ��ҩƷ
	public String deleteMedicine(String name){
		int mark=0;
		for(Medicine a:Administor.medicines){
			if(a.getName().equals(name)){
				medicines.remove(a);
				mark=1;
				break;
			}
		}
		if(mark==0) return "ɾ��ʧ�ܣ�";
		return "ɾ���ɹ���";
	}
	//ɾ����Ŀ
	public String deleteChargeItem(String name){
		int mark=0;
		for(ChargeItem a:Administor.chargeItems){
			if(a.getName().equals(name)){
				medicines.remove(a);
				mark=1;
				break;
			}
		}
		if(mark==0) return "ɾ��ʧ�ܣ�";
		return "ɾ���ɹ���";
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
