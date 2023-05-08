create table student
(
   id integer not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);

insert into student(id, name, passport_number) values (1, 'Prakash','abc');