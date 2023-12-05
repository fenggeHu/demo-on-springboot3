CREATE TABLE `tb_org` (
  `id` bigint NOT NULL COMMENT '机构id',
  `name` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '简称',
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '全称',
  `email` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系电话',
  `host` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '域名',
  `homepage` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '首页',
  `contact` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人',
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `level` int NOT NULL DEFAULT '0' COMMENT '会员等级-级别0~9,默认0',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态值 1启用 0禁用',
  `created_at` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `updated_at` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `parent_id` bigint DEFAULT '0' COMMENT '上级机构id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='组织机构基本信息';

CREATE TABLE `tb_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户数字ID',
  `username` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `email` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱地址',
  `default_language` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '默认语言',
  `real_name` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '姓名',
  `area_code` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机区号',
  `telephone` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号码',
  `password` varchar(250) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `status` tinyint NOT NULL COMMENT '状态值 1启用 0禁用',
  `created_at` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `updated_at` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `created_ip` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户注册IP',
  `bind_ga` tinyint NOT NULL DEFAULT '0' COMMENT '是否绑定GA 0未绑定 1绑定',
  `ga_key` varchar(40) COLLATE utf8mb4_bin DEFAULT '' COMMENT 'GA key',
  `bind_phone` tinyint NOT NULL DEFAULT '0' COMMENT '是否绑定手机 0未绑定 1绑定',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_username` (`username`),
  KEY `ix_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户基本信息';

CREATE TABLE `tb_org_user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '机构用户ID',
  `org_id` bigint NOT NULL COMMENT '机构id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `position` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '职位',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '简介',
  `status` tinyint NOT NULL COMMENT '状态值 1启用 0禁用',
  `created_at` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `updated_at` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_org_user` (`org_id`,`user_id`),
  KEY `ix_org` (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='组织机构下的用户';
