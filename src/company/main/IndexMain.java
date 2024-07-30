package company.main;

import java.util.Scanner;

import company.service.Company;
import company.service.CompanyAttendance;
import company.service.CompanyLeave;
<<<<<<< HEAD
=======
import company.service.CompanyLeaveList;
import company.service.CompanyList;
>>>>>>> 6500417 (리스트반복수정이전30일최종본)
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
<<<<<<< HEAD
			System.out.println("5. 종료");
=======
			System.out.println("5. 퇴사사원목록");
			System.out.println("6. 종료");
>>>>>>> 6500417 (리스트반복수정이전30일최종본)
			System.out.println("---------------------");
			System.out.print("번호 입력 : ");
			
			int n = sc.nextInt();
			
<<<<<<< HEAD
			if(n == 5) break;
=======
			if(n == 6) break;
>>>>>>> 6500417 (리스트반복수정이전30일최종본)
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
<<<<<<< HEAD
=======
			else if(n == 5) {
				company = new CompanyLeaveList();
			}
>>>>>>> 6500417 (리스트반복수정이전30일최종본)
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
