package person;

import java.io.Serializable;
import java.util.ArrayList;
import data.Data;
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
	/*--------------------------------------------------------------------*/
	public Patient(){

	}
	public Patient(String name,String age,String sex,String phoneNumber,String id){
		this.setName(name);;
		this.setAge(age);;
		this.setSex(sex);
		this.setPhoneNumber(phoneNumber);
		this.setId(id);
	}
	//病人预约
	public	OrderInformation order(HospitalDepartment hospitalDepartment,Doctor doctor,String ordertime){

		OrderInformation orderInfor=new OrderInformation(this,hospitalDepartment,doctor,ordertime);
		/**向预约表中添加预约信息**/;
		return orderInfor;
	}
	//加入病人挂号信息
	public void insertPatientInformation(String name,String sex,String age,String phoneNumber,String id,String ordertime){
		this.setName(name);
		this.setAge(age);
		this.setSex(sex);
		this.setPhoneNumber(phoneNumber);
		this.setOrderTime(ordertime);
		this.setId(id);
		
		
		
	}
	/*--------------------------------------------------------------------*/
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
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
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