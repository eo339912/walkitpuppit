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


create table market(
seq number(20) constraint market_seq_pk primary key,
title varchar2(100),
content varchar2(1000),
okays char(2),
pimage varchar2(1000),
sselect varchar2(500),
regdt varchar2(60),
id varchar2(20) constraint market_id_fk references member(id)
);

CREATE SEQUENCE seq_mol
