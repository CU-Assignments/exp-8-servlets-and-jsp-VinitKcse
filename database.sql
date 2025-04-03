-- Create Database
CREATE DATABASE IF NOT EXISTS CompanyDB;
USE CompanyDB;

-- Employee Table for Servlet + JDBC
CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(50),
    salary DECIMAL(10,2)
);

-- Insert Sample Employees
INSERT INTO employees (name, department, salary) VALUES
('John Doe', 'IT', 75000),
('Jane Smith', 'HR', 65000),
('Mark Johnson', 'Finance', 80000);

-- Create Database for Student Portal
CREATE DATABASE IF NOT EXISTS StudentDB;
USE StudentDB;

-- Student Table
CREATE TABLE IF NOT EXISTS students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    course VARCHAR(50)
);

-- Insert Sample Students
INSERT INTO students (name, course) VALUES
('Alice Brown', 'Computer Science'),
('Bob Williams', 'Mathematics');

-- Attendance Table
CREATE TABLE IF NOT EXISTS attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    date DATE NOT NULL,
    status ENUM('Present', 'Absent', 'Late') NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);

-- Insert Sample Attendance Records
INSERT INTO attendance (student_id, date, status) VALUES
(1, '2024-04-01', 'Present'),
(2, '2024-04-01', 'Absent');
