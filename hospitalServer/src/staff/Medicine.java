package staff;

import java.io.Serializable;

/**
 * Created by m1580 on 2016/12/18.
 */
//药品类
public class Medicine implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private String shortName;//拼音简码
    private String unit;
    private double price;
    private String no;//主键
    
    private int number;//医生开药的数量
    private double amount=0;//总金额，自定义了get方法
    
    private int deposit;//药品库存量
    
    public double getAmount() {
    	amount=price*number;
		return amount;
	}
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getShortName() {
        return shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }

    public int getDeposit() {
        return deposit;
    }
    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }
    
    public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	//添加药品时的构造方法
    public Medicine(String name,String shortName,String unit,double price,String no,int deposit){
        this.name=name;
        this.shortName=shortName;
        this.unit=unit;
        this.price=price;
        this.no=no;
        this.deposit=deposit;
    }
    //病人处方单中的药品
    public Medicine(String name,String shortName,String unit,double price,String no){
        this.name=name;
        this.shortName=shortName;
        this.unit=unit;
        this.price=price;
        this.no=no;
    }
}