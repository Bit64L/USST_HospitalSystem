package registrationGUI;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import data.Data;
import person.*;
import staff.OrderInformation;
import staff.OutPatientRecord;

public class Registration {
	static String ip = Data.IP;// 设置服务器端ip地址
	private Patient patient;
	private OutPatientRecord opr;

	public Patient getPatient() {
		return this.patient;
	}

	public OutPatientRecord getOutPatientRecord() {
		return this.opr;
	}

	// 发送挂号请求
	public OrderInformation sendregister(String patientID) {
		Socket s = null;
		ObjectInputStream inObject = null;
		ObjectOutputStream outObject = null;
		Object patient = null;
		Object orderInformation = null;
		try {
			s = new Socket(ip, 8888);
			outObject = new ObjectOutputStream(s.getOutputStream());
			/* 送到服务器 */
			/* 发送协议号 */
			outObject.writeObject("2000");

			patient = new Patient();
			((Patient) patient).setId(patientID);
			/* 发送挂号ID */
			outObject.writeObject(patient);

			outObject.flush();
			/* 获取服务器结果 */
			inObject = new ObjectInputStream(s.getInputStream());
			orderInformation = inObject.readObject();

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

	// 发送请求:录入未预约病人的挂号信息,在就诊的医生的就诊病人队列加入该病人
	public Patient sendAddDoctorNoAppointmentdPatient(Patient patient) {
		Socket s = null;
		ObjectInputStream inObject = null;
		ObjectOutputStream outObject = null;

		try {
			s = new Socket(ip, 8888);
			outObject = new ObjectOutputStream(s.getOutputStream());
			/* 送到服务器 */
			/* 发送协议号 */
			outObject.writeObject("2002");

			/* 发送 病人 */
			outObject.writeObject(patient);
			outObject.flush();
			/* 获取服务器结果 */
			inObject = new ObjectInputStream(s.getInputStream());
			Patient inPatient = (Patient) inObject.readObject();

			s.close();
			inObject.close();
			outObject.close();
			if (inPatient != null)
				return inPatient;
			else
				return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 发送请求:录入预约病人的挂号信息,在就诊的医生的就诊病人队列加入该病人
	public Patient sendAddDoctorAppointmentdPatient(Patient patient) {
		Socket s = null;
		ObjectInputStream inObject = null;
		ObjectOutputStream outObject = null;

		try {
			s = new Socket(ip, 8888);
			outObject = new ObjectOutputStream(s.getOutputStream());
			/* 送到服务器 */
			/* 发送协议号 */
			outObject.writeObject("2001");

			/* 发送 病人 */
			outObject.writeObject(patient);
			outObject.flush();
			/* 获取服务器结果 */
			inObject = new ObjectInputStream(s.getInputStream());
			Patient inPatient = (Patient) inObject.readObject();

			s.close();
			inObject.close();
			outObject.close();
			if (inPatient != null)
				return inPatient;
			else
				return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 发送请求:获取病人的收费信息
	public Patient sendPatientChargeItem(String patientId) {
		Socket s = null;
		ObjectInputStream inObject = null;
		ObjectOutputStream outObject = null;
		Object patient = null;
		Object inPatient = null;
		try {
			s = new Socket(ip, 8888);
			outObject = new ObjectOutputStream(s.getOutputStream());
			/* 送到服务器 */
			/* 发送协议号 */
			outObject.writeObject("2003");

			patient = new Patient();
			((Patient) patient).setId(patientId);
			/* 发送病人ID */
			outObject.writeObject(patient);

			outObject.flush();
			/* 获取服务器结果 */
			inObject = new ObjectInputStream(s.getInputStream());
			inPatient = inObject.readObject();

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

	// 发送请求:病人支付完成
	public Patient sendPatientPayment(Patient patient) {
		Socket s = null;
		ObjectInputStream inObject = null;
		ObjectOutputStream outObject = null;

		Object inPatient = null;
		// boolean re=false;
		try {
			/* 送到服务器 */
			s = new Socket(ip, 8888);
			outObject = new ObjectOutputStream(s.getOutputStream());

			/* 发送协议号 */
			outObject.writeObject("2004");
			/* 发送病人信息 */
			outObject.writeObject(patient);

			outObject.flush();

			/* 获取服务器结果 */
			inObject = new ObjectInputStream(s.getInputStream());
			inPatient = inObject.readObject();

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

	// 发送请求: 获取科室信息
	public String getHospitalDepartmentInformation() {
		// TODO Auto-generated method stub
		Socket socket = null;
		ObjectInputStream inobj = null;
		ObjectOutputStream outobj = null;
		String hospitalDepartmentNames = null;
		try {
			socket = new Socket(ip, 8888);
			outobj = new ObjectOutputStream(socket.getOutputStream());
			inobj = new ObjectInputStream(socket.getInputStream());

			outobj.writeObject("预约要科室信息");
			outobj.flush();
			try {
				hospitalDepartmentNames = (String) inobj.readObject();
				return hospitalDepartmentNames;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			socket.close();
			outobj.close();
			inobj.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return null;
	}
	// 发送请求:创建病人门诊记录
	// public void createOutPatientRecord(Patient patient,String mounth,String
	// date){
	// OutPatientRecord opr=new
	// OutPatientRecord(patient.getId(),patient.getName(),patient.getAge(),patient.getSex(),patient.getPhoneNumber(),mounth,date);
	// this.patient=patient;
	// this.opr=opr;
	// }
	// 发送请求:判断是否预约
	// public boolean isOrderd(){
	// String ordertime=patient.getOrderedTime();
	// if(ordertime==null)//假设未预约的ordertime为空
	// return false;
	// else
	// return true;
	// }

}
