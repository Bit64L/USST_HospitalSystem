package person;

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
	//���ҽ���˻�
	public void addDoctor(String userName,String password,String name,String id,HospitalDepartment hospitalDepartment) throws IOException{
		doctors.add(new Doctor(userName,password,name,id,hospitalDepartment));
		//writeAccount("account.txt");
	}
	//��ӹҺ��շ���Ա�˻�
	public void addCharger(String userName,String password,String name,String id) throws IOException{
		chargers.add(new Charger(userName,password,name,id));
		//writeAccount("account.txt");
	}
	//��ӿ���
	public void addHospitalDepartment(String name,String no) throws IOException{
		Administrator.hospitalDepartments.add(new HospitalDepartment(name,no));
		//writeAccount("hospitalDepartment.txt");
	}
	//���ҩƷ
	public void addMedicine(String name,String shortName,String unit,double price,String no,int deposit) throws IOException{
		Administrator.medicines.add(new Medicine(name,shortName,unit,price,no,deposit));
		//writeAccount("medicine.txt");
	}
	//����շ���Ŀ
	public void addChargeItem(String name,String shortName,String unit,double price,String no) throws IOException{
		Administrator.chargeItems.add(new ChargeItem(name,shortName,unit,price,no));
		//writeAccount("chargeItem.txt");
	}
	//�޸��˻�
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
		if(mark==0) return "�޸��˺ţ�";
		return "�޸ĳɹ���";
	}*/
	//�޸Ŀ���
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
		if(mark==0) return "�޸ÿ��ң�";
		return "�޸ĳɹ���";
	}
	//�޸�ҩƷ
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
		if(mark==0) return "�޸�ҩƷ��";
		return "�޸ĳɹ���";
	}
	//�޸��շ���Ŀ
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
		if(mark==0) return "�޸���Ŀ��";
		return "�޸ĳɹ���";
	}
	//ɾ���˺�
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
		if(mark==0) return "ɾ��ʧ�ܣ�";
		return "ɾ���ɹ���";
	}*/
	//ɾ������
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
		if(mark==0) return "ɾ��ʧ�ܣ�";
		return "ɾ���ɹ���";
	}
	//ɾ��ҩƷ
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
		if(mark==0) return "ɾ��ʧ�ܣ�";
		return "ɾ���ɹ���";
	}
	//ɾ����Ŀ
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
		if(mark==0) return "ɾ��ʧ�ܣ�";
		return "ɾ���ɹ���";
	}
	//���ı�Ľ��д���ļ�
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
	private int registerNum;//�Һ���
	private double money;//�����ܽ��
	
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

	
	public int getRegisterNum() {
		return registerNum;
	}

	public void setRegisterNum(int registerNum) {
		this.registerNum = registerNum;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public HospitalDepartment(String name,String no){
		this.name = name;
		this.no = no;
		registerNum=0;
		money=0;
	}
	
}
//ҩƷ��
class Medicine{
	private String name;
	private String shortName;//ƴ������
	private String unit;
	private double price;
	private String no;
	private boolean state=false;//ָʾ�շ�״̬��false��ʾδ�շ�
	private int deposit;//ҩƷ�����
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
	
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public Medicine(String name,String shortName,String unit,double price,String no,int deposit){
		this.name=name;
		this.shortName=shortName;
		this.unit=unit;
		this.price=price;
		this.no=no;
		this.deposit=deposit;
	}
}
//�շ���Ŀ��
class ChargeItem{
	private String name;
	private String shortName;
	private String unit;
	private double price;
	private String no;
	private boolean state=false;//ָʾ�շ�״̬��false��ʾδ�շ�
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
	
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public ChargeItem(String name,String shortName,String unit,double price,String no){
		this.name=name;
		this.shortName=shortName;
		this.price=price;
		this.unit=unit;
		this.no=no;
	}
}