package staff;

import person.Patient;

public class OrderInformation {
	private String patientID;
	private String patientName;
	private String patientAge;
	private String patientSex;
	private String patientPN;
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
		this.setPatientPN(patient.getPhoneNumber());
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

	public String getPatientPN() {
		return patientPN;
	}

	public void setPatientPN(String patientPN) {
		this.patientPN = patientPN;
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
