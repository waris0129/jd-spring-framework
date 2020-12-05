SELECT * FROM departments;


SELECT * FROM employees;


SELECT * FROM regions;


SELECT employee_id,first_name,department
FROM employees;

-- where
SELECT * FROM employees
WHERE department = 'Sports';

-- like
SELECT *
FROM employees
WHERE department like '%nit%';

-- operator
SELECT *
FROM employees
WHERE salary > 100000;

SELECT *
FROM employees
WHERE salary < 100000;

SELECT *
FROM employees
WHERE salary <= 100000;

-- and  or
SELECT *
FROM employees
WHERE department = 'Clothing'
AND  salary > 90000
AND region_id = 2;


SELECT *
FROM employees
WHERE department = 'Clothing'
OR salary > 90000;

-- grouping ()  show me employee salary loser than 40k in clothing or pharmacy
SELECT *
FROM employees
WHERE salary < 40000
AND (department = 'Clothing'
OR department='Pharmacy');



-- not equal to <> or != or NOT
SELECT *
FROM employees
WHERE department <> 'Sports';

SELECT *
FROM employees
WHERE NOT department = 'Sports';


-- IS keyword, working with null
SELECT *
FROM employees
WHERE email IS NULL;


SELECT *
FROM employees
WHERE email IS NOT NULL;

-- IN keyword
SELECT *
FROM employees
WHERE department = 'Sports'
OR department='First Aid'
OR department='Toys'
OR department='Garden';

SELECT *
FROM employees
WHERE department IN ('Sports','First Aid','Toys','Garden');


-- Between And

SELECT *
FROM employees
WHERE salary BETWEEN 80000 and 100000;


-- WRITE query that returns the first name and email of females that work in the tools department
-- having a salary greater than 110,000

SELECT first_name
FROM employees
WHERE gender = 'F'
AND department= 'Tools'
AND salary>110000;


-- write query returns first name and hire date of those emoloyees who earn more
-- than 165,000 and those employees that work in sports departments and
-- also happend to be man

SELECT *
FROM employees
WHERE salary>165000
OR (department='Sports' AND gender='M');

-- ORDER BY
SELECT *
FROM employees
ORDER BY employee_id DESC ;

-- DISTINCT
SELECT DISTINCT department
FROM employees;


-- FETCH--> FETCH FIRST 3 ROWS ONLY
SELECT DISTINCT department
FROM employees
FETCH FIRST 3 ROWS ONLY ;

-- as
SELECT salary as yearly_salary
FROM employees;


-- Displays the name and ages of the top 4 oldest students
SELECT *
FROM students
ORDER BY age DESC
FETCH FIRST 4 ROWS ONLY ;


-- write a query that returns students based on the following criteria
-- The student must not be order than age 20 of their student_no is either between
-- 3 and 5 or their student_no is 7
-- your query return students older than age 20 but in that case must have a student_no
-- is at least 4
SELECT *
FROM  students
WHERE age<=20
AND (student_no BETWEEN 3 AND 5 OR student_no=7)
OR (age>20 AND student_no>=4);




-- FUNCTION

SELECT upper(first_name), lower(last_name)
FROM employees;


SELECT length(first_name)
FROM employees;

SELECT length(TRIM('    Hello There   '));

SELECT length('    Hello There   ');


SELECT first_name || ' '||last_name AS FULL_NAME
FROM employees;


SELECT (salary>140000)
FROM employees;


SELECT (salary>140000) AS hight_paid
From employees
order by salary desc ;


SELECT department, (department like '%oth%')
FROM employees;


SELECT 'THIS IS FAKE DATE' TEST_DATE;


-- Substring : FROM 1 FOR 4
SELECT substring('THIS IS TEST DATA' FROM 1 FOR 4) AS TEST_DATA;

SELECT substring('This is test data' FROM 9) AS TEST_DATA;

SELECT department, replace(department,'Clothing','Clothes')
FROM departments;


-- Aggregating

SELECT max(salary)
from employees;

SELECT Min(salary)
from employees;

SELECT AVG(salary)
from employees;


SELECT round(AVG(salary))
from employees;


SELECT count(employee_id)
from employees;


SELECT SUM(salary)
FROM employees;


SELECT SUM(salary)
FROM employees
WHERE department='Clothing';


-- Write query returns all of the records and column from the
-- professors table but shortens the department names
-- to only the first three characters in upper case

SELECT  last_name,upper(substring(department, 1,3))
FROM professors;


-- write highest and lowest salary from the professors table excluding
-- the professpr named Wilson

SELECT max(salary),min(salary)
FROM professors
WHERE NOT last_name='Wilson';


-- GROUNP BY
SELECT count(*), department
FROM employees
GROUP BY department;



