/**
 * 工具类：
 * 1.时间类
 * 		(1)获取当前系统时间  Time.getCurrentTime()
 * 		(2)返回 当前时间-预约时间,单位s   timeMinus(String currentTime,String orderTime) 
									//时间差  用于预约的人是否在一个小时内，若是，则可优先看病
 * 2.数据库工具类
 * 		用法: DB db=new DB();
 * 				db.insert(sqlStr)  -sqlStr为sql语句,返回执行成功与否
 * 				db.delete(sqlStr)  -sqlStr为sql语句,返回执行成功与否
 * 				db.update(sqlStr)  -sqlStr为sql语句,返回执行成功与否
 * 				db.select(sqlStr)  -sqlStr为sql语句，返回ResultSet,就算什么都没查到reslutset也不是null
 */
/**
 * @author ray
 *
 */
package utility;

