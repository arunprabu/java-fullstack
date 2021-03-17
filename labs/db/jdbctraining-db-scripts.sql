#create schema
CREATE DATABASE jdbctraining;

#use schema
USE jdbctraining;

#create table employee
CREATE TABLE employee (
id int auto_increment,
name text,
age int,
designation text,
department text,
country text,
PRIMARY KEY(id)
);

#describe table details
DESCRIBE employee;

#insert data
INSERT INTO employee (name, age, designation, department, country) VALUES ('Anand', 25, 'Developer', 'IT', 'India');
INSERT INTO employee (name, age, designation, department, country) VALUES ('Anupama', 30, 'Lead', 'IT', 'India');
INSERT INTO employee (name, age, designation, department, country) VALUES ('Anil', 40, 'Manager', 'IT', 'India');

#select data
SELECT * FROM employee;

#select with filter
SELECT * FROM employee WHERE age >= 30 AND designation = 'Lead';

#select with aggregation
SELECT avg(age) AS 'Avg Age' FROM employee GROUP BY age;

#select department wise count
SELECT department, count(*) FROM employee GROUP BY department;

#select department having more than 2 employees
SELECT department FROM employee GROUP BY department HAVING count(*) >= 2;

#update data
UPDATE employee SET name = 'Ajay', age=35, designation='Analyst' WHERE id = 3;
UPDATE employee SET department = 'Sales' WHERE id = 3;

#delete data
DELETE FROM employee WHERE id  = 4;

#truncate
TRUNCATE TABLE employee;

#drop table
DROP TABLE employee;

#drop schema table
DROP TABLE jdbctraining;