package precidentGUI;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import utility.DB;

public class MedicinePie {

	public static void main(ResultSet rs) {
		// TODO 自动生成的方法存根
		DB db = new DB();
		//db.select("select * from Doctor") = rs
		 DefaultPieDataset dpd=new DefaultPieDataset(); //建立一个默认的饼图
		// ResultSet rs = db.select("select * from Doctor");
 		while(true){
 				try {
					if(rs.next())
					{
						try {
							dpd.setValue(rs.getString("medicineID"),rs.getInt("deposit"));
						} catch (SQLException e) {
						// TODO 自动生成的 catch 块
					e.printStackTrace();
						}
					}
					else {break;}
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				}
		 	
	        JFreeChart chart=ChartFactory.createPieChart("库存量",dpd,true,true,false); 
	        //可以查具体的API文档,第一个参数是标题，第二个参数是一个数据集，第三个参数表示是否显示Legend，第四个参数表示是否显示提示，第五个参数表示图中是否存在URL
	        
	        ChartFrame chartFrame=new ChartFrame("药品库存量",chart); 
	        //chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
	        chartFrame.pack(); //以合适的大小展现图形
	        chartFrame.setVisible(true);//图形是否可见
	        db.closeAll();
	}

}
