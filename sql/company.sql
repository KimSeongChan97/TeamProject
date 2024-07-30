create table company(
name varchar2(15) not null,     --빈 값 불가
id varchar2(30) primary key,    --기본 키
pw varchar2(30) not null,       --빈 값 불가
regist_day date not null,       --빈 값 불가
phone varchar2(30) not null     --빈 값 불가
);

create table Company_Status(
name varchar2(15) not null,     --빈 값 불가
id varchar2(30) primary key,    --기본 키(중복불가능)
checkin_time date not null,           --빈 값 불가
checkout_time date,
status varchar2(15) default '결근',  --기본값 '결근'
reason varchar2(15)
);