-- create schemas
CREATE SCHEMA `e-shop` DEFAULT CHARACTER SET utf8mb4 ;

-- sys_admin
create table sys_admin
(
    id int,
    username nvarchar(50) not null comment '登录用户名，login，唯一',
    password nvarchar(500) null,
    full_name nvarchar(20) null comment '真实姓名',
    mobile nvarchar(11) null comment '电话',
    avatar nvarchar(500) null comment '头像',
    is_delete tinyint default 0  null,
    create_time datetime default now() null,
    update_time datetime default now() null
)
    comment '管理员表';

create unique index sys_admin_id_uindex
	on sys_admin (id);

create unique index sys_admin_username_uindex
	on sys_admin (username);

alter table sys_admin
    add constraint sys_admin_pk
        primary key (id);

alter table sys_admin modify id int auto_increment;


INSERT INTO `e-shop`.`sys_admin` (`username`, `password`, `full_name`, `mobile`, `avatar`)VALUES ('admin', '$2a$10$xk.8KkSOZRKzhsFVPWz9IOGHnAplWc8JMjKwb7lxi21MpTP51UVou', 'admin', '13000000000'
,'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdiy.qqjay.com%2Fu%2Ffiles%2F2012%2F0510%2F25c1770e108250f8a14cbc468c2030bf.jpg&refer=http%3A%2F%2Fdiy.qqjay.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1623478281&t=6f33ecf24e207659305f19a65bf879bf');

-- sys_admin_role
create table sys_admin_role
(
    admin_id int null,
    role_id int null,
    is_delete tinyint default 0 null,
    create_time datetime default now() null,
    update_time datetime default now() null
)
    comment '管理员角色对应表';

INSERT INTO `e-shop`.sys_admin_role (admin_id, role_id, is_delete, create_time, update_time) VALUES (1, 1, DEFAULT, DEFAULT, DEFAULT)

-- sys_role
create table sys_role
(
    id int,
    role_name nvarchar(20) null,
    is_delete tinyint default 0 null,
    create_time datetime default now() null,
    update_time datetime default now() null
);
    comment '角色表';

create unique index sys_role_id_uindex
	on sys_role (id);

alter table sys_role
    add constraint sys_role_pk
        primary key (id);

alter table sys_role modify id int auto_increment;

INSERT INTO `e-shop`.sys_role (role_name, is_delete, create_time, update_time) VALUES ('admin', DEFAULT, DEFAULT, DEFAULT)