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
	private Doctor doctor;
	/*----------------------------------------------------------------------*/
	public OrderInformation(){

	}
	public OrderInformation(Patient patient,HospitalDepartment hospitalDepartment,Doctor doctor,String ordertime){
//			this.setPatientID(patient.getId());
//			this.setPatientName(patient.getName());
//			this.setPatientAge(patient.getAge());
//			this.setPatientSex(patient.getSex());
//			this.setPatientPN(patient.getPhoneNumber());
//			this.setHospitalDepartment(hospitalDepartment);
//			this.setOrdertime(ordertime);
		setOrderInfor(patient,hospitalDepartment,doctor,ordertime);

	}
	public OrderInformation(Patient patient,HospitalDepartment hospitalDepartment,Doctor doctor,String month,String date,String hour){
//		this.setPatientID(patient.getId());
//		this.setPatientName(patient.getName());
//		this.setPatientAge(patient.getAge());
//		this.setPatientSex(patient.getSex());
//		this.setPatientPN(patient.getPhoneNumber());
//		this.setHospitalDepartment(hospitalDepartment);
//		this.setOrdertime(ordertime);
		setOrderInfor(patient,hospitalDepartment,doctor,month,date,hour);

	}
	public void setOrderInfor(Patient patient,HospitalDepartment hospitalDepartment,Doctor doctor,String ordertime){
		this.setPatient(patient);
		this.setPatientID(patient.getId());
		this.setPatientName(patient.getName());
		this.setPatientAge(patient.getAge());
		this.setPatientSex(patient.getSex());
		this.setPatientPhoneNumber(patient.getPhoneNumber());
		this.setHospitalDepartment(hospitalDepartment);
		this.setDoctor(doctor);
		this.setOrdertime(ordertime);
	}

	public void setOrderInfor(Patient patient,HospitalDepartment hospitalDepartment,Doctor doctor,String month,String date,String hour){
		this.setPatient(patient);
		this.setPatientID(patient.getId());
		this.setPatientName(patient.getName());
		this.setPatientAge(patient.getAge());
		this.setPatientSex(patient.getSex());
		this.setPatientPhoneNumber(patient.getPhoneNumber());
		this.setHospitalDepartment(hospitalDepartment);
		this.setDoctor(doctor);
		this.setMonth(month);
		this.setDate(date);
		this.setHour(hour);

	}

/*----------------------------------------------------------------------*/

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
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}


}