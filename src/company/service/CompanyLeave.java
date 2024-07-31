package company.service;

import java.util.Scanner;

import company.dao.CompanyDAO;

public class CompanyLeave implements Company{

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		CompanyDAO companyDAO = CompanyDAO.getInstance();
		String name = companyDAO.delete(id,pw);
		
		if(name == null) {
			System.out.println("아이디 또는 비밀번호가 맞지 않습니다.");
		}
		else {
			System.out.println(name + "님이 퇴사하셨습니다.");
		}
		
	}

}