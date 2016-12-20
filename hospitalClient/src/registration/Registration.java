package registration;

import java.sql.ResultSet;

import person.*;
import staff.OutPatientRecord;
import utility.jdbc;

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
		//获取病人预约信息,再做修改
	}
	//录入病人基本信息,选择科室
	public void addPatientInfo(){
		//patient;
	}
	//自动选择该科室医生响度空闲的医生
	public void autoAddSequenceDoctro(){
		String ID;//sql语句查询该科室医生排队人数最少的医生id;
		//在相对ID医生下的排队序列添加到末尾
	}
	//显示挂号收费信息
	public void showCharge(){
		jdbc db=new jdbc();
		String sqlStr=null;
		ResultSet rs=db.select(sqlStr);
	}
	
	
}
