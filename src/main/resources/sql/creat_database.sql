create database questionnaire;

use questionnaire;


# create user table

create table user
(
    id int unsigned auto_increment primary key,
    username varchar(32) not null,
    password varchar(64) not null
);

create table role(
    id int unsigned auto_increment primary key ,
    name varchar(32) not null
);

create table user_role(
    id int unsigned auto_increment primary key ,
    uid int unsigned,
    rid int unsigned,
    constraint `User_ID` foreign key (`uid`) references `user` (`id`),
    constraint `Role_ID` foreign key (`rid`) references `role` (`id`)
);

# drop table user;



# show databases;
use questionnaire;


show tables;

desc user;

# md5
insert into user(user.username, user.password) values ('root', md5("QWERTY"));

# BCrypt
update user set password = "$2a$10$5nhOOsz1JQWmA6d8IXeOJ.sYQ209L/lnXAomO198Ro4x/BVnDgVJS" where id = 1;

insert into role(name) values ('root');

insert into user_role (uid, rid) values (1, 1);

select * from user where username = 'root';

select * from user_role;
select * from role;

truncate user_role;
truncate role;

drop table user_role;


# create table questionnaire

create table questionnaire(
    id bigint unsigned not null auto_increment comment '问卷编号' primary key,
    name varchar(20) not null comment '问卷名',
    qn_describe text comment '问卷描述',
    create_time datetime default current_timestamp comment '问卷创建时间',
    update_time datetime default current_timestamp on update current_timestamp comment '更新时间',
    status enum('public', 'close') comment '当前问卷是否开放'
) default charset=utf8;

# create table question

create table question(
    q_id bigint unsigned not null auto_increment comment '问题编号' primary key ,
     q_describe text comment '问题描述',
     id bigint unsigned not null comment '所属问卷编号',
     question_type enum('subjective', 'objective') not null ,
     constraint `Questionnaire_Id` foreign key (`id`) references questionnaire(`id`)
) default charset=utf8;


# create table option

create table question_option(
    op_id bigint unsigned not null auto_increment comment '选项编号' primary key ,
    op_describe varchar(50) comment '选项内容',
    q_id bigint unsigned not null comment '所属问题编号',
    constraint `Question_Id` foreign key (`q_id`) references question(`q_id`)
) default charset=utf8;

# create table subjective_question_answer

create table subjective_question_answer(
    sub_q_id bigint unsigned not null auto_increment comment '答案编号' primary key,
    content text comment '答案内容'
) default charset=utf8;

create table objective_question_answer(
    obj_id bigint unsigned not null auto_increment comment '答案编号' primary key ,
    op_id bigint unsigned not null comment '题目编号',
    constraint `Option_Id` foreign key (`op_id`) references question_option(`op_id`)
) default charset=utf8;


show tables;

desc questionnaire;

show create table questionnaire;

show full columns from questionnaire;

alter table questionnaire comment '用于存放问卷信息的表';



desc user;

select * from user;