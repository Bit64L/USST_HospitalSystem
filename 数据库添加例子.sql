
//ԤԼ����
insert into Appointment(patientID,name,sex,age,phoneNumber,hospitalDepartmentID,hospitalDepartmentName,orderTime)
values(350111,'��һ','��',45,'130111',1,'���','2016/12/24 09:00:00');
insert into Appointment(patientID,name,sex,age,phoneNumber,hospitalDepartmentID,hospitalDepartmentName,orderTime)
values(630222,'����','Ů',40,'150222',2,'����','2016/12/24 13:00:00');
insert into Appointment(patientID,name,sex,age,phoneNumber,hospitalDepartmentID,hospitalDepartmentName,orderTime)
values(560333,'����','��',18,'130555',3,'����','2016/12/24 15:00:00');
update Appointment set hospitalDepartmentID=8 where patientID='350111'
update Appointment set hospitalDepartmentID=10 where patientID='560333'
update Appointment set hospitalDepartmentID=9 where patientID='630222'
update Appointment set orderTime='2016/12/24 15:00:00' where patientID='560333'
update Appointment set orderTime='2016/12/24 13:00:00' where patientID='630222'
update Appointment set orderTime='2016/12/24 09:00:00' where patientID='350111'
select * from Appointment 
delete from Appointment
//���Ҿ���
insert into HospitalDepartment(hospitalDepartmentName) values('���');
insert into HospitalDepartment(hospitalDepartmentName) values('����');
insert into HospitalDepartment(hospitalDepartmentName) values('����');
insert into HospitalDepartment(hospitalDepartmentName) values('��ҽ��');

update HospitalDepartment set registerNum=100,money=1000;
select * from HospitalDepartment
delete from HospitalDepartment

//ҩƷ����
insert into Medicine(name,shortName,unit,price,deposit) values('999��ð��','999gml','��',20.50,50);
insert into Medicine(name,shortName,unit,price,deposit) values('С�������','xchkl','��',15.80,40);
insert into Medicine(name,shortName,unit,price,deposit) values('����������','bynkl','��',25.00,50);
insert into Medicine(name,shortName,unit,price,deposit) values('��ζ�ػ���','lwdhw','ƿ',45.00,20);
insert into Medicine(name,shortName,unit,price,deposit) values('��������','jljn','��',20.60,20);
select * from Medicine
delete from Medicine

//�շ���Ŀ����
insert into ChargeItem(name,shortName,unit,price) values('����','cj','��',300.00);
insert into ChargeItem(name,shortName,unit,price) values('B��','bc','��',200.00);
select * from ChargeItem
delete from ChargeItem

//����Ա����
insert into Manager(password,name) values('123','����');
insert into Manager(password,name) values('123','����');
select * from Manager
delete from Manager

//ҽ������
insert into Doctor(name,password,cureNum,cureMoney,hospitalDepartmentID,hospitalDepartmentName) 
 values('����ʶ','123',12,123.5,8,'���');
insert into Doctor(name,password,cureNum,cureMoney,hospitalDepartmentID,hospitalDepartmentName) 
 values('������','111',55,456.5,9,'����');
insert into Doctor(name,password,cureNum,cureMoney,hospitalDepartmentID,hospitalDepartmentName) 
 values('������','222',6,489.8,10,'����');
insert into Doctor(name,password,cureNum,cureMoney,hospitalDepartmentID,hospitalDepartmentName) 
 values('С��','333',88,1888,11,'��ҽ��');
 
select * from Doctor
delete from Doctor

//�շ���Ա����
insert into Charger(password,name) values('888','��һ');
insert into Charger(password,name) values('888','����');
insert into Charger(password,name) values('888','����');
select * from Charger
delete from Charger

//ҩʦ����
insert into Druggist(password,name) values('999','ҩʦһ');
insert into Druggist(password,name) values('999','ҩʦ��');
insert into Druggist(password,name) values('999','ҩʦ��');
select * from Druggist
delete from Druggist

//Ժ������
insert into President(password,name) values('111','Ժ��һ');
insert into President(password,name) values('222','Ժ����');
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