package data; /**
 * Created by m1580 on 2016/12/18.
 */
import person.*;
import staff.*;

import java.util.ArrayList;

public class Data {
    public static ArrayList<Administrator> administrators=new ArrayList<>();
    public static ArrayList<Doctor> doctors=new ArrayList<>();//医生
    public static ArrayList<Charger> chargers=new ArrayList<>();//收费人员
    public static ArrayList<Druggist> druggists=new ArrayList<>();//药师
    public static ArrayList<President> presidents=new ArrayList<>();//院长
    public static ArrayList<HospitalDepartment> hospitalDepartments = new ArrayList<>();//科室
    public static ArrayList<Medicine> medicines = new ArrayList<>();//药品
    public static ArrayList<ChargeItem> chargeItems = new ArrayList<>();//收费项目
    public static ArrayList<Patient> registerPatients=new ArrayList<>();//挂号病人
    public static ArrayList<Patient> orderPatients = new ArrayList<>();//预约病人
    public static ArrayList<OrderInformation> orderInfors=new ArrayList<>();//预约信息
    public static ArrayList<OutPatientRecord> outPatientRecord=new ArrayList<>();//门诊记录
    public static void initial(){
        //管理员
        administrators.add(new Administrator("000","000","李玲"));
        //医生
        doctors.add(new Doctor("111","111","李达","0001",new HospitalDepartment("内科","000001")));
        //收费人员
        chargers.add(new Charger("222","222","李二","0002"));
        //药师
        druggists.add(new Druggist("333","333","李三","0003"));
        //院长
        presidents.add(new President("444","444","李五","0004"));
        //科室
        hospitalDepartments.add(new HospitalDepartment("内科","000001 "));
        //药品
        medicines.add(new Medicine("阿莫西林片","amxlp","盒",20,"000001",100));
        //收费项目
        chargeItems.add(new ChargeItem("红细胞计数","hxbjs","次",50,"000001"));
        //预约信息
        orderInfors.add(new OrderInformation(new Patient("张三三","20","男","12345678900","123456789000000000"),new HospitalDepartment("内科","000001 "),new Doctor("111","111","李达","0001",new HospitalDepartment("内科","000001")),"12","12","14"));
        //预约病人
        orderPatients.add(new Patient("张三三","20","男","12345678900","123456789000000000"));
    }
    
}
