CREATE SEQUENCE seq_member;
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
title varchar2(100) , /*내용*/
content varchar2(1000), /*내용*/
filename varchar2(1000), /*파일업로드*/
regdt date /*등록일자*/
);

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



