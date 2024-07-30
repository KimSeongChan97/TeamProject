-- 사원 테이블
create table company(
<<<<<<< HEAD
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
=======
name varchar2(15) not null,     -- 사원 이름
id varchar2(30) primary key,    -- 사원 아이디
pw varchar2(30) not null,       -- 사원 비밀번호
phone varchar2(30) not null,    -- 사원 전화번호
regist_day date not null,       -- 사원 입사일
leave_day date,                 -- 사원 퇴사일
deleteyn varchar2(1) default 'N' --기본값 'N'
);

-- 출결체크 테이블
create table Company_Status(
name varchar2(15) not null,         -- 사원 이름
id varchar2(30) primary key,        -- 사원 아이디
checkin_time date not null,         -- 사원 출근 시간
checkout_time date,                 -- 사원 퇴근 시간
status varchar2(15) default '결근',  -- 출근 , 퇴근 , 결근 , 지각
reason varchar2(15)                 -- 지각이유 , 결근이유 등등
);
>>>>>>> 6500417 (리스트반복수정이전30일최종본)
