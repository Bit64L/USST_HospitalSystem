package person;

import java.io.Serializable;
import java.util.ArrayList;

import staff.*;
public class Patient  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String age;
	private String sex;
	private String phoneNumber;
	private String id;
	private HospitalDepartment hospitalDepartment;
	private String orderTime;
	private Doctor doctor;
	private boolean chargestate=false;//收费状态 是否完成缴费
	private double amount;//缴费总额 不包括挂号费
	private ArrayList<Medicine> medicines=new ArrayList<>();
	private ArrayList<ChargeItem> chargeItems=new ArrayList<>();
/*------------------------------------------------------------------------------*/	
	public Patient(String name,String age,String sex,String phoneNumber,String id){
		this.setName(name);
		this.setAge(age);;
		this.setSex(sex);
		this.setPhoneNumber(phoneNumber);
		this.setId(id);
	}

	
	
	
/*-------------------------------------------------------------*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public HospitalDepartment getHospitalDepartment() {
		return hospitalDepartment;
	}
	public void setHospitalDepartment(HospitalDepartment hospitalDepartment) {
		this.hospitalDepartment = hospitalDepartment;
	}
	public String getOrderedTime() {
		return orderTime;
	}
	public void setOrderedTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public ArrayList<Medicine> getMedicines() {
		return medicines;
	}
	public ArrayList<ChargeItem> getChargeItems() {
		return chargeItems;
	}

	public boolean getChargestate() {
		return chargestate;
	}
	public void setChargestate(boolean chargestate) {
		this.chargestate = chargestate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}


}
