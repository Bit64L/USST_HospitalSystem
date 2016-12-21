package registrationGUI;

import person.*;
import staff.OutPatientRecord;

public class Registration {
	private Patient patient;
	private OutPatientRecord opr;
	
	public Patient getPatient(){
		return this.patient;
	}
	public OutPatientRecord getOutPatientRecord(){
		return this.opr;
	}
	
	
	//创建病人门诊记录
	public void createOutPatientRecord(Patient patient,String mounth,String date){
		OutPatientRecord opr=new OutPatientRecord(patient.getId(),patient.getName(),patient.getAge(),patient.getSex(),patient.getPhoneNumber(),mounth,date);
		this.patient=patient;
		this.opr=opr;
		//将opr存入数据库表中
	}
	//判断是否预约
	public boolean isOrderd(){
		String ordertime=patient.getOrderedTime();
		if(ordertime==null)//假设未预约的ordertime为空
			return false;
		else 
			return true;
	}
	//修改预约记录信息;
	public void alterOrderInfor(){
		
	}
	
}
