package person;

public class Druggist extends Person{

	public Druggist(String userName,String password,String name,String id){
		super(userName,password, name, id);
	}
	//��ʾ���˹���ҩƷ
	public String showMedicine(Patient patient){
		String str="";
		for(Medicine e : patient.getMedicines()){
			str+=e.getName()+" "+e.getNo()+e.getUnit()+e.getPrice();
		}
		return str;
	}
}
