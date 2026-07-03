-- Day 4 MySQL 多表设计与关联查询
-- 数据库：java_backend_learning

use java_backend_learning;

-- 创建用户表
create table user (
                      id bigint primary key auto_increment,
                      username varchar(50) not null,
                      phone varchar(20),
                      create_time datetime
);

-- 查看用户表结构
desc user;

-- 插入用户数据
insert into user(username, phone, create_time)
values ('张三', '13800000000', now());

insert into user(username, phone, create_time)
values ('李四', '13900000000', now());

insert into user(username, phone, create_time)
values ('王五', '13700000000', now());

-- 查询用户
select * from user;

-- 创建订单表
create table orders (
                        id bigint primary key auto_increment,
                        user_id bigint not null,
                        order_no varchar(50) not null,
                        product_name varchar(100) not null,
                        amount decimal(10, 2) not null,
                        create_time datetime
);

-- 查看订单表结构
desc orders;

-- 插入订单数据
insert into orders(user_id, order_no, product_name, amount, create_time)
values (1, 'ORDER001', 'Java 编程书', 88.50, now());

insert into orders(user_id, order_no, product_name, amount, create_time)
values (1, 'ORDER002', '机械键盘', 199.00, now());

insert into orders(user_id, order_no, product_name, amount, create_time)
values (2, 'ORDER003', '鼠标', 59.90, now());

-- 查询订单
select * from orders;

-- 老写法关联查询
select
    u.id,
    u.username,
    o.order_no,
    o.product_name,
    o.amount
from user u, orders o
where u.id = o.user_id;

-- inner join：只查询两边都匹配的数据
select
    u.id,
    u.username,
    o.order_no,
    o.product_name,
    o.amount
from user u
         inner join orders o on u.id = o.user_id;

-- left join：左表 user 全部保留
select
    u.id,
    u.username,
    o.order_no,
    o.product_name,
    o.amount
from user u
         left join orders o on u.id = o.user_id;

-- 对比 u.id 和 o.user_id
select
    u.id as user_table_id,
    o.user_id as order_table_user_id,
    u.username,
    o.order_no,
    o.product_name
from user u
         left join orders o on u.id = o.user_id;

-- 查询订单总数
select count(*) from orders;

-- 查询订单总金额
select sum(amount) from orders;

-- 按用户统计订单数量
select
    user_id,
    count(*) as order_count
from orders
group by user_id;

-- 按用户统计消费总金额
select
    user_id,
    sum(amount) as total_amount
from orders
group by user_id;

-- inner join + group by：统计有订单的用户
select
    u.id,
    u.username,
    count(o.id) as order_count,
    sum(o.amount) as total_amount
from user u
         inner join orders o on u.id = o.user_id
group by u.id, u.username;

-- left join + group by：统计所有用户，没有订单的用户金额显示 0
select
    u.id,
    u.username,
    count(o.id) as order_count,
    ifnull(sum(o.amount), 0) as total_amount
from user u
         left join orders o on u.id = o.user_id
group by u.id, u.username;

-- having：查询订单数大于 1 的用户
select
    user_id,
    count(*) as order_count
from orders
group by user_id
having count(*) > 1;

-- having：查询消费总金额大于 100 的用户
select
    user_id,
    sum(amount) as total_amount
from orders
group by user_id
having sum(amount) > 100;

-- 关联用户名，查询订单数大于 1 的用户
select
    u.id,
    u.username,
    count(o.id) as order_count,
    ifnull(sum(o.amount), 0) as total_amount
from user u
         left join orders o on u.id = o.user_id
group by u.id, u.username
having count(o.id) > 1;

-- 查询 orders 表中 user_id 在 user 表中不存在的无效数据
select *
from orders
where user_id not in (
    select id from user
);

-- 删除无效订单数据
delete from orders
where user_id not in (
    select id from user
);

-- 添加外键约束
alter table orders
    add constraint fk_orders_user
        foreign key (user_id)
            references user(id);

-- 测试外键：这条应该失败，因为 user_id = 999 不存在
insert into orders(user_id, order_no, product_name, amount, create_time)
values (999, 'ORDER999', '不存在用户的订单', 100.00, now());

-- 测试外键：这条应该成功，因为 user_id = 3 存在
insert into orders(user_id, order_no, product_name, amount, create_time)
values (3, 'ORDER004', '显示器', 899.00, now());

-- 事务测试：rollback 回滚
start transaction;

insert into orders(user_id, order_no, product_name, amount, create_time)
values (1, 'ORDER005', '事务测试订单', 10.00, now());

select * from orders;

rollback;

select * from orders;

-- 事务测试：commit 提交
start transaction;

insert into orders(user_id, order_no, product_name, amount, create_time)
values (1, 'ORDER006', '事务提交订单', 20.00, now());

commit;

select * from orders;