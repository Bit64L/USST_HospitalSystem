package staff;

import java.io.Serializable;

import person.*;

public class OrderInformation  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Patient patient;
	private String patientID;
	private String patientName;
	private String patientAge;
	private String patientSex;
	private String patientPhoneNumber;
	private HospitalDepartment hospitalDepartment;
	private String ordertime;
	private String month;
	private String date;
	private String hour;
/*---------------------------------------------------------------------------*/
	public OrderInformation(){
		
	}
	public OrderInformation(Patient patient,HospitalDepartment hospitalDepartment,String ordertime){
//			this.setPatientID(patient.getId());
//			this.setPatientName(patient.getName());
//			this.setPatientAge(patient.getAge());
//			this.setPatientSex(patient.getSex());
//			this.setPatientPhoneNumber(patient.getPhoneNumber());
//			this.setHospitalDepartment(hospitalDepartment);
//			this.setOrdertime(ordertime);
			setOrderInfor(patient,hospitalDepartment,ordertime);
			
	}
	public OrderInformation(Patient patient,HospitalDepartment hospitalDepartment,String month,String date,String hour){

		setOrderInfor(patient,hospitalDepartment,month,date,hour);
		
}
	
	public void setOrderInfor(Patient patient,HospitalDepartment hospitalDepartment,String ordertime){
		this.setPatient(patient);
		this.setPatientID(patient.getId());
		this.setPatientName(patient.getName());
		this.setPatientAge(patient.getAge());
		this.setPatientSex(patient.getSex());
		this.setPatientPhoneNumber(patient.getPhoneNumber());
		this.setHospitalDepartment(hospitalDepartment);
		this.setOrdertime(ordertime);
	}
	public void setOrderInfor(Patient patient,HospitalDepartment hospitalDepartment,String month,String date,String hour){
		this.setPatient(patient);
		this.setPatientID(patient.getId());
		this.setPatientName(patient.getName());
		this.setPatientAge(patient.getAge());
		this.setPatientSex(patient.getSex());
		this.setPatientPhoneNumber(patient.getPhoneNumber());
		this.setHospitalDepartment(hospitalDepartment);
		//this.setOrdertime(ordertime);
		this.setMonth(month);
		this.setDate(date);
		this.setHour(hour);
	}
	public void showInfor(){
		System.out.println("预约信息:");
		patient.showInfor();
		System.out.println("预约科室:"+this.getHospitalDepartment().getName()+" 时间:"+this.getMonth()+this.getDate()+this.getHour());;
	}
/*---------------------------------------------------------------------------*/

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
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getPatientPhoneNumber() {
		return patientPhoneNumber;
	}
	public void setPatientPhoneNumber(String patientPhoneNumber) {
		this.patientPhoneNumber = patientPhoneNumber;
	}
	
	
}