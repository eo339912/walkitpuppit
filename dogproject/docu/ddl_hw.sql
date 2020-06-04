 CREATE TABLE "WP"."PARK" 
   (	"SEQ" NUMBER(20,0) primary key, 
	"SNAME" VARCHAR2(60 BYTE), 
	"X" NUMBER(15,10), 
	"Y" NUMBER(15,10), 
	"SPOTNUM" VARCHAR2(30 BYTE), 
	"SPOTNM" VARCHAR2(60 BYTE), 
	"SENTER" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

CREATE SEQUENCE seq_parkco;
create table parkcomments(
pseq number(20) ,
seq number(20),
id varchar2(20) ,
comments varchar2(1000),
regdt date ,
CONSTRAINT comments_PK PRIMARY KEY (seq),
CONSTRAINT comments_FK FOREIGN KEY (pseq) REFERENCES park(seq)
)

CREATE SEQUENCE seq_walk;
create table walk(
seq number(20) PRIMARY KEY,
p_seq NUMBER(20,0),
id varchar2(20),
inpark date ,
outpark  date,
incheck number(2),
CONSTRAINT walk_FK FOREIGN KEY (id) REFERENCES member(id),
CONSTRAINT w_seq_FK FOREIGN KEY (p_seq) REFERENCES park(seq)
);

drop table walk;

CREATE SEQUENCE seq_message;
create table message(
seq number(20),
userid varchar2(20),
m_id varchar2(20),
title varchar2(100),
contents VARCHAR2(500),
REGDT date ,
CONSTRAINT message_PK PRIMARY KEY (seq),
CONSTRAINT message_FK FOREIGN KEY (m_id) REFERENCES member(id)
);
drop table message;

alter table walk 
add (sname VARCHAR2(60));

alter table walk add FOREIGN KEY(sname) REFERENCES park(sname);

add CONSTRAINT walks_FK FOREIGN KEY (sname) REFERENCES park(sname);

select * from walk
D
  