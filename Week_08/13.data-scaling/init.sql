--  # sharding sphere scaling
CREATE SCHEMA demo_ds;
CREATE TABLE IF NOT EXISTS demo_ds.t_order
(
    order_id BIGINT NOT NULL AUTO_INCREMENT,
    user_id  INT    NOT NULL,
    status   VARCHAR(50),
    PRIMARY KEY (order_id)
) ENGINE = InnoDB,
  CHARSET = utf8mb4;

CREATE USER 'scaling'@'localhost' IDENTIFIED BY 'scaling';
GRANT ALL ON *.* TO 'scaling'@'localhost';
FLUSH PRIVILEGES;