package person;

import java.io.Serializable;
import java.util.*;
import staff.*;
public class Doctor implements Serializable{
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private Patient addpatient;
	private ArrayList<Patient> patients=new ArrayList<>();//未开处方的病人
	private ArrayList<Patient> patientsFinish=new ArrayList<>();//已经开处方的病人
	private HospitalDepartment hospitalDepartment;
	private int cureNum;//医生就诊数量
	private double money;//医生总金额
	private String userName;
	private String password;
	private String name;
	public Doctor(String userName, String password, String name,HospitalDepartment hospitalDepartment) {
		this.userName=userName;
		this.password=password;
		this.name=name;
		this.hospitalDepartment=hospitalDepartment;
		// TODO Auto-generated constructor stub
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
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

	public ArrayList<Patient> getPatients() {
		return patients;
	}


	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}


	public HospitalDepartment getHospitalDepartment() {
		return hospitalDepartment;
	}


	public void setHospitalDepartment(HospitalDepartment hospitalDepartment) {
		this.hospitalDepartment = hospitalDepartment;
	}


	public int getCureNum() {
		return cureNum;
	}


	public void setCureNum(int cureNum) {
		this.cureNum = cureNum;
	}


	public double getMoney() {
		return money;
	}


	public void setMoney(double money) {
		this.money = money;
	}
	
	public Doctor(){

	}
	//开处方
	public void prescribe(Patient patient,ArrayList<ChargeItem> chargeItems,ArrayList<Medicine> medicines){
		for(int i=0;i<chargeItems.size();i++){
			patient.getChargeItems().add(chargeItems.get(i));
			setMoney(getMoney()+patient.getChargeItems().get(i).getPrice());
			getHospitalDepartment().setMoney(getHospitalDepartment().getMoney()+patient.getChargeItems().get(i).getPrice());
		}
		chargeItems=null;
		for(int i=0;i<medicines.size();i++){
			patient.getMedicines().add(medicines.get(i));
			setMoney(getMoney()+patient.getMedicines().get(i).getPrice());
			getHospitalDepartment().setMoney(getHospitalDepartment().getMoney()+patient.getMedicines().get(i).getPrice());
		}
		medicines=null;
	}
	//显示收费项目
	public String showChargeItem(Patient patient){
		String ans="";
		for(int i=0;i<patient.getChargeItems().size();i++){
			ans+=patient.getChargeItems().get(i).getName()
					+"\t"+patient.getChargeItems().get(i).getUnit()
					+"\t"+patient.getChargeItems().get(i).getPrice();
		}
		return ans;
	}
	//显示药品
	public String showMedicine(Patient patient){
		String ans="";
		for(int i=0;i<patient.getMedicines().size();i++){
			ans+=patient.getMedicines().get(i).getName()
					+"\t"+patient.getMedicines().get(i).getUnit()
					+"\t"+patient.getMedicines().get(i).getPrice();
		}
		return ans;
	}

	public Patient getAddpatient() {
		return addpatient;
	}

	public void setAddpatient(Patient addpatient) {
		this.addpatient = addpatient;
	}

	public ArrayList<Patient> getPatientsFinish() {
		return patientsFinish;
	}

	public void setPatientsFinish(ArrayList<Patient> patientsFinish) {
		this.patientsFinish = patientsFinish;
	}
	
}
