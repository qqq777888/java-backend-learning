# java-backend-learning
1
# Java Backend Learning

## 学习目标
一个月内完成 Java 后端基础学习，并完成一个基于 Spring Boot + MySQL 的后台管理系统项目。

## 当前学习路线
- JavaSE 基础
- MySQL 数据库
- Maven / Git
- Spring Boot
- MyBatis-Plus
- JWT 登录认证
- 后台管理系统项目

## 每日记录
### Day 1
- 注册 GitHub
- 创建学习仓库
- 配置后端学习环境
- 开始复习 JavaSE 基础


## Day 2 学习内容

### 今日完成
- 给学生管理系统添加年龄输入校验
- 使用 try-catch 处理年龄输入异常
- 给手机号添加长度和纯数字校验
- 给学号添加长度校验和重复校验
- 学习 HashMap 的基本使用
- 将学生管理系统升级为 ArrayList + HashMap 版本
- 完成 Git 提交并推送到 GitHub

### 今日技术点
- try-catch 异常处理
- Integer.parseInt 字符串转整数
- continue 跳过本次循环
- charAt 获取字符串指定位置字符
- boolean 标记变量
- HashMap 的 put、get、remove、containsKey
- ArrayList 和 HashMap 的区别

### 今日总结
ArrayList 适合按顺序保存和遍历所有学生，HashMap 适合根据学号快速查询学生。  
同时维护 ArrayList 和 HashMap 时，添加和删除必须同步，否则可能出现数据不一致。


## Day 3 学习内容

### 今日完成
- 安装并配置 MySQL 命令行环境
- 创建 java_backend_learning 数据库
- 创建 jdbcStudent 学生表
- 学习 MySQL 基础字段类型：varchar、int、datetime
- 掌握 SQL 基础增删改查
- 学习 where 条件查询、like 模糊查询、order by 排序、limit 分页
- 将 Day3 SQL 练习整理为 sql/day03_student.sql 并提交 GitHub

### 今日技术点
- create database 创建数据库
- use 切换数据库
- create table 创建表
- insert 新增数据
- select 查询数据
- update 修改数据
- delete 删除数据
- where 条件过滤
- like 模糊查询
- order by 排序
- limit 分页查询


## Day 4 学习内容

### 今日完成
- 学习 MySQL 多表设计
- 创建 user 用户表和 orders 订单表
- 理解一对多关系：一个用户可以有多个订单
- 学习主键 id 和业务订单号 order_no 的区别
- 学习 decimal(10, 2) 金额字段类型
- 学习 inner join 和 left join
- 学习 count、sum、group by 分组统计
- 学习 having 分组后过滤
- 学习 foreign key 外键约束
- 学习 transaction 事务、commit 提交、rollback 回滚
- 整理 Day4 SQL 到 sql/day04_multi_table.sql

### 今日技术点
- bigint
- auto_increment
- decimal(10, 2)
- inner join
- left join
- group by
- having
- ifnull
- foreign key
- start transaction
- commit
- rollback


## Day 5 学习内容

### 今日完成
- 创建 Maven 项目 day05-jdbc-demo
- 在 pom.xml 中引入 MySQL JDBC 驱动 mysql-connector-j
- 使用 JDBC 成功连接 MySQL 数据库
- 使用 Java 查询 jdbcStudent 表数据
- 学习 JDBC 核心对象：
    - DriverManager
    - Connection
    - PreparedStatement
    - ResultSet
- 学习 PreparedStatement 的 ? 占位符
- 使用 JDBC 完成 jdbcStudent 表的增删改查
- 将数据库查询结果封装成 JdbcStudent 对象
- 使用 List<JdbcStudent> 保存多条学生数据
- 拆分代码结构：
    - JdbcStudent 实体类
    - JdbcUtil 工具类
    - StudentDao 数据访问类
    - JdbcStudentDemo 测试入口

### 今日技术点
- JDBC
- Maven 依赖管理
- MySQL Connector/J
- DriverManager.getConnection()
- PreparedStatement
- executeQuery()
- executeUpdate()
- ResultSet
- Java 对象封装数据库结果
- DAO 思想