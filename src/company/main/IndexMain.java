package company.main;

import java.util.Scanner;

import company.service.Company;
import company.service.CompanyAttendance;
import company.service.CompanyLeave;
import company.service.CompanyRegist;

public class IndexMain {
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		Company company = null;
		
		while(true) {
			System.out.println("---------------------");
			System.out.println("1. 입사");
			System.out.println("2. 사원목록");
			System.out.println("3. 출결체크");
			System.out.println("4. 퇴사");
			System.out.println("5. 종료");
			System.out.println("---------------------");
			System.out.print("번호 입력 : ");
			
			int n = sc.nextInt();
			
			if(n == 5) break;
			if(n == 1) {
				company = new CompanyRegist();
				
			}
			else if(n == 2) {
				company = new CompanyList();
			}
			else if(n == 3) {
				company = new CompanyAttendance();
				
			}
			else if(n == 4) {
				company = new CompanyLeave();
			}
			else {
				System.out.println("1 ~ 5 중에서 선택하세요");
				continue;
			}
			company.execute();
		}
	}
	
	public static void main(String[] args) {
		IndexMain indexMain = new IndexMain();
		indexMain.menu();
		
		System.out.println("프로그램이 종료되었습니다.");

	}

}
