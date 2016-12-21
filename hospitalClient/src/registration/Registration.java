package registration;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import person.*;
import staff.HospitalDepartment;
import staff.OrderInformation;
import staff.OutPatientRecord;

public class Registration {
	static ArrayList<Patient> registerPatients=new ArrayList<>();//挂号病人
	static ArrayList<Patient> orderPatients = new ArrayList<>();//预约病人
	static ArrayList<OrderInformation> orderInfors=new ArrayList<>();//预约信息
	private Patient patient;
	private OutPatientRecord opr;
	
	public Patient getPatient(){
		return this.patient;
	}
	public OutPatientRecord getOutPatientRecord(){
		return this.opr;
	}
	//挂号
	public void Register(String patientID){
		Socket s=null;
		ObjectInputStream inObject=null;
		ObjectOutputStream outObject=null;
		Object person=null;
		try {
			s=new Socket("127.0.0.1",8888);
			outObject=new ObjectOutputStream(s.getOutputStream());
			/*送到服务器*/
			outObject.writeObject("2000");

			//Patient patient=new Patient();
			outObject.writeObject(person);

			outObject.flush();
			/*获取服务器结果*/
			inObject=new ObjectInputStream(s.getInputStream());
			person=inObject.readObject();	
			
			s.close();
			inObject.close();
			outObject.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//创建病人门诊记录
	public void createOutPatientRecord(Patient patient,String mounth,String date){
		OutPatientRecord opr=new OutPatientRecord(patient.getId(),patient.getName(),patient.getAge(),patient.getSex(),patient.getPhoneNumber(),mounth,date);
		this.patient=patient;
		this.opr=opr;
		//将opr存入数据库表中
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
	//查找预约病人的预约记录
	public OrderInformation searchOrderInfor(Patient patient){
		
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
