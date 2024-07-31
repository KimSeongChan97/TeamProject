package company.service;

import java.util.Scanner;

import company.dao.CompanyDAO;

public class CompanyAttendance implements Company {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		CompanyDAO companyDAO = CompanyDAO.getInstance(); 
		
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		String name = companyDAO.login(id, pw);
		
		if(name == null) {
			System.out.println("아이디 또는 비밀번호가 맞지 않습니다.");
		}
		else {
			System.out.println(name + "님 로그인");
			while(true) {
				System.out.println("------------------");
				System.out.println("1. 출근");
				System.out.println("2. 퇴근");
				System.out.println("3. 이전메뉴");
				System.out.println("------------------");
				System.out.print("번호 입력 : ");
				int n = sc.nextInt();
				
				if(n == 3) return;
				
				else if (n == 1) {
					companyDAO.checkin(id);
					System.out.println("출근하셨습니다.");
				}
				else if (n == 2) {
					companyDAO.checkout(id);
					System.out.println("퇴근하셨습니다.");
				}
				else {
					System.out.println("1 ~ 3 중에서 입력하세요");
					continue;
				}
			}//while
		}
		
	}

}