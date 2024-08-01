package company.service;

import java.util.Scanner;

import company.dao.CompanyDAO;

public class CompanyAttendanceLog implements Company {
    
    // Company 인터페이스의 execute 메서드를 구현
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        CompanyDAO companyDAO = CompanyDAO.getInstance(); // CompanyDAO의 싱글톤 인스턴스 가져오기
        
        // 사용자로부터 아이디 입력 받기
        System.out.print("아이디 : ");
        String id = sc.next();
        
        // 출퇴근 기록 조회
        companyDAO.getAttendanceLogs(id);
    }
}
