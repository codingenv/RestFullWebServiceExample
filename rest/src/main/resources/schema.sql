create table student
(
   id integer not null,
   name varchar(255) not null,
   city varchar(255) not null,
   age integer not null,
   std integer not null,
   stream  varchar(255) not null,
   primary key(id)
);

insert into student(id, name, city, age, std, stream) values (1, 'Prakash','Bangalore', 14, 12, 'Science');
insert into student(id, name, city, age, std, stream) values (2, 'Prateek','Surat', 13, 11, 'Arts');
insert into student(id, name, city, age, std, stream) values (3, 'Vijay','Surat', 13, 10, 'Arts');