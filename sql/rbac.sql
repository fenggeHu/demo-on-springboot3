CREATE TABLE `tb_resource` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `value` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '资源代码',
  `name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '资源名称',
  `type` tinyint DEFAULT '0' COMMENT '权限类型：1页面 2操作 3数据 0未知',
  `parent_id` bigint NOT NULL COMMENT '父级id，0是顶级',
  `status` tinyint DEFAULT '1' COMMENT '状态值 1启用 0禁用',
  `created_at` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `updated_at` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_value` (`value`),
  KEY `idx_status_type` (`status`,`type`),
  KEY `ix_parent` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='权限资源信息';

CREATE TABLE `tb_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色名称',
  `status` tinyint DEFAULT '1' COMMENT '状态值 1启用 0禁用',
  `created_at` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `updated_at` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `org_id` bigint NOT NULL COMMENT '机构id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_org_name` (`org_id`,`name`),
  KEY `ix_org` (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色信息 - 可按机构分别设置角色';

CREATE TABLE `tb_resource` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `value` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '资源代码',
  `name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '资源名称',
  `type` tinyint DEFAULT '0' COMMENT '权限类型：1页面 2操作 3数据 0未知',
  `parent_id` bigint NOT NULL COMMENT '父级id，0是顶级',
  `status` tinyint DEFAULT '1' COMMENT '状态值 1启用 0禁用',
  `created_at` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `updated_at` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_value` (`value`),
  KEY `idx_status_type` (`status`,`type`),
  KEY `ix_parent` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='权限资源信息';

CREATE TABLE `tb_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ouid` bigint NOT NULL COMMENT '机构用户id',
  `org_id` bigint NOT NULL COMMENT '(冗余)机构id',
  `user_id` bigint NOT NULL COMMENT '(冗余)用户id',
  `role_id` bigint NOT NULL COMMENT '角色id',
  `status` tinyint DEFAULT '1' COMMENT '状态值 1启用 0禁用',
  `created_at` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `updated_at` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_org_user_role` (`ouid`,`role_id`),
  KEY `ix_org` (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='（机构）用户与角色关系';
