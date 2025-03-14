insert into user_details(id,dob,name)
values(10001,current_date(),'Abhishek');
insert into user_details(id,dob,name)
values(10002,current_date(),'Rohit');
insert into user_details(id,dob,name)
values(10003,current_date(),'Ravi');

insert into post(id,description,user_id)
values(20001,'Learning AWS',10001);
insert into post(id,description,user_id)
values(20002,'Learning Azure',10001);

insert into post(id,description,user_id)
values(20003,'Learning Java',10002);
insert into post(id,description,user_id)
values(20004,'Learning Docker',10002);

insert into post(id,description,user_id)
values(20005,'I am not Learning',10003);
