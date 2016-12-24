package registration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import data.*;
import person.*;
import staff.HospitalDepartment;
import staff.OrderInformation;
import staff.OutPatientRecord;
import utility.DB;

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
	
	
	//录入挂号信息,在就诊的医生的就诊病人队列加入该病人
	public Doctor addDoctorPatient(Doctor doctor, Patient patient){
		doctor.getPatients().add(patient);
		Data.registerPatients.add(patient);
		return doctor;
		
	}
	
	//录入未预约病人的挂号信息,在就诊的医生的就诊病人队列加入该病人
	public Patient addDoctorNoAppointmentPatient(Patient patient){
		String sqlstr="SELECT hospitalDepartmentID FROM HospitalDepartment WHERE hospitalDepartmentName='"+patient.getHospitalDepartment().getNo()+"';";           
		DB db=new DB();
		ResultSet rs=db.select(sqlstr);
		String hospitalDepartmentNo=null;
		try {
			if(rs.next())	
				hospitalDepartmentNo=""+rs.getInt("hospitalDepartmentID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String hospitalDepartmentNo="0";//根据病人中的科室名字,获取科室id
		//根据科室id,获取当前科室就诊病人最少的医生
		Doctor doctor=null;//Data.doctors.get(0);//Doctor 
		doctor=this.getLeastPatientDoctor(hospitalDepartmentNo);
		
		patient.setDoctor(doctor);
		doctor.getPatients().add(patient);
		Data.registerPatients.add(patient);
		return patient;
	}
	
	//录入预约病人的挂号信息,在就诊的医生的就诊病人队列加入该病人
	public Patient addDoctorAppointmentPatient(Patient patient) {
		String sqlstr="SELECT hospitalDepartmentID FROM HospitalDepartment WHERE hospitalDepartmentName='"+patient.getHospitalDepartment().getName()+"';";           
		DB db=new DB();
		ResultSet rs=db.select(sqlstr);
		String hospitalDepartmentNo=null;
		try {
			if(rs.next())
				hospitalDepartmentNo=""+rs.getInt("hospitalDepartmentID");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String hospitalDepartmentNo="0";//根据病人中的科室名字,获取科室id
		//根据科室id,获取当前科室就诊病人最少的医生
		Doctor doctor=null;//Data.doctors.get(0);//Doctor 
		doctor=this.getLeastPatientDoctor(hospitalDepartmentNo);
		
		patient.setDoctor(doctor);
		doctor.getPatients().add(patient);
		Data.registerPatients.add(patient);
		return patient;
	}
	
	//根据科室ID,获取就诊病人数最少的医生
	public Doctor getLeastPatientDoctor(String hospitalDepartmentNo){
		Doctor minDoctor=null;
		int Min=500;
		for(Doctor d:Data.doctors){
			if(d.getHospitalDepartment().getNo().equals(hospitalDepartmentNo)){
				if(d.getPatients().size()<Min){
					minDoctor=d;
					Min=d.getPatients().size();
				}
				
			}
			
		}
		return minDoctor;
	}
	
	//根据病人ID获取病人的收费信息
	public Patient getPatientChargeItem(String patientId){
		for(Patient p : Data.registerPatients){
			if(p.getId().equals(patientId))
				return p;
		}
		return null;
	}
	
	
	//创建病人门诊记录
	public void createOutPatientRecord(Patient patient,String month,String date){
		OutPatientRecord opr=new OutPatientRecord(patient.getId(),patient.getName(),patient.getAge(),patient.getSex(),patient.getPhoneNumber(),month,date);
		outPatientRecord.add(opr);
		
	}
	//判断是否预约
	public boolean isOrdered(Patient patient){
		for(Patient p : orderPatients){
			if(patient.getId().equals(p.getId()))
				return true;
		}
		return false;
	}
	//显示预约病人的预约记录
	public OrderInformation showOrderInfor(Patient patinet){
		OrderInformation oi=null;
		for(OrderInformation p : orderInfors){
			if(patient.getId().equals(p.getPatientID()))
				oi=p;
				orderInfors.remove(p);
				return oi;
		}
		return null;
		
		
	}
	//查找预约病人的预约信息
	public OrderInformation searchOrderInfor(Patient patient){		
		OrderInformation oi=null;
		for(OrderInformation p : orderInfors){
			if(patient.getId().equals(p.getPatientID()))
				oi=p;
				orderInfors.remove(p);
				return oi;
		}
		return null;	
	}
	//修改预约记录信息;
	public void alterOrderInfor(OrderInformation orderInfor,Patient patient,HospitalDepartment hospitalDepartment,Doctor doctor,String ordertime){
		orderInfor.setOrderInfor(patient, hospitalDepartment,doctor, ordertime);
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
