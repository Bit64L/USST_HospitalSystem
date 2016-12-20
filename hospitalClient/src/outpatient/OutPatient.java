package outpatient;

import person.*;
import staff.OutPatientRecord;

public class OutPatient {
	
	public void createOutPatientRecord(Patient patient,String mounth,String date){
		OutPatientRecord opr=new OutPatientRecord(patient.getId(),patient.getName(),patient.getAge(),patient.getSex(),patient.getPhoneNumber(),mounth,date);
		//将opr存入数据库表中
		
		
	}
	
}
