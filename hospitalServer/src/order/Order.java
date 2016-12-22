package order;

import person.Doctor;
import person.Patient;
import staff.HospitalDepartment;
import staff.OrderInformation;

import java.util.ArrayList;

import data.*;

public class Order {
	private ArrayList<OrderInformation> orderInfors=Data.orderInfors;
	private Patient patient;
	private HospitalDepartment hospitalDepartment;
	private String month;
	private String date;
	private String hour;
	
	//预约,并把预约信息写入Data中;
	public void order(Patient patient,HospitalDepartment hospitalDepartment,Doctor doctor,String month,String date,String hour){
		OrderInformation orderInformation=new OrderInformation(patient,hospitalDepartment,doctor,month,date,hour);
		orderInfors.add(orderInformation);
	}
	
	
 	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public HospitalDepartment getHospitalDepartment() {
		return hospitalDepartment;
	}

	public void setHospitalDepartment(HospitalDepartment hospitalDepartment) {
		this.hospitalDepartment = hospitalDepartment;
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
	
}
