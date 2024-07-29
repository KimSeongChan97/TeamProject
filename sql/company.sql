create table company(
name varchar2(15) not null,     --빈 값 불가
id varchar2(30) primary key,    --기본 키
regist_day date not null,       --빈 값 불가
etc varchar2(50)                --비고
);

create table Company_Attendance(
name varchar2(15) not null,     --빈 값 불가
id varchar2(30) primary key,    --기본 키(중복불가능)
ontime date not null,           --빈 값 불가
outtime date,
Attendance varchar2(15) default '결근',  --기본값 '결근'
reason varchar2(15)
);