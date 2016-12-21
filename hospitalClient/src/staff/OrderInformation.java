package staff;

import java.io.Serializable;

import person.*;

public class OrderInformation  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String patientID;
	private String patientName;
	private String patientAge;
	private String patientSex;
	private String patientPhoneNumber;
	private HospitalDepartment hospitalDepartment;
	private String ordertime;
	
	public OrderInformation(){
		
	}
	public OrderInformation(Patient patient,HospitalDepartment hospitalDepartment,String ordertime){
//			this.setPatientID(patient.getId());
//			this.setPatientName(patient.getName());
//			this.setPatientAge(patient.getAge());
//			this.setPatientSex(patient.getSex());
//			this.setPatientPN(patient.getPhoneNumber());
//			this.setHospitalDepartment(hospitalDepartment);
//			this.setOrdertime(ordertime);
			setOrderInfor(patient,hospitalDepartment,ordertime);
			
	}
	
	public void setOrderInfor(Patient patient,HospitalDepartment hospitalDepartment,String ordertime){
		this.setPatientID(patient.getId());
		this.setPatientName(patient.getName());
		this.setPatientAge(patient.getAge());
		this.setPatientSex(patient.getSex());
		this.setPatientPhoneNumber(patient.getPhoneNumber());
		this.setHospitalDepartment(hospitalDepartment);
		this.setOrdertime(ordertime);
	}
	
	
	
	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientSex() {
		return patientSex;
	}

	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}

	public String getPatientPhoneNumber() {
		return patientPhoneNumber;
	}

	public void setPatientPhoneNumber(String patientPhoneNumber) {
		this.patientPhoneNumber = patientPhoneNumber;
	}


	public HospitalDepartment getHospitalDepartment() {
		return hospitalDepartment;
	}
	public void setHospitalDepartment(HospitalDepartment hospitalDepartment) {
		this.hospitalDepartment = hospitalDepartment;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	
	
}
