/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.21-log : Database - sq_users
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`com_permission` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `com_permission`;

/*Table structure for table `sys_button` */

DROP TABLE IF EXISTS `sys_button`;

CREATE TABLE `sys_button` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '按钮ID',
  `name` VARCHAR(20) NOT NULL COMMENT '按钮名称',
  `icon` VARCHAR(32) DEFAULT NULL COMMENT '按钮图标',
  `menu_id` INT(11) NOT NULL COMMENT '菜单ID',
  `request_type` VARCHAR(10) NOT NULL DEFAULT 'GET' COMMENT '请求类型：GET 或 POST',
  `enabled` TINYINT(1) DEFAULT '1' COMMENT '是否可用 1：启用 0：禁用',
  `version` INT(4) DEFAULT '1' COMMENT '版本号，乐观锁，防止重复提交数据。',
  `create_user_id` INT(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update_user_id` INT(11) DEFAULT NULL COMMENT '最后修改人ID',
  `last_update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

/*Data for the table `sys_button` */

INSERT  INTO `sys_button`(`id`,`name`,`icon`,`menu_id`,`request_type`,`enabled`,`version`,`create_user_id`,`create_time`,`last_update_user_id`,`last_update_time`) VALUES 
(1,'新增',NULL,3,'GET',1,1,NULL,'2019-04-30 08:56:39',NULL,'2019-04-30 08:56:39'),
(2,'修改',NULL,3,'GET',1,1,NULL,'2019-04-30 08:57:18',NULL,'2019-04-30 08:57:18'),
(3,'删除',NULL,3,'GET',1,1,NULL,'2019-04-30 08:57:54',NULL,'2019-04-30 08:57:54'),
(100,'100按钮','sys-button100-icon',2,'GET',1,1,NULL,'2019-05-07 08:18:06',NULL,'2019-05-07 08:18:06'),
(101,'new按钮','sys-buttonNew-icon',2,'GET',1,1,NULL,'2019-05-07 08:22:06',NULL,'2019-05-07 08:22:06'),
(102,'测试按钮','string',3,'POST',0,3,NULL,'2019-05-14 14:17:21',NULL,'2019-05-14 14:39:37');

/*Table structure for table `sys_group_role_pk` */

DROP TABLE IF EXISTS `sys_group_role_pk`;

CREATE TABLE `sys_group_role_pk` (
  `group_id` INT(11) UNSIGNED NOT NULL COMMENT '用户组ID',
  `role_id` INT(11) UNSIGNED NOT NULL COMMENT '角色ID',
  KEY `group_id` (`group_id`),
  KEY `fk_role_id` (`role_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_group_role_pk` */

INSERT  INTO `sys_group_role_pk`(`group_id`,`role_id`) VALUES 
(5,1),
(5,2),
(5,3);

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `parent_id` INT(11) NOT NULL DEFAULT '0' COMMENT '父菜单ID',
  `name` VARCHAR(50) NOT NULL COMMENT '菜单名称',
  `url` VARCHAR(255) NOT NULL COMMENT '菜单链接',
  `icon` VARCHAR(50) DEFAULT NULL COMMENT '菜单图标',
  `sort` INT(11) DEFAULT NULL COMMENT '菜单序号',
  `level` SMALLINT(2) NOT NULL DEFAULT '1' COMMENT '菜单层级',
  `leaf` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '菜单是否叶子节点（1：是 0：否）',
  `enabled` TINYINT(1) NOT NULL DEFAULT '1' COMMENT '是否可用 1：启用 0：禁用',
  `version` INT(4) DEFAULT '1' COMMENT '版本号，乐观锁，防止重复提交数据。',
  `description` VARCHAR(200) DEFAULT NULL COMMENT '描述',
  `create_user_id` INT(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update_user_id` INT(11) DEFAULT NULL COMMENT '最后修改人ID',
  `last_update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu` */

INSERT  INTO `sys_menu`(`id`,`parent_id`,`name`,`url`,`icon`,`sort`,`level`,`leaf`,`enabled`,`version`,`description`,`create_user_id`,`create_time`,`last_update_user_id`,`last_update_time`) VALUES 
(1,0,'系统管理','http://localhost:8091/m/sys/menu/1',NULL,1,1,0,1,1,NULL,NULL,'2019-04-29 00:03:52',NULL,'2019-04-29 00:03:52'),
(2,0,'用户管理','http://localhost:8091/m/sys/user/page',NULL,2,1,0,1,1,NULL,NULL,'2019-04-29 00:04:40',NULL,'2019-04-29 00:04:40'),
(3,0,'菜单管理','http://localhost:8091/m/sys/menu/page',NULL,3,1,0,1,1,NULL,NULL,'2019-04-29 00:05:02',NULL,'2019-04-29 00:05:02'),
(4,0,'按钮管理','http://localhost:8091/m/sys/button/page',NULL,4,1,0,1,1,NULL,NULL,'2019-04-29 00:05:13',NULL,'2019-04-29 00:05:13'),
(5,0,'用户组管理','http://localhost:8091/m/sys/group/page',NULL,5,1,0,1,1,NULL,NULL,'2019-04-29 00:05:28',NULL,'2019-04-29 00:05:28'),
(6,2,'新增用户','http://localhost:8091/m/sys/user/add',NULL,6,2,0,1,1,NULL,NULL,'2019-04-29 00:06:45',NULL,'2019-04-29 00:06:45'),
(7,2,'修改用户','http://localhost:8091/m/sys/user/update',NULL,7,2,0,1,1,NULL,NULL,'2019-04-29 00:06:57',NULL,'2019-04-29 00:06:57'),
(8,2,'删除用户','http://localhost:8091/m/sys/user/delete',NULL,8,2,0,1,1,NULL,NULL,'2019-04-29 00:07:15',NULL,'2019-04-29 00:07:15'),
(9,2,'查看用户详情','http://localhost:8091/m/sys/user/detail',NULL,9,2,0,1,1,NULL,NULL,'2019-04-29 00:07:31',NULL,'2019-04-29 00:07:31'),
(10,8,'删除单个用户','http://localhost:8091/m/sys/user/delete_one',NULL,0,3,0,1,1,NULL,NULL,'2019-04-29 00:08:27',NULL,'2019-04-29 00:08:27'),
(11,8,'批量删除用户','http://localhost:8091/m/sys/user/delete_batch',NULL,11,3,0,1,1,NULL,NULL,'2019-04-29 00:08:56',NULL,'2019-04-29 00:08:56');

/*Table structure for table `sys_permission` */

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(32) NOT NULL COMMENT '权限名称',
  `description` VARCHAR(200) DEFAULT NULL COMMENT '权限描述',
  `state` TINYINT(1) NOT NULL DEFAULT '1' COMMENT '权限状态1：启用  0：禁用',
  `version` SMALLINT(4) DEFAULT '1' COMMENT '版本号，乐观锁，防止重复提交数据。',
  `create_user_id` INT(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update_user_id` INT(11) DEFAULT NULL COMMENT '最后修改人ID',
  `last_update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sys_permission` */

INSERT  INTO `sys_permission`(`id`,`name`,`description`,`state`,`version`,`create_user_id`,`create_time`,`last_update_user_id`,`last_update_time`) VALUES 
(1,'超级管理员权限','超级管理员权限描述',1,1,NULL,'2019-04-30 08:43:15',NULL,'2019-04-30 08:43:15'),
(2,'普通管理员权限','普通管理员权限描述',1,1,NULL,'2019-04-30 08:43:41',NULL,'2019-04-30 08:43:41'),
(3,'普通用户权限','普通用户权限描述',1,1,NULL,'2019-04-30 08:44:03',NULL,'2019-04-30 08:44:03'),
(5,'测试用户权限','测试用户权限描述',1,1,NULL,'2019-04-30 08:48:38',NULL,'2019-04-30 08:48:38');

/*Table structure for table `sys_permission_resource_pk` */

DROP TABLE IF EXISTS `sys_permission_resource_pk`;

CREATE TABLE `sys_permission_resource_pk` (
  `permission_id` INT(11) UNSIGNED NOT NULL COMMENT '权限ID',
  `resource_type` VARCHAR(20) NOT NULL COMMENT '资源类型:Menu、Button',
  `resource_id` INT(11) UNSIGNED NOT NULL COMMENT '资源ID：菜单ID、按钮ID'
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_permission_resource_pk` */

INSERT  INTO `sys_permission_resource_pk`(`permission_id`,`resource_type`,`resource_id`) VALUES 
(5,'Menu',2),
(5,'Menu',3),
(5,'Button',1),
(5,'Button',2),
(5,'Button',3);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` VARCHAR(50) NOT NULL COMMENT '角色名称',
  `state` TINYINT(1) NOT NULL DEFAULT '1' COMMENT '角色状态 1：有效 0：无效',
  `description` VARCHAR(200) DEFAULT NULL COMMENT '角色描述',
  `create_user_id` INT(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update_user_id` INT(11) DEFAULT NULL COMMENT '最后修改人ID',
  `last_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `version` INT(4) DEFAULT '1' COMMENT '版本号，乐观锁，防止重复提交数据。',
  PRIMARY KEY (`id`),
  KEY `role_name` (`name`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

INSERT  INTO `sys_role`(`id`,`name`,`state`,`description`,`create_user_id`,`create_time`,`last_update_user_id`,`last_update_time`,`version`) VALUES 
(1,'超级管理员',1,'可以管理数据库所有资源的。包括可查看被禁用的菜单、按钮信息',1,'2019-04-15 00:00:00',1,'2019-04-18 14:44:18',1),
(2,'总经理',1,'总经理描述',NULL,'2019-04-28 11:27:33',NULL,'2019-04-28 11:27:33',1),
(3,'经理',1,'经理描述',NULL,'2019-04-28 11:28:02',NULL,'2019-04-28 11:28:02',1);

/*Table structure for table `sys_role_permission_pk` */

DROP TABLE IF EXISTS `sys_role_permission_pk`;

CREATE TABLE `sys_role_permission_pk` (
  `role_id` INT(11) UNSIGNED NOT NULL COMMENT '角色ID',
  `permission_id` INT(11) UNSIGNED NOT NULL COMMENT '权限ID'
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_permission_pk` */

INSERT  INTO `sys_role_permission_pk`(`role_id`,`permission_id`) VALUES 
(3,3),
(3,5),
(2,1),
(2,2);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` VARCHAR(50) NOT NULL COMMENT '登录名称',
  `password` VARCHAR(50) NOT NULL COMMENT '登录密码',
  `real_name` VARCHAR(50) DEFAULT NULL COMMENT '真实名称',
  `sex` SMALLINT(2) DEFAULT '2' COMMENT '性别0：男 1：女 2：其他',
  `birthday` DATE DEFAULT NULL COMMENT '生日',
  `email` VARCHAR(32) DEFAULT NULL COMMENT '邮箱地址',
  `telephone` VARCHAR(20) DEFAULT NULL COMMENT '手机号码',
  `province_code` VARCHAR(20) DEFAULT NULL COMMENT '地址',
  `province_name` VARCHAR(200) DEFAULT NULL,
  `city_code` VARCHAR(20) DEFAULT NULL COMMENT '详细地址',
  `city_name` VARCHAR(200) DEFAULT NULL,
  `district_code` VARCHAR(20) DEFAULT NULL COMMENT '邮政编码',
  `district_name` VARCHAR(200) DEFAULT NULL,
  `id_card` VARCHAR(32) DEFAULT NULL COMMENT '身份证号码',
  `state` SMALLINT(2) DEFAULT '1' COMMENT '状态：1：在职 2：离职 3：停职 4：退休',
  `create_user_id` INT(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update_user_id` INT(11) DEFAULT NULL COMMENT '最后修改人ID',
  `last_update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `version` INT(4) DEFAULT '1' COMMENT '版本号，乐观锁，防止重复提交数据。',
  PRIMARY KEY (`id`),
  KEY `real_name` (`real_name`)
) ENGINE=INNODB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

INSERT  INTO `sys_user`(`id`,`username`,`password`,`real_name`,`sex`,`birthday`,`email`,`telephone`,`province_code`,`province_name`,`city_code`,`city_name`,`district_code`,`district_name`,`id_card`,`state`,`create_user_id`,`create_time`,`last_update_user_id`,`last_update_time`,`version`) VALUES 
(1,'root','root','超级管理员',0,'2019-04-29',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,'2019-04-18 00:00:00',0,'2019-04-29 15:11:20',1),
(2,'direnjie','ucKHjVMqRgEQN5Y8sZrOEQ==','狄仁杰',0,'1992-01-01','11223344@qq.com','188012345678','湖北武汉市','湖北','东湖高新区武大科技园',NULL,'430061',NULL,'42010619910616122X',1,NULL,'2019-04-24 09:47:20',NULL,'2019-04-29 14:18:05',1),
(3,'sunce','ucKHjVMqRgEQN5Y8sZrOEQ==','孙策',0,'1992-12-13','87654321@qq.com','18802096666','湖北武汉市','湖北','汉阳区王家湾',NULL,'430061',NULL,'420106199106161235',1,NULL,'2019-04-24 07:50:24',NULL,'2019-04-29 14:18:05',1),
(6,'baozheng','4Pu54T4+5Vl3VZUH7Ni4Lw==','包拯',0,'1992-01-13','88865231@qq.com','18802090000','湖北武汉市','湖北','汉阳区王家湾',NULL,'430061',NULL,'420106199106161235',1,NULL,'2019-04-24 09:45:24',NULL,'2019-04-29 14:18:07',1),
(7,'yuanfang','w6fNvwQGKC5J2b4I5JD3aQ==','元芳',0,'1792-01-13','77775231@qq.com','18802097777',NULL,NULL,NULL,NULL,NULL,NULL,'420106199106161235',1,NULL,'2019-04-29 15:27:55',NULL,'2019-04-29 15:27:55',1);

/*Table structure for table `sys_user_group` */

DROP TABLE IF EXISTS `sys_user_group`;

CREATE TABLE `sys_user_group` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '组ID',
  `name` VARCHAR(50) NOT NULL COMMENT '组名称',
  `description` VARCHAR(200) DEFAULT NULL COMMENT '组描述',
  `create_user_id` INT(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update_user_id` INT(11) DEFAULT NULL COMMENT '最后修改人ID',
  `last_update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `version` INT(4) DEFAULT '1' COMMENT '版本号，乐观锁，防止重复提交数据。',
  PRIMARY KEY (`id`),
  KEY `group_name` (`name`)
) ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_group` */

INSERT  INTO `sys_user_group`(`id`,`name`,`description`,`create_user_id`,`create_time`,`last_update_user_id`,`last_update_time`,`version`) VALUES 
(2,'系统管理员','系统管理员描述',NULL,'2019-04-24 10:01:20',NULL,'2019-04-24 10:01:20',1),
(3,'超级管理员','超级管理员描述',NULL,'2019-04-24 10:01:28',NULL,'2019-04-24 10:01:28',1),
(4,'普通管理员','普通管理员描述',NULL,'2019-04-24 10:43:24',NULL,'2019-04-24 10:43:24',1),
(5,'普通用户','普通用户描述',NULL,'2019-04-24 10:45:30',NULL,'2019-04-24 18:45:46',1);

/*Table structure for table `sys_user_group_pk` */

DROP TABLE IF EXISTS `sys_user_group_pk`;

CREATE TABLE `sys_user_group_pk` (
  `user_id` INT(11) UNSIGNED NOT NULL COMMENT '用户ID',
  `group_id` INT(11) UNSIGNED NOT NULL COMMENT '用户组ID',
  KEY `user_id` (`user_id`),
  KEY `group_id` (`group_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_group_pk` */

INSERT  INTO `sys_user_group_pk`(`user_id`,`group_id`) VALUES 
(2,5),
(3,5),
(6,5);

/*Table structure for table `sys_user_role_pk` */

DROP TABLE IF EXISTS `sys_user_role_pk`;

CREATE TABLE `sys_user_role_pk` (
  `user_id` INT(11) UNSIGNED NOT NULL COMMENT '用户ID',
  `role_id` INT(11) UNSIGNED NOT NULL COMMENT '角色ID',
  KEY `user_id` (`user_id`),
  KEY `user_role` (`user_id`,`role_id`),
  KEY `fk_ur_role_id` (`role_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role_pk` */

INSERT  INTO `sys_user_role_pk`(`user_id`,`role_id`) VALUES 
(1,1),
(2,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
