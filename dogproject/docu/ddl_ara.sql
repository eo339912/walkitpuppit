
create table market(
seq number(20) constraint market_seq_pk primary key,
title varchar2(100),
content varchar2(1000),
okays char(2),
pimage varchar2(1000),
sselect varchar2(500),
regdt date,
filename varchar2(1000),
ftitle varchar2(100),
fcontent varchar2(1000),
fokays char(2),
fsselect varchar2(500),
fregdt date,
sell varchar2(30),
fsell varchar2(30),
fprice varchar2(30),
price varchar2(30),
id varchar2(20) constraint market_id_fk references member(id)
);

drop table market;

create table review(
seq number(20) constraint review_seq_pk primary key,
title varchar2(100),
content varchar2(1000),
okays char(2),
filename varchar2(1000),
regdt date,
cnt number(20),
id varchar2(20) constraint review_id_fk references member(id) on delete cascade);

create table mcomment(
id varchar2(20),
regdt date,
seq number(20) primary key,
m_seq number(20),
mcomment varchar2(1000),
CONSTRAINT mcomment_FK FOREIGN KEY (m_seq) REFERENCES market(seq) on delete cascade);

drop table mcomment;
drop table review;

CREATE SEQUENCE seq_market;
CREATE SEQUENCE seq_review;
CREATE SEQUENCE seq_member;
CREATE SEQUENCE seq_mcomment;