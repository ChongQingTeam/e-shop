-- create schemas
CREATE SCHEMA `e-shop` DEFAULT CHARACTER SET utf8mb4 ;

-- e_admin
create table sys_admin
(
    id int,
    username nvarchar(50) not null comment '登录用户名，login，唯一',
    password nvarchar(500) null,
    full_name nvarchar(20) null comment '真实姓名',
    mobile nvarchar(11) null comment '电话'
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


INSERT INTO `e-shop`.`sys_admin` (`username`, `password`, `full_name`, `mobile`) VALUES ('admin', '$2a$10$xk.8KkSOZRKzhsFVPWz9IOGHnAplWc8JMjKwb7lxi21MpTP51UVou', 'admin', '13000000000');
