package person;

import java.util.ArrayList;

public class Charger extends Person{
	static ArrayList<Patient> registerPatients=new ArrayList<>();//�ҺŲ���
	static ArrayList<Patient> orderPatients = new ArrayList<>();//ԤԼ����
	public Charger(String userName,String password,String name,String id){
		super(userName,password,name,id);
	}
	//δԤԼ���˹Һ�
	public String createRegister(Patient patient,Doctor doctor,HospitalDepartment hospitalDepartment){
		patient.setDoctor(doctor);
		patient.setHospitalDepartment(hospitalDepartment);
		/**����Ϣд���ļ�**/
	}
	//��ѯ�Ƿ�Ϊ��ԤԼ����
	public boolean findInOder(Patient patient){
		for(Patient p : orderPatients){
			if(patient.getId().equals(p.getId()))
				return true;
		}
		return false;
	}
	
	
}
