/*
 Navicat Premium Data Transfer

 Source Server         : 127
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : shiroadmin

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 22/10/2020 20:46:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_department
-- ----------------------------
DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门办公电话',
  `address` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '办公室地点',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_department
-- ----------------------------
INSERT INTO `tb_department` VALUES (1, '开发部', '15045755555', '开发部1001室', '2020-03-16 00:00:00', '2020-08-19 16:48:16');
INSERT INTO `tb_department` VALUES (2, '信息技术部', '15079451241', '采购中心', '2020-03-16 00:00:00', '2020-08-19 16:48:20');
INSERT INTO `tb_department` VALUES (3, '生活部', '18214521412', '3楼405房间', '2020-03-19 00:00:00', '2020-08-19 16:48:23');
INSERT INTO `tb_department` VALUES (4, '行政部', '15079457458', '3栋504房间', '2020-03-19 00:00:00', '2020-03-25 11:27:35');

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单/按钮ID',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上级菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单/按钮名称',
  `url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '权限标识',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `type` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型 0菜单 1按钮',
  `order_num` bigint(20) NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `modified_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `available` int(11) NULL DEFAULT 1 COMMENT '0：不可用，1：可用',
  `open` int(1) NULL DEFAULT 1 COMMENT '0:不展开，1：展开',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 344 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES (1, 0, '系统管理', '', NULL, 'el-icon-setting', '0', 1, '2020-03-07 17:41:30', '2020-08-19 17:57:20', 1, 0);
INSERT INTO `tb_menu` VALUES (2, 1, '菜单功能权限', '/menus', NULL, 'el-icon-help', '0', 3, '2020-03-07 18:57:42', '2020-03-20 11:50:46', 1, 0);
INSERT INTO `tb_menu` VALUES (3, 0, '用户管理', '/logs', NULL, 'el-icon-camera', '0', 6, '2020-03-07 18:58:18', '2020-05-07 19:35:19', 1, 0);
INSERT INTO `tb_menu` VALUES (4, 1, '日志管理', '/users', 'users', 'el-icon-user', '0', 2, '2020-03-10 05:27:54', '2020-04-23 20:04:36', 1, 0);

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `modified_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '是否可用,0:不可用，1：可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 79 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES (1, '系统管理员', '拥有系统的最高权限.', '2019-06-14 00:00:00', '2020-04-27 21:29:29', 1);
INSERT INTO `tb_role` VALUES (2, '功能管理员', '负责功能模块', '2019-06-14 20:49:22', '2019-11-11 16:46:57', 1);
INSERT INTO `tb_role` VALUES (3, '用户管理员', '负责用户模块管理', '2019-06-14 00:00:00', '2020-05-29 17:14:02', 1);

-- ----------------------------
-- Table structure for tb_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_menu`;
CREATE TABLE `tb_role_menu`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单/按钮ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role_menu
-- ----------------------------
INSERT INTO `tb_role_menu` VALUES (1, 1);
INSERT INTO `tb_role_menu` VALUES (1, 2);
INSERT INTO `tb_role_menu` VALUES (1, 3);
INSERT INTO `tb_role_menu` VALUES (3, 3);
INSERT INTO `tb_role_menu` VALUES (2, 2);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `avatar` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '头像',
  `phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `sex` int(1) NULL DEFAULT NULL COMMENT '性别 0男 1女 2保密',
  `status` int(1) NOT NULL COMMENT '状态 0锁定 1有效',
  `birth` date NULL DEFAULT NULL,
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `modified_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `type` int(11) NOT NULL DEFAULT 1 COMMENT '0:超级管理员，1：系统用户',
  `department_id` bigint(20) NULL DEFAULT 1 COMMENT '部门id',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'token',
  `version` int(11) NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(11) NOT NULL DEFAULT 0 COMMENT '0正常，1 删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'admin', '我是超级管理员', '542119880@qq.com', 'image/avatar/1.png', '18212121212', 0, 1, '2020-03-27', '2020-10-13 21:49:21', '2020-10-21 21:49:26', 0, 1, NULL, '1234', NULL, 1, 0);
INSERT INTO `tb_user` VALUES (2, 'Jesse', '我是系统监控员', '819334901@qq.com', 'image/avatar/1.png', '18212121212', 1, 1, '2019-10-20', '2020-10-30 21:58:37', '2020-10-31 21:58:41', 1, 2, NULL, '12345', NULL, 1, 0);
INSERT INTO `tb_user` VALUES (3, 'test', '我是用户管理员', '20100000@qq.com', 'image/avatar/1.png', '18212121212', 0, 1, '2020-04-29', '2020-10-20 18:54:44', '2020-10-22 18:54:48', 1, 3, NULL, '123456', NULL, 1, 0);

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES (1, 1);
INSERT INTO `tb_user_role` VALUES (1, 2);
INSERT INTO `tb_user_role` VALUES (1, 3);
INSERT INTO `tb_user_role` VALUES (2, 2);
INSERT INTO `tb_user_role` VALUES (3, 3);

SET FOREIGN_KEY_CHECKS = 1;
