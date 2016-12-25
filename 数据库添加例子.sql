
//预约举例
insert into Appointment(patientID,name,sex,age,phoneNumber,hospitalDepartmentID,hospitalDepartmentName,orderTime)
values(350111,'程一','男',45,'130111',1,'外科','2016/12/24 09:00:00');
insert into Appointment(patientID,name,sex,age,phoneNumber,hospitalDepartmentID,hospitalDepartmentName,orderTime)
values(630222,'王二','女',40,'150222',2,'妇科','2016/12/24 13:00:00');
insert into Appointment(patientID,name,sex,age,phoneNumber,hospitalDepartmentID,hospitalDepartmentName,orderTime)
values(560333,'刘三','男',18,'130555',3,'儿科','2016/12/24 15:00:00');
update Appointment set hospitalDepartmentID=8 where patientID='350111'
update Appointment set hospitalDepartmentID=10 where patientID='560333'
update Appointment set hospitalDepartmentID=9 where patientID='630222'
update Appointment set orderTime='2016/12/24 15:00:00' where patientID='560333'
update Appointment set orderTime='2016/12/24 13:00:00' where patientID='630222'
update Appointment set orderTime='2016/12/24 09:00:00' where patientID='350111'
select * from Appointment 
delete from Appointment
//科室举例
insert into HospitalDepartment(hospitalDepartmentName) values('外科');
insert into HospitalDepartment(hospitalDepartmentName) values('妇科');
insert into HospitalDepartment(hospitalDepartmentName) values('儿科');
insert into HospitalDepartment(hospitalDepartmentName) values('中医科');

update HospitalDepartment set registerNum=100,money=1000;
select * from HospitalDepartment
delete from HospitalDepartment

//药品举例
insert into Medicine(name,shortName,unit,price,deposit) values('999感冒灵','999gml','盒',20.50,50);
insert into Medicine(name,shortName,unit,price,deposit) values('小柴胡颗粒','xchkl','盒',15.80,40);
insert into Medicine(name,shortName,unit,price,deposit) values('鼻炎宁颗粒','bynkl','盒',25.00,50);
insert into Medicine(name,shortName,unit,price,deposit) values('六味地黄丸','lwdhw','瓶',45.00,20);
insert into Medicine(name,shortName,unit,price,deposit) values('金龙胶囊','jljn','盒',20.60,20);
select * from Medicine
delete from Medicine

//收费项目举例
insert into ChargeItem(name,shortName,unit,price) values('肠镜','cj','次',300.00);
insert into ChargeItem(name,shortName,unit,price) values('B超','bc','次',200.00);
select * from ChargeItem
delete from ChargeItem

//管理员举例
insert into Manager(password,name) values('123','王四');
insert into Manager(password,name) values('123','张琪');
select * from Manager
delete from Manager

//医生举例
insert into Doctor(name,password,cureNum,cureMoney,hospitalDepartmentID,hospitalDepartmentName) 
 values('马意识','123',12,123.5,8,'外科');
insert into Doctor(name,password,cureNum,cureMoney,hospitalDepartmentID,hospitalDepartmentName) 
 values('张柳柳','111',55,456.5,9,'妇科');
insert into Doctor(name,password,cureNum,cureMoney,hospitalDepartmentID,hospitalDepartmentName) 
 values('李依依','222',6,489.8,10,'儿科');
insert into Doctor(name,password,cureNum,cureMoney,hospitalDepartmentID,hospitalDepartmentName) 
 values('小明','333',88,1888,11,'中医科');
 
select * from Doctor
delete from Doctor

//收费人员举例
insert into Charger(password,name) values('888','杨一');
insert into Charger(password,name) values('888','成龙');
insert into Charger(password,name) values('888','章子');
select * from Charger
delete from Charger

//药师举例
insert into Druggist(password,name) values('999','药师一');
insert into Druggist(password,name) values('999','药师二');
insert into Druggist(password,name) values('999','药师三');
select * from Druggist
delete from Druggist

//院长举例
insert into President(password,name) values('111','院长一');
insert into President(password,name) values('222','院长二');
select * from President
delete from President


select * from Appointment
select * from HospitalDepartment
select * from Medicine
select * from ChargeItem
select * from Manager
select * from Doctor
select * from Charger
select * from Druggist
select * from President