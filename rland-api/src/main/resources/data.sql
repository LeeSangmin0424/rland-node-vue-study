-- -- drop table if exists `Menu`;

-- create table Menu{
--     id int primary key not null auto_increment,
--     name varchar(1000),
--     price int
-- };

-- -- ������ �ٽ� ���۵ɶ� �˾Ƽ� ������.
DROP TABLE IF EXISTS `MENU`;
CREATE TABLE MENU(
   ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   NAME VARCHAR(1000),
   PRICE INT);
INSERT INTO MENU(NAME,PRICE)
VALUES('�Ƹ޸�ī��',4000);

INSERT INTO MENU(NAME,PRICE)
VALUES('ī���',4000);

INSERT INTO MENU(NAME,PRICE)
VALUES('���̽� �Ƹ޸�ī��',4500);

insert into Menu(name, price)
values('��Ʈ����',5500);

insert into Menu(name, price)
values('ī���',4500);

insert into Menu(name, price)
values('���̽� �Ƹ޸�ī��',3000);