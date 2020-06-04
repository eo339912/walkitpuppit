CREATE SEQUENCE seq_member;
create table member(
seq number(20), /*번호*/
id varchar2(20) primary key, /*아이디*/
pwd varchar2(60), /*비밀번호*/
name varchar2(20), /*회원이름*/
thumd varchar2(1000), /*회원사진*/
regdt date /*가입일자*/
);


CREATE SEQUENCE seq_puppy;
create table puppy(
seq number(20) primary key, /*번호*/
id varchar2(20) , /*아이디*/
pname varchar2(20), /*강아지이름*/
pbirth date, /*강아지 생일*/
pgender char(3), /*강아지 성별*/
pkind varchar2(30), /*강아지 종류*/
pimage varchar2(1000), /*강아지사진*/
CONSTRAINT puppy_FK FOREIGN KEY (id) REFERENCES member(id) on delete cascade
);

create table member(
seq number(20), /*번호*/
id varchar2(20) primary key, /*아이디*/
pwd varchar2(60), /*비밀번호*/
name varchar2(20), /*회원이름*/
pname varchar2(20), /*강아지이름*/
pbirth date, /*강아지 생일*/
pgender char(3), /*강아지 성별*/
pimage varchar2(1000), /*강아지사진*/
regdt date /*가입일자*/
);

CREATE SEQUENCE seq_board;
create table board(
seq number(20) primary key, /*번호*/
title varchar2(100) , /*제목*/
content varchar2(1000), /*내용*/
filename varchar2(1000), /*파일업로드*/
id varchar2(20), /*작성자*/
regdt date, /*등록일자*/
cnt number(20)
);

CREATE SEQUENCE seq_comments;
create table comments(
id varchar2(20),
regdt date,
seq number(20) primary key,
b_seq number(20),
commentsO varchar2(1000),
CONSTRAINT comment_FK FOREIGN KEY (b_seq) REFERENCES board(seq) on delete cascade
);


drop table comments;
drop table board;
drop table member;
drop table puppy;
drop table park;


select * from walk;
select * from park;
select * from walk where seq=28 and id='admin';
update walk set outpark=SYSDATE, incheck = 0  where seq=13

update park set senter = (
select sum(incheck) from walk where  p_seq = 586
) where seq = 586


UPDATE park A SET senter = (
SELECT sum(incheck) FROM walk B WHERE B.p_seq = A.seq);

select * from walk;
SELECT w.*, w.inpark 
FROM park p
INNER JOIN walk w ON p.seq = w.p_seq where p.seq = 205 and w.incheck = 1

select * from walk where p_seq = 205 and incheck = 1