/*
Navicat MySQL Result Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : db_mblog

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-01-18 22:17:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mto_channel
-- ----------------------------
DROP TABLE IF EXISTS `wangque_channel`;
CREATE TABLE `wangque_channel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key_` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `status` int(5) NOT NULL,
  `thumbnail` varchar(128) DEFAULT NULL,
  `weight` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mto_channel
-- ----------------------------
INSERT INTO `wangque_channel` VALUES ('1', 'banner', 'banner', '1', '', '3');
INSERT INTO `wangque_channel` VALUES ('2', 'blog', '博客', '0', '', '2');
INSERT INTO `wangque_channel` VALUES ('3', 'jotting', '随笔', '0', '', '1');
INSERT INTO `wangque_channel` VALUES ('4', 'share', '分享', '0', '', '0');

-- ----------------------------
-- Table structure for wangque_options
-- ----------------------------
DROP TABLE IF EXISTS `wangque_options`;
CREATE TABLE `wangque_options` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key_` varchar(32) DEFAULT NULL,
  `type` int(5) DEFAULT 0,
  `value` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wangque_options
-- ----------------------------
INSERT INTO `wangque_options` VALUES ('1', 'site_name', '0', 'Wangque');
INSERT INTO `wangque_options` VALUES ('2', 'site_domain', '0', 'http://mtons.com');
INSERT INTO `wangque_options` VALUES ('3', 'site_keywords', '0', 'mtons,博客,社区');
INSERT INTO `wangque_options` VALUES ('4', 'site_description', '0', 'Mtons, 做一个有内涵的技术社区');
INSERT INTO `wangque_options` VALUES ('5', 'site_metas', '0', '');
INSERT INTO `wangque_options` VALUES ('6', 'site_copyright', '0', 'Copyright © Mtons');
INSERT INTO `wangque_options` VALUES ('7', 'site_icp', '0', '');
INSERT INTO `wangque_options` VALUES ('8', 'qq_callback', '0', '');
INSERT INTO `wangque_options` VALUES ('9', 'qq_app_id', '0', '');
INSERT INTO `wangque_options` VALUES ('10', 'qq_app_key', '0', '');
INSERT INTO `wangque_options` VALUES ('11', 'weibo_callback', '0', '');
INSERT INTO `wangque_options` VALUES ('12', 'weibo_client_id', '0', '');
INSERT INTO `wangque_options` VALUES ('13', 'weibo_client_sercret', '0', '');
INSERT INTO `wangque_options` VALUES ('14', 'github_callback', '0', '');
INSERT INTO `wangque_options` VALUES ('15', 'github_client_id', '0', '');
INSERT INTO `wangque_options` VALUES ('16', 'github_secret_key', '0', '');

-- ----------------------------
-- Table structure for mto_user
-- ----------------------------
DROP TABLE IF EXISTS `wangque_user`;
CREATE TABLE `wangque_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `avatar` varchar(128) DEFAULT '/dist/images/ava/default.png',
  `email` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `status` int(5) NOT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `gender` int(5) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `comments` int(11) NOT NULL,
  `posts` int(11) NOT NULL,
  `signature` varchar(140) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_USERNAME` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mto_user
-- ----------------------------
INSERT INTO `wangque_user` VALUES ('1', 'admin', '小豆丁', 'https://en.gravatar.com/userimage/154673030/b9a54b5b990a61cc074668b2e2a0b8c0.png', 'example@mtons.com', '3TGCQF25BLHU9R7IQUITN0FCC5', '0', '2017-08-06 17:52:41', '2017-07-26 11:08:36', '2017-10-17 13:24:13', '0', '1', '0', '0', '');
