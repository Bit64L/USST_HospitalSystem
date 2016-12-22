package registration;

import java.util.ArrayList;

import data.Data;
import order.Order;
import person.Doctor;
import person.Patient;
import staff.HospitalDepartment;
import staff.OrderInformation;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Patient patient=new Patient("张三三","20","男","12345678900","123456789000000000");
		HospitalDepartment hospitalDepartment=new HospitalDepartment("牙科", "233");
		String month="12";
		String date="13";
		String hour="14";
		Doctor doctor=new Doctor();
		Order order=new Order();
		ArrayList<OrderInformation> orderInfors=Data.orderInfors;
		//OrderInformation orderInfor=new OrderInformation();
		order.order(patient, hospitalDepartment, doctor,month, date, hour);
		for(OrderInformation orderInfor : orderInfors){
			orderInfor.showInfor();
		}
		
	}

}
