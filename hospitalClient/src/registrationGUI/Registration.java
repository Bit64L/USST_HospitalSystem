package registrationGUI;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import person.*;
import staff.OrderInformation;
import staff.OutPatientRecord;

public class Registration {
	static String ip="124.76.5.175";//设置服务器端ip地址
	private Patient patient;
	private OutPatientRecord opr;
	
	public Patient getPatient(){
		return this.patient;
	}
	public OutPatientRecord getOutPatientRecord(){
		return this.opr;
	}
	//发送挂号请求
	public OrderInformation sendregister(String patientID){
		Socket s=null;
		ObjectInputStream inObject=null;
		ObjectOutputStream outObject=null;
		Object patient=null;
		Object orderInformation=null;
		try {
			s=new Socket(ip,8888);
			outObject=new ObjectOutputStream(s.getOutputStream());
			/*送到服务器*/
			/*发送协议号*/
			outObject.writeObject("2000");

			patient=new Patient();
			((Patient) patient).setId(patientID);
			/*发送挂号ID*/
			outObject.writeObject(patient);

			outObject.flush();
			/*获取服务器结果*/
			inObject=new ObjectInputStream(s.getInputStream());
			orderInformation=inObject.readObject();	
			
			s.close();
			inObject.close();
			outObject.close();
			return (OrderInformation) orderInformation;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		
	}
	//发送请求:录入预约病人的挂号信息,在就诊的医生的就诊病人队列加入该病人
	public boolean sendAddDoctorPatient(Doctor doctor, Patient patient){
		Socket s=null;
		ObjectInputStream inObject=null;
		ObjectOutputStream outObject=null;
		Object doc=null;
		try {
			s=new Socket(ip,8888);
			outObject=new ObjectOutputStream(s.getOutputStream());
			/*送到服务器*/
			/*发送协议号*/
			outObject.writeObject("2001");

			doc=doctor;
			((Doctor) doc).setAddpatient(patient);

			/*发送医生 病人*/
			outObject.writeObject(doctor);
			outObject.flush();
			/*获取服务器结果*/
			inObject=new ObjectInputStream(s.getInputStream());
			Doctor inDoctor=(Doctor) inObject.readObject();
			
			s.close();
			inObject.close();
			outObject.close();
			if(inDoctor!=null)
				return true;
			else 
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//发送请求:录入未预约病人的挂号信息,在就诊的医生的就诊病人队列加入该病人
	public Patient sendAddDoctorNoAppointmentdPatient(Patient patient){
		Socket s=null;
		ObjectInputStream inObject=null;
		ObjectOutputStream outObject=null;
		
		try {
			s=new Socket(ip,8888);
			outObject=new ObjectOutputStream(s.getOutputStream());
			/*送到服务器*/
			/*发送协议号*/
			outObject.writeObject("2002");

			/*发送 病人*/
			outObject.writeObject(patient);
			outObject.flush();
			/*获取服务器结果*/
			inObject=new ObjectInputStream(s.getInputStream());
			Patient inPatient=(Patient) inObject.readObject();
			
			s.close();
			inObject.close();
			outObject.close();
			if(inPatient!=null)
				return inPatient;
			else 
				return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//发送请求:获取病人的收费信息
	public Patient sendPatientChargeItem(String patientId){
		Socket s=null;
		ObjectInputStream inObject=null;
		ObjectOutputStream outObject=null;
		Object patient=null;
		Object inPatient=null;
		try {
			s=new Socket(ip,8888);
			outObject=new ObjectOutputStream(s.getOutputStream());
			/*送到服务器*/
			/*发送协议号*/
			outObject.writeObject("2003");

			patient=new Patient();
			((Patient) patient).setId(patientId);
			/*发送病人ID*/
			outObject.writeObject(patient);

			outObject.flush();
			/*获取服务器结果*/
			inObject=new ObjectInputStream(s.getInputStream());
			inPatient=inObject.readObject();	
			
			s.close();
			inObject.close();
			outObject.close();
			return (Patient) inPatient;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//发送请求:修改预约记录信息;
	public void sendAlterOrderInformation(){
		
	}
	//发送请求:录入未预约病人挂号信息;
	public void sendInsertRegister(){
		;
	}
	//发送请求:创建病人门诊记录
//	public void createOutPatientRecord(Patient patient,String mounth,String date){
//		OutPatientRecord opr=new OutPatientRecord(patient.getId(),patient.getName(),patient.getAge(),patient.getSex(),patient.getPhoneNumber(),mounth,date);
//		this.patient=patient;
//		this.opr=opr;		
//	}
	//发送请求:判断是否预约
//	public boolean isOrderd(){
//		String ordertime=patient.getOrderedTime();
//		if(ordertime==null)//假设未预约的ordertime为空
//			return false;
//		else 
//			return true;
//	}

	
}
