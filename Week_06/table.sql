USE my_shop;
-- ----------------------------
-- User 用户表
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`
(
    `id`          BIGINT AUTO_INCREMENT                 NOT NULL COMMENT 'ID',
    `username`    VARCHAR(64)                           NOT NULL COMMENT '用户名',
    `nickname`    VARCHAR(64)                           NOT NULL COMMENT '昵称',
    `password`    VARCHAR(255)                          NOT NULL COMMENT '密码',
    `status`      TINYINT   DEFAULT 1                   NOT NULL COMMENT '状态：1启用，0禁用',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '更新时间',
    `create_by`   BIGINT                                NOT NULL COMMENT '创建者',
    `update_by`   BIGINT                                NOT NULL COMMENT '更新者',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT ='用户表';

-- ----------------------------
-- Catalog  商品类目表
-- ----------------------------
DROP TABLE IF EXISTS `t_catalog`;
CREATE TABLE `t_catalog`
(
    `id`          INT AUTO_INCREMENT                    NOT NULL COMMENT 'ID',
    `name`        VARCHAR(64)                           NOT NULL COMMENT '类目名称',
    `parent_id`   INT                                   NULL COMMENT '父类ID',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '更新时间',
    `create_by`   BIGINT                                NOT NULL COMMENT '创建者',
    `update_by`   BIGINT                                NOT NULL COMMENT '更新者',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT ='商品类目表';

-- ----------------------------
-- Goods    商品表
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`
(
    `id`          BIGINT AUTO_INCREMENT                 NOT NULL COMMENT 'ID',
    `name`        VARCHAR(255)                          NOT NULL COMMENT '商品名称',
    `image_url`   VARCHAR(255)                          NULL COMMENT '商品图片',
    `desc`        VARCHAR(255)                          NULL COMMENT '商品描述',
    `catalog_id`  INT                                   NULL COMMENT '商品类目ID',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '更新时间',
    `create_by`   BIGINT                                NOT NULL COMMENT '创建者',
    `update_by`   BIGINT                                NOT NULL COMMENT '更新者',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT ='商品表';

-- ----------------------------
-- Goods SKU (Stock Keeping Unit)    商品库存表
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku`;
CREATE TABLE `t_goods_sku`
(
    `id`          BIGINT AUTO_INCREMENT                 NOT NULL COMMENT 'ID',
    `goods_id`    BIGINT                                NOT NULL COMMENT '商品ID',
    `stock`       INT                                   NOT NULL COMMENT '库存',
    `price`       DECIMAL(10, 2)                        NOT NULL COMMENT '商品价格',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '更新时间',
    `create_by`   BIGINT                                NOT NULL COMMENT '创建者',
    `update_by`   BIGINT                                NOT NULL COMMENT '更新者',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT ='商品库存表';

-- ----------------------------
-- Order    订单表
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`
(
    `id`          BIGINT AUTO_INCREMENT                 NOT NULL COMMENT 'ID',
    `order_no`    VARCHAR(64)                           NOT NULL COMMENT '订单编号',
    `status`      TINYINT                               NOT NULL COMMENT '订单状态，0:未支付, 1:已完成 ,2:已取消 ,3:已退款 ',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '更新时间',
    `create_by`   BIGINT                                NOT NULL COMMENT '创建者',
    `update_by`   BIGINT                                NOT NULL COMMENT '更新者',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT ='订单表';

-- ----------------------------
-- Order Detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail`
(
    `id`          BIGINT AUTO_INCREMENT                 NOT NULL COMMENT 'ID',
    `order_id`    BIGINT                                NOT NULL COMMENT '订单ID',
    `goods_id`    BIGINT                                NOT NULL COMMENT '商品ID',
    `price`       DECIMAL(10, 2)                        NOT NULL COMMENT '明细价格',
    `count`       INT                                   NOT NULL COMMENT '商品数量',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '更新时间',
    `create_by`   BIGINT                                NOT NULL COMMENT '创建者',
    `update_by`   BIGINT                                NOT NULL COMMENT '更新者',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT ='订单明细表';