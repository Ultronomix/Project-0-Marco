create table state(
id SERIAL primary key,
"name" varchar not null
);

insert into state ("name") values ('arizona'), ('california'), ('texas');

select * from state;
delete from state * ;

create table university(
id SERIAL,
"name" varchar not null,
primary key(id)
);

insert into university ("name") values ('university of phoenix');
select * from university;


create table branch(
id SERIAL primary key,
"name" varchar not null,
address varchar not null unique,
university_id serial not null,
state_id serial not null,

foreign key (university_id) references university(id),
foreign key (state_id) references state(id)
);

insert into branch ("name",address,university_id,state_id) values
('university of phoenix in texas','austin',1,3),
('university of phoenix in texas','san antonio',1,3),
('university of phoenix in california','bakersfield',1,2),
('university of phoenix in california','san diego',1,2),
('university of phoenix in arizona','phoenix',1,1),
('university of phoenix in arizona','tucson',1,1);

select * from branch;



create table faculty(
id SERIAL,
"name" varchar not null ,
advisor_email varchar not null unique,
branch_id serial not null,

foreign key (branch_id) references branch(id),
primary key(id)
);

insert into faculty("name",advisor_email,branch_id) values
('Faculty of Arts','phoenix_arts_advisor@phoenix.edu',11),
('Faculty of Arts','austin_arts_advisor@phoenix.edu',7),
('Faculty of Economics','sandiego_economics_advisor@phoenix.edu',10),
('Faculty of Economics','sanantonio_economics_advisor@phoenix.edu',8),
('Faculty of Engineering','tucson_engineering_advisor@phoenix.edu',12),
('Faculty of Engineering','bakersfield_engineering_advisor@phoenix.edu',9);

select * from faculty;


create table "program" (
id SERIAL,
"name" varchar not null,
duration varchar not null,
faculty_id serial,

foreign key (faculty_id) references faculty(id), 
primary key(id)
);

insert into "program" ("name", duration , faculty_id )  values
('associate degree','two years',1),
('associate degree','two years',2),
('bachelor degree','four years',3),
('bachelor degree','four years',4),
('bachelor degree','four years',5),
('bachelor degree','four years',6),
('master degree','two years after the bachelor degree',5),
('master degree','three years after the bachelor degree',6);

select * from "program";



create table student(
id SERIAL,
first_name varchar not null,
last_name varchar not null,
email varchar not null unique,
"password" varchar not null check( length ("password") >= 8), 
faculty_id serial not null,
program_id serial not null,

foreign key (faculty_id) references faculty (id),
foreign key (program_id) references "program" (id),
primary key(id)
);


insert into student (first_name,last_name,email,"password",faculty_id,program_id)
values ('tom','hanks','tom_hanks@gmail.com','p@$$word',1,1),
('olivia','oliver','olivia_oliver@gmail.com','p@$$word',2,2),
('patricia','james','patricia_james@gmail.com','p@$$word',3,3),
('maria','noah','maria_noah@gmail.com','p@$$word',4,4),
('david','benjamin','david_benjamin@gmail.com','p@$$word',5,5),
('emma','lucas','emma_lucas@gmail.com','p@$$word',6,6),
('evelyn','william','evelyn_william@gmail.com','p@$$word',5,7),
('marco','younan','marco_younan@gmail.com','p@$$word',6,8);

select *
from student;





select faculty.name as faculty_name,
program.name as program_name ,
program.duration as program_duration,
branch.name as branch_name ,
branch.address as branch_address,
faculty.id as faculty_id,
program.id as program_id

from faculty
join "program"
on faculty.id = program.faculty_id 
join branch
on branch.id = faculty.branch_id 
;


select student.first_name as student_first_name,
student.last_name as student_last_name,
student.email as student_email,
student."password" as student_password,
faculty.name as faculty_name,
program.name as program_name ,
program.duration as program_duration,

from student 
join faculty
on student.faculty_id = faculty.id 
join "program"
on student.program_id = program.id
;

drop table student ;






