create table IF NOT EXISTS yms_user_info
(
  uid            int primary key not null auto_increment comment '用户id 主键',
  uname          varchar(64) not null comment '用户名' ,
  sex            bit(1) not null comment '性别',
  phone          char(11) not null comment '手机号',
  city           varchar(32) not null comment '城市',
  email          char(60) comment '电子邮箱',
  user_level          char(2) comment '用户等级',
  remark         varchar(128) comment '备注',
  updated_by     varchar(32) comment '修改人',
  updated_at     date comment '修改时间',
  created_at     date not null comment '创建时间',
  created_by     varchar(32) not null comment '创建人'

)comment='云梦丝用户表';


create index i_yms_user_info on yms_user_info(uid);

grant all on yms_user_info to root@'%';

flush privileges;