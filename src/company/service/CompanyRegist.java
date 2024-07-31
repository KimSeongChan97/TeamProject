package company.service;

import java.util.Scanner;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;

public class CompanyRegist implements Company {
	private String id = "";
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		
		CompanyDAO companyDAO = CompanyDAO.getInstance();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		while(true){
			System.out.println();
			System.out.print("아이디 입력 : ");
			id = sc.next();
			
			boolean exist= companyDAO.isExistId(id);
			if(exist) {
				System.out.println("이미 사용중인 아이디입니다.");
			}
			else {
				System.out.println("사용가능한 아이디입니다.");
				break;
			}
		}
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		companyDAO.regist(name, id, pw, phone);
		
		System.out.println(name + "님이 입사하셨습니다.");
		
		
	}

}
