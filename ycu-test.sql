/*
 Navicat Premium Data Transfer

 Source Server         : LocalHost
 Source Server Type    : MySQL
 Source Server Version : 50549
 Source Host           : localhost:3306
 Source Schema         : ycu-test

 Target Server Type    : MySQL
 Target Server Version : 50549
 File Encoding         : 65001

 Date: 05/07/2020 15:05:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `article_number` int(10) NOT NULL AUTO_INCREMENT,
  `article_title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `article_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `article_create` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `article_writer` int(20) NOT NULL,
  `article_avatarurl` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `article_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `article_level` int(5) DEFAULT 0,
  PRIMARY KEY (`article_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '标题一', '英国和法国对这项提案已经发表了一些反对意见。', '1566617562953', 10001, 'http://ycuming.com:81/10001.jpg', '小明', 0);
INSERT INTO `article` VALUES (2, '标题二', '一、发表的英语是publish,音标英 [ˈpʌblɪʃ]、美 [ˈpʌblɪʃ]。 二、释义: vt.& ...', '1666618573953', 10002, 'http://ycuming.com:81/10002.jpg', '小红', 0);
INSERT INTO `article` VALUES (3, '标题三', 'Oops my baby, you woke up in my bed：', '1666618573953', 10002, 'http://ycuming.com:81/10002.jpg', '小红', 0);
INSERT INTO `article` VALUES (4, '标题四', '现在是5月16日，距高考22天。 我也开始本能地害怕。 学习没学好，和几个同学的关系也没处理清楚，成为一名League of Legends职业选手的梦想更是遥不可及。 不喜欢什么“乾坤未定，你我皆是黑马。” 总要为慵懒买单。 19届考生加油！冲鸭！', '1777618573953', 10001, 'http://ycuming.com:81/10001.jpg', '小明', 0);
INSERT INTO `article` VALUES (5, '标题五', '英国和法国对这项提案已经发表了一些反对意见。', '1566617562953', 10001, 'http://ycuming.com:81/10001.jpg', '小明', 0);
INSERT INTO `article` VALUES (10, '标题六', '英国和法国对这项提案已经发表了一些反对意见。', '1566617562953', 10001, 'http://ycuming.com:81/10001.jpg', '小明', 0);
INSERT INTO `article` VALUES (11, '标题七', '英国和法国对这项提案已经发表了一些反对意见。', '1666617562953', 10002, 'http://ycuming.com:81/10002.jpg', '小红', 0);
INSERT INTO `article` VALUES (12, '标题八', '这项提案已经发表了一些反对意见。', '1666717562953', 10001, 'http://ycuming.com:81/10002.jpg', '小明', 0);
INSERT INTO `article` VALUES (13, '标题九', 'She said boy tell me honestly', '1555618573953', 10002, 'http://ycuming.com:81/10002.jpg', '小红', 1);
INSERT INTO `article` VALUES (14, '标题十', 'She said boy tell me honestly', '1555618573953', 10002, 'http://ycuming.com:81/10002.jpg', '小红', 1);
INSERT INTO `article` VALUES (15, '停水通知', 'She said boy tell me honestly', '1555618573953', 10002, 'http://ycuming.com:81/10002.jpg', '小红', 1);
INSERT INTO `article` VALUES (16, '停水通知', 'okokokokokokokokok', '1555618573953', 10002, 'http://ycuming.com:81/10002.jpg', '小红', 1);
INSERT INTO `article` VALUES (18, '停水通知', 'okokokokokokokokok', '1555618573953', 10002, 'http://ycuming.com:81/10002.jpg', '小红', 1);
INSERT INTO `article` VALUES (19, '停水通知', 'okokokokokokokokok', '1555618573953', 10002, 'http://ycuming.com:81/10002.jpg', '小红', 1);
INSERT INTO `article` VALUES (20, '停水通知', 'okokokokokokokokok', '1555618573953', 10002, 'http://ycuming.com:81/10002.jpg', '小红', 0);
INSERT INTO `article` VALUES (21, '停水通知', 'She said boy tell me honestly', '1555618573953', 10002, 'http://ycuming.com:81/10002.jpg', '小红', 0);

-- ----------------------------
-- Table structure for dorm
-- ----------------------------
DROP TABLE IF EXISTS `dorm`;
CREATE TABLE `dorm`  (
  `dorm_id` int(5) NOT NULL AUTO_INCREMENT,
  `dorm_belongto` int(3) NOT NULL,
  `dorm_gmtcreate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dorm_messgae` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`dorm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dorm
-- ----------------------------
INSERT INTO `dorm` VALUES (1, 1, '1553483223', '温度过高，当前温度为45°C');
INSERT INTO `dorm` VALUES (2, 1, '1553483223', '当前烟雾浓度过高！');
INSERT INTO `dorm` VALUES (3, 2, '1212121212', '当前湿度过高！');
INSERT INTO `dorm` VALUES (4, 1, '1570349812', ' 复旦一F201宿舍温度异常！可能发生火灾了！当前温度为40 验证码：250');
INSERT INTO `dorm` VALUES (5, 1, '1570349973', ' 复旦一F201宿舍温度异常！可能发生火灾了！当前温度为40 验证码：250');
INSERT INTO `dorm` VALUES (6, 1, '1573823853', ' 复旦二F202宿舍温度异常！可能发生火灾了！当前温度为30°C     验证码：250');
INSERT INTO `dorm` VALUES (7, 1, '1573823901', ' 复旦二F202宿舍温度异常！可能发生火灾了！当前温度为30°C     验证码：250');
INSERT INTO `dorm` VALUES (8, 1, '1573824267', ' 可能发生火灾了！ 复旦二F202宿舍温度异常！当前温度为30°C     验证码：250');
INSERT INTO `dorm` VALUES (9, 1, '1573824470', '  验证码：2500 可能发生火灾了！ 复旦二F202宿舍温度异常！当前温度为30°C    ');
INSERT INTO `dorm` VALUES (10, 1, '1573824867', '  验证码：2500 可能发生火灾了！ 复旦二F202宿舍温度异常！当前温度为30°C    ');
INSERT INTO `dorm` VALUES (11, 1, '1573825455', '  验证码：2500 可能发生火灾了！ 复旦二F202宿舍温度异常！当前温度为30°C    ');
INSERT INTO `dorm` VALUES (12, 1, '1573826761', '  复旦二F202宿舍温度异常  可能发生火灾了！当前温度为30°C  验证码：2500  ');
INSERT INTO `dorm` VALUES (13, 1, '1573833177', '  复旦二F202 可能发生漏水！ 当前水位为0.7  验证码：2500  ');

-- ----------------------------
-- Table structure for error
-- ----------------------------
DROP TABLE IF EXISTS `error`;
CREATE TABLE `error`  (
  `error_belongto` int(5) NOT NULL,
  `error_id` int(5) NOT NULL AUTO_INCREMENT,
  `error_dorm` int(5) NOT NULL,
  PRIMARY KEY (`error_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of error
-- ----------------------------
INSERT INTO `error` VALUES (1, 1, 1);
INSERT INTO `error` VALUES (1, 2, 2);
INSERT INTO `error` VALUES (2, 3, 3);
INSERT INTO `error` VALUES (1, 4, 4);
INSERT INTO `error` VALUES (1, 5, 5);
INSERT INTO `error` VALUES (1, 6, 6);
INSERT INTO `error` VALUES (1, 7, 7);
INSERT INTO `error` VALUES (1, 8, 8);
INSERT INTO `error` VALUES (1, 9, 9);
INSERT INTO `error` VALUES (1, 10, 10);
INSERT INTO `error` VALUES (1, 11, 11);
INSERT INTO `error` VALUES (1, 12, 12);
INSERT INTO `error` VALUES (1, 13, 13);

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `item_id` int(2) NOT NULL,
  `item_emperature` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `item_humidity` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ietm_potency` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `item_shuiwei` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `item_yudi` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `item_men` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `item_deng` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES (1, '30', '30', '3.212', '0.7', '1', '0', '1');

-- ----------------------------
-- Table structure for light
-- ----------------------------
DROP TABLE IF EXISTS `light`;
CREATE TABLE `light`  (
  `light_number` int(10) NOT NULL,
  `light_switch` int(10) DEFAULT NULL,
  `light_belongto` int(10) NOT NULL,
  `light_luminance` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `light_men` int(10) NOT NULL,
  `light_chuanglian` int(10) NOT NULL,
  PRIMARY KEY (`light_belongto`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of light
-- ----------------------------
INSERT INTO `light` VALUES (1, 1, 1, '13', 1, 1);
INSERT INTO `light` VALUES (2, 0, 2, '0', 0, 1);
INSERT INTO `light` VALUES (3, 0, 3, '0', 0, 0);

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `room_number` int(10) NOT NULL,
  `room_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `room_show` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `room_belongto` int(10) NOT NULL,
  PRIMARY KEY (`room_belongto`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, '复旦三F201', '0', 1);
INSERT INTO `room` VALUES (2, '复旦三F202', '0', 2);
INSERT INTO `room` VALUES (3, '复旦三F203', '0', 3);

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status`  (
  `status_number` int(10) NOT NULL AUTO_INCREMENT,
  `status_article` int(10) NOT NULL,
  `status_notifier` int(10) NOT NULL,
  `status_receiver` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status_rcondition` int(5) DEFAULT 0,
  `status_level` int(5) NOT NULL,
  PRIMARY KEY (`status_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES (1, 1, 10001, '2017100401', 1, 0);
INSERT INTO `status` VALUES (2, 10, 10001, '10002', 0, 0);
INSERT INTO `status` VALUES (3, 10, 10001, '2017100401', 1, 1);
INSERT INTO `status` VALUES (4, 10, 10001, '2017100402', 0, 0);
INSERT INTO `status` VALUES (5, 10, 10001, '2017100403', 0, 0);
INSERT INTO `status` VALUES (6, 10, 10001, '2017100404', 0, 0);
INSERT INTO `status` VALUES (7, 10, 10001, '2017100405', 0, 0);
INSERT INTO `status` VALUES (8, 10, 10001, '2017100406', 0, 0);
INSERT INTO `status` VALUES (9, 11, 10002, '10001', 1, 0);
INSERT INTO `status` VALUES (10, 11, 10002, '2017100401', 0, 0);
INSERT INTO `status` VALUES (11, 11, 10002, '2017100402', 1, 0);
INSERT INTO `status` VALUES (12, 11, 10002, '2017100403', 0, 0);
INSERT INTO `status` VALUES (13, 11, 10002, '2017100404', 0, 0);
INSERT INTO `status` VALUES (14, 11, 10002, '2017100405', 0, 0);
INSERT INTO `status` VALUES (15, 12, 10002, '2017100406', 1, 0);
INSERT INTO `status` VALUES (16, 13, 10002, '10001', 0, 0);
INSERT INTO `status` VALUES (17, 13, 10002, '2017100401', 0, 0);
INSERT INTO `status` VALUES (18, 13, 10002, '2017100402', 1, 1);
INSERT INTO `status` VALUES (19, 13, 10002, '2017100403', 0, 1);
INSERT INTO `status` VALUES (20, 13, 10002, '2017100404', 0, 1);
INSERT INTO `status` VALUES (21, 13, 10002, '2017100405', 0, 1);
INSERT INTO `status` VALUES (22, 13, 10002, '2017100406', 0, 1);
INSERT INTO `status` VALUES (23, 14, 10002, '10001', 0, 1);
INSERT INTO `status` VALUES (24, 14, 10002, '2017100401', 0, 1);
INSERT INTO `status` VALUES (25, 14, 10002, '2017100402', 0, 1);
INSERT INTO `status` VALUES (26, 14, 10002, '2017100403', 0, 1);
INSERT INTO `status` VALUES (27, 14, 10002, '2017100404', 0, 1);
INSERT INTO `status` VALUES (28, 14, 10002, '2017100405', 0, 1);
INSERT INTO `status` VALUES (29, 14, 10002, '2017100406', 0, 1);
INSERT INTO `status` VALUES (30, 15, 10002, '10001', 0, 1);
INSERT INTO `status` VALUES (31, 15, 10002, '2017100401', 0, 1);
INSERT INTO `status` VALUES (32, 15, 10002, '2017100402', 0, 1);
INSERT INTO `status` VALUES (33, 15, 10002, '2017100403', 0, 1);
INSERT INTO `status` VALUES (34, 15, 10002, '2017100404', 0, 0);
INSERT INTO `status` VALUES (35, 15, 10002, '2017100405', 0, 1);
INSERT INTO `status` VALUES (36, 15, 10002, '2017100406', 0, 0);
INSERT INTO `status` VALUES (37, 16, 10002, '10001', 0, 1);
INSERT INTO `status` VALUES (38, 16, 10002, '2017100401', 0, 0);
INSERT INTO `status` VALUES (39, 16, 10002, '2017100402', 0, 1);
INSERT INTO `status` VALUES (40, 16, 10002, '2017100403', 0, 1);
INSERT INTO `status` VALUES (41, 16, 10002, '2017100404', 0, 1);
INSERT INTO `status` VALUES (42, 16, 10002, '2017100405', 0, 0);
INSERT INTO `status` VALUES (43, 16, 10002, '2017100406', 0, 1);
INSERT INTO `status` VALUES (44, 18, 10002, '10001', 0, 1);
INSERT INTO `status` VALUES (45, 18, 10002, '2017100401', 0, 1);
INSERT INTO `status` VALUES (46, 18, 10002, '2017100402', 0, 1);
INSERT INTO `status` VALUES (47, 18, 10002, '2017100403', 0, 1);
INSERT INTO `status` VALUES (48, 18, 10002, '2017100404', 0, 1);
INSERT INTO `status` VALUES (49, 18, 10002, '2017100405', 0, 1);
INSERT INTO `status` VALUES (50, 18, 10002, '2017100406', 0, 1);
INSERT INTO `status` VALUES (51, 19, 10002, '10001', 0, 1);
INSERT INTO `status` VALUES (52, 19, 10002, '2017100401', 0, 1);
INSERT INTO `status` VALUES (53, 19, 10002, '2017100402', 0, 1);
INSERT INTO `status` VALUES (54, 19, 10002, '2017100403', 0, 1);
INSERT INTO `status` VALUES (55, 19, 10002, '2017100404', 0, 1);
INSERT INTO `status` VALUES (56, 19, 10002, '2017100405', 0, 1);
INSERT INTO `status` VALUES (57, 19, 10002, '2017100406', 0, 1);
INSERT INTO `status` VALUES (58, 20, 10002, '10001', 0, 0);
INSERT INTO `status` VALUES (59, 20, 10002, '2017100401', 0, 0);
INSERT INTO `status` VALUES (60, 20, 10002, '2017100402', 0, 0);
INSERT INTO `status` VALUES (61, 20, 10002, '2017100403', 0, 0);
INSERT INTO `status` VALUES (62, 20, 10002, '2017100404', 0, 0);
INSERT INTO `status` VALUES (63, 20, 10002, '2017100405', 0, 0);
INSERT INTO `status` VALUES (64, 20, 10002, '2017100406', 0, 0);
INSERT INTO `status` VALUES (65, 21, 10002, '10001', 0, 0);
INSERT INTO `status` VALUES (66, 21, 10002, '2017100401', 0, 0);
INSERT INTO `status` VALUES (67, 21, 10002, '2017100402', 0, 0);
INSERT INTO `status` VALUES (68, 21, 10002, '2017100403', 0, 0);
INSERT INTO `status` VALUES (69, 21, 10002, '2017100404', 0, 0);
INSERT INTO `status` VALUES (70, 21, 10002, '2017100405', 0, 0);
INSERT INTO `status` VALUES (71, 21, 10002, '2017100406', 0, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_number` int(20) NOT NULL,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_power` int(5) NOT NULL,
  `user_belongto` int(5) DEFAULT NULL,
  `user_avatarurl` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (10001, '小明', '123456', 1, 0, 'http://ycuming.com:81/10001.jpg', '1008611');
INSERT INTO `user` VALUES (10002, '小红', '123456', 1, 0, 'http://ycuming.com:81/10002.jpg', '1008622');
INSERT INTO `user` VALUES (2017100401, '张三', '123456', 3, 1, 'http://ycuming.com:81/2017100401.jpg', '15135964789');
INSERT INTO `user` VALUES (2017100402, '李四', '123456', 0, 1, 'http://ycuming.com:81/2017100402.jpg', '13233222720');
INSERT INTO `user` VALUES (2017100403, '王五', '123456', 0, 1, 'http://ycuming.com:81/2017100403.jpg', '15536261908');
INSERT INTO `user` VALUES (2017100404, '赵六', '123456', 3, 2, 'http://ycuming.com:81/2017100404.jpg', '13935110215');
INSERT INTO `user` VALUES (2017100405, '七哥', '123456', 0, 2, 'http://ycuming.com:81/2017100405.jpg', '13935110216');
INSERT INTO `user` VALUES (2017100406, '八神', '123456', 3, 3, 'http://ycuming.com:81/2017100406.jpg', '13935110217');

SET FOREIGN_KEY_CHECKS = 1;
