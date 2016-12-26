package person;
import java.io.Serializable;

import staff.*;
public class President implements Serializable{

	/**
	 * 
	 */
	private String userName;
	private String password;
	private String name;
	private static final long serialVersionUID = 1L;
	public President(String userName, String password, String name) {
		this.userName=userName;
		this.password=password;
		this.name=name;
		// TODO Auto-generated constructor stub
	}
	public President(String userName, String password) {
		this.userName=userName;
		this.password=password;
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
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