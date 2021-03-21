CREATE DATABASE IF NOT EXISTS `hmily_demo_account` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

USE `hmily_demo_account`;

DROP TABLE IF EXISTS `account_a`;
CREATE TABLE `account_a`
(
    `id`            BIGINT(20)     NOT NULL AUTO_INCREMENT,
    `user_id`       VARCHAR(128)   NOT NULL,
    `balance`       DECIMAL(10, 0) NOT NULL COMMENT '用户余额',
    `freeze_amount` DECIMAL(10, 0) NOT NULL COMMENT '冻结金额，扣款暂存余额',
    `create_time`   DATETIME       NOT NULL,
    `update_time`   DATETIME DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin;

INSERT INTO `account_a`(`id`, `user_id`, `balance`, `freeze_amount`, `create_time`, `update_time`)
VALUES
    (1, '10000', 10000000, 0, NOW(), NULL);

DROP TABLE IF EXISTS `account_b`;
CREATE TABLE `account_b`
(
    `id`            BIGINT(20)     NOT NULL AUTO_INCREMENT,
    `user_id`       VARCHAR(128)   NOT NULL,
    `balance`       DECIMAL(10, 0) NOT NULL COMMENT '用户余额',
    `freeze_amount` DECIMAL(10, 0) NOT NULL COMMENT '冻结金额，扣款暂存余额',
    `create_time`   DATETIME       NOT NULL,
    `update_time`   DATETIME DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin;

INSERT INTO `account_b`(`id`, `user_id`, `balance`, `freeze_amount`, `create_time`, `update_time`)
VALUES
    (1, '20000', 20000000, 0, NOW(), NULL);