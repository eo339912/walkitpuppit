create table member(
id varchar2(20) primary key,
pwd varchar2(60),
name varchar2(20),
hobby varchar2(20),
gender char(1),
religion char(3),
introduction varchar2(1000),
regdt date);

--drop table board;
CREATE SEQUENCE seq_board;
create table board(
seq number(20) primary key,
title varchar2(100),
contents varchar2(1000),
regdt date,
id varchar2(20),
CONSTRAINT board_FK FOREIGN KEY (id) REFERENCES member(id)
);

alter table board add filename varchar2(100);



