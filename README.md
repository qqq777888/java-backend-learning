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