package company.service;

import java.util.Scanner;

import company.dao.CompanyDAO;

public class CompanyAttendance implements Company {

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("출석 ID 입력: ");
        String attendanceId = sc.nextLine();
        System.out.print("회사 ID 입력: ");
        String companyId = sc.nextLine();
        System.out.print("날짜 입력 (yyyy-mm-dd): ");
        String date = sc.nextLine();
        System.out.print("출석 여부 입력 (true/false): ");
        boolean isPresent = sc.nextBoolean();
        
        
        CompanyDAO companyDAO = CompanyDAO.getInstance();
        
        companyDAO.addAttendance(attendanceId, companyId, date, isPresent);
 
    }

}