SELECT SUM(salary) as total_salary, department
FROM employees
GROUP BY department;



SELECT SUM(salary) as total_salary, department
FROM employees
WHERE region_id in (4,5,6)
GROUP BY department;



-- HAVING, GROUP BY

SELECT department, count(*)
from employees
GROUP BY department
HAVING count(*)<36
ORDER BY department;



-- Show all unique domain and number of employees

SELECT *
FROM employees
WHERE NOT email IS null;

-- POSITION (INDEX IN TEXT): FIND INDEX

SELECT count(*), substring(email,position('@'in email)+1) email_domain
FROM employees
WHERE email IS NOT NULL
GROUP BY email_domain;

SELECT *
FROM employees
WHERE department NOT IN (SELECT department FROM departments);

SELECT *
FROM (SELECT * FROM employees WHERE salary>150000) a;


-- Return all employees that workn in electronic dIvision
SELECT division
FROM departments WHERE division='Electronics';

SELECT *
FROM employees
WHERE department in
      (SELECT departments.department
       FROM departments WHERE division='Electronics'
);



-- return all employees work in ASIA or CANADA make more than 130000
SELECT * FROM regions;

SELECT *
FROM employees
WHERE region_id in
      (SELECT regions.region_id
      FROM regions
      WHERE country = 'Asia' or country='Canada');




-- return first name and how much less making from the highest emoloyee in the company

SELECT first_name, salary, ((SELECT max(salary)
                            FROM employees)- salary) as Difference
FROM employees;

SELECT max(salary)
FROM employees;
--166976

SELECT MIN(salary)
FROM employees;
--20542


-- write a query tat returns all of the thse emoloyees that work in the kids division
-- and dates at the which those employees were hired is greateer than all of the hire_date
-- of employees who work in the maintance department


-- ANY : = ANY,
-- ALL : > ALL
SELECT *
FROM employees
WHERE department = ANY (SELECT department FROM departments WHERE division = 'Kids')
AND hire_date > ALL (SELECT hire_date FROM employees Where department ='Maintenance');


--WRITE QUERY returns the NAME of those students THAT are taking the courses physics and us history

SELECT student_name
FROM students
WHERE student_no = ANY (SELECT student_no
                        FROM student_enrollment
                        where course_no = ANY (SELECT course_no
                                               from courses
                                               where course_title IN ('Physics','US History')));

SELECT *
FROM courses;

SELECT *
from courses
where course_title = 'Physics';
--CS180
SELECT student_no
FROM student_enrollment
where course_no = ANY (SELECT course_no
                       from courses
                       where course_title in ('Physics','US History'));







-- case statement
SELECT  first_name , salary,
CASE
    WHEN salary< 100000 THEN 'UNDER PAID'
    WHEN salary>= 100000 THEN 'PAID WELL'
    ELSE 'UNPAID'
END as category
FROM employees;


SELECT category,COUNT(*)
FROM (
     SELECT first_name,salary,
         CASE
             WHEN salary< 100000 THEN 'UNDER PAID'
             WHEN salary>= 100000 AND salary<160000 THEN 'PAID WELL'
             ELSE 'EXECUTIVE'
        END as category
     FROM employees ORDER BY salary DESC
         ) a
GROUP BY category;









--- JOINT
SELECT  * FROM employees;
SELECT * FROM regions;
SELECT * FROM departments;

SELECT first_name,country
FROM employees e,regions r
WHERE e.region_id= r.region_id;


SELECT  first_name, region, division
FROM employees e, departments d , regions r
where e.department = d.department
AND e.region_id = r.region_id;


SELECT first_name, country
FROM employees INNER JOIN regions
ON employees.region_id = regions.region_id;


SELECT first_name, email, division
FROM employees e INNER JOIN departments d
ON e.department = d.department
WHERE email IS NOT NULL;



SELECT first_name, email, division, country
FROM employees e inner join  departments d
on e.department = d.department INNER JOIN regions r
ON e.region_id = r.region_id
WHERE email IS NOT NULL;




SELECT DISTINCT department FROM employees; --27
SELECT DISTINCT department FROM departments; --24


SELECT DISTINCT e.department, d.department
FROM employees e LEFT JOIN departments d
ON e.department = d.department;



SELECT DISTINCT e.department, d.department
FROM employees e RIGHT JOIN departments d
ON e.department = d.department;




SELECT DISTINCT e.department, d.department
FROM employees e FULL JOIN departments d
ON e.department = d.department;






-- UNION

SELECT department
FROM employees
UNION
SELECT department
FROM departments;



-- UNION ALL
SELECT department
FROM employees
UNION ALL
SELECT department
FROM departments;






-- EXCEPT
SELECT department
FROM employees
EXCEPT
SELECT department
FROM departments;


