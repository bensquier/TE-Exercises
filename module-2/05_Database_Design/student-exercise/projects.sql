

BEGIN TRANSACTION;

CREATE TABLE employee (
	employee_id serial,
	department_id integer NOT NULL,
	first_name varchar(20) NOT NULL,
	last_name varchar(30) NOT NULL,
	birth_date date NOT NULL,
	gender char(1) NOT NULL,
	hire_date date NOT NULL,
	CONSTRAINT pk_employee_employee_id PRIMARY KEY (employee_id),
	CONSTRAINT ck_gender CHECK (gender IN ('M', 'F'))
);

CREATE TABLE department (
	department_id serial,
	name varchar(40) UNIQUE NOT NULL,
	CONSTRAINT pk_department_department_id PRIMARY KEY (department_id)
);

CREATE TABLE project (
	project_id serial,
	name varchar(40) UNIQUE NOT NULL,
	from_date date,
	to_date date,
	CONSTRAINT pk_project_project_id PRIMARY KEY (project_id)
);

CREATE TABLE project_employee (
	project_id integer NOT NULL,
	employee_id integer NOT NULL,
	CONSTRAINT pk_project_employee_project_project_id_employee_id PRIMARY KEY (project_id, employee_id)
);

/*
COMMIT;

ROLLBACK;


BEGIN TRANSACTION;
*/

INSERT INTO department (name) VALUES ('Human Resources');
INSERT INTO department (name) VALUES ('Security');
INSERT INTO department (name) VALUES ('Engineering');

INSERT INTO project (name, from_date, to_date) VALUES ('Project Ben 10', '1991-08-29', '2001-08-29');
INSERT INTO project (name, from_date) VALUES ('Unnamed Project', '2020-10-19');
INSERT INTO project (name, from_date) VALUES ('Project Never Ending', '2000-01-01');
INSERT INTO project (name, from_date, to_date) VALUES ('Project TE', '2020-09-14', '2020-12-18');

INSERT INTO employee (department_id, first_name, last_name, birth_date, gender, hire_date)
VALUES (1, 'Ben', 'Squier', '1991-08-29', 'M', '2012-05-01');
INSERT INTO employee (department_id, first_name, last_name, birth_date, gender, hire_date)
VALUES (1, 'Jim', 'Johnson', '1990-09-11', 'M', '2014-08-29');
INSERT INTO employee (department_id, first_name, last_name, birth_date, gender, hire_date)
VALUES (2, 'Tony', 'Robins', '1987-05-06', 'M', '1999-12-31');
INSERT INTO employee (department_id, first_name, last_name, birth_date, gender, hire_date)
VALUES (2, 'Megan', 'Dougherty', '1991-10-28', 'F', '2015-07-18');
INSERT INTO employee (department_id, first_name, last_name, birth_date, gender, hire_date)
VALUES (2, 'Chris', 'Reed', '1988-11-08', 'M', '2001-01-01');
INSERT INTO employee (department_id, first_name, last_name, birth_date, gender, hire_date)
VALUES (3, 'Hannah', 'Mckee', '2010-05-07', 'F', '2015-09-22');
INSERT INTO employee (department_id, first_name, last_name, birth_date, gender, hire_date)
VALUES (3, 'Matt', 'Mckee', '1997-11-14', 'M', '2008-01-24');
INSERT INTO employee (department_id, first_name, last_name, birth_date, gender, hire_date)
VALUES (3, 'Tim', 'Arant', '1988-10-13', 'M', '2003-03-30');

INSERT INTO project_employee (project_id, employee_id) VALUES (1, 1);
INSERT INTO project_employee (project_id, employee_id) VALUES (2, 2);
INSERT INTO project_employee (project_id, employee_id) VALUES (3, 3);
INSERT INTO project_employee (project_id, employee_id) VALUES (1, 4);
INSERT INTO project_employee (project_id, employee_id) VALUES (1, 5);
INSERT INTO project_employee (project_id, employee_id) VALUES (4, 6);
INSERT INTO project_employee (project_id, employee_id) VALUES (3, 7);
INSERT INTO project_employee (project_id, employee_id) VALUES (2, 8);

/*
COMMIT;

ROLLBACK;


BEGIN TRANSACTION;
*/

ALTER TABLE employee ADD FOREIGN KEY (department_id) REFERENCES department(department_id);
ALTER TABLE project_employee ADD FOREIGN KEY (project_id) REFERENCES project(project_id);
ALTER TABLE project_employee ADD FOREIGN KEY (employee_id) REFERENCES employee(employee_id);


COMMIT;

ROLLBACK;