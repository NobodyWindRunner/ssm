/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50539
Source Host           : 127.0.0.1:3306
Source Database       : ssms

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2017-12-25 10:23:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for db_department
-- ----------------------------
DROP TABLE IF EXISTS `db_department`;
CREATE TABLE `db_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of db_department
-- ----------------------------
INSERT INTO `db_department` VALUES ('1', '项目部');
INSERT INTO `db_department` VALUES ('2', '技术部');
INSERT INTO `db_department` VALUES ('3', '财务部');

-- ----------------------------
-- Table structure for db_employee
-- ----------------------------
DROP TABLE IF EXISTS `db_employee`;
CREATE TABLE `db_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DEPT_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pb2w7i8r3ku40leaqtp0or3vv` (`DEPT_ID`),
  CONSTRAINT `FK_pb2w7i8r3ku40leaqtp0or3vv` FOREIGN KEY (`DEPT_ID`) REFERENCES `db_department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of db_employee
-- ----------------------------
INSERT INTO `db_employee` VALUES ('20', '23', '李四', '女', '2');
INSERT INTO `db_employee` VALUES ('22', '23213', '3213124', '男', '1');
INSERT INTO `db_employee` VALUES ('25', '333333', '33333', '女', '2');
INSERT INTO `db_employee` VALUES ('26', '333', '张三', '男', '2');
INSERT INTO `db_employee` VALUES ('27', '3232', '323', '男', '2');
INSERT INTO `db_employee` VALUES ('28', '213213', '123213', '男', '3');
INSERT INTO `db_employee` VALUES ('29', '123123', '3123123', '男', '3');

-- ----------------------------
-- Table structure for db_menuinfo
-- ----------------------------
DROP TABLE IF EXISTS `db_menuinfo`;
CREATE TABLE `db_menuinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imgUrl` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `menuDesc` longtext COLLATE utf8_unicode_ci,
  `menuName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `menuUrl` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `orderNum` int(11) NOT NULL,
  `parentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of db_menuinfo
-- ----------------------------
INSERT INTO `db_menuinfo` VALUES ('1', '', '', '管理系统', '', '1', '0');
INSERT INTO `db_menuinfo` VALUES ('2', '', '', '系统设置', '', '0', '0');
INSERT INTO `db_menuinfo` VALUES ('3', '', '', '用户管理', '', '0', '1');
INSERT INTO `db_menuinfo` VALUES ('4', '', '', '用户添加', 'userinfo/new', '0', '3');
INSERT INTO `db_menuinfo` VALUES ('5', '', '', '用户列表', 'userinfo/list', '1', '3');
INSERT INTO `db_menuinfo` VALUES ('6', '', '', '项目管理', '', '1', '1');
INSERT INTO `db_menuinfo` VALUES ('7', '', '', '项目添加', 'project/new', '0', '6');
INSERT INTO `db_menuinfo` VALUES ('8', '', '', '项目列表', 'project/list', '1', '6');
INSERT INTO `db_menuinfo` VALUES ('9', '', '', '历史项目', 'project/hislist', '2', '6');
INSERT INTO `db_menuinfo` VALUES ('10', '', '', '部门管理', '', '2', '1');
INSERT INTO `db_menuinfo` VALUES ('11', '', '', '部门添加', 'department/new', '0', '10');
INSERT INTO `db_menuinfo` VALUES ('12', '', '', '部门列表', 'department/list', '1', '10');
INSERT INTO `db_menuinfo` VALUES ('13', '', '', '员工管理', '', '3', '1');
INSERT INTO `db_menuinfo` VALUES ('14', '', '', '员工添加', 'employee/new', '0', '13');
INSERT INTO `db_menuinfo` VALUES ('15', '', '', '员工列表', 'employee/list', '1', '13');
INSERT INTO `db_menuinfo` VALUES ('16', '', '', '菜单管理', '', '0', '2');
INSERT INTO `db_menuinfo` VALUES ('17', '', '', '菜单添加', '/yl/doctor/patient/list.do', '0', '16');
INSERT INTO `db_menuinfo` VALUES ('18', '', '', '菜单列表', '/yl/doctor/prescription/new.do', '1', '16');

-- ----------------------------
-- Table structure for db_project
-- ----------------------------
DROP TABLE IF EXISTS `db_project`;
CREATE TABLE `db_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `detail` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `proName` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `statusVal` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of db_project
-- ----------------------------
INSERT INTO `db_project` VALUES ('1', '保险后台管理系统,SSH', 'XX保险后台管理系统', '1');
INSERT INTO `db_project` VALUES ('2', '后台报表系统', 'XX银行后台报表系统', '2');
INSERT INTO `db_project` VALUES ('3', '自助贷款系统', 'XX银行自助贷款系统', '1');
INSERT INTO `db_project` VALUES ('4', '自助点单系统', 'XXKTV自助点单系统', '3');
INSERT INTO `db_project` VALUES ('5', '自助收费系统', 'XXKTV自助收费系统', '2');
INSERT INTO `db_project` VALUES ('8', 'SSMS', 'XX银行自助贷款系统SSMS', '1');

-- ----------------------------
-- Table structure for db_role
-- ----------------------------
DROP TABLE IF EXISTS `db_role`;
CREATE TABLE `db_role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of db_role
-- ----------------------------
INSERT INTO `db_role` VALUES ('0', '管理员');
INSERT INTO `db_role` VALUES ('1', '员工');

-- ----------------------------
-- Table structure for db_teacher
-- ----------------------------
DROP TABLE IF EXISTS `db_teacher`;
CREATE TABLE `db_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teaName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teaClass` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of db_teacher
-- ----------------------------

-- ----------------------------
-- Table structure for db_user
-- ----------------------------
DROP TABLE IF EXISTS `db_user`;
CREATE TABLE `db_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `statusVal` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of db_user
-- ----------------------------
INSERT INTO `db_user` VALUES ('2', 'admin', 'admin', '1');
INSERT INTO `db_user` VALUES ('3', 'user', 'user', '1');
INSERT INTO `db_user` VALUES ('4', 'zjr', 'zjr', '1');

-- ----------------------------
-- Table structure for db_user_role
-- ----------------------------
DROP TABLE IF EXISTS `db_user_role`;
CREATE TABLE `db_user_role` (
  `id` int(11) NOT NULL,
  `roleId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of db_user_role
-- ----------------------------
INSERT INTO `db_user_role` VALUES ('0', '0', '2');
INSERT INTO `db_user_role` VALUES ('1', '1', '3');
