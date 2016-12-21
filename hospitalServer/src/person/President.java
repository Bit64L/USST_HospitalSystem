package person;
import staff.*;
public class President extends Person{

	public President(String userName, String password, String name, String id) {
		super(userName, password, name, id);
		// TODO Auto-generated constructor stub
	}
	//查询科室的挂号量和总金额
	public String showDepartment(HospitalDepartment hospitalDepartment){
		String str=hospitalDepartment.getName()+"\n";
		str+="挂号量："+hospitalDepartment.getRegisterNum()+"\n";
		str+="总金额："+hospitalDepartment.getMoney()+"\n";
		return str;
	}
	//查询医生的就诊数量和金额
	public String showDoctor(Doctor doctor){
		String str=doctor.getName()+"\n";
		str+="挂号量："+doctor.getCureNum()+"\n";
		str+="总金额："+doctor.getMoney();
		return str;
	}
	//查询药品库存量
	public String showDoctor(Medicine medicine){
		String str=medicine.getName()+'\n';
		str+="库存量："+medicine.getDeposit()+medicine.getUnit()+'\n';
		return str;
	}

}