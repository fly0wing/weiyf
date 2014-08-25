/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : billing_customer

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2014-08-25 14:34:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer_login
-- ----------------------------
DROP TABLE IF EXISTS `customer_login`;
CREATE TABLE `customer_login` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户标识',
  `login_name` varchar(32) DEFAULT NULL COMMENT '登录名',
  `login_email` varchar(64) DEFAULT NULL COMMENT '登录邮箱',
  `login_phone` varchar(16) DEFAULT NULL COMMENT '登录手机号',
  `nickname` varchar(32) NOT NULL COMMENT '昵称',
  `is_anonymous` bit(1) NOT NULL COMMENT '是否匿名',
  `current_password` varchar(60) DEFAULT NULL COMMENT '当前密码',
  `enabled` bit(1) NOT NULL COMMENT '可用',
  `first_session_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '首次会话标识',
  `require_password_change` bit(1) NOT NULL COMMENT '要求修改密码',
  `security_level` int(10) NOT NULL COMMENT '安全级别',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  `last_login_time` datetime NOT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_login_email` (`login_email`) USING BTREE,
  UNIQUE KEY `uniq_login_phone` (`login_phone`) USING BTREE,
  UNIQUE KEY `uniq_login_name` (`login_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录账号';

-- ----------------------------
-- Records of customer_login
-- ----------------------------

-- ----------------------------
-- Table structure for customer_session
-- ----------------------------
DROP TABLE IF EXISTS `customer_session`;
CREATE TABLE `customer_session` (
  `id` bigint(20) unsigned NOT NULL COMMENT '会话标识',
  `customer_id` bigint(20) unsigned NOT NULL COMMENT '用户标识',
  `party_id` bigint(20) NOT NULL COMMENT '商户标识',
  `product_id` bigint(20) unsigned NOT NULL COMMENT '产品标识',
  `domain_id` varchar(20) NOT NULL COMMENT '应用域标识',
  `app_id` bigint(20) unsigned NOT NULL COMMENT '应用标识',
  `entry_id` bigint(20) unsigned NOT NULL COMMENT '入口标识',
  `geo_id` bigint(20) unsigned NOT NULL COMMENT '地理标识',
  `is_anonymous` bit(1) NOT NULL COMMENT '是否匿名',
  `create_time` datetime NOT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户会话';

-- ----------------------------
-- Records of customer_session
-- ----------------------------

-- ----------------------------
-- Table structure for customer_terminal
-- ----------------------------
DROP TABLE IF EXISTS `customer_terminal`;
CREATE TABLE `customer_terminal` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户终端标识',
  `customer_id` bigint(20) unsigned NOT NULL COMMENT '用户标识',
  `terminal_id` bigint(20) unsigned NOT NULL COMMENT '终端标识',
  `terminal_name` varchar(32) NOT NULL COMMENT '终端名称',
  `bind_status_id` bigint(20) unsigned NOT NULL COMMENT '绑定状态标识',
  `current_op_time` datetime NOT NULL COMMENT '当前操作时间',
  `last_op_time` datetime NOT NULL COMMENT '上次操作时间',
  `first_bind_time` datetime NOT NULL COMMENT '首次绑定时间',
  `is_auto_login` bit(1) NOT NULL COMMENT '是否自动登录',
  `last_login_token` varchar(32) NOT NULL COMMENT '上次登录令牌',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户终端';

-- ----------------------------
-- Records of customer_terminal
-- ----------------------------

-- ----------------------------
-- Table structure for terminal
-- ----------------------------
DROP TABLE IF EXISTS `terminal`;
CREATE TABLE `terminal` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '终端标识',
  `fingerprint` varchar(32) NOT NULL COMMENT '终端指纹',
  `default_name` varchar(32) NOT NULL COMMENT '默认名称',
  `terminal_type_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '终端类型标识',
  `first_session_id` bigint(20) unsigned NOT NULL COMMENT '首次会话标识',
  `first_activate_time` datetime NOT NULL COMMENT '首次激活时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_terminal_fingerprint` (`fingerprint`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='终端';

-- ----------------------------
-- Records of terminal
-- ----------------------------

-- ----------------------------
-- Table structure for terminal_activate
-- ----------------------------
DROP TABLE IF EXISTS `terminal_activate`;
CREATE TABLE `terminal_activate` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '激活标识',
  `terminal_id` bigint(32) NOT NULL COMMENT '终端标识',
  `session_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '会话标识',
  `activate_time` datetime NOT NULL COMMENT '激活时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='终端激活';

-- ----------------------------
-- Records of terminal_activate
-- ----------------------------

-- ----------------------------
-- Table structure for terminal_type
-- ----------------------------
DROP TABLE IF EXISTS `terminal_type`;
CREATE TABLE `terminal_type` (
  `terminal_type_id` bigint(20) unsigned NOT NULL COMMENT '终端类型标识',
  `parent_type_id` bigint(20) unsigned NOT NULL COMMENT '父类型标识',
  `os_type` varchar(32) DEFAULT NULL COMMENT '操作系统类型',
  `screen_size_enum_id` bigint(20) unsigned NOT NULL COMMENT '屏幕尺寸枚举',
  `description` varchar(255) NOT NULL DEFAULT '0' COMMENT '描述',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后修改时间',
  `last_modified_by_user_login` varchar(64) DEFAULT NULL COMMENT '最后修改者',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `created_by_user_login` varchar(64) DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`terminal_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='终端类型';

-- ----------------------------
-- Records of terminal_type
-- ----------------------------
