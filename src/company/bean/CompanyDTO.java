package company.bean;

import lombok.Getter;
<<<<<<< HEAD
import lombok.NonNull;
=======
>>>>>>> 6500417 (리스트반복수정이전30일최종본)
import lombok.Setter;

@Getter
@Setter
<<<<<<< HEAD
public class CompanyDTO {
	@NonNull
	private String name;
	@NonNull
	private String id;
	@NonNull
	private String pw;
	@NonNull
	private String phone;
	@NonNull
	private String regist_day;
	@NonNull
	private String checkin_time;
	@NonNull
	private String checkout_time;
	@NonNull
	private String status;
	@NonNull
	private String reason;
=======

public class CompanyDTO {
	private String name; //사원 이름
	private String id; //사원 아이디
	private String pw; //사원 비밀번호
	private String phone; //사원 전화번호
	private String regist_day; //입사일
	private String leave_day; //사원 입사일
	private String deleteYN; //탈퇴 여부
	
	
	
	private String checkIn_Time; //출근시간
	private String checkOut_Time; //퇴근시간
	private String status; //출근 , 퇴근 , 결근 , 지각
	private String reason; //지각 이유 , 결근 이유 등등
	
>>>>>>> 6500417 (리스트반복수정이전30일최종본)
}


