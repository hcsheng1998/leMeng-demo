/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 11/12/2020 16:36:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for discipline
-- ----------------------------
DROP TABLE IF EXISTS `discipline`;
CREATE TABLE `discipline`  (
  `pk_dis_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dis_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uk_dis_num` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`pk_dis_id`) USING BTREE,
  UNIQUE INDEX `discipline_uk_dis_num_uindex`(`uk_dis_num`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discipline
-- ----------------------------
INSERT INTO `discipline` VALUES (1, '语文', '001');
INSERT INTO `discipline` VALUES (2, '数学', '002');
INSERT INTO `discipline` VALUES (3, '英语', '003');
INSERT INTO `discipline` VALUES (4, '政治', '005');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `pk_stu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_num` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`pk_stu_id`) USING BTREE,
  UNIQUE INDEX `student_stu_num_uindex`(`stu_num`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'hcs', '001');
INSERT INTO `student` VALUES (2, 'lbq', '002');

-- ----------------------------
-- Table structure for student_discipline_mapping
-- ----------------------------
DROP TABLE IF EXISTS `student_discipline_mapping`;
CREATE TABLE `student_discipline_mapping`  (
  `pk_dis_id_mp` bigint(20) NOT NULL,
  `pk_stu_id_mp` bigint(20) NOT NULL,
  `grade` decimal(19, 2) NULL DEFAULT NULL,
  `pk_semester` smallint(6) NOT NULL DEFAULT 0,
  `pk_years` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '2020',
  PRIMARY KEY (`pk_dis_id_mp`, `pk_stu_id_mp`, `pk_years`, `pk_semester`) USING BTREE,
  INDEX `FKqnam6eswdlrq9ra6xvtvp3sm`(`pk_stu_id_mp`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of student_discipline_mapping
-- ----------------------------
INSERT INTO `student_discipline_mapping` VALUES (1, 1, 85.60, 0, '2020');
INSERT INTO `student_discipline_mapping` VALUES (2, 1, 88.62, 0, '2020');
INSERT INTO `student_discipline_mapping` VALUES (3, 1, 91.30, 0, '2020');
INSERT INTO `student_discipline_mapping` VALUES (1, 2, 95.60, 0, '2020');
INSERT INTO `student_discipline_mapping` VALUES (2, 2, 98.59, 0, '2020');
INSERT INTO `student_discipline_mapping` VALUES (3, 2, 98.39, 0, '2020');
INSERT INTO `student_discipline_mapping` VALUES (1, 1, 88.33, 1, '2019');
INSERT INTO `student_discipline_mapping` VALUES (2, 1, 86.26, 1, '2019');
INSERT INTO `student_discipline_mapping` VALUES (3, 1, 74.26, 1, '2019');
INSERT INTO `student_discipline_mapping` VALUES (1, 2, 99.36, 1, '2019');
INSERT INTO `student_discipline_mapping` VALUES (2, 2, 98.16, 1, '2019');
INSERT INTO `student_discipline_mapping` VALUES (3, 2, 68.36, 1, '2019');

-- ----------------------------
-- Table structure for student_teacher_mapping
-- ----------------------------
DROP TABLE IF EXISTS `student_teacher_mapping`;
CREATE TABLE `student_teacher_mapping`  (
  `pk_tea_id_mp` bigint(20) NOT NULL,
  `pk_stu_id_mp` bigint(20) NOT NULL,
  `pk_semester` smallint(6) NOT NULL DEFAULT 0,
  `pk_years` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '2020',
  PRIMARY KEY (`pk_tea_id_mp`, `pk_stu_id_mp`, `pk_years`, `pk_semester`) USING BTREE,
  INDEX `FK2sw2jfrk0rgag9c1it60083cx`(`pk_stu_id_mp`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of student_teacher_mapping
-- ----------------------------
INSERT INTO `student_teacher_mapping` VALUES (1, 1, 0, '2020');
INSERT INTO `student_teacher_mapping` VALUES (1, 2, 0, '2020');
INSERT INTO `student_teacher_mapping` VALUES (2, 1, 0, '2020');
INSERT INTO `student_teacher_mapping` VALUES (2, 2, 0, '2020');
INSERT INTO `student_teacher_mapping` VALUES (3, 1, 0, '2020');
INSERT INTO `student_teacher_mapping` VALUES (3, 2, 0, '2020');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `pk_tea_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tea_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tea_num` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`pk_tea_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '小语', '001');
INSERT INTO `teacher` VALUES (2, '小数', '002');
INSERT INTO `teacher` VALUES (3, '小英', '003');
INSERT INTO `teacher` VALUES (8, '外语', '006');

-- ----------------------------
-- Table structure for teacher_discipline_mapping
-- ----------------------------
DROP TABLE IF EXISTS `teacher_discipline_mapping`;
CREATE TABLE `teacher_discipline_mapping`  (
  `pk_dis_id_mp` bigint(20) NOT NULL,
  `pk_tea_id_mp` bigint(20) NOT NULL,
  `pk_semester` smallint(6) NOT NULL DEFAULT 0,
  `pk_years` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '2020',
  PRIMARY KEY (`pk_dis_id_mp`, `pk_tea_id_mp`, `pk_years`, `pk_semester`) USING BTREE,
  INDEX `FKc1f5d2sm3p5048wma97fjxtae`(`pk_tea_id_mp`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of teacher_discipline_mapping
-- ----------------------------
INSERT INTO `teacher_discipline_mapping` VALUES (1, 1, 0, '2020');
INSERT INTO `teacher_discipline_mapping` VALUES (2, 2, 0, '2020');
INSERT INTO `teacher_discipline_mapping` VALUES (3, 3, 0, '2020');

SET FOREIGN_KEY_CHECKS = 1;
