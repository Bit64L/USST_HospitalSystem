package person;
import Staff.*;
public class President extends Person{

	public President(String userName, String password, String name, String id) {
		super(userName, password, name, id);
		// TODO Auto-generated constructor stub
	}
	//��ѯ���ҵĹҺ������ܽ��
	public String showDepartment(HospitalDepartment hospitalDepartment){
		String str=hospitalDepartment.getName()+"\n";
		str+="�Һ�����"+hospitalDepartment.getRegisterNum()+"\n";
		str+="�ܽ�"+hospitalDepartment.getMoney()+"\n";
		return str;
	}
	//��ѯҽ���ľ��������ͽ��
	public String showDoctor(Doctor doctor){
		String str=doctor.getName()+"\n";
		str+="�Һ�����"+doctor.getCureNum()+"\n";
		str+="�ܽ�"+doctor.getMoney();
		return str;
	}
	//��ѯҩƷ�����
	public String showDoctor(Medicine medicine){
		String str=medicine.getName()+'\n';
		str+="�������"+medicine.getDeposit()+medicine.getUnit()+'\n';
		return str;
	}

}