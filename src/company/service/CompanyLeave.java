package company.service;

import java.util.Scanner;

import company.dao.CompanyDAO;

public class CompanyLeave implements Company{

    // Company 인터페이스의 execute 메서드를 구현
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        System.out.print("아이디 : ");
        String id = sc.next(); // 사용자로부터 아이디 입력 받기
        System.out.print("비밀번호 : ");
        String pw = sc.next(); // 사용자로부터 비밀번호 입력 받기
        
        CompanyDAO companyDAO = CompanyDAO.getInstance(); // CompanyDAO의 싱글톤 인스턴스 가져오기
        String name = companyDAO.delete(id, pw); // 입력받은 아이디와 비밀번호로 퇴사 처리 시도
        
        if(name == null) {
            // 퇴사 실패 시 메시지 출력
            System.out.println("아이디 또는 비밀번호가 맞지 않습니다.");
        } else {
            // 퇴사 성공 시 메시지 출력
            System.out.println(name + "님이 퇴사하셨습니다.");
        }
    }
}
