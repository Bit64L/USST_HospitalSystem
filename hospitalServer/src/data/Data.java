package data; /**
 * Created by m1580 on 2016/12/18.
 */
import person.*;
import staff.*;

import java.util.ArrayList;

public class Data {
    public static ArrayList<Administrator> administrators=new ArrayList<>();
    public static ArrayList<Doctor> doctors=new ArrayList<>();//登录的医生
    public static ArrayList<Charger> chargers=new ArrayList<>();//登陆的收费人员
    public static ArrayList<Druggist> druggists=new ArrayList<>();//登陆的药师
    public static ArrayList<President> presidents=new ArrayList<>();//登陆的院长
    public static ArrayList<HospitalDepartment> hospitalDepartments = new ArrayList<>();//科室
    public static ArrayList<Medicine> medicines = new ArrayList<>();//药品
    public static ArrayList<ChargeItem> chargeItems = new ArrayList<>();//收费项目
    public static ArrayList<Patient> registerPatients=new ArrayList<>();//挂号病人
    //public static ArrayList<Patient> orderPatients = new ArrayList<>();//预约病人
    public static ArrayList<OrderInformation> orderInfors=new ArrayList<>();//预约信息
    public static ArrayList<OutPatientRecord> outPatientRecord=new ArrayList<>();//门诊记录
    //public static Patient patientSample;
    public static Patient patientSample;
  
    public static void initial(){
        //管理员
        administrators.add(new Administrator("000","000","李玲"));
        //医生
        doctors.add(new Doctor("2004","111","李达",new HospitalDepartment("内科","12")));
        //收费人员
        chargers.add(new Charger("222","222","李二"));
        //药师
        druggists.add(new Druggist("333","333","李三"));
        //院长
        presidents.add(new President("444","444","李五"));
        //科室
        hospitalDepartments.add(new HospitalDepartment("内科","000001 "));
        //药品
        medicines.add(new Medicine("阿莫西林片","amxlp","盒",20,"000001",100));
        //收费项目
        chargeItems.add(new ChargeItem("红细胞计数","hxbjs","次",50,"000001"));
        //病人例子
        patientSample=new Patient("张三三","20","男","12345678900","123456789000000000");
//        patientSample.getMedicines().add(new Medicine("999感冒灵",30,"盒",5));
       // patientSample.getChargeItems().add(new ChargeItem("阿莫西林片",20,"盒",5));
       // patientSample.getChargeItems().add(new ChargeItem("12345",12,"盒",5));
        //patientSample.getChargeItems().add(new ChargeItem("22222",15,"盒",5));
        patientSample.setDoctor(new Doctor("2004","123","马意识",new HospitalDepartment("外科","8")));
        patientSample.setChargestate(true);
        //预约信息
        orderInfors.add(new OrderInformation(patientSample,new HospitalDepartment("内科","12"),new Doctor("2004","123","马意识",new HospitalDepartment("外科","8")),"12","12","14"));
        //预约病人
        registerPatients.add(patientSample);
        //orderPatients.add(patientSample);
    }
    
}
