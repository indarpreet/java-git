DROP TABLE student;

create table student(id integer not null auto_increment, first_name varchar(255), primary key (id));

INSERT INTO student(first_Name) VALUES ('admin');

INSERT INTO student(first_Name) VALUES ('john');

INSERT INTO student(first_Name) VALUES ('sham');

DROP TABLE item;

create table item(id integer not null, name varchar(255),price integer not null, quantity integer not null, primary key (id));

insert into item VALUES(10001, 'item1' , 10 , 20);

insert into item VALUES(10002, 'item2' , 5 , 10);


insert into item VALUES(10003, 'item3' , 15 , 2);