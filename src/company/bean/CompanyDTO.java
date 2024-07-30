package company.bean;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
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
}
