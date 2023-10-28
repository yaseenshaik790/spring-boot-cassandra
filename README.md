# spring-boot-cassandra

1. Install Java 8 and Python 2.7 and Cassandra 3.0.9 in your local
2. Got to Cassndrabin folder and open cmd and execute below commands in two seperate terminals
     1. cassandra.bat
     2. start cqlsh
3. Clone the porject and execute below SQL Scripts

create keyspace skycassandra with replication={'class':'SimpleStrategy', 'replication_factor':1};

create table User(
id int PRIMARY KEY,
name text,
address text,
age int);

CREATE TABLE EMPLOYEE(
EMP_ID INT,
EMP_FIRST_NAME TEXT,
EMP_LAST_NAME VARCHAR,
EMP_SALARY INT,
EMP_COMM FLOAT,
EMP_DEPTNO INT,
EMP_DOB DATE,
PRIMARY KEY (EMP_ID, EMP_DEPTNO, EMP_SALARY) 
);
EMP_ID -> PRIMARY KEY
EMP_SAL, EMP_FIRST_NAME, EMP_DOB -> CUSTER KEY

INSERT INTO EMPLOYEE(EMP_ID, EMP_FIRST_NAME, EMP_LAST_NAME, EMP_SALARY, EMP_COMM, EMP_DEPTNO,EMP_DOB )VALUES (1001,'rakesh','Malviya',5000,1.3, 10,'1987-01-09');
INSERT INTO EMPLOYEE(EMP_ID, EMP_FIRST_NAME, EMP_LAST_NAME, EMP_SALARY, EMP_COMM, EMP_DEPTNO,EMP_DOB )VALUES (1002,'Jack','Malddadviya',5000,1.3, 10,'1987-01-09');
INSERT INTO EMPLOYEE(EMP_ID, EMP_FIRST_NAME, EMP_LAST_NAME, EMP_SALARY, EMP_COMM, EMP_DEPTNO,EMP_DOB )VALUES (1003,'Harsh','Masdviya',3000,1.3, 10,'1987-01-09');
INSERT INTO EMPLOYEE(EMP_ID, EMP_FIRST_NAME, EMP_LAST_NAME, EMP_SALARY, EMP_COMM, EMP_DEPTNO,EMP_DOB )VALUES (1004,'Yaseen','Malviya',5000,2.3, 170,'1997-01-09');
INSERT INTO EMPLOYEE(EMP_ID, EMP_FIRST_NAME, EMP_LAST_NAME, EMP_SALARY, EMP_COMM, EMP_DEPTNO,EMP_DOB )VALUES (1005,'Mack','Malviya',6000,1.3, 10,'1987-01-09');
INSERT INTO EMPLOYEE(EMP_ID, EMP_FIRST_NAME, EMP_LAST_NAME, EMP_SALARY, EMP_COMM, EMP_DEPTNO,EMP_DOB )VALUES (1006,'Rohit','khjad',15000,1.6, 100,'1988-01-09');

Rules
* You have to use all partition key column only with = operator.
  select * from employee where empid = 1001; not allowed
  select * from employee where empid = 1001 and empsal=200; allowed

* Use the clustering column in the same order as it is defined in table, you skip the sequence of cluster column
Ex: select * from employee where empid=1001 and emp_sal=2000 and em firstname ='Rohit' and emp_dob='1998-09-09';   not allowed
    select * from employee where empid=1001 and emp_sal=2000 and em firstname ='Rohit';


*

select * from employee where emp_id=1003 ALLOW FILTERING;

* In operator is allowed on all the column of partition key but it slow downs the performance

5. Use below Postman Collections

Get User: curl --location 'http://localhost:8080/users'
Save User:
curl --location 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--data '{
    "id": 6,
    "name": "Klpakpd ",
    "address": "JKkghijka",
    "age": 22
}'
Get User By ID:
curl --location 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--data '{
    "id": 6,
    "name": "Klpakpd ",
    "address": "JKkghijka",
    "age": 22
}'

Delete User:
curl --location --request DELETE 'http://localhost:8080/users/1'
