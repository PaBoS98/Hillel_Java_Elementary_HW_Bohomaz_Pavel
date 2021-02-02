create database if not exists student;

create table if not exists student.students (
  id_student INT auto_increment primary key not null,
  student_full_name varchar(100) null,
  `group` int,
  year_of_admission INT null
);

create table if not exists student.groups (
  id_group int primary key not null,
  `group` varchar(100) null
);

create table if not exists student.points (
	id_point int primary key not null,
    lesson int,
    student int,
    point int null
);

create table if not exists student.lessons (
	id_lesson int primary key not null,
    lesson_name varchar(100) null,
    teacher int,
    semester int null,
    year int null
);

create table if not exists student.teachers (
	id_teacher int primary key not null,
    teacher_full_name varchar(100) null,
    deparmten int
);

create table if not exists student.deparmtens (
	id_deparmten int primary key not null,
    deparmten_name varchar(100) null,
    manager varbinary(100) null
);

alter table student.students add foreign key(`group`) references student.groups(id_group);
alter table student.points add foreign key(student) references student.students(id_student);
alter table student.points add foreign key(lesson) references student.lessons(id_lesson);
alter table student.lessons add foreign key(teacher) references student.teachers(id_teacher);
alter table student.teachers add foreign key(deparmten) references student.deparmtens(id_deparmten);

insert into student.groups value(0312,'Java Elementary'), (0125,'Java Introdaction'), (0111,'Python');
insert into student.deparmtens value(01, 'JAVA courses', 'Ktoto ktotov'), (034, 'PYTHON courses', 'Ivan Ivanych');
insert into student.teachers value(1428, 'Prepodovatel Chegotogov Valerievich', 1),(8828, 'Zaklinatel Zmey Zmeinovich', 34),(1597, 'Full Name', 1),(2021, 'Surname Name Patronymic', 1);
insert into student.lessons value(1, 'DataBase', 1428, 1, 2021), (98, 'Introdaction', 2021, 2, 2021), (14, 'About Snake', 8828, 1, 2021), (56, 'Hello World', 1597, 1, 2021);
insert into student.students(student_full_name, `group`, year_of_admission) value('Lazarev Naum Rostislavovich', 111, 2018), ('Krasilnikov Rodion Nikolayevich', 111, 2018), ('Kalinina Adel Lavrentyevna', 111, 2018),
	('Anisimov Ippolit Tarasovich', 125, 2020),('Mikheyev Avgust Valentinovich', 125, 2019),('Blinova Khana Glebovna', 312, 2020),
    ('Titov Varlam Yulianovich', 312, 2020),('Tarasov Ernest Vsevolodovich', 312, 2008);
insert into student.points value(45, 14,1, 80), (123, 1,2, 100), (12, 56,3, 90), (55, 56,4, 40), (57, 98,5, 23), (666, 1,6, 66), (69, 1,7, 54), (23, 56,8, 10);

select * from student.groups;
select * from student.deparmtens;
select * from student.teachers;
select * from student.lessons;
select * from student.students;
select * from student.points;

select id_student, student_full_name, `group`, year_of_admission, lesson, `point` from student.students 
left join student.points on id_student = student;