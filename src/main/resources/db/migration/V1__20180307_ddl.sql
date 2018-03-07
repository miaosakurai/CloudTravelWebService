/*
 Navicat Premium Data Transfer

 Source Server         : localhost-mysql
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : cloud_trip

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 03/07/2018 16:28:22 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `friend`
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `from_user_id` int(11) NOT NULL,
  `to_user_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`from_user_id`,`to_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `location`
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `location_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `level` tinyint(2) NOT NULL,
  `open_time` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `location_comment`
-- ----------------------------
DROP TABLE IF EXISTS `location_comment`;
CREATE TABLE `location_comment` (
  `location_comment_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `star` int(11) NOT NULL,
  `content` text NOT NULL,
  `photo` text NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`location_comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `moment`
-- ----------------------------
DROP TABLE IF EXISTS `moment`;
CREATE TABLE `moment` (
  `moment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `photo` text NOT NULL,
  `create_time` datetime NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`moment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `moment_comment`
-- ----------------------------
DROP TABLE IF EXISTS `moment_comment`;
CREATE TABLE `moment_comment` (
  `moment_comment_id` int(11) NOT NULL,
  `moment_id` int(11) NOT NULL,
  `commenter_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`moment_comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `schedule`
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `remark` text NOT NULL,
  `priority` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  `location_name` varchar(255) NOT NULL,
  PRIMARY KEY (`schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `search_history`
-- ----------------------------
DROP TABLE IF EXISTS `search_history`;
CREATE TABLE `search_history` (
  `search_history_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`search_history_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
