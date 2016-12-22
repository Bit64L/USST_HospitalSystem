package registrationGUI;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import person.*;
import staff.OrderInformation;
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
	//发送挂号请求
	public OrderInformation sendregister(String patientID){
		Socket s=null;
		ObjectInputStream inObject=null;
		ObjectOutputStream outObject=null;
		Object patient=null;
		Object orderInformation=null;
		try {
			s=new Socket("127.0.0.1",8888);
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
