USE `test`;
CREATE TABLE `login_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `login_name` VARCHAR(20) DEFAULT NULL COMMENT '登录名',
  `mobile` BIGINT(20) DEFAULT '0' COMMENT '手机号',
  `gender` CHAR(1) DEFAULT NULL COMMENT '性别M男F女',
  `birthday` DATETIME DEFAULT NULL COMMENT '生日',
  `height` FLOAT DEFAULT NULL COMMENT '身高米',
  `wealth` DOUBLE DEFAULT '0' COMMENT '财富元',
  `enabled` TINYINT(1) DEFAULT NULL COMMENT '是否激活的',
  `description` TEXT COMMENT '描述',
  `image` BLOB COMMENT '头像',
  `status` INT(11) DEFAULT '1' COMMENT '状态不可逆:1正常2停止发放3作废未使用优惠券',
  `remark` VARCHAR(256) DEFAULT NULL COMMENT '后台备注',
  `create_by` BIGINT(20) DEFAULT NULL COMMENT '创建者ID',
  `create_on` DATETIME DEFAULT NULL COMMENT '创建时间',
  `modify_by` BIGINT(20) DEFAULT NULL COMMENT '更新者ID',
  `modify_on` DATETIME DEFAULT NULL COMMENT '更新时间',
  `version` INT(11) DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='测试用户表';