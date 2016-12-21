package registration;

import java.util.ArrayList;
import data.*;
import person.*;
import staff.HospitalDepartment;
import staff.OrderInformation;
import staff.OutPatientRecord;

public class Registration {
	//Data data=new Data();
	private ArrayList<Patient> registerPatients=Data.registerPatients;//挂号病人
	private ArrayList<Patient> orderPatients = Data.orderPatients;//预约病人
	private ArrayList<OrderInformation> orderInfors=Data.orderInfors;//预约信息
	private ArrayList<OutPatientRecord> outPatientRecord=Data.outPatientRecord;//门诊记录
	private Patient patient;
	private HospitalDepartment hospitalDepartment;
	private OutPatientRecord opr;
	
	public Patient getPatient(){
		return this.patient;
	}
	public OutPatientRecord getOutPatientRecord(){
		return this.opr;
	}
	
	
	//创建病人门诊记录
	public void createOutPatientRecord(Patient patient,String month,String date){
		OutPatientRecord opr=new OutPatientRecord(patient.getId(),patient.getName(),patient.getAge(),patient.getSex(),patient.getPhoneNumber(),month,date);
		outPatientRecord.add(opr);
		
	}
	//判断是否预约
	public boolean isOrderd(Patient patient){
		for(Patient p : orderPatients){
			if(patient.getId().equals(p.getId()))
				return true;
		}
		return false;
	}
	//显示预约病人的预约记录
	public OrderInformation showOrderInfor(Patient patinet){
		
		for(OrderInformation p : orderInfors){
			if(patient.getId().equals(p.getPatientID()))
				return p;
		}
		return null;
		
		
	}
	//修改预约记录信息;
	public void alterOrderInfor(OrderInformation orderInfor,Patient patient,HospitalDepartment hospitalDepartment,String ordertime){
		orderInfor.setOrderInfor(patient, hospitalDepartment, ordertime);
	}
	//未预约病人挂号
	public void createRegister(Patient patient,HospitalDepartment hospitalDepartment){
		Doctor doctor=new Doctor();//按照部门自动搜索当前排队人数最少的医生
		patient.setDoctor(doctor);
		patient.setHospitalDepartment(hospitalDepartment);
		hospitalDepartment.setRegisterNum(hospitalDepartment.getRegisterNum()+1);
		doctor.setCureNum(doctor.getCureNum()+1);
		/**将信息写回文件**/
	}
	//病人预约
	public void patientOrder(Patient patinet,HospitalDepartment hospitalDepartment,String ordertime){
		
	}
}
