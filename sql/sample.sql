-- 用户表
create table sys_user
(
    id           bigint                               not null comment '主键'
        primary key,
    user_account varchar(255)                         not null comment '用户账号',
    password     varchar(1024)                        not null comment '用户密码',
    user_name    varchar(255)                         null comment '用户昵称',
    user_email   varchar(255)                         null comment '用户邮箱',
    user_phone   varchar(255)                         null comment '用户电话',
    user_address varchar(255)                         null comment '用户地址',
    user_profile text                                 null comment '用户简介',
    user_role    tinyint(1) default 0                 null comment '用户权限 0 - 普通用户 1 - 管理员',
    user_status  tinyint(1) default 1                 not null comment '用户状态 0 - 无效 1 - 有效',
    create_time  datetime   default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time  datetime   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
);