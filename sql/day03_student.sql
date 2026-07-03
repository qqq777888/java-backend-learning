-- Day 3 MySQL 基础练习
-- 数据库：java_backend_learning

-- 查看数据库
show databases;

-- 创建数据库
create database java_backend_learning;

-- 使用数据库
use java_backend_learning;

-- 查看当前正在使用的数据库
select database();

-- 创建学生表
create table student (
                         id varchar(20) primary key,
                         name varchar(50) not null,
                         age int not null,
                         phone varchar(20),
                         create_time datetime
);

-- 查看表结构
desc student;

-- 插入学生数据
insert into student(id, name, age, phone, create_time)
values ('001', '张三', 18, '13800000000', now());

insert into student(id, name, age, phone, create_time)
values ('002', '李四', 20, '13900000000', now());

-- 查询所有学生
select * from student;

-- 根据学号查询
select * from student
where id = '001';

-- 查询年龄大于 18 的学生
select * from student
where age > 18;

-- 模糊查询：查询姓名中包含“三”的学生
select * from student
where name like '%三%';

-- 修改学生信息
update student
set name = '王五', age = 22, phone = '13700000000'
where id = '001';

-- 删除学生
delete from student
where id = '002';

-- 再插入几条数据，用于排序和分页练习
insert into student(id, name, age, phone, create_time)
values ('003', '赵六', 19, '13600000000', now());

insert into student(id, name, age, phone, create_time)
values ('004', '孙七', 23, '13500000000', now());

insert into student(id, name, age, phone, create_time)
values ('005', '周八', 21, '13400000000', now());

-- 按年龄升序
select * from student
order by age asc;

-- 按年龄降序
select * from student
order by age desc;

-- 按创建时间倒序
select * from student
order by create_time desc;

-- 查询前 2 条
select * from student
                  limit 2;

-- 分页查询：第 1 页，每页 2 条
select * from student
                  limit 0, 2;

-- 分页查询：第 2 页，每页 2 条
select * from student
                  limit 2, 2;