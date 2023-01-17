-- -- drop table if exists `Menu`;

-- create table Menu{
--     id int primary key not null auto_increment,
--     name varchar(1000),
--     price int
-- };

-- -- 서버가 다시 시작될때 알아서 읽힌다.
DROP TABLE IF EXISTS `MENU`;
CREATE TABLE MENU(
   ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   NAME VARCHAR(1000),
   PRICE INT);
INSERT INTO MENU(NAME,PRICE)
VALUES('아메리카노',4000);

INSERT INTO MENU(NAME,PRICE)
VALUES('카페라떼',4000);

INSERT INTO MENU(NAME,PRICE)
VALUES('아이스 아메리카노',4500);

insert into Menu(name, price)
values('민트초코',5500);

insert into Menu(name, price)
values('카페라떼',4500);

insert into Menu(name, price)
values('아이스 아메리카노',3000);