package company.service;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;

public class CompanyLeaveList implements Company{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("[퇴사 사원 목록]");
		System.out.println("이름\t퇴사일\t전화번호");
		
		CompanyDAO companyDAO = CompanyDAO.getInstance();
		CompanyDTO companyDTO = new CompanyDTO();
		
		companyDAO.leavelist(companyDTO);
	}
	
}
