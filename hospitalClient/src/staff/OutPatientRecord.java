package staff;

import java.io.Serializable;

public class OutPatientRecord  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
    private String name;
    private String age;
    private String sex;
    private String phonenumber;
    private String month;
    private String date;
    //无参构造函数
    public  OutPatientRecord(){
    	
    }
    //带参构造函数
    public OutPatientRecord(String id,String name,String age,String sex,String phonenumber,String month,String date){
    	this.id=id;
    	this.name=name;
    	this.age=age;
    	this.sex=sex;
    	this.phonenumber=phonenumber;
    	this.month=month;
    	this.date=date;
    }
    public void setId(String id){
    	this.id=id; 
    }
    public String getId(){
    	return this.id;
    }
    public void setName(String name){
    	this.name=name; 
    }
    public String getName(){
    	return this.name;
    }
    public void setAge(String age){
    	this.age=age;
    }
    public String getAge(){
    	return this.age;
    }
    public void setSex(String sex){
    	this.sex=sex;
    }
    public String getSex(){
    	return this.sex;
    }
    public void setPhonenumber(String phonenumber){
    	this.phonenumber=phonenumber;
    }
    public String getPhonenumber(){
    	return this.phonenumber;
    }
    public void setMonth(String month){
    	this.month=month;
    }
    public String getMonth(){
    	return this.month;
    }
    public void setDate(String date){
    	this.date=date;
    }
    public String getDate(){
    	return this.date;
    }
    
    
}
