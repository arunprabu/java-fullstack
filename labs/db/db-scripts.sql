CREATE DATABASE jdbctraining;

USE jdbctraining;

CREATE TABLE employee (	
	id int auto_increment,
	name text,
	age int,
	designation text,
	department text,
	country text,
	PRIMARY KEY(id)
);

CREATE TABLE employee (
	id int serial,
	name text,
	age int,
	gender text,
	designation text,
	department text,
	address text,
	country text,
	contractor boolean,
	PRIMARY KEY(id)
);


//POSTGRES
CREATE DATABSE IPAAS;

CREATE TABLE INCIDENT (
	id SERIAL,
	submitter TEXT,
	description TEXT,
	priority TEXT,
	status TEXT,
	creation_time TIMESTAMP,
	resolution_time TIMESTAMP,	
	PRIMARY KEY(id)
);

CREATE TABLE INCIDENT (
	id INT AUTO_INCREMENT,
	submitter TEXT,
	description TEXT,
	priority TEXT,
	status TEXT,
	creation_time TIMESTAMP,
	resolution_time TIMESTAMP,	
	PRIMARY KEY(id)
);


CREATE TABLE COMPANY(
   ID INT PRIMARY KEY     NOT NULL,
   NAME           TEXT    NOT NULL,
   AGE            INT     NOT NULL,
   ADDRESS        CHAR(50),
   SALARY         REAL
);

CREATE SCHEMA hibernate_training;

USE hibernate_training;

CREATE TABLE hibernate_training.employee (
	id int(11),
	name varchar(255),
	age int(3),
	gender varchar(10),
	designation varchar(255),
	department varchar(255),
	address varchar(255),
	country varchar(255),
	contractor boolean,
	PRIMARY KEY(id)
);

ALTER TABLE employee CHANGE COLUMN id id INT NOT NULL AUTO_INCREMENT ;

SELECT * FROM employee;

TRUNCATE employee;

SELECT * FROM employee;
INSERT INTO employee (id, name, age, designation, department, country) VALUES (100, 'Anand', 25, 'Developer', 'IT', 'India'); 
UPDATE employee SET designation = 'IT' WHERE id = 100;
DELETE FROM employee WHERE pid = 100;

SELECT CURRNT_TIMESTAMP;

DROP TABLE employee;
DROP DATABASE jdbctraining;