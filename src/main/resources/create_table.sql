create table admin_info(
user_name VARCHAR(64),
password VARCHAR(256)
)
ENGINE= InnoDB
DEFAULT CHARACTER SET =utf8
COLLATE = utf8_general_ci;

CREATE TABLE `ztree` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `pid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `task_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(64) COLLATE utf8_bin NOT NULL,
  `type` varchar(16) COLLATE utf8_bin NOT NULL,
  `content` test COLLATE utf8_bin DEFAULT NULL,
  `owner` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `roler` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `group_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;