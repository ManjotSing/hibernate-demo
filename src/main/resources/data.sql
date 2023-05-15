insert into course(id, name) values(10001,'JPA Learning');
insert into course(id, name) values(10002,'Java Learning');
insert into course(id, name) values(10003,'Microservice Learning');


insert into passport(id, passport_number) values(30001,'ABX3145');
insert into passport(id, passport_number) values(30002,'ZBH2267');
insert into passport(id, passport_number) values(30003,'DBA2041');

insert into student(id, name, passport_id) values(20001,'Manoj',30001);
insert into student(id, name, passport_id) values(20002,'Ravi', 30002);
insert into student(id, name, passport_id) values(20003,'Ranga', 30003);


insert into review(id, rating, description,course_id) values(40001,'good','Great course',10001);
insert into review(id, rating, description,course_id) values(40002,'average','Wonderful course',10002);
insert into review(id, rating, description, course_id) values(40003,'worst','Awesome course',10003);

insert into student_course(student_id,course_id) values(20001,10001);
insert into student_course(student_id,course_id) values(20001,10002);