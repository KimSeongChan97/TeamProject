PPT 수정 240730

[4-Company.pptx](https://github.com/user-attachments/files/16434605/4-Company.pptx)

(목차 순서 및 발표 메모 추가 )
----------------------------------------------------------------------------------------

프로젝트기간 : 목, 금 , 토, 일요일 ( 4일 )
프로젝트 발표 : 월요일 (화요일 가능성 있음)


1. 단톡방
2. 어떤 Java 프로젝트 할지 => 복습의 목적, Git 이용 연습 ( 상속/인터페이스 有)
3. 어떤 프로젝트 작성할지 -> 목요일 오전에 발표(ppt or pdf or txt)

[Git]
1. git : pull -> 작업 (  내려받고 )
2. push -> pull ( 올린거 다시 내려 받고 ) -> 작업
3.  .. .. 반복

--프로젝트--
DB이용..
회원가입 - 로그인 - 탈퇴

다중 DB
입사 - 출근 - 지각 - 사유(결근 - 휴가 - 조퇴) - 퇴근 - 퇴사

DB(미리 데이터 입력)
출근 - 지각 - 사유(결근 - 휴가 - 조퇴) - 퇴근

회사 테이블
이름 id 입사일 비고

출결 테이블
이름 id 출근시간 퇴근시간 출결 사유(빈 값 허용)

회사테이블에 데이터를 입력하는 입사 프로그램 작동 시 출결테이블에도 이름, id 작성 출결은 기본으로 '결근' 데이터 입력
퇴사 프로그램 작동시 출결테이블에도 id에 해당하는 데이터 삭제

출결 항목관련
테이블에 항목을 입력하는 입사 프로그램 적용 시 출결의 기본값은 '결근'

static 영역에서 데이터베이스를 한번 접속하여 프로그램 실행시마다 출근시간, 퇴근시간, 사유를 'null'값으로, 출결을 '결근'으로 초기화

기준 출근시간 이전은 '출근'
기준 출근시간보다 느리면 '지각'
기준 퇴근시간보다 빠르면 '조퇴'
사유에 "휴가"가 있으면 '휴가'

기술스택 : Java(eclipse), Oracle(database) 만 사용

============================결과
---------------------
1. 회원가입
2. 로그인
3. 탈퇴
4. 종료
--------------------
1.1 회원가입
이름 : 
아이디 : 
비밀번호 : 
전화번호 : 

(성공시)
회원가입 성공 --> 회원테이블 데이터 삽입

2.1 로그인
아이디 :
비번 : 

(성공시)
--------------------------
1. 출근
2. 퇴근
3. 기타
--------------------------

2.1.1 출근
출결 테이블 데이터삽입
이름 출근시간 출결 사유( 결근으로 기본값)
홍길동 10:24    결근->출근 or 지각

2.1.2 퇴근
출결 테이블 데이터삽입
이름     출근시간    퇴근시간    출결 사유
홍길동    10:24      20:00    퇴근 or 조퇴

2.1.3 기타 ( 휴가 ? )
출결 테이블 데이터삽입
이름     출근시간    퇴근시간    출결 사유
홍길동    null      null       휴가

3. 탈퇴
아이디 :
비번 : 
(성공시)
회원 id 값을 가지고 데이터 삭제
====================================

---------------------
1. 입사
2. 출결체크
3. 퇴사
4. 종료
--------------------
번호 입력 : 

1.입사
이름 : 홍길동
아이디 : hong
비밀번호 : 123
전화번호 : 010-1234-1234

(성공시)
회원가입 성공 --> 회사테이블 데이터 삽입 후 출결테이블에 이름, 아이디, 비밀번호, 전화번호 같이 입력
(실패시)
return ;

2. 출결체크

아이디 :
비번 : 

성공시
--------------------------
1. 출근
2. 퇴근
3. 이전메뉴
--------------------------
번호 입력 : 

2.1 출근

(성공시)
출결 테이블 데이터삽입	출근시간은 sysdate

이름		출근시간 	퇴근시간	출결(결근으로 고정값)		사유
홍길동 	10:24	  	(null)		결근->출근 or 지각		

2.2 퇴근

아이디 :
비번 : 

(성공시)
출결 테이블 데이터삽입

이름		출근시간	퇴근시간	출결 					사유
홍길동	10:24		20:00		출근 ->퇴근 or 조퇴

3. 퇴사
아이디 :
비번 : 
(성공시)
회사테이블과 출결테이블에서 둘다 회원 id 값을 가지고 데이터 삭제
==============================================================
실제 실행시 ->

프로그램 요약
프로그램은 다음과 같은 주요 기능을 제공하며, 메뉴를 통해 사용자와 상호작용합니다:

입사: 새로운 사원을 등록합니다.
사원목록: 현재 근무 중인 사원의 목록을 출력합니다.
출결체크: 사원이 출근 또는 퇴근을 기록합니다.
퇴사: 사원을 퇴사 처리합니다.
퇴사사원목록: 퇴사한 사원의 목록을 출력합니다.
종료: 프로그램을 종료합니다.
주요 기능 및 시나리오
입사

이름, 아이디, 비밀번호, 전화번호를 입력받아 새로운 사원을 등록합니다.
등록된 사원은 회사 테이블에 저장되고, 출결 현황은 기본적으로 '결근'으로 설정됩니다.
사원목록

현재 근무 중인 사원의 목록을 보여줍니다.
각 사원의 이름, 아이디, 입사일, 전화번호, 출결 현황을 출력합니다.
출결체크

로그인하여 출근 또는 퇴근을 기록합니다.
출근 시 출결 현황이 '출근' 또는 '지각'으로 변경됩니다.
퇴근 시 출결 현황이 '퇴근' 또는 '조퇴'로 변경됩니다.
퇴사

사원을 퇴사 처리합니다.
퇴사한 사원의 정보는 회사 테이블에서 삭제되고, 퇴사 사원 목록에 추가됩니다.
퇴사사원목록

퇴사한 사원의 목록을 보여줍니다.
각 사원의 이름, 아이디, 입사일, 퇴사일을 출력합니다.
종료

프로그램을 종료합니다.

실행 예시

메뉴화면
---------------------
1. 입사
2. 사원목록
3. 출결체크
4. 퇴사
5. 퇴사사원목록
6. 종료
---------------------
번호 입력 :

입사
번호 입력 : 1
이름 : 홍길동
아이디 입력 : hong
사용가능한 아이디입니다.
비밀번호 : 123
전화번호 : 010-1111-2222
홍길동님이 입사하셨습니다.

사원목록
번호 입력 : 2
이름    아이디    입사일        전화번호        출결현황
----------------------------------------
홍길동    hong    2024-07-31    010-1111-2222    결근

출결체크(출근)
번호 입력 : 3
아이디 : hong
비밀번호 : 123
홍길동님 로그인
------------------
1. 출근
2. 퇴근
3. 이전메뉴
------------------
번호 입력 : 1
출근하셨습니다.

사원목록(출근 후)
번호 입력 : 2
이름    아이디    입사일        전화번호        출결현황
----------------------------------------
홍길동    hong    2024-07-31    010-1111-2222    출근

출결체크(퇴근)
번호 입력 : 3
아이디 : hong
비밀번호 : 123
홍길동님 로그인
------------------
1. 출근
2. 퇴근
3. 이전메뉴
------------------
번호 입력 : 2
퇴근하셨습니다.

사원목록(퇴근 후)
번호 입력 : 2
이름    아이디    입사일        전화번호        출결현황
----------------------------------------
홍길동    hong    2024-07-31    010-1111-2222    조퇴

퇴사
번호 입력 : 4
아이디 : hong
비밀번호 : 123
홍길동님이 퇴사하셨습니다.

퇴사사원목록
번호 입력 : 5
[퇴사 사원 목록]
이름    아이디    입사일        퇴사일
홍길동    hong    2024-07-31    2024-07-31

종료
번호 입력 : 6
프로그램이 종료되었습니다.


요약
프로그램은 사원 등록, 출결 체크, 퇴사 처리 및 목록 출력을 포함한 전반적인 사원 관리 기능을 제공합니다. 각 기능은 메뉴를 통해 선택되며, 사용자 입력을 받아 데이터베이스와 상호작용합니다.








