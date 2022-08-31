create table university(
id SERIAL,
address varchar not null,
"name" varchar not null,
primary key(id)
);

insert into university (address,"name") values ('Arizona','My University');

select * from university;



create table faculty(
id SERIAL,
"name" varchar not null unique ,
advisor_email varchar not null unique,
university_id serial,

foreign key (university_id) references university(id),
primary key(id)
);

insert into faculty("name",advisor_email,university_id) values
('Faculty of Arts','arts_advisor@myuni.edu',1),
('Faculty of Economics','economics_advisor@myuni.edu',1),
('Faculty of Engineering','engineering_advisor@myuni.edu',1),
('Faculty of Music','music_advisor@myuni.edu',1),
('Faculty of Philosophy','philosophy_advisor@myuni.edu',1);

select * from faculty;



create table student(
id SERIAL,
first_name varchar not null,
last_name varchar not null,
email varchar not null unique,
"password" varchar not null check( length ("password") >= 8), 
program_name varchar not null,
faculty_id serial not null,


foreign key (faculty_id) references faculty (id),
primary key(id)
);


insert into student (first_name,last_name,email,"password",program_name,faculty_id)
values ('tom','hanks','tom_hanks@gmail.com','p@$$word','Master degree',1),
('olivia','oliver','olivia_oliver@gmail.com','p@$$word','Associate degree',2),
('patricia','james','patricia_james@gmail.com','p@$$word','Bachelor degree',4),
('maria','noah','maria_noah@gmail.com','p@$$word','PHD',5),
('david','benjamin','david_benjamin@gmail.com','p@$$word','Bachelor degree',3),
('emma','lucas','emma_lucas@gmail.com','p@$$word','Bachelor degree',2),
('evelyn','william','evelyn_william@gmail.com','p@$$word','Master degree',3);

insert into student (first_name,last_name,email,"password",program_name,faculty_id)
values('marly','younan','marlyyounan@gmail.com','p@$$word','Master degree','4');

select *
from student;

delete from student where id =;



select student.id as student_id, 
student.first_name as student_first_name, 
student.last_name as student_last_name, 
student.email as student_email, 
student.password as student_password, 
student.program_name as program_name, 
faculty.name as faculty_name

from student
join faculty 
on student.faculty_id = faculty.id;


delete from student
where student.id = ;










