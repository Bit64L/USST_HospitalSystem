package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	
	public String getCurrentTime(){ //获取当前时间
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String currentTime=sdf.format(date);
		return currentTime;
	}
	
	
	public long timeMinus(String currentTime,String orderTime){  
		//时间差  用于预约的人是否在一个小时内，若是，则可优先看病
		int curD,orderD;
		int curH,orderH;
		int curM,orderM;
		int curS,orderS;
		curD=Integer.parseInt((String) currentTime.subSequence(8, 10));
		curH=Integer.parseInt((String) currentTime.subSequence(11, 13));
		curM=Integer.parseInt((String) currentTime.subSequence(14, 16));
		curS=Integer.parseInt((String) currentTime.subSequence(17, 19));
		
		orderD=Integer.parseInt((String) orderTime.subSequence(8, 10));
		orderH=Integer.parseInt((String) orderTime.subSequence(11, 13));
		orderM=Integer.parseInt((String) orderTime.subSequence(14, 16));
		orderS=Integer.parseInt((String) orderTime.subSequence(17, 19));

		long secondCount=(curD-orderD)*3600*24+(curH-orderH)*3600+(curM-orderM)*60+(curS-orderS);
		return secondCount;
		
	}
	
	
	
}
