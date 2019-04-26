/*
Navicat MySQL Data Transfer

Source Server         : wechart-local
Source Server Version : 50505
Source Host           : 39.107.239.18:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-04-26 17:19:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '用户页面', 'user');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `password` varchar(100) NOT NULL,
  `username` varchar(20) NOT NULL COMMENT '用于登录的账号',
  `display_name` varchar(20) DEFAULT NULL COMMENT '显示的用户名',
  `email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `url` varchar(255) DEFAULT NULL COMMENT '个人主页',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `profile` varchar(255) DEFAULT NULL COMMENT '简介',
  `create_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '正常1，禁止登录0, 已删除-1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_user_username` (`username`) USING BTREE,
  UNIQUE KEY `uq_user_displayname` (`display_name`) USING BTREE,
  UNIQUE KEY `uq_user_email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'e10adc3949ba59abbe56e057f20f883e', 'zhangsan', null, null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  KEY `role_id` (`role_id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
