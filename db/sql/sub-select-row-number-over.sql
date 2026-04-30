https://leetcode.com/problems/department-top-three-salaries/description/

CREATE TABLE employees (
    e_id INT,
    e_name VARCHAR(100),
    e_salary INT,
    e_dept_id INT
);
INSERT INTO employees (e_id, e_name, e_salary, e_dept_id) VALUES (1, 'John Doe', 50000, 1);
INSERT INTO employees (e_id, e_name, e_salary, e_dept_id) VALUES (2, 'Jane Smith', 55000, 1);
INSERT INTO employees (e_id, e_name, e_salary, e_dept_id) VALUES (3, 'Boby Johnson', 48000, 1);
INSERT INTO employees (e_id, e_name, e_salary, e_dept_id) VALUES (4, 'Marry William', 60000, 2);
INSERT INTO employees (e_id, e_name, e_salary, e_dept_id) VALUES (5, 'Linda Davis', 62000, 2);
INSERT INTO employees (e_id, e_name, e_salary, e_dept_id) VALUES (6, 'James Lee', 58000, 2);

select * from employees;

SELECT e.*, ROW_NUMBER() OVER(
        PARTITION BY e_dept_id
        ORDER BY e_salary DESC) AS rn
    FROM employees e;

SELECT * FROM (
    SELECT e.*, ROW_NUMBER() OVER(
        PARTITION BY e_dept_id
        ORDER BY e_salary DESC) AS rn
    FROM employees e
) AS t
WHERE t.rn <= 3;