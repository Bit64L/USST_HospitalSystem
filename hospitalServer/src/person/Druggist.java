package person;
import java.io.Serializable;

import staff.*;
public class Druggist implements Serializable{

	private String userName;
	private String password;
	private String name;
	private static final long serialVersionUID = 1L;
	public Druggist(String userName, String password, String name) {
		this.userName=userName;
		this.password=password;
		this.name=name;
		// TODO Auto-generated constructor stub
	}
	public Druggist(String userName, String password) {
		this.userName=userName;
		this.password=password;
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	//显示药品
	public String showMedicine(Patient patient){
		String str="";
		for(Medicine e : patient.getMedicines()){
			str+=e.getName()+" "+e.getNo()+e.getUnit()+e.getPrice();
		}
		return str;
	}
}