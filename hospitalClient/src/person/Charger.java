package person;

import java.io.Serializable;
import java.util.ArrayList;

import staff.*;
public class Charger implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String name;
	static ArrayList<Patient> registerPatients=new ArrayList<>();//挂号病人
	static ArrayList<Patient> orderPatients = new ArrayList<>();//预约病人
	public Charger(String userName,String password){
		this.userName=userName;
		this.password=password;
		
	}
	public Charger(String userName,String password,String name){
		this.userName=userName;
		this.password=password;
		this.name=name;
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

	public static ArrayList<Patient> getRegisterPatients() {
		return registerPatients;
	}

	public static void setRegisterPatients(ArrayList<Patient> registerPatients) {
		Charger.registerPatients = registerPatients;
	}

	public static ArrayList<Patient> getOrderPatients() {
		return orderPatients;
	}

	public static void setOrderPatients(ArrayList<Patient> orderPatients) {
		Charger.orderPatients = orderPatients;
	}

	//未预约病人挂号
	public void createRegister(Patient patient,Doctor doctor,HospitalDepartment hospitalDepartment){
		patient.setDoctor(doctor);
		patient.setHospitalDepartment(hospitalDepartment);
		hospitalDepartment.setRegisterNum(hospitalDepartment.getRegisterNum()+1);
		doctor.setCureNum(doctor.getCureNum()+1);
		/**将信息写回文件**/
	}
	//查询是否为已预约病人
	public boolean findInOder(Patient patient){
		for(Patient p : orderPatients){
			if(patient.getId().equals(p.getId()))
				return true;
		}
		return false;
	}
	//收费
//	public String charge(Patient patient){
//		double sum=0;
//		for(int i=0;i<patient.getChargeItems().size();i++){
//			sum+=patient.getChargeItems().get(i).getPrice();
//			patient.getChargeItems().get(i).setState(true);
//		}
//		for(int i=0;i<patient.getMedicines().size();i++){
//			sum+=patient.getMedicines().get(i).getPrice();
//			patient.getMedicines().get(i).setState(true);
//		}
//		return "共收费"+sum+"元";
//	}
	
	
}