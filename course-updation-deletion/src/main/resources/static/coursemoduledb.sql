DROP DATABASE IF EXISTS coursemoduledb;
CREATE DATABASE IF NOT EXISTS coursemoduledb;
USE coursemoduledb;

DROP TABLE IF EXISTS employee,
    departments,
    courses,
    users,
    course_prerequisite;
###ddls###

##USERS
create table users(
                      usr_email varchar(255) PRIMARY KEY,
                      usr_name varchar(255) not null,
                      usr_password varchar(255) not null,
                      usr_type varchar(255) not null
);


##DEPARTMENTS
create table departments(
                            department_id INT AUTO_INCREMENT PRIMARY KEY,
                            name varchar(255) not null,
                            capacity int not null
);


##EMPLOYEE
create table employee(
                         employee_id INT AUTO_INCREMENT PRIMARY KEY,
                         first_name varchar(255) not null,
                         last_name varchar(255),
                         email varchar(255) not null unique,
                         title varchar(255),
                         photograph_path varchar(255),
                         dept_id int
);

##COURSES
create table courses(
                        course_id int AUTO_INCREMENT PRIMARY KEY,
                        course_code int not null unique,
                        name varchar(255) not null,
                        description varchar(255),
                        year int not null,
                        term varchar(255) not null,
                        credits int not null,
                        capacity int not null,
                        faculty_id int
);


##COURSE_PREREQUISITES
create table course_prerequisite(
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    course_id_fk int,
                                    prereq_id int,
                                    prereq_description varchar(255)
);

###ALTER FKS

alter table employee add constraint fk_usr_emp_relation FOREIGN KEY (email) REFERENCES users(usr_email);


alter table employee add constraint fk_department FOREIGN KEY (dept_id) REFERENCES departments(department_id);

alter table courses add constraint fk_faculty FOREIGN KEY (faculty_id) REFERENCES employee(employee_id);

alter table course_prerequisite add constraint fk_course_id FOREIGN KEY (course_id_fk) REFERENCES courses(course_id);

alter table course_prerequisite add constraint fk_prereq_id FOREIGN KEY (prereq_id) REFERENCES courses(course_id);


###DATA

## Insert sample data into the 'users' table
INSERT INTO users(usr_name, usr_email, usr_password, usr_type) VALUES
    ('John Doe', 'john.doe@example.com', 'password123', 'admin'),
    ('Jane Smith', 'jane.smith@example.com', 'pass456', 'users'),
    ('Bob Johnson', 'bob.johnson@example.com', 'secure789', 'users'),
    ('Alice Williams', 'alice.williams@example.com', '12345pass', 'admin'),
    ('Charlie Brown', 'charlie.brown@example.com', 'securepass', 'users'),
	('sachin.nair@example.com', 'sachin.nair@example.com', 'sachinpass', 'admin'),
	('michal.das@example.com', 'michal.das@example.com', 'michalpass', 'users');


### Inserting data into the 'departments' table
insert into departments (department_id, name, capacity) values
(1, 'Computer Science', 25),
(2, 'Mathematics', 30),
(3, 'Physics', 20),
(4, 'Chemistry', 30),
(5, 'Biology', 45);

### Inserting data into the 'employee' table
insert into employee (employee_id, first_name, last_name, email, title, photograph_path, dept_id) values
(1, 'John', 'Doe', 'john.doe@example.com', 'Professor', '/photos/john_doe.jpg', 1),
(2, 'Jane', 'Smith', 'jane.smith@example.com', 'Assistant Professor', '/photos/jane_smith.jpg', 2),
(3, 'Bob', 'Johnson', 'bob.johnson@example.com', 'Associate Professor', '/photos/bob_johnson.jpg', 3),
(4, 'Alice', 'Williams', 'alice.williams@example.com', 'Lecturer', '/photos/alice_williams.jpg', 4),
(5, 'Charlie', 'Brown', 'charlie.brown@example.com', 'Senior Lecturer', '/photos/charlie_brown.jpg', 5);

### Inserting data into the 'courses' table with course_code as varchar
insert into courses (course_id, course_code, name, description, year, term, credits, capacity, faculty_id) values
(1, '101', 'Introduction to Computer Science', 'Fundamentals of programming and algorithms', 1, 'Fall', 3, 50, 2),
(2, '201', 'Linear Algebra', 'Basic concepts of linear algebra', 2, 'Spring', 4, 40, 3),
(3, '301', 'Classical Mechanics', 'Newtonian mechanics and motion', 3, 'Fall', 3, 30, 4),
(4, '102', 'Data Structures', 'Advanced data structures and algorithms', 2, 'Spring', 4, 45, 2),
(5, '202', 'Abstract Algebra', 'Algebraic structures and properties', 3, 'Fall', 3, 35, 3);

### Inserting data into the 'course_prerequisite' table
INSERT INTO course_prerequisite (id, course_id_fk, prereq_id, prereq_description) VALUES
    (1, 2, 1, 'Introduction to Computer Science'),
    (2, 3, 2, 'Linear Algebra'),
    (3, 4, 1, 'Introduction to Computer Science'),
    (4, 5, 2, 'Linear Algebra'),
    (5, 3, 4, 'Data Structures');






