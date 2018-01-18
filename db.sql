CREATE TABLE t_test (
	id int NOT NULL AUTO_INCREMENT primary key,
	name varchar(100) NULL,
	remark varchar(100) NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci ;


drop table  if exists t_test_uuid;
CREATE TABLE t_test_uuid (
	id   varchar(32) NOT null primary key,
	name varchar(100) NULL,
	age int not null default 0,
	remark varchar(100) NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci ;