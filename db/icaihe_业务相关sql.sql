DROP TABLE IF EXISTS `ich_box_office`;

CREATE TABLE `ich_box_office` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `ich_id` varchar(100)  NOT NULL COMMENT 'ICHID',
  `office_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '归属公司',

  `create_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `ich_box_office_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='财盒机构关联表';


