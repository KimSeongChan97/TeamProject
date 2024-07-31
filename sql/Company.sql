-- 사원 테이블
create table company(
name varchar2(15) not null,     -- 사원 이름
id varchar2(30) primary key,    -- 사원 아이디
pw varchar2(30) not null,       -- 사원 비밀번호
phone varchar2(30) not null,    -- 사원 전화번호
regist_day date not null       -- 사원 입사일
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
-- 퇴사사원목록 테이블
create table leaveperson(
name varchar2(15) not null,		--퇴사 사원 이름
id varchar2(30) not null,		--퇴사 사원의 아이디
regist_day date not null,		--입사 날짜
leave_day date not null			--퇴사 날짜
);