SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------

CREATE TABLE IF NOT EXISTS `t_sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `modified_date` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `mailbox` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salt_value` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
);


--
-- DROP TABLE IF EXISTS `t_sys_user`;
-- CREATE TABLE `t_sys_user`  (
--   `id` bigint(20) NOT NULL AUTO_INCREMENT,
--   `created_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
--   `created_date` datetime NOT NULL,
--   `last_modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
--   `modify_date` datetime NOT NULL,
--   `version` bigint(20) NOT NULL,
--   `mailbox` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
--   `mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
--   `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
--   `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
--   `salt_value` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
--   PRIMARY KEY (`id`) USING BTREE
-- );