/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : topview

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 23/04/2020 23:00:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dragon
-- ----------------------------
DROP TABLE IF EXISTS `dragon`;
CREATE TABLE `dragon`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int(0) NOT NULL,
  `tribeid` int(0) NOT NULL,
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `health` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dragon
-- ----------------------------
INSERT INTO `dragon` VALUES (1, '永恒巨龙', 1, 1, '造成同等攻击力的伤害', '优');
INSERT INTO `dragon` VALUES (2, '降落', 2, 1, '喵', '良');
INSERT INTO `dragon` VALUES (3, '大表哥', 3, 1, '飞飞', '差');
INSERT INTO `dragon` VALUES (5, '233', 233, 233, '233', '233');
INSERT INTO `dragon` VALUES (7, '32', 32, 1, '32', '良');
INSERT INTO `dragon` VALUES (11, '死亡之翼', 23, 1, '23', '优');
INSERT INTO `dragon` VALUES (14, '永恒巨龙', 1, 1, '1', '差');
INSERT INTO `dragon` VALUES (16, '美味飞鱼', 1, 1, '炉石', '差');
INSERT INTO `dragon` VALUES (17, '永恒巨龙', 23, 13, '23', '敖');

-- ----------------------------
-- Table structure for tribe
-- ----------------------------
DROP TABLE IF EXISTS `tribe`;
CREATE TABLE `tribe`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tribe
-- ----------------------------
INSERT INTO `tribe` VALUES (1, '炉石', '200', '茂名', '传说');
INSERT INTO `tribe` VALUES (2, 'nice', '20', 'nice', '飞');
INSERT INTO `tribe` VALUES (3, 'wa', '131', 'gd', '23');
INSERT INTO `tribe` VALUES (4, 'ha', '23', 'tj', 'da');
INSERT INTO `tribe` VALUES (5, 'qq', '533', 'nj', '南京');
INSERT INTO `tribe` VALUES (6, 'ww', '222', 'nj', '南极');
INSERT INTO `tribe` VALUES (7, 'aa', '111', 'da', '大');
INSERT INTO `tribe` VALUES (8, 'bb', '22', 'sd', '时代');
INSERT INTO `tribe` VALUES (9, 'cc', '54', 'wq', '武器');
INSERT INTO `tribe` VALUES (10, 'dd', '57', 'sh', '上海');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `card` int(0) NOT NULL,
  `phone` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('233', '233', 'DragonTrainer', 1, 133, 133);
INSERT INTO `user` VALUES ('321', '321', 'Visiter', 2, 33, 33);
INSERT INTO `user` VALUES ('11', '123', 'Visiter', 3, 11, 11);
INSERT INTO `user` VALUES ('1', '1', 'DragonTrainer', 5, 1, 1);
INSERT INTO `user` VALUES ('2', '2', 'DragonTrainer', 6, 2, 2);
INSERT INTO `user` VALUES ('3', '3', 'DragonTrainer', 7, 3, 3);
INSERT INTO `user` VALUES ('4', '4', 'DragonTrainer', 8, 4, 4);
INSERT INTO `user` VALUES ('22', '22', 'Visiter', 9, 22, 22);
INSERT INTO `user` VALUES ('777', '777', 'DragonMother', 11, 666, 666);

SET FOREIGN_KEY_CHECKS = 1;
