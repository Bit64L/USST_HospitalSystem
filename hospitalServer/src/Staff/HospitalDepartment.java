package Staff;

/**
 * Created by m1580 on 2016/12/18.
 */
//医院科室类
public class HospitalDepartment{
    private String name;
    private String no;//编号
    private int registerNum;//挂号量
    private double money;//科室总金额

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }


    public int getRegisterNum() {
        return registerNum;
    }

    public void setRegisterNum(int registerNum) {
        this.registerNum = registerNum;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public HospitalDepartment(String name,String no){
        this.name = name;
        this.no = no;
        registerNum=0;
        money=0;
    }

}