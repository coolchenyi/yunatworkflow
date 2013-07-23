create table admin_info(
user_name VARCHAR(64),
password VARCHAR(256)
)
ENGINE= InnoDB
DEFAULT CHARACTER SET =utf8
COLLATE = utf8_general_ci;
--开发中心树
CREATE TABLE `ztree` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `pid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `task_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(64) COLLATE utf8_bin NOT NULL,
  `type` varchar(16) COLLATE utf8_bin NOT NULL,
  `content` text COLLATE utf8_bin DEFAULT NULL,
  `owner` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `roler` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `group_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
--开发中心附件
create table attachment(
fid varchar(32) not null,
task_id varchar(32) not null,
file_name varchar(64) not null,
description varchar(512),
PRIMARY KEY (fid)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
--开发中心参数配置
create table rule(
rid varchar(32) not null,
rule_type varchar(32) not null comment 'contant常量,variable变量,regex正则表达式',
original_value varchar(128) not null,
new_value varchar(128) not null,
task_id varchar(32) not null,
primary key(rid)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
