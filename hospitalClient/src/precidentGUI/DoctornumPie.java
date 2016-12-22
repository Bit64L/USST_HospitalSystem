package precidentGUI;

import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

import utility.DB;

import java.sql.*;

public class DoctornumPie {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Connection con = null;
		
		String sql = "select *from Doctor";
		ResultSet rs = null;
		Statement st = null;
		try {
			rs=st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		DB db = new DB();
		db.select("Select name From Doctor");
		
		
		 DefaultPieDataset dpd=new DefaultPieDataset(); //建立一个默认的饼图
		 	for(int i=0;i<100;i++)
		 	{
		 		
		 		try {
					while(db.select("select name from Doctor").next()&&db.select("select cureNum from Doctor").next())
					{
						try {
							dpd.setValue(db.select("select name from Doctor").getString("name"), dpd.getValue(db.select("select cureNum from Doctor").getInt("cureNum")));
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		 	}
		 	
//	        dpd.setValue("管理人员", 25);  //输入数据
//	        dpd.setValue("市场人员", 25);
//	        dpd.setValue("开发人员", 45);
//	        dpd.setValue("其他人员", 10);
	        JFreeChart chart=ChartFactory.createPieChart("就诊数量",dpd,true,true,false); 
	        //可以查具体的API文档,第一个参数是标题，第二个参数是一个数据集，第三个参数表示是否显示Legend，第四个参数表示是否显示提示，第五个参数表示图中是否存在URL
	        
	        ChartFrame chartFrame=new ChartFrame("医生就诊数量",chart); 
	        //chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
	        chartFrame.pack(); //以合适的大小展现图形
	        chartFrame.setVisible(true);//图形是否可见
	}

}
