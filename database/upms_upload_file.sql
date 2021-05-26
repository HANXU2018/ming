/*
 Navicat Premium Data Transfer

 Source Server         : phpstudy
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : upms

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 26/05/2021 20:03:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for upms_upload_file
-- ----------------------------
DROP TABLE IF EXISTS `upms_upload_file`;
CREATE TABLE `upms_upload_file`  (
  `system_id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属用户\r\n',
  `basepath` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '根目录',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态(-1:黑名单,1:正常)',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名称',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `description` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统描述',
  `ctime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `orders` bigint(20) NOT NULL COMMENT '排序',
  PRIMARY KEY (`system_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
