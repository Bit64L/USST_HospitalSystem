package person;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static void initial() throws IOException {
		Scanner in = new Scanner(// 导入账号
				new FileInputStream(".\\data\\account.txt"));
		while (true) {
			try {
				String str = in.nextLine();
				String[] strs = str.split("\\s");
				Account account = new Account(strs[0], strs[1], strs[2]);
				Administrator.accounts.add(account);
			} catch (Exception NoSuchElementException) {
				in.close();
				break;
			}
		}
		in = new Scanner(// 导入医院科室
				new FileInputStream(".\\data\\hospitalDepartment.txt"));
		while (true) {
			try {
				String str = in.nextLine();
				String[] strs = str.split("\\s");
				HospitalDepartment hospitalDepartment = new HospitalDepartment(strs[0], strs[1]);
				Administrator.hospitalDepartments.add(hospitalDepartment);
			} catch (Exception NoSuchElementException) {
				in.close();
				break;
			}
		}
		in = new Scanner(// 导入药品信息
				new FileInputStream(".\\data\\medicine.txt"));
		while (true) {
			try {
				String str = in.nextLine();
				String[] strs = str.split("\\s");
				double price = Double.parseDouble(strs[3]);
				Medicine medicine = new Medicine(strs[0], strs[1], strs[2], price, strs[4]);
				Administrator.medicines.add(medicine);
			} catch (Exception NoSuchElementException) {
				in.close();
				break;
			}
		}
		in = new Scanner(// 导入收费项目
				new FileInputStream(".\\data\\chargeItem.txt"));
		while (true) {
			try {
				String str = in.nextLine();
				String[] strs = str.split("\\s");
				double price = Double.parseDouble(strs[3]);
				ChargeItem chargeItem = new ChargeItem(strs[0], strs[1], strs[2], price, strs[4]);
				Administrator.chargeItems.add(chargeItem);
			} catch (Exception NoSuchElementException) {
				in.close();
				break;
			}
		}
		// 从文件读入挂号病人信息
		in = new Scanner(new FileInputStream(".\\data\\registerPatients.txt"));
		String str;
		while (true) {
			try {
				str = in.nextLine();
				String[] strs = str.split("\\s+");
				Charger.registerPatients.add(new Patient(strs[0], strs[1], strs[2], strs[3]));
			} catch (Exception NoSuchElementException) {
				in.close();
				break;
			}
		}
		// 从文件读入预约病人信息
		in = new Scanner(new FileInputStream(".\\data\\orderPatients.txt"));
		while (true) {
			try {
				str = in.nextLine();
				String[] strs = str.split("\\s+");
				Charger.orderPatients.add(new Patient(strs[0], strs[1], strs[2], strs[3]));
			} catch (Exception NoSuchElementException) {
				in.close();
				break;
			}
		}
	}

}
