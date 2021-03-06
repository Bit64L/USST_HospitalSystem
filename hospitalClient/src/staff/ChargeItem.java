package staff;

import java.io.Serializable;

/**
 * Created by m1580 on 2016/12/18.
 */
//收费项目类
public class ChargeItem  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;//药品名
    private String shortName;
    private String unit;//计量单位
    private double price;
    private String no;//id主键
    
    private int number;//医生开的数量
    private double amount=0;//总金额,自定义实现了get方法
    
    
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public boolean isState() {
//        return state;
//    }
//
//    public void setState(boolean state) {
//        this.state = state;
//    }

    public ChargeItem(String name, String shortName, String unit, double price, String no) {
        this.name = name;
        this.shortName = shortName;
        this.price = price;
        this.unit = unit;
        this.no = no;
    }

	public ChargeItem(String name, double price, String unit, int number) {
		// TODO Auto-generated constructor stub
		this.setName(name);
		this.setPrice(price);
		this.setUnit(unit);
		this.setNumber(number);
		
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getAmount() {
		this.amount=price*number;
		return amount;
	}
}